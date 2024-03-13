package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.ga.mutators.MutatorManager;
import evorep.object.Instrumenter;
import evorep.spoon.typesgraph.TypeGraph;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SpoonManager {

    private final static String DEFAULT_BIN_PATH = "./bin";
    private static File outputBinDirectory;
    private static Launcher launcher;
    private static String targetClassName;
    private static String testSuiteClassName;

    private static TypeGraph typesGraph;
    private static URL outputBinURL;

    private SpoonManager() {
    }

    public static void initialize() {
        initialize(ToolConfig.srcPath, ToolConfig.binPath, ToolConfig.className, ToolConfig.testSuiteClassName, ToolConfig.srcJavaVersion);
    }

    public static void initialize(String srcPath, String binPath, String fullClassName, int srcJavaVersion) {
        try {
            initializeOutputDirectories(binPath);
            initializeLauncher(srcPath, srcJavaVersion);
            initializeFactories();
            initializeTargetClass(fullClassName);
            initializeRepOKMethod();
            initializeTypeGraph();
            initializeMutatorManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeMutatorManager() {
        MutatorManager.initialize();
    }

    public static void initialize(String srcPath, String binPath, String fullClassName, String testSuiteClassName, int srcJavaVersion) {
        try {
            initializeOutputDirectories(binPath);
            initializeLauncher(srcPath, srcJavaVersion);
            initializeFactories();
            initializeTargetClass(fullClassName);
            initializeTestSuiteClass(testSuiteClassName);
            initializeRepOKMethod();
            initializeTypeGraph();
            initializeMutatorManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeOutputDirectories(String binPath) {
        if (binPath == null)
            binPath = DEFAULT_BIN_PATH;
        outputBinDirectory = Utils.createDirectory(binPath);
        outputBinURL = Utils.createURL(outputBinDirectory);
    }

    private static void initializeLauncher(String srcPath, int srcJavaVersion) {
        launcher = new Launcher();
        launcher.setBinaryOutputDirectory(outputBinDirectory);
        launcher.addInputResource(srcPath);
        launcher.getEnvironment().setComplianceLevel(srcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        // launcher.getEnvironment().setSourceClasspath(new
        // String[]{System.getProperty("java.class.path")});
        launcher.buildModel();
        launcher.getModelBuilder().compile();
    }

    private static void initializeFactories() {
        SpoonFactory.initialize(launcher);
    }

    private static void initializeTargetClass(String fullName) {
        targetClassName = fullName;
    }

    private static void initializeTestSuiteClass(String fullTestSuiteClassName) {
        testSuiteClassName = fullTestSuiteClassName;
        instrumentTestSuite();
        compileModel();
    }

    private static void instrumentTestSuite() {
        getTestSuiteClass().getMethods().forEach(method -> {
            // Check if the method contains the test annotation
            if (isTestMethod(method)) {
                Instrumenter.instrumentMethod(method);
            }
        });
    }

    private static boolean isTestMethod(CtMethod<?> method) {
        for (CtAnnotation<?> annotation : method.getAnnotations()) {
            if (annotation.getName().equals("Test")) {
                return true;
            }
        }
        return false;
    }

    private static void initializeRepOKMethod() {
        getTargetClass().addMethod(SpoonFactory.createRepOK("repOK"));
    }

    private static void initializeTypeGraph() {
        typesGraph = new TypeGraph(getTargetClass().getReference());
    }

    public static CtClass<?> getTargetClass() {
        return launcher.getFactory().Class().get(targetClassName);
    }

    public static CtClass<?> getTestSuiteClass() {
        return launcher.getFactory().Class().get(testSuiteClassName);
    }

    public static CtClass<?> getClass(String className) {
        return launcher.getFactory().Class().get(className);
    }

    public static TypeGraph getTypeGraph() {
        return typesGraph;
    }

    public static boolean compileIndividual(Individual individual) {
        SpoonHelper.putIndividualIntoTheEnvironment(individual);
        return compileModel();
    }

    public static boolean compileModel() {
        boolean compiles = false;
        try {
            compiles = launcher.getModelBuilder().compile();
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return compiles;
    }

    public static void runTestSuite(String testSuiteFullyQualifiedName, URLClassLoader classLoader) {
        try {
            Class<?> testClass = classLoader.loadClass(testSuiteFullyQualifiedName);
            List<Method> testMethods = getRunnableTests(testClass);
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            int testsExecuted = 0;
            int errors = 0;
            for (Method testMethod : testMethods) {
                // Run the test method and let the instrumentation collect the created objects
                try {
                    Object result = testMethod.invoke(testObject);
                    testsExecuted++;
                } catch (Exception e) {
                    System.err.println("error running test " + testMethod.getName() + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the list of runnable tests in the given test class
     * A test method is runnable if it is annotated with @Test.
     *
     * @param testClass the test class
     * @return the list of methods corresponding to runnable tests
     */
    private static List<Method> getRunnableTests(Class<?> testClass) {
        // Use reflection to find all the JUnit tests in the class
        ArrayList<Method> testMethods = new ArrayList<>();
        for (Method method : testClass.getDeclaredMethods()) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation.annotationType().getSimpleName().equals("Test")) {
                    testMethods.add(method);
                }
            }
        }
        return testMethods;
    }

    public static int runRepOK(Individual individual, Method repOK, Object instance) {
        // Create an ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create a Callable<Boolean> to invoke the method
        Callable<Boolean> task = () -> {
            return (boolean) repOK.invoke(instance);
        };

        boolean result = false;
        try {
            // Submit the task to the executor and get a Future object
            Future<Boolean> future = executor.submit(task);
            // Set a timeout for the task
            result = future.get(300, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            // Handle timeout exception
            //e.printStackTrace();
            return -1;
        } catch (Exception e) {
            // Handle other exceptions
            //e.printStackTrace();
            //System.err.println("\nThe individual was:\n\n" + individual.toString());
            return -1;
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
        if (result)
            return 1;
        return 0;
    }

    public static Class<?> loadTargetClass(URLClassLoader classLoader) {
        Class<?> aClass = null;
        try {
            aClass = classLoader.loadClass(targetClassName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return aClass;
    }

    public static Method loadMethod(Class<?> clazz, String methodName) {
        Method method = null;
        try {
            method = clazz.getMethod(methodName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return method;
    }

    public static URLClassLoader createClassLoader() {
        return new URLClassLoader(new URL[]{outputBinURL});
    }
}
