package evorep.util;

import java.io.File;
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
}
