package evoexpress.spoon;

import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static final Random r = new Random();

    public static int nextInt(int bound) {
        return r.nextInt(bound);
    }

    public static int nextInt(int min, int max) {
        return r.nextInt(max - min) + min;
    }

    public static boolean nextBoolean() {
        return r.nextBoolean();
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

    public static CtCodeElement getRandomElement(List<CtCodeElement> list) {
        if (list.isEmpty())
            return null;
        return list.get(r.nextInt(list.size()));
    }

}
