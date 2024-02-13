package evorep.spoon;

import evorep.config.ToolConfig;
import evorep.ga.Individual;
import evorep.spoon.typesgraph.TypesGraph;
import evorep.util.Utils;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

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
            Class<?> aClass = urlClassLoader.loadClass(targetClass.getSimpleName());
            Method repOKMethod = aClass.getMethod("repOK");
            repOKResult = (boolean) repOKMethod.invoke(aClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return repOKResult;
    }

}
