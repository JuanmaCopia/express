package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.instrumentation.Instrumentation;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
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
    private static int compilationId = 0;

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
        CtClass<?> addedClass = putIndividualIntoTheEnvironment(individual);
        boolean compiles = compileModel();
        removeClassFromEnvironment(addedClass);
        return compiles;
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

    public static CtClass<?> putIndividualIntoTheEnvironment(Individual individual) {
        CtClass<?> preconditionClass = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName + compilationId++);

        CtMethod<?> initialChecks = preconditionClass.getMethodsByName("initialCheck").get(0);
        CtMethod<?> structureChecks = preconditionClass.getMethodsByName("structureCheck").get(0);
        CtMethod<?> primitiveChecks = preconditionClass.getMethodsByName("primitiveCheck").get(0);
        initialChecks.setBody(individual.getInitialCheck());
        structureChecks.setBody(individual.getStructureCheck());
        primitiveChecks.setBody(individual.getPrimitiveCheck());

        CtPackage ctPackage = SpoonManager.targetClass.getPackage();
        ctPackage.addType(preconditionClass);
        individual.className = preconditionClass.getQualifiedName();
        return preconditionClass;
    }

    public static void removeClassFromEnvironment(CtClass<?> ctClass) {
        CtPackage ctPackage = SpoonManager.targetClass.getPackage();
        ctPackage.removeType(ctClass);
    }

}
