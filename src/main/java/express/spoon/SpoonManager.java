package express.spoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import express.classinvariant.predicate.PredicateManager;
import express.compile.InMemoryCompiler;
import express.compile.OutputManager;
import express.config.Config;
import express.instrumentation.Instrumentation;
import express.type.TypeUtils;
import express.type.typegraph.TypeData;
import spoon.Launcher;
import spoon.compiler.Environment;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtCompilationUnit;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.CompilationUnitFactory;
import spoon.reflect.visitor.PrettyPrinter;
import spoon.support.reflect.declaration.CtCompilationUnitImpl;

public class SpoonManager {

    private static final Logger logger = Logger.getLogger(SpoonManager.class.getName());

    static Config config;
    static Launcher launcher;

    static TypeData subjectTypeData;
    static CtClass<?> subjectClass;
    static CtPackage subjectPackage;
    static CtClass<?> subjectTestClass;

    static OutputManager outputManager;
    static InMemoryCompiler inMemoryCompiler;

    static CompilationUnitFactory cuFactory;
    static PrettyPrinter prettyPrinter;

    static boolean initialized = false;

    public static void initialize(Config conf) {
        config = conf;
        initializeLauncher();
        initializeFactories();
        initializeSubjectData();
        initializeOutputManager();
        initializePredicateManager();
        performInstrumentation();
        initializeCompiler();
        compileModel();
        initialized = true;
    }

    private static void initializeLauncher() {
        launcher = new Launcher();
        launcher.addInputResource(config.subjectSrcPath);
        launcher.addInputResource(config.subjectTestSrcPath);
        launcher.getEnvironment().setComplianceLevel(config.subjectSrcJavaVersion);
        launcher.getEnvironment().setShouldCompile(false);
        launcher.getEnvironment().setAutoImports(false);
        launcher.getEnvironment().setPrettyPrintingMode(Environment.PRETTY_PRINTING_MODE.FULLYQUALIFIED);
        // launcher.getEnvironment().setPreserveLineNumbers(true);
        launcher.buildModel();
    }

    private static void initializeSubjectData() {
        subjectTypeData = new TypeData(launcher.getModel(), launcher.getFactory().Class().get(config.subjectClassName));
        subjectTestClass = launcher.getFactory().Class().get(config.subjectTestSuiteClassName);
        subjectClass = subjectTypeData.getThisCtClass();
        subjectPackage = subjectClass.getPackage();
    }

    private static void initializeOutputManager() {
        outputManager = new OutputManager(config);
    }

    private static void initializeFactories() {
        cuFactory = launcher.getFactory().CompilationUnit();
        prettyPrinter = launcher.createPrettyPrinter();
        SpoonFactory.initialize(launcher);
    }

    private static void initializePredicateManager() {
        PredicateManager.initialize(config, subjectTypeData);
    }

    private static void performInstrumentation() {
        Instrumentation.instrumentClasses(launcher.getModel());
        Instrumentation.instrumentTestSuite(subjectTestClass);
    }

    private static void initializeCompiler() {
        inMemoryCompiler = new InMemoryCompiler();
        List<String> classpath = new ArrayList<>();
        classpath.add("lib/junit-4.13.2.jar");
        classpath.add("lib/collector-1.0.jar");
        inMemoryCompiler.setClasspath(classpath);
        inMemoryCompiler.addSource(getSourceMap());
    }

    private static void compileModel() {
        if (!inMemoryCompiler.compile()) {
            System.err.println("Compilation failed!");
            throw new RuntimeException("Compilation failed");
        } else {
            System.out.println("Compilation successful!");
        }
    }

    public static Map<String, String> getSourceMap() {
        Map<String, String> sourceMap = new HashMap<>();
        List<CtType<?>> allTypes = launcher.getFactory().Type().getAll();
        for (CtType<?> type : allTypes) {
            if (TypeUtils.isUserDefinedType(type.getReference()))
                sourceMap.put(type.getQualifiedName(), getPrettyPrintedSourceCode(type));
        }
        return sourceMap;
    }

    public static String getPrettyPrintedSourceCode(CtType<?> type) {
        CtCompilationUnit origCU = cuFactory.getOrCreate(type);
        CtCompilationUnit cu = new CtCompilationUnitImpl();
        cu.addDeclaredType(type);
        cu.setPackageDeclaration(origCU.getPackageDeclaration());
        return prettyPrinter.printCompilationUnit(cu);
    }

    public static void addClassToMainPackage(CtClass<?> cls) {
        if (subjectPackage.getType(cls.getSimpleName()) == null) {
            subjectPackage.addType(cls);
        }
    }

    public static void removeClassFromMainPackage(CtClass<?> cls) {
        subjectPackage.removeType(cls);
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static TypeData getSubjectTypeData() {
        return subjectTypeData;
    }

    public static Launcher getLauncher() {
        return launcher;
    }

    public static CtClass<?> getSubjectTestClass() {
        return subjectTestClass;
    }

    public static OutputManager getOutputManager() {
        return outputManager;
    }

    public static Config getConfig() {
        return config;
    }

    public static InMemoryCompiler getInMemoryCompiler() {
        return inMemoryCompiler;
    }

    public static ClassLoader getClassLoader() {
        return inMemoryCompiler.getClassLoader();
    }
}
