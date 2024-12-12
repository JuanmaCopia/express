package express.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Utils {

    public static File createDirectory(String path) {
        File binDir = new File(path);
        if (!binDir.exists()) {
            binDir.mkdirs();
        }
        return binDir;
    }

    public static URL createURL(File outputBinDirectory) {
        try {
            return outputBinDirectory.toURI().toURL();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void saveToFile(String content, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Modified source code saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
