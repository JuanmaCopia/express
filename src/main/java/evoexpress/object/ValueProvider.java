package evoexpress.object;

import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to provide random values for specific types (used for object mutation)
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ValueProvider {

    /**
     * Get a random value for the given primitive type
     *
     * @param type is the type to get the random value for
     * @return a random value for the given primitive type
     */
    public static Object getRandomValueForPrimitiveType(CtTypeReference<?> type) {
        Random r = new Random();
        if (type.getSimpleName().equals("int"))
            return r.nextInt(100);
        if (type.getSimpleName().equals("double"))
            return r.nextDouble();
        if (type.getSimpleName().equals("float"))
            return r.nextFloat();
        if (type.getSimpleName().equals("long"))
            return r.nextLong();
        if (type.getSimpleName().equals("short"))
            return (short) r.nextInt(100);
        if (type.getSimpleName().equals("byte"))
            return (byte) r.nextInt(100);
        if (type.getSimpleName().equals("char"))
            return (char) r.nextInt(100);
        if (type.getSimpleName().equals("boolean"))
            return r.nextBoolean();
        throw new IllegalArgumentException("Type not supported: " + type);
    }

    /**
     * Get a random value for the given reference type, by searching for a random value in the object
     *
     * @param type                 is the type to get the random value for
     * @param object               is the object to get the random value from
     * @param evaluableExpressions is the list of evaluable expressions for the object
     * @return a random value for the given reference type
     */
    public static Object getRandomValueForReferenceType(CtTypeReference<?> type, Object object, List<List<CtField<?>>> evaluableExpressions) {
        List<CtField<?>> expr = getRandomExpressionOfSameType(type, evaluableExpressions);
        return eval(expr, object);
    }

    /**
     * Get a random expression of the same type as the given type
     *
     * @param type                 is the type to get the random expression
     * @param evaluableExpressions is the list of evaluable expressions for the object
     * @return a random expression of the same type as the given type
     */
    private static List<CtField<?>> getRandomExpressionOfSameType(CtTypeReference<?> type, List<List<CtField<?>>> evaluableExpressions) {
        List<List<CtField<?>>> expressionsOfSameType = new ArrayList<>();
        for (List<CtField<?>> expression : evaluableExpressions) {
            CtField<?> lastField = expression.get(expression.size() - 1);
            if (lastField.getType().equals(type)) {
                expressionsOfSameType.add(expression);
            }
        }
        if (expressionsOfSameType.isEmpty()) return null;
        Random r = new Random();
        int random = r.nextInt(expressionsOfSameType.size());
        return expressionsOfSameType.get(random);
    }

    /**
     * Evaluate the given expression on the given object
     *
     * @param expression is the expression to evaluate
     * @param object     is the object to evaluate the expression on
     * @return the value of the expression on the object
     */
    private static Object eval(List<CtField<?>> expression, Object object) {
        if (expression == null) return null;
        Object current = object;
        for (int i = 0; i < expression.size(); i++) {
            try {
                Field f = current.getClass().getDeclaredField(expression.get(i).getSimpleName());
                f.setAccessible(true);
                current = f.get(current);
                if (current == null) {
                    return null;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return null;
            }
        }
        return current;
    }

}
