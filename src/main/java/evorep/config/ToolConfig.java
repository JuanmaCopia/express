package evorep.config;

import evorep.spoon.SpoonManager;

import java.io.FileInputStream;
import java.util.Properties;

public class ToolConfig {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static void parseConfigurationFile() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);

            String srcPath = properties.getProperty("evorep.srcpath");
            String binPath = properties.getProperty("evorep.binpath");
            String className = properties.getProperty("evorep.classname");

            System.out.println("\n -----------------  Configuration Parameters  -----------------\n");
            System.out.println("\tevorep.srcpath = " + srcPath);
            System.out.println("\tevorep.binpath = " + binPath);
            System.out.println("\tevorep.classname = " + className);

            SpoonManager.initialize(srcPath, binPath, className);

            System.out.println("\n --------------------------  Running  -------------------------\n\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
