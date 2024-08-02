package evoexpress.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Config {

    private static final String OUTPUT_SRC_FOLDER = ".output/src";
    private static final String OUTPUT_BIN_FOLDER = ".output/bin";

    private static final int DEFAULT_MAX_MUTATIONS_PER_INSTANCE = 1;
    private static final int DEFAULT_JAVA_VERSION = 17;
    private static final int DEFAULT_TIMEOUT_MS = 300;

    private final Logger logger = Logger.getLogger(Config.class.getName());

    // Subject Settings
    public String subjectSrcPath;
    public String subjectTestSrcPath;
    public String subjectClassName;
    public String subjectTestSuiteClassName;
    public int subjectSrcJavaVersion = DEFAULT_JAVA_VERSION;

    // Output Settings
    public static String outputBinPath = OUTPUT_BIN_FOLDER;
    public static String outputSrcPath = OUTPUT_SRC_FOLDER;
    public String preconditionClassName;
    public String preconditionMethodName;

    // Search Settings

    // Object Settings
    public int maxMutationsPerInstance = DEFAULT_MAX_MUTATIONS_PER_INSTANCE;

    // Fitness Settings
    public int timeout_ms = DEFAULT_TIMEOUT_MS;

    public Config() {
    }

    public Config(String configFilePath) {
        if (configFilePath == null)
            throw new IllegalArgumentException("Config file path cannot be null");

        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);

            // Subject Settings
            subjectSrcPath = properties.getProperty("evoexpress.subject.src_path");
            subjectTestSrcPath = properties.getProperty("evoexpress.subject.test_src_path");
            subjectClassName = properties.getProperty("evoexpress.subject.class_name");
            subjectTestSuiteClassName = properties.getProperty("evoexpress.subject.test_suite_class_name");
            subjectSrcJavaVersion = Integer.parseInt(properties.getProperty("evoexpress.subject.src_java_version"));

            // Output Settings
            outputBinPath = properties.getProperty("evoexpress.output.bin_path");
            outputSrcPath = createOuputSrcFolderString(properties.getProperty("evoexpress.output.src_path"));
            preconditionClassName = properties.getProperty("evoexpress.output.precondition_class_name");
            preconditionMethodName = properties.getProperty("evoexpress.output.precondition_method_name");

            // Search Settings

            // Object Settings
            maxMutationsPerInstance = Integer
                    .parseInt(properties.getProperty("evoexpress.object.max_mutations_per_instance"));

            // Fitness Settings
            timeout_ms = Integer.parseInt(properties.getProperty("evoexpress.fitness.timeout_ms"));

            logger.info("Successfully Parsed Configuration File");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "\n -----------------  Configuration Parameters  -----------------\n" +
                "\nSubject Settings:" +
                "\n\tevoexpress.subject.src_path = " + subjectSrcPath +
                "\n\tevoexpress.subject.test_src_path = " + subjectTestSrcPath +
                "\n\tevoexpress.subject.class_name = " + subjectClassName +
                "\n\tevoexpress.subject.test_suite_class_name = " + subjectTestSuiteClassName +
                "\n\tevoexpress.subject.src_java_version = " + subjectSrcJavaVersion +
                "\n\nOutput Settings:" +
                "\n\tevoexpress.output.bin_path = " + outputBinPath +
                "\n\tevoexpress.output.src_path = " + outputSrcPath +
                "\n\tevoexpress.output.precondition_class_name = " + preconditionClassName +
                "\n\tevoexpress.output.precondition_method_name = " + preconditionMethodName +
                "\n\nSearch Settings:" +
                "\n\nObject Settings:" +
                "\n\tevoexpress.object.max_mutations_per_instance = " + maxMutationsPerInstance +
                "\n\nFitness Settings:" +
                "\n\tevoexpress.fitness.timeout_ms = " + timeout_ms +
                "\n --------------------------------------------------------------\n";
    }

    public String createOuputSrcFolderString(String outputSrcFolder) {
        return outputSrcFolder + "/" + subjectClassName;
    }
}
