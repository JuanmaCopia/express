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
            initializePreconditionParameters();
            initializeTestSuiteClass();
            compileModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializePreconditionParameters() {
        if (SpoonManager.targetMethod == null)
            preconditionParameters = new LinkedList<>();
        else
            preconditionParameters = new LinkedList<>(SpoonManager.targetMethod.getParameters());
        CtClass<?> targetClass = SpoonManager.targetClass;
        CtParameter<?> thisParameter = targetClass.getFactory().Core().createParameter();
        thisParameter.setType(targetClass.getReference());
        thisParameter.setSimpleName("rootObject");
        preconditionParameters.addFirst(thisParameter);
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
        launcher.getEnvironment().setComplianceLevel(ToolConfig.srcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        // launcher.getEnvironment().setSourceClasspath(new
        // String[]{System.getProperty("java.class.path")});
        launcher.buildModel();
        if (!launcher.getModelBuilder().compile())
            throw new RuntimeException("Model does not compile!!");

    }

/*    private static void buildAndCompileModel() {
        launcher.addInputResource(ToolConfig.srcPath);
        launcher.buildModel();
        if (!launcher.getModelBuilder().compile())
            throw new RuntimeException("Model does not compile!!");
    }*/

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

    public static CtClass<?> getCtClass(String className) {
        return launcher.getFactory().Class().get(className);
    }

    public static boolean compileIndividual(Individual individual) {
        SpoonHelper.putIndividualIntoTheEnvironment(individual);
        if (!compileModel()) {
            SpoonHelper.removeIndividualFromEnvironment(individual);
            return false;
            /*System.err.println("\n Individual not compiling: \n");
            System.err.println(individual.getChromosome().toString());
            throw new RuntimeException("The individual does not compile!!!");*/
        }
        return true;
    }

    public static boolean compileModel() {
        boolean compiles = false;
        try {
            compiles = launcher.getModelBuilder().compile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compiles;
    }

}
