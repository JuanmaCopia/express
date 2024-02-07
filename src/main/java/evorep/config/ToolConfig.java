package evorep.config;

import evorep.spoon.SpoonManager;

import java.io.FileInputStream;
import java.util.Properties;

public class ToolConfig {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static String srcPath;
    public static String binPath;
    public static String className;
    public static int srcjavaversion;

    public static void parseConfigurationFile() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);

            srcPath = properties.getProperty("evorep.srcpath");
            binPath = properties.getProperty("evorep.binpath");
            className = properties.getProperty("evorep.classname");
            srcjavaversion = Integer.parseInt(properties.getProperty("evorep.srcjavaversion"));

            System.out.println("\n -----------------  Configuration Parameters  -----------------\n");
            System.out.println("\tevorep.srcpath = " + srcPath);
            System.out.println("\tevorep.binpath = " + binPath);
            System.out.println("\tevorep.classname = " + className);
            System.out.println("\tevorep.srcjavaversion = " + srcjavaversion);
            System.out.println("\n --------------------------------------------------------------\n");

            SpoonManager.initialize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
