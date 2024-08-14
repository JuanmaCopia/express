package express.config;

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
    public String outputBinPath = OUTPUT_BIN_FOLDER;
    public String outputSrcPath = OUTPUT_SRC_FOLDER;
    public String predicateClassName;
    public String predicateMethodName;

    // Simulated Annealing Settings
    public double initialTemperature;
    public double coolingRate;
    public int restartRounds;

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
            subjectSrcPath = properties.getProperty("express.subject.src_path");
            subjectTestSrcPath = properties.getProperty("express.subject.test_src_path");
            subjectClassName = properties.getProperty("express.subject.class_name");
            subjectTestSuiteClassName = properties.getProperty("express.subject.test_suite_class_name");
            subjectSrcJavaVersion = Integer.parseInt(properties.getProperty("express.subject.src_java_version"));

            // Output Settings
            outputBinPath = properties.getProperty("express.output.bin_path");
            outputSrcPath = createOuputSrcFolderString(properties.getProperty("express.output.src_path"));
            predicateClassName = properties.getProperty("express.output.predicate_class_name");
            predicateMethodName = properties.getProperty("express.output.predicate_method_name");

            // Search Settings
            initialTemperature = Double.parseDouble(properties.getProperty("express.search.sa.initial_temperature"));
            coolingRate = Double.parseDouble(properties.getProperty("express.search.sa.cooling_rate"));
            restartRounds = Integer.parseInt(properties.getProperty("express.search.sa.restart_rounds"));

            // Object Settings
            maxMutationsPerInstance = Integer
                    .parseInt(properties.getProperty("express.object.max_mutations_per_instance"));

            // Fitness Settings
            timeout_ms = Integer.parseInt(properties.getProperty("express.fitness.timeout_ms"));

            logger.info("Successfully Parsed Configuration File");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "==========================  Configuration Parameters  ==========================\n" +
                "\nSubject Settings:" +
                "\n\texpress.subject.src_path = " + subjectSrcPath +
                "\n\texpress.subject.test_src_path = " + subjectTestSrcPath +
                "\n\texpress.subject.class_name = " + subjectClassName +
                "\n\texpress.subject.test_suite_class_name = " + subjectTestSuiteClassName +
                "\n\texpress.subject.src_java_version = " + subjectSrcJavaVersion +
                "\n\nOutput Settings:" +
                "\n\texpress.output.bin_path = " + outputBinPath +
                "\n\texpress.output.src_path = " + outputSrcPath +
                "\n\texpress.output.predicate_class_name = " + predicateClassName +
                "\n\texpress.output.predicate_method_name = " + predicateMethodName +
                "\n\nSearch Settings:" +
                "\n\texpress.search.sa.initial_temperature = " + initialTemperature +
                "\n\texpress.search.sa.cooling_rate = " + coolingRate +
                "\n\texpress.search.sa.restart_rounds = " + restartRounds +
                "\n\nObject Settings:" +
                "\n\texpress.object.max_mutations_per_instance = " + maxMutationsPerInstance +
                "\n\nFitness Settings:" +
                "\n\texpress.fitness.timeout_ms = " + timeout_ms;
    }

    public String createOuputSrcFolderString(String outputSrcFolder) {
        return outputSrcFolder + "/" + subjectClassName;
    }
}
