package express.spoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import express.type.typegraph.Path;
import express.util.LinkedIdentityHashSet;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtVariable;

public class RandomUtils {

    private static final Random r = new Random(SpoonManager.getConfig().randomSeed);

    public static int nextInt(int bound) {
        return r.nextInt(bound);
    }

    public static boolean nextBoolean() {
        return r.nextBoolean();
    }

    public static byte nextByte(byte min, byte max) {
        return (byte) (min + r.nextInt(max - min));
    }

    public static short nextShort(short min, short max) {
        return (short) (min + r.nextInt(max - min));
    }

    public static int nextInt(int min, int max) {
        return min + r.nextInt(max - min);
    }

    public static long nextLong(long min, long max) {
        return min + ((long) (r.nextDouble() * (max - min)));
    }

    public static float nextFloat(float min, float max) {
        return min + r.nextFloat() * (max - min);
    }

    public static double nextDouble(double min, double max) {
        return min + r.nextDouble() * (max - min);
    }

    public static double nextDouble() {
        return r.nextDouble();
    }

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) nextInt(Character.MAX_VALUE);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

    public static CtExpression<Boolean> negateOrNot(CtExpression<Boolean> expression) {
        if (r.nextBoolean())
            return expression;
        return (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(expression, UnaryOperatorKind.NOT);
    }

    public static CtVariable<?> getRandomElementOfType(List<CtVariable<?>> list, Class<?> type) {
        List<CtVariable<?>> newList = SpoonQueries.getVariablesOfType(list, type);
        if (newList.isEmpty())
            return null;
        int choice = r.nextInt(newList.size());
        return newList.get(choice);
    }


    public static CtVariable<?> getRandomElement(List<CtVariable<?>> list1, List<CtVariable<?>> list2) {
        if (list1 == null || list2 == null)
            throw new IllegalArgumentException("Lists cannot be null");

        int totalElements = list1.size() + list2.size();

        int choice = r.nextInt(totalElements);

        if (choice < list1.size())
            return list1.get(choice);
        return list2.get(choice - list1.size());
    }

    public static CtStatement getRandomStatementNonBlockNonExpression(CtBlock<?> block) {
        List<CtStatement> statements = block.getElements(e ->
                e instanceof CtStatement
                        && !(e instanceof CtBlock)
                        && !(e instanceof CtExpression)
        );
        if (statements.isEmpty())
            return null;
        return statements.get(r.nextInt(statements.size()));
    }

    public static CtStatement getRandomStatementNonBlockNonExpressionNonReturn(CtBlock<?> block) {
        List<CtStatement> statements = block.getElements(e ->
                e instanceof CtStatement
                        && !(e instanceof CtBlock)
                        && !(e instanceof CtExpression)
                        && !(e instanceof CtReturn)
        );
        if (statements.isEmpty())
            return null;
        return statements.get(r.nextInt(statements.size()));
    }

    public static List<Integer> getTwoRandomIndices(int bound) {
        if (bound < 2)
            throw new IllegalArgumentException("Bound must be at least 2");
        int index1 = r.nextInt(bound);
        int index2 = r.nextInt(bound);
        while (index2 == index1)
            index2 = r.nextInt(bound);
        return List.of(index1, index2);
    }

    public static int getRandomInteger(List<Integer> list) {
        return list.get(r.nextInt(list.size()));
    }

    public static Path getRandomPath(List<Path> paths) {
        if (paths == null || paths.isEmpty()) {
            throw new IllegalArgumentException("The collection of lists must not be null or empty");
        }

        // Calculate the inverse size weights
        List<Double> weights = new ArrayList<>();
        for (Path path : paths) {
            weights.add(1.0 / (path.size() * path.size()));
        }

        // Calculate the total sum of weights
        double totalWeight = weights.stream().mapToDouble(Double::doubleValue).sum();

        // Normalize weights to get probabilities
        List<Double> probabilities = new ArrayList<>();
        for (double weight : weights) {
            probabilities.add(weight / totalWeight);
        }

        // Generate a random number
        double randomValue = r.nextDouble();

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

        return paths.get(index);
    }

    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The collection must not be null or empty");
        }

        int randomIndex = r.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static <T> T getRandomElement(LinkedIdentityHashSet<T> set) {
        return getRandomElement(new ArrayList<>(set));
    }

    public static List<BinaryOperatorKind> getNumericComparisons() {
        return List.of(BinaryOperatorKind.EQ, BinaryOperatorKind.NE, BinaryOperatorKind.GE, BinaryOperatorKind.GT, BinaryOperatorKind.LE, BinaryOperatorKind.LT);
    }

    public static List<BinaryOperatorKind> getBooleanComparisons() {
        return List.of(BinaryOperatorKind.EQ, BinaryOperatorKind.NE);
    }

    public static BinaryOperatorKind getRandomComparableBinaryOperator() {
        return getRandomElement(getNumericComparisons());
    }

    public static BinaryOperatorKind getRandomBooleanBinaryOperator() {
        return getRandomElement(getBooleanComparisons());
    }

    public static List<Integer> generateRandomIntegers(int max, int n) {
        if (n > max + 1) {
            throw new IllegalArgumentException("Cannot generate more distinct integers than the range allows.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers, r);
        return numbers.subList(0, n);
    }
}
