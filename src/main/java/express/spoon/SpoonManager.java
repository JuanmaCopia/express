package express.spoon;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import express.compile.InMemoryCompiler;
import express.compile.InputOutputManager;
import express.config.Config;
import express.type.typegraph.TypeData;
import express.instrumentation.Instrumentation;
import spoon.Launcher;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.declaration.*;
import spoon.reflect.factory.CompilationUnitFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.PrettyPrinter;
import spoon.support.reflect.cu.CompilationUnitImpl;
import spoon.support.reflect.declaration.CtCompilationUnitImpl;
import spoon.support.reflect.declaration.CtImportImpl;

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
    static CtPackage mainPackage;

    static boolean initialized = false;

    public static void initialize(Config conf) {
        config = conf;
        launcher = new Launcher();
        launcher.addInputResource(config.subjectSrcPath);
        launcher.addInputResource(config.subjectTestSrcPath);

        launcher.getEnvironment().setComplianceLevel(config.subjectSrcJavaVersion);
        launcher.getEnvironment().setShouldCompile(false);
        launcher.getEnvironment().setAutoImports(false);
        // launcher.getEnvironment().setPreserveLineNumbers(true);
        launcher.buildModel();

        typeData = new TypeData(launcher.getFactory().Class().get(config.subjectClassName));
        mainPackage = typeData.getThisCtClass().getPackage();

        output = new InputOutputManager(config);

        SpoonFactory.initialize(config, launcher, typeData);

        testSuiteClass = launcher.getFactory().Class().get(config.subjectTestSuiteClassName);
        Instrumentation.instrumentClasses(launcher.getModel());
        Instrumentation.instrumentTestSuite(testSuiteClass);

        // Initialize compiler
        cuFactory = launcher.getFactory().CompilationUnit();
        prettyPrinter = launcher.createPrettyPrinter();
        inMemoryCompiler = new InMemoryCompiler();

        // Set the classpath to include JUnit 4 JAR file
        List<String> classpath = new ArrayList<>();
        classpath.add("lib/junit-4.13.2.jar");
        classpath.add("lib/collector-1.0.jar");
        // Update this path to the actual location of JUnit 4 JAR
        inMemoryCompiler.setClasspath(classpath);
        inMemoryCompiler.addSource(getSourceMap());

        //testIMC();

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

//        CtClass<?> cls = SpoonFactory.createPredicateClass(1);
//        System.out.println(getPrettyPrintedSourceCode(cls));
//
//        CtClass<?> clsclone = cls.clone();
//        clsclone.setSimpleName("Predicate2");
//        cls.getPackage().addType(clsclone);
//        System.out.println(getPrettyPrintedSourceCode(clsclone));

        //output.getCompiler().compileModel();

        initialized = true;
    }

    // private static void test1() {
    // InMemoryCompiler compiler = new InMemoryCompiler();

    // // Add JUnit JAR to classpath

    // // Set the classpath to include JUnit 4 JAR file
    // List<String> classpath = new ArrayList<>();
    // classpath.add("lib/junit-4.13.2.jar"); // Update this path to the actual
    // location of JUnit 4 JAR
    // compiler.setClasspath(classpath);

    // // Add source code
    // compiler.addSource("TestExample", "public class TestExample { @org.junit.Test
    // public void test() { assert true; } }");

    // // Compile
    // boolean success = compiler.compile();
    // System.out.println("Compilation success: " + success);
    // }

    private static void testIMC() {
        cuFactory = launcher.getFactory().CompilationUnit();
        prettyPrinter = launcher.createPrettyPrinter();
        inMemoryCompiler = new InMemoryCompiler();

        // Set the classpath to include JUnit 4 JAR file
        List<String> classpath = new ArrayList<>();
        classpath.add("lib/junit-4.13.2.jar"); // Update this path to the actual location of JUnit 4 JAR
        inMemoryCompiler.setClasspath(classpath);
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

    private static Map<String, String> getSourceMap() {
        Map<String, String> sourceMap = new HashMap<>();
        List<CtType<?>> allTypes = launcher.getFactory().Type().getAll();
        for (CtType<?> type : allTypes) {
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
        if (mainPackage.getType(cls.getSimpleName()) == null) {
            mainPackage.addType(cls);
        }
    }

    public static void removeClassFromMainPackage(CtClass<?> cls) {
        mainPackage.removeType(cls);
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

    public static InMemoryCompiler getInMemoryCompiler() {
        return inMemoryCompiler;
    }

    public static ClassLoader getClassLoader() {
        return inMemoryCompiler.getClassLoader();
    }
}
