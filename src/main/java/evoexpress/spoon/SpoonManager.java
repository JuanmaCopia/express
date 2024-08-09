package evoexpress.spoon;

import evoexpress.config.Config;
import evoexpress.instrumentation.Instrumentation;
import evoexpress.output.InputOutputManager;
import evoexpress.type.typegraph.TypeData;
import spoon.Launcher;
import spoon.reflect.declaration.*;

import java.net.URLClassLoader;
import java.util.logging.Logger;

public class SpoonManager {

    private static final Logger logger = Logger.getLogger(SpoonManager.class.getName());

    static Config config;
    static InputOutputManager output;

    static Launcher launcher;
    static CtClass<?> testSuiteClass;
    static TypeData typeData;

    static boolean initialized = false;

    public static void initialize(Config conf) {
        config = conf;
        launcher = new Launcher();
        launcher.addInputResource(config.subjectSrcPath);

        launcher.getEnvironment().setComplianceLevel(config.subjectSrcJavaVersion);
        launcher.getEnvironment().setShouldCompile(true);
        launcher.getEnvironment().setAutoImports(true);
        //launcher.getEnvironment().setPreserveLineNumbers(true);
        launcher.buildModel();

        typeData = new TypeData(launcher.getFactory().Class().get(config.subjectClassName));

        output = new InputOutputManager(launcher, config, typeData.getThisCtClass().getPackage());
        launcher.setBinaryOutputDirectory(output.getOutputBinPath());
        launcher.setSourceOutputDirectory(output.getOutputSrcPath());

        SpoonFactory.initialize(config, launcher, typeData);

        testSuiteClass = launcher.getFactory().Class().get(config.subjectTestSuiteClassName);
        Instrumentation.instrumentClasses(launcher.getModel());
        Instrumentation.instrumentTestSuite(testSuiteClass);

        output.getCompiler().compileModel();

        initialized = true;
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static TypeData getTypeData() {
        return typeData;
    }

    public static Launcher getLauncher() {
        return launcher;
    }

    public static CtClass<?> getTestSuiteClass() {
        return testSuiteClass;
    }

    public static InputOutputManager getOutput() {
        return output;
    }

    public static Config getConfig() {
        return config;
    }
}
