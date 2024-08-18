package express.spoon;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import express.compile.InMemoryCompiler;
import express.compile.InputOutputManager;
import express.config.Config;
import express.instrumentation.Instrumentation;
import express.type.typegraph.TypeData;
import spoon.Launcher;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.CompilationUnitFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.PrettyPrinter;
import spoon.support.reflect.cu.CompilationUnitImpl;

public class SpoonManager {

    private static final Logger logger = Logger.getLogger(SpoonManager.class.getName());

    static Config config;
    static InputOutputManager output;
    static InMemoryCompiler inMemoryCompiler;

    static CompilationUnitFactory cuFactory;
    static PrettyPrinter prettyPrinter;

    static Launcher launcher;
    static CtClass<?> testSuiteClass;
    static TypeData typeData;

    static boolean initialized = false;

    public static void initialize(Config conf) {
        config = conf;
        launcher = new Launcher();
        launcher.addInputResource(config.subjectSrcPath);
        launcher.addInputResource(config.subjectTestSrcPath);

        launcher.getEnvironment().setComplianceLevel(config.subjectSrcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        // launcher.getEnvironment().setPreserveLineNumbers(true);
        launcher.buildModel();

        typeData = new TypeData(launcher.getFactory().Class().get(config.subjectClassName));

        output = new InputOutputManager(launcher, config, typeData.getThisCtClass().getPackage());
        launcher.setBinaryOutputDirectory(output.getOutputBinPath());
        launcher.setSourceOutputDirectory(output.getOutputSrcPath());

        SpoonFactory.initialize(config, launcher, typeData);

        testSuiteClass = launcher.getFactory().Class().get(config.subjectTestSuiteClassName);
        Instrumentation.instrumentClasses(launcher.getModel());
        Instrumentation.instrumentTestSuite(testSuiteClass);

        output.getCompiler().compileModel();

        initialized = true;
    }

    private static void testIMC() {
        cuFactory = launcher.getFactory().CompilationUnit();
        prettyPrinter = launcher.createPrettyPrinter();
        inMemoryCompiler = new InMemoryCompiler();
        inMemoryCompiler.addSource(getSourceMap());
        boolean compilationResult;
        try {
            compilationResult = inMemoryCompiler.compile();
        } catch (Exception e) {
            logger.severe("Compilation failed");
            e.printStackTrace();
            throw new RuntimeException("Compilation failed");
        }

        if (!compilationResult) {
            logger.severe("Compilation failed");
            throw new RuntimeException("Compilation failed");
        } else {
            logger.info("Compilation successful");
        }

        // ClassLoader inMemoryClassLoader = inMemoryCompiler.getClassLoader();
        String scheduleClassName = "examples.schedule.Schedule";
        Class<?> scheduleClass;

        try {
            // Invoke a method from the dynamically compiled class
            scheduleClass = inMemoryCompiler.loadClass(scheduleClassName);
            Object instance = scheduleClass.getDeclaredConstructor().newInstance();
            Method sizeMethod = scheduleClass.getDeclaredMethod("size");
            sizeMethod.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error invoking method from dynamically compiled class");
        }

        List<CtType<?>> types = launcher.getModel().getAllTypes().stream()
                .filter(t -> t.getQualifiedName().equals(scheduleClass.getName())).toList();

        CtType<?> scheduleOrig = types.get(0);
        CtType<?> scheduleType2 = scheduleOrig.clone();
        scheduleType2.setSimpleName("Schedule2");
        scheduleOrig.getPackage().addType(scheduleType2);

        CtStatement stringStatement = scheduleType2.getMethod("size").getBody().getStatements().get(0);

        Factory factory = launcher.getFactory();

        // Create a CtTypeReference for String
        CtTypeReference<String> stringType = factory.Type().stringType();

        // Create a CtLiteral for the value "hi"
        CtLiteral<String> literal = factory.createLiteral();
        literal.setValue("hi, I have been recompiled!");

        CtLocalVariable<?> localVar = SpoonFactory.createLocalVariable("s", stringType, literal);

        stringStatement.replace(localVar);

        boolean result;
        try {
            result = inMemoryCompiler.compileSingleClass(scheduleType2.getQualifiedName(),
                    getPrettyPrintedSourceCode(scheduleType2));
        } catch (Exception e) {
            logger.severe("ReCompilation failed");
            e.printStackTrace();
            throw new RuntimeException("ReCompilation failed");
        }

        if (!result) {
            logger.severe("ReCompilation failed");
            throw new RuntimeException("ReCompilation failed");
        }

        try {
            // Invoke a method from the dynamically compiled class
            Class<?> recompiledSchedule = inMemoryCompiler.loadClass(scheduleType2.getQualifiedName());
            Object instance = recompiledSchedule.getDeclaredConstructor().newInstance();
            Method sizeMethod = recompiledSchedule.getDeclaredMethod("size");
            sizeMethod.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error invoking method from dynamically recompiled class");
        }
    }

    private static void initializeCompiler() {
        cuFactory = SpoonFactory.getFactory().CompilationUnit();
        prettyPrinter = launcher.createPrettyPrinter();
    }

    private static Map<String, String> getSourceMap() {
        Map<String, String> sourceMap = new HashMap<>();
        List<CtType<?>> allTypes = launcher.getFactory().Type().getAll();
        for (CtType<?> type : allTypes) {
            sourceMap.put(type.getQualifiedName(), getOriginalSourceCode(type));
        }
        return sourceMap;
    }

    private static String getOriginalSourceCode(CtType<?> type) {
        CompilationUnit cu = cuFactory.getOrCreate(type);
        return prettyPrinter.printCompilationUnit(cu);
    }

    private static String getPrettyPrintedSourceCode(CtType<?> type) {
        CompilationUnit origCU = cuFactory.getOrCreate(type);

        CompilationUnit cu = new CompilationUnitImpl();
        cu.addDeclaredType(type);
        cu.setPackageDeclaration(origCU.getPackageDeclaration());
        return prettyPrinter.printCompilationUnit(cu);
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static TypeData getTypeData() {
        return typeData;
    }

    public static Launcher getLauncher() {
        return launcher;
    }

    public static CtClass<?> getTestSuiteClass() {
        return testSuiteClass;
    }

    public static InputOutputManager getOutput() {
        return output;
    }

    public static Config getConfig() {
        return config;
    }
}
