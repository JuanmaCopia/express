package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.ga.mutators.MutatorManager;
import evorep.instrumentation.Instrumentation;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SpoonManager {

    private final static String DEFAULT_BIN_PATH = "./bin";
    public static File outputBinDirectory;
    public static Launcher launcher;
    public static CtClass<?> targetClass;
    public static CtMethod<?> targetMethod;
    public static CtClass<?> testSuiteClass;
    public static CtClass<?> preconditionClass;

    public static String preconditionName;
    public static URL outputBinURL;
    public static URLClassLoader classLoader;


    public static void initialize() {
        try {
            initializeOutputDirectories();
            initializeLauncher();
            initializeFactories();
            initializeTarget();
            initializeTestSuiteClass();
            initializeMutatorManager();
            compileModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeOutputDirectories() {
        String binPath = ToolConfig.binPath;
        if (binPath == null)
            binPath = DEFAULT_BIN_PATH;
        outputBinDirectory = Utils.createDirectory(binPath);
        outputBinURL = Utils.createURL(outputBinDirectory);
        classLoader = Utils.createClassLoader(outputBinURL);
    }

    private static void initializeLauncher() {
        launcher = new Launcher();
        launcher.setBinaryOutputDirectory(outputBinDirectory);
        launcher.addInputResource(ToolConfig.srcPath);
        launcher.getEnvironment().setComplianceLevel(ToolConfig.srcJavaVersion);
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

    private static void initializeTarget() {
        targetClass = launcher.getFactory().Class().get(ToolConfig.className);
        targetMethod = targetClass.getMethod(ToolConfig.methodName);
    }

    private static void initializeTestSuiteClass() {
        testSuiteClass = launcher.getFactory().Class().get(ToolConfig.testSuiteClassName);
        Instrumentation.instrumentTestSuite(testSuiteClass);
    }

    private static void initializeMutatorManager() {
        MutatorManager.initialize();
    }


    public static CtClass<?> getCtClass(String className) {
        return launcher.getFactory().Class().get(className);
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

}
