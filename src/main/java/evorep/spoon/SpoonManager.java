package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.instrumentation.Instrumentation;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.OutputType;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.logging.Logger;

public class SpoonManager {

    private static final Logger logger = Logger.getLogger(SpoonManager.class.getName());
    public static File outputBinDirectory;
    public static File outputSrcDirectory;
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
            initializeTarget();
            initializePrecondition();
            initializeTestSuiteClass();
            compileModel();
            initializeClassLoader();
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
        thisParameter.setSimpleName("_this");
        preconditionParameters.addFirst(thisParameter);
    }

    private static void initializeOutputDirectories() {
        outputBinDirectory = Utils.createDirectory(ToolConfig.outputBinPath);
        outputSrcDirectory = Utils.createDirectory(ToolConfig.outputSrcPath);
    }

    private static void initializeClassLoader() {
        outputBinURL = Utils.createURL(outputBinDirectory);
        classLoader = Utils.createClassLoader(outputBinURL);
    }

    private static void initializeLauncher() {
        launcher = new Launcher();
        launcher.addInputResource(ToolConfig.subjectSrcPath);
        launcher.setBinaryOutputDirectory(outputBinDirectory);
        launcher.setSourceOutputDirectory(outputSrcDirectory);
        launcher.getEnvironment().setComplianceLevel(ToolConfig.subjectSrcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        launcher.buildModel();
    }

    private static void instrumentClasses() {
        Instrumentation.instrumentClasses(launcher.getModel());
    }

    private static void initializeFactories() {
        SpoonFactory.initialize(launcher);
    }

    private static void initializeTarget() {
        targetClass = launcher.getFactory().Class().get(ToolConfig.subjectClassName);
        targetMethod = targetClass.getMethod(ToolConfig.subjectMethodName);
        if (targetMethod == null)
            logger.warning("Target Method not found or not set");
    }

    private static void initializeTestSuiteClass() {
        testSuiteClass = launcher.getFactory().Class().get(ToolConfig.subjectTestSuiteClassName);
        Instrumentation.instrumentTestSuite(testSuiteClass);
    }

    public static boolean compileIndividual(Individual individual) {
        CtClass<?> addedClass = putIndividualIntoTheEnvironment(individual);
        boolean compiles = compileModel();
        removeClassFromPackage(addedClass);
        return compiles;
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

    public static CtClass<?> putIndividualIntoTheEnvironment(Individual individual) {
        CtClass<?> preconditionClass = generateIndividualCtClass(individual, compilationId++);
        addClassToPackage(preconditionClass);
        individual.setIndividualClassName(preconditionClass.getQualifiedName());
        return preconditionClass;
    }

    private static CtClass<?> generateIndividualCtClass(Individual individual, Integer id) {
        String preconditionClassName = ToolConfig.preconditionClassName;
        if (id != null)
            preconditionClassName += id;

        CtClass<?> preconditionClass = SpoonFactory.createPreconditionClass(preconditionClassName);

        CtMethod<?> initialChecks = preconditionClass.getMethodsByName("initialCheck").get(0);
        CtMethod<?> structureChecks = preconditionClass.getMethodsByName("structureCheck").get(0);
        CtMethod<?> primitiveChecks = preconditionClass.getMethodsByName("primitiveCheck").get(0);
        initialChecks.setBody(individual.getInitialCheck());
        structureChecks.setBody(individual.getStructureCheck());
        primitiveChecks.setBody(individual.getPrimitiveCheck());

        return preconditionClass;
    }

    public static void addClassToPackage(CtClass<?> ctClass) {
        targetClass.getPackage().addType(ctClass);
    }

    public static void removeClassFromPackage(CtClass<?> ctClass) {
        targetClass.getPackage().removeType(ctClass);
    }

    public static void generateSourcePreconditionSourceFile(Individual individual) {
        CtClass<?> individualCtClass = generateIndividualCtClass(individual, null);
        addClassToPackage(individualCtClass);
        try {
            launcher.getModelBuilder().generateProcessedSourceFiles(OutputType.CLASSES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        removeClassFromPackage(individualCtClass);
    }

}
