package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.instrumentation.Instrumentation;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.logging.Logger;

public class SpoonManager {

    private final static String DEFAULT_BIN_PATH = "./bin";

    private static final Logger logger = Logger.getLogger(SpoonManager.class.getName());
    public static File outputBinDirectory;
    public static Launcher launcher;
    public static CtClass<?> targetClass;
    public static CtMethod<?> targetMethod;
    public static LinkedList<CtParameter<?>> preconditionParameters;
    public static CtClass<?> testSuiteClass;
    public static URL outputBinURL;
    public static URLClassLoader classLoader;


    public static void initialize() {
        try {
            initializeOutputDirectories();
            initializeLauncher();
            initializeFactories();
            //buildAndCompileModel();

            initializeTarget();
            initializePrecondition();
            initializeTestSuiteClass();
            compileModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializePrecondition() {
        if (SpoonManager.targetMethod == null)
            preconditionParameters = new LinkedList<>();
        else
            preconditionParameters = new LinkedList<>(SpoonManager.targetMethod.getParameters());
        CtClass<?> targetClass = SpoonManager.targetClass;
        CtParameter<?> thisParameter = targetClass.getFactory().Core().createParameter();
        thisParameter.setType(targetClass.getReference());
        thisParameter.setSimpleName("rootObject");
        preconditionParameters.addFirst(thisParameter);
        //preconditionClass = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName);
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
        launcher.addInputResource(ToolConfig.srcPath);
        launcher.setBinaryOutputDirectory(outputBinDirectory);
        //launcher.setSourceOutputDirectory(outputBinDirectory);
        launcher.getEnvironment().setComplianceLevel(ToolConfig.srcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        // launcher.getEnvironment().setSourceClasspath(new
        // String[]{System.getProperty("java.class.path")});
        launcher.buildModel();
        if (!launcher.getModelBuilder().compile())
            throw new RuntimeException("Model does not compile!!");

    }

    private static void initializeFactories() {
        SpoonFactory.initialize(launcher);
    }

    private static void initializeTarget() {
        targetClass = launcher.getFactory().Class().get(ToolConfig.className);
        targetMethod = targetClass.getMethod(ToolConfig.methodName);
        if (targetMethod == null)
            logger.warning("Target Method not found or not set");
    }

    private static void initializeTestSuiteClass() {
        testSuiteClass = launcher.getFactory().Class().get(ToolConfig.testSuiteClassName);
        Instrumentation.instrumentTestSuite(testSuiteClass);
    }

    public static boolean compileIndividual(Individual individual) {
        CtClass<?> addedClass = SpoonHelper.putIndividualIntoTheEnvironment(individual);
        if (!compileModel()) {
            SpoonHelper.removeClassFromEnvironment(addedClass);
            //throw new RuntimeException("The individual does not compile!!!");
            return false;
        }
        SpoonHelper.removeClassFromEnvironment(addedClass);
        return true;
    }

    public static boolean compileModel() {
        boolean compiles = false;
        try {
            compiles = launcher.getModelBuilder().compile();
            //launcher.getModelBuilder().generateProcessedSourceFiles(OutputType.CLASSES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compiles;
    }

}
