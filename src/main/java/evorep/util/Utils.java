package evorep.util;

import org.apache.commons.math3.util.Combinations;
import spoon.reflect.declaration.CtField;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

    public static List<List<CtField<?>>> generateCombinations(List<CtField<?>> inputList, int r) {
        Combinations combinations = new Combinations(inputList.size(), r);
        List<List<CtField<?>>> result = new ArrayList<>();

        for (int[] indices : combinations) {
            List<CtField<?>> combination = new ArrayList<>();
            for (int index : indices) {
                combination.add(inputList.get(index));
            }
            result.add(combination);
        }

        return result;
    }
}
