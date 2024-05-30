package evoexpress.spoon;

import evoexpress.config.ToolConfig;
import evoexpress.ga.individual.Individual;
import evoexpress.instrumentation.Instrumentation;
import evoexpress.util.Utils;
import spoon.Launcher;
import spoon.OutputType;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import type.precondition.InputTypeData;

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
    public static InputTypeData inputTypeData;
    public static CtClass<?> testSuiteClass;
    public static URL outputBinURL;
    public static URLClassLoader classLoader;

    public static void initialize() {
        try {
            initializeOutputDirectories();
            initializeLauncher();
            initializeFactories();
            initializeTarget();
            initializeInputTypeData();
            initializeTestSuiteClass();
            compileModel();
            initializeClassLoader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeInputTypeData() {
        inputTypeData = new InputTypeData(createParameterList());
    }

    private static LinkedList<CtParameter<?>> createParameterList() {
        LinkedList<CtParameter<?>> preconditionParameters;
        if (SpoonManager.targetMethod == null)
            preconditionParameters = new LinkedList<>();
        else
            preconditionParameters = new LinkedList<>(SpoonManager.targetMethod.getParameters());
        CtClass<?> targetClass = SpoonManager.targetClass;
        CtParameter<?> thisParameter = targetClass.getFactory().Core().createParameter();
        thisParameter.setType(targetClass.getReference());
        thisParameter.setSimpleName("_this");
        preconditionParameters.addFirst(thisParameter);
        return preconditionParameters;
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
        //CtClass<?> addedClass = putIndividualIntoTheEnvironment(individual);
        //addClassToPackage(individual.getCtClass());
//        individual.setIndividualClassName(preconditionClass.getQualifiedName());
        boolean compiles = compileModel();
        if (!compiles)
            removeClassFromPackage(individual.getCtClass());
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

//    public static CtClass<?> putIndividualIntoTheEnvironment(Individual individual) {
//        CtClass<?> preconditionClass = generateIndividualCtClass(individual, compilationId++);
//        addClassToPackage(preconditionClass);
//        individual.setIndividualClassName(preconditionClass.getQualifiedName());
//        return preconditionClass;
//    }
//
//    private static CtClass<?> generateIndividualCtClass(Individual individual, Integer id) {
//        return Refactoring.copyType(individual.getClass());
//    }

    public static void addClassToPackage(CtClass<?> ctClass) {
        targetClass.getPackage().addType(ctClass);
    }

    public static void removeClassFromPackage(CtClass<?> ctClass) {
        targetClass.getPackage().removeType(ctClass);
    }

    public static void generateSourcePreconditionSourceFile(Individual individual) {
        CtClass<?> individualCtClass = individual.getCtClass();
        individualCtClass.setSimpleName(ToolConfig.preconditionClassName);
        addClassToPackage(individualCtClass);
        try {
            launcher.getModelBuilder().generateProcessedSourceFiles(OutputType.CLASSES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        removeClassFromPackage(individualCtClass);
    }

}
