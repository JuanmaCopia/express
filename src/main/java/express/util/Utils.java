package express.util;

import express.type.typegraph.Path;
import org.apache.commons.math3.util.Combinations;
import spoon.reflect.declaration.CtField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Utils {

    private static final Random r = new Random();

    public static int nextInt(int bound) {
        return r.nextInt(bound);
    }

    public static boolean nextBoolean() {
        return r.nextBoolean();
    }

    public static URLClassLoader createClassLoader(URL outputBinURL) {
        return new URLClassLoader(new URL[]{outputBinURL});
    }

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

    public static void saveToFile(String content, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Modified source code saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path getRandomPath(Collection<Path> paths) {
        if (paths == null || paths.isEmpty()) {
            throw new IllegalArgumentException("The collection of lists must not be null or empty");
        }

        // Calculate the inverse size weights
        List<Double> weights = new ArrayList<>();
        for (Path path : paths) {
            weights.add(1.0 / path.size());
        }

        // Calculate the total sum of weights
        double totalWeight = weights.stream().mapToDouble(Double::doubleValue).sum();

        // Normalize weights to get probabilities
        List<Double> probabilities = new ArrayList<>();
        for (double weight : weights) {
            probabilities.add(weight / totalWeight);
        }

        // Generate a random number
        double randomValue = Math.random();

        // Use the random number to select a list based on the probabilities
        double cumulativeProbability = 0.0;
        int index = 0;
        for (double probability : probabilities) {
            cumulativeProbability += probability;
            if (randomValue <= cumulativeProbability) {
                break;
            }
            index++;
        }

        // Convert collection to a list to access by index
        List<Path> listOfPaths = new ArrayList<>(paths);
        return listOfPaths.get(index);
    }

    public static <T> T getRandomElement(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("The collection must not be null or empty");
        }

        // Convert the collection to a list
        List<T> list = new ArrayList<>(collection);

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());

        // Return the element at the random index
        return list.get(randomIndex);
    }

}
