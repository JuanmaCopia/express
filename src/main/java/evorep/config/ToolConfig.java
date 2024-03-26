package evorep.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ToolConfig {
    private static final String CONFIG_FILE_PATH = "config.properties";

    // Subject Settings
    public static String srcPath;
    public static String testSrcPath;
    public static String binPath;
    public static String className;
    public static String methodName;
    public static String testSuiteClassName;

    public static int srcJavaVersion;

    // Output Settings
    public static String preconditionClassName;
    public static String preconditionMethodName;

    // Search Settings
    public static int maxPopulation;
    public static int maxGenerations;
    public static int elitismCount;
    public static double mutationRate;
    public static double crossoverRate;

    // Object Settings
    public static int maxMutationsPerInstance;

    // Fitness Settings
    public static int timeout;


    public static void parseConfigurationFile() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);

            // Subject Settings
            srcPath = properties.getProperty("evorep.src_path");
            testSrcPath = properties.getProperty("evorep.test_src_path");
            binPath = properties.getProperty("evorep.bin_path");
            className = properties.getProperty("evorep.class_name");
            methodName = properties.getProperty("evorep.method_name");
            testSuiteClassName = properties.getProperty("evorep.test_suite_class_name");
            srcJavaVersion = Integer.parseInt(properties.getProperty("evorep.src_java_version"));

            // Output Settings
            preconditionClassName = properties.getProperty("evorep.precondition_class_name");
            preconditionMethodName = properties.getProperty("evorep.precondition_method_name");

            // Search Settings
            maxPopulation = Integer.parseInt(properties.getProperty("evorep.search.max_population"));
            maxGenerations = Integer.parseInt(properties.getProperty("evorep.search.max_generations"));
            elitismCount = Integer.parseInt(properties.getProperty("evorep.search.elitism"));
            mutationRate = Double.parseDouble(properties.getProperty("evorep.search.mutation_rate"));
            crossoverRate = Double.parseDouble(properties.getProperty("evorep.search.crossover_rate"));

            // Object Settings
            maxMutationsPerInstance = Integer.parseInt(properties.getProperty("evorep.object.max_mutations_per_instance"));

            // Fitness Settings
            timeout = Integer.parseInt(properties.getProperty("evorep.fitness.timeout"));

            System.out.println("\n -----------------  Configuration Parameters  -----------------\n");
            System.out.println("Subject Settings:");
            System.out.println("\tevorep.src_path = " + srcPath);
            System.out.println("\tevorep.test_src_path = " + testSrcPath);
            System.out.println("\tevorep.bin_path = " + binPath);
            System.out.println("\tevorep.class_name = " + className);
            System.out.println("\tevorep.method_name = " + methodName);
            System.out.println("\tevorep.test_suite_class_name = " + testSuiteClassName);
            System.out.println("\tevorep.src_java_version = " + srcJavaVersion);
            System.out.println("\nOutput Settings:");
            System.out.println("\tevorep.precondition_class_name = " + preconditionClassName);
            System.out.println("\tevorep.precondition_method_name = " + preconditionMethodName);
            System.out.println("\nSearch Settings:");
            System.out.println("\tevorep.search.max_population = " + maxPopulation);
            System.out.println("\tevorep.search.max_generations = " + maxGenerations);
            System.out.println("\tevorep.search.elitism = " + elitismCount);
            System.out.println("\tevorep.search.mutation_rate = " + mutationRate);
            System.out.println("\tevorep.search.crossover_rate = " + crossoverRate);
            System.out.println("\nObject Settings:");
            System.out.println("\tevorep.object.max_mutations_per_instance = " + maxMutationsPerInstance);
            System.out.println("\nFitness Settings:");
            System.out.println("\tevorep.fitness.timeout = " + timeout);
            System.out.println("\n --------------------------------------------------------------\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
