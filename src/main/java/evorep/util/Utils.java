package evorep.util;

import java.io.File;

public class Utils {

    public static File createDirectory(String path) {
        File binDir = new File(path);
        if (!binDir.exists()) {
            binDir.mkdirs();
        }
        return binDir;
    }
}
