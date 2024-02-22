package evorep.config;

import evorep.spoon.SpoonManager;

import java.io.FileInputStream;
import java.util.Properties;

public class ToolConfig {
    private static final String CONFIG_FILE_PATH = "config.properties";

    // Subject Settings
    public static String srcPath;
    public static String testSrcPath;
    public static String binPath;
    public static String className;
    public static String testSuiteClassName;

    public static int srcJavaVersion;

    // Search Settings
    public static int maxPopulation;
    public static int maxGenerations;


    public static void parseConfigurationFile() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);

            srcPath = properties.getProperty("evorep.src_path");
            testSrcPath = properties.getProperty("evorep.test_src_path");
            binPath = properties.getProperty("evorep.bin_path");
            className = properties.getProperty("evorep.class_name");
            testSuiteClassName = properties.getProperty("evorep.test_suite_class_name");
            srcJavaVersion = Integer.parseInt(properties.getProperty("evorep.src_java_version"));

            maxPopulation = Integer.parseInt(properties.getProperty("evorep.search.max_population"));
            maxGenerations = Integer.parseInt(properties.getProperty("evorep.search.max_generations"));

            System.out.println("\n -----------------  Configuration Parameters  -----------------\n");
            System.out.println("\tevorep.src_path = " + srcPath);
            System.out.println("\tevorep.test_src_path = " + testSrcPath);
            System.out.println("\tevorep.bin_path = " + binPath);
            System.out.println("\tevorep.class_name = " + className);
            System.out.println("\tevorep.test_suite_class_name = " + testSuiteClassName);
            System.out.println("\tevorep.src_java_version = " + srcJavaVersion);
            System.out.println("");
            System.out.println("\tevorep.search.max_population = " + maxPopulation);
            System.out.println("\tevorep.search.max_generations = " + maxGenerations);
            System.out.println("\n --------------------------------------------------------------\n");

            SpoonManager.initialize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
