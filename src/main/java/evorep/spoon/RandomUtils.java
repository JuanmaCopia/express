package evorep.spoon;

import spoon.reflect.code.CtExpression;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static Random r = new Random();

    public static int nextInt(int bound) {
        return r.nextInt(bound);
    }

    public static boolean nextBoolean() {
        return r.nextBoolean();
    }

    public static boolean chooseWithProbability(int numberOfElements) {
        int probability = 100 / numberOfElements;
        return r.nextInt(100) < probability;
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

    public static CtVariable<?> getRandomElementOfType(List<CtVariable<?>> list, CtTypeReference<?> type) {
        return getRandomElementOfType(list, type.getActualClass());
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

    public static CtVariable<?> getRandomElement(List<CtVariable<?>> list) {
        if (list == null)
            throw new IllegalArgumentException("Lists cannot be null");

        return list.get(r.nextInt(list.size()));
    }

}
