package evorep.spoon;

import evorep.config.ToolConfig;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;

import java.io.File;

public class SpoonManager {

    private final static String DEFAULT_BIN_PATH = "./target";

    private static SpoonAPI launcher;
    private static CtClass<?> targetClass;

    private SpoonManager() {
    }

    public static void initialize() {
        initialize(ToolConfig.srcPath, ToolConfig.binPath, ToolConfig.className, ToolConfig.srcJavaVersion);
    }

    public static void initialize(String srcPath, String binPath, String fullClassName, int srcJavaVersion) {
        try {
            initializeLauncher(srcPath, binPath, srcJavaVersion);
            initializeFactories();
            initializeClass(fullClassName);
            initializeCompiler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeLauncher(String srcPath, String binPath, int srcJavaVersion) {
        launcher = new Launcher();
        launcher.addInputResource(srcPath);
        launcher.setBinaryOutputDirectory(createBinDirectory(binPath));
        launcher.getEnvironment().setComplianceLevel(srcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        launcher.buildModel();
    }

    private static File createBinDirectory(String binPath) {
        if (binPath == null)
            binPath = DEFAULT_BIN_PATH;
        File binDir = new File(binPath);
        if (!binDir.exists()) {
            binDir.mkdirs();
        }
        return binDir;
    }

    private static void initializeFactories() {
        SpoonFactory.initialize(launcher);
    }

    private static void initializeClass(String fullClassName) {
        targetClass = launcher.getFactory().Class().get(fullClassName);
    }

    private static void initializeCompiler() {
        SpoonCompiler.initialize(launcher);
    }

    public static CtClass<?> getTargetClass() {
        return targetClass;
    }

}
