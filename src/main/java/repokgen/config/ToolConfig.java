package repokgen.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import repokgen.spoon.SpoonManager;

public class ToolConfig {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static void parseConfigurationFile() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);

            boolean debugMode = Boolean.parseBoolean(properties.getProperty("app.debug"));
            String srcPath = properties.getProperty("app.srcpath");
            String binPath = properties.getProperty("app.binpath");
            String className = properties.getProperty("app.classname");

            System.err.println("\n -----------------  Configuration Parameters  -----------------\n");
            System.out.println("\tapp.debug = " + debugMode);
            System.out.println("\tapp.srcpath = " + srcPath);
            System.out.println("\tapp.binpath = " + binPath);
            System.out.println("\tapp.classname = " + className);

            SpoonManager.initialize(srcPath, binPath, className);

            System.err.println("\n --------------------------  Running  -------------------------\n\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
