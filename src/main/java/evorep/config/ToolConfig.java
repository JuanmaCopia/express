package evorep.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ToolConfig {

    private static final String CONFIG_FILE_PATH = "config.properties";
    private static final Logger logger = Logger.getLogger(ToolConfig.class.getName());

    // Subject Settings
    public static String subjectSrcPath;
    public static String subjectTestSrcPath;
    public static String subjectClassName;
    public static String subjectTestSuiteClassName;
    public static String subjectMethodName;
    public static int subjectSrcJavaVersion;

    // Output Settings
    public static String outputBinPath = "./output/bin";
    public static String outputSrcPath = "./output/src";
    public static String preconditionClassName = "Precondition";
    public static String preconditionMethodName = "precondition";

    // Search Settings
    public static int maxPopulation;
    public static int maxGenerations;
    public static int elitismCount;
    public static double mutationRate;
    public static double crossoverRate;

    // Object Settings
    public static int maxMutationsPerInstance;

    // Fitness Settings
    public static int timeout_ms = 300;

    public static void parseConfigurationFile() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);

            // Subject Settings
            subjectSrcPath = properties.getProperty("evorep.subject.src_path");
            subjectTestSrcPath = properties.getProperty("evorep.subject.test_src_path");
            subjectClassName = properties.getProperty("evorep.subject.class_name");
            subjectMethodName = properties.getProperty("evorep.subject.method_name");
            subjectTestSuiteClassName = properties.getProperty("evorep.subject.test_suite_class_name");
            subjectSrcJavaVersion = Integer.parseInt(properties.getProperty("evorep.subject.src_java_version"));

            // Output Settings
            outputBinPath = properties.getProperty("evorep.output.bin_path");
            outputSrcPath = createOuputSrcFolderString(properties.getProperty("evorep.output.src_path"));
            preconditionClassName = properties.getProperty("evorep.output.precondition_class_name");
            preconditionMethodName = properties.getProperty("evorep.output.precondition_method_name");

            // Search Settings
            maxPopulation = Integer.parseInt(properties.getProperty("evorep.search.max_population"));
            maxGenerations = Integer.parseInt(properties.getProperty("evorep.search.max_generations"));
            elitismCount = Integer.parseInt(properties.getProperty("evorep.search.elitism"));
            mutationRate = Double.parseDouble(properties.getProperty("evorep.search.mutation_rate"));
            crossoverRate = Double.parseDouble(properties.getProperty("evorep.search.crossover_rate"));

            // Object Settings
            maxMutationsPerInstance = Integer.parseInt(properties.getProperty("evorep.object.max_mutations_per_instance"));

            // Fitness Settings
            timeout_ms = Integer.parseInt(properties.getProperty("evorep.fitness.timeout_ms"));

            printConfigurationParameters();

            logger.info("Successfully Parsed Configuration File");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printConfigurationParameters() {
        System.out.println("\n -----------------  Configuration Parameters  -----------------\n");
        System.out.println("Subject Settings:");
        System.out.println("\tevorep.subject.src_path = " + subjectSrcPath);
        System.out.println("\tevorep.subject.test_src_path = " + subjectTestSrcPath);
        System.out.println("\tevorep.subject.class_name = " + subjectClassName);
        System.out.println("\tevorep.subject.method_name = " + subjectMethodName);
        System.out.println("\tevorep.subject.test_suite_class_name = " + subjectTestSuiteClassName);
        System.out.println("\tevorep.subject.src_java_version = " + subjectSrcJavaVersion);
        System.out.println("\nOutput Settings:");
        System.out.println("\tevorep.output.bin_path = " + outputBinPath);
        System.out.println("\tevorep.output.src_path = " + outputSrcPath);
        System.out.println("\tevorep.output.precondition_class_name = " + preconditionClassName);
        System.out.println("\tevorep.output.precondition_method_name = " + preconditionMethodName);
        System.out.println("\nSearch Settings:");
        System.out.println("\tevorep.search.max_population = " + maxPopulation);
        System.out.println("\tevorep.search.max_generations = " + maxGenerations);
        System.out.println("\tevorep.search.elitism = " + elitismCount);
        System.out.println("\tevorep.search.mutation_rate = " + mutationRate);
        System.out.println("\tevorep.search.crossover_rate = " + crossoverRate);
        System.out.println("\nObject Settings:");
        System.out.println("\tevorep.object.max_mutations_per_instance = " + maxMutationsPerInstance);
        System.out.println("\nFitness Settings:");
        System.out.println("\tevorep.fitness.timeout_ms = " + timeout_ms);
        System.out.println("\n --------------------------------------------------------------\n");
    }

    public static String createOuputSrcFolderString(String outputSrcFolder) {
        return outputSrcFolder + "/" + subjectClassName + "/" + subjectMethodName;
    }
}
