package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.spoon.typesgraph.TypesGraph;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class SpoonManager {

    private final static String DEFAULT_BIN_PATH = "./bin";

    private static Launcher launcher;
    private static CtClass<?> targetClass;
    private static TypesGraph typesGraph;

    private static File outputBinDirectory;
    private static URLClassLoader urlClassLoader;

    private SpoonManager() {
    }

    public static void initialize() {
        initialize(ToolConfig.srcPath, ToolConfig.binPath, ToolConfig.className, ToolConfig.srcJavaVersion);
    }

    public static void initialize(String srcPath, String binPath, String fullClassName, int srcJavaVersion) {
        try {
            initializeOutputDirectories(binPath);
            initializeLauncher(srcPath, srcJavaVersion);
            initializeFactories();
            initializeClass(fullClassName);
            initializeRepOKMethod();
            initializeTypesGraph();
            compileModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeOutputDirectories(String binPath) {
        if (binPath == null)
            binPath = DEFAULT_BIN_PATH;
        outputBinDirectory = Utils.createDirectory(binPath);
        URL outputBinURL = Utils.createURL(outputBinDirectory);
        urlClassLoader = new URLClassLoader(new URL[]{outputBinURL});
    }

    private static void initializeLauncher(String srcPath, int srcJavaVersion) {
        launcher = new Launcher();
        launcher.setBinaryOutputDirectory(outputBinDirectory);
        launcher.addInputResource(srcPath);
        launcher.getEnvironment().setComplianceLevel(srcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        launcher.buildModel();
    }


    private static void initializeFactories() {
        SpoonFactory.initialize(launcher);
    }

    private static void initializeClass(String fullClassName) {
        targetClass = launcher.getFactory().Class().get(fullClassName);
    }

    private static void initializeRepOKMethod() {
        targetClass.addMethod(SpoonFactory.createRepOK("repOK"));
    }

    private static void initializeTypesGraph() {
        typesGraph = TypesGraph.createTypesGraph(targetClass.getReference());
    }

    public static CtClass<?> getTargetClass() {
        return targetClass;
    }

    public static TypesGraph getTypesGraph() {
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
            //e.printStackTrace();
        }
        return compiles;
    }

    public static boolean runIndividual(Individual individual) {
        SpoonHelper.putIndividualIntoTheEnvironment(individual);
        boolean repOKResult = false;
        try {
            Class<?> aClass = urlClassLoader.loadClass(targetClass.getQualifiedName());
            Method repOKMethod = aClass.getMethod(individual.getChromosome().getSimpleName());
            repOKResult = (boolean) repOKMethod.invoke(aClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return repOKResult;
    }

    public static void runTestSuite(String testSuiteFullyQualifiedName) {
        try {
            Class<?> testClass = urlClassLoader.loadClass(testSuiteFullyQualifiedName);
            List<Method> testMethods = getRunnableTests(testClass);
            Object testObject = testClass.newInstance();
            int testsExecuted = 0;
            int errors = 0;
            for (Method testMethod : testMethods) {
                // Run the test method and let the instrumentation collect the created objects
                try {
                    Object result = testMethod.invoke(testObject);
                    testsExecuted++;
                } catch (Exception e) {
                    System.err.println("error running test " + testMethod.getName() + ": "+e.getMessage());
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

}
