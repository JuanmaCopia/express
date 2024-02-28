package evorep.object;

import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to perform random mutations on a given object
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectMutator {

  /**
   * Perform a random mutation on the given object
   * @param object is the object to mutate
   * @param allMutableExpressions is the list of mutable expressions
   */
  public static void mutate(Object object, List<List<CtField<?>>> allMutableExpressions) {
    if (object == null) throw new IllegalArgumentException("Object to mutate cannot be null");

    // Get the list of mutable expressions
    List<List<CtField<?>>> mutableExpressions = getMutableExpressions(object, allMutableExpressions);
    if (mutableExpressions.isEmpty()) throw new IllegalArgumentException("No mutable expressions found");

    // Choose a random expression
    int random = (int) (Math.random() * mutableExpressions.size());
    List<CtField<?>> expression = mutableExpressions.get(random);

    System.out.println("Performing mutation on field: " + expression);
    mutableExpressions.remove(random); // Remove the selected expression from the list of mutable expressions
    replaceByRandomValue(expression, object, mutableExpressions);
  }

  /**
   * Get the list of mutable expressions for the given object
   * The mutable expressions are those that can be evaluated on the object
   * @param object is the object to get the mutable expressions from
   * @param allMutableExpressions is the list of mutable expressions
   * @return the list of mutable expressions for the given object
   */
  private static List<List<CtField<?>>> getMutableExpressions(Object object, List<List<CtField<?>>> allMutableExpressions) {
    List<List<CtField<?>>> mutableExpressions = new ArrayList<>();
    for (List<CtField<?>> mutableExpression : allMutableExpressions) {
      if (isMutable(object, mutableExpression)) {
        mutableExpressions.add(mutableExpression);
      }
    }
    return mutableExpressions;
  }

  /**
   * Check if the given expression is mutable on the given object
   * @param object is the object to check
   * @param expression is the expression to check
   * @return true if the expression is mutable on the object, false otherwise
   */
  private static boolean isMutable(Object object, List<CtField<?>> expression) {
    if (object == null) return false;
    Object current = object;
    boolean isMutable = true;
    for (int i = 0; i < expression.size() - 1; i++) {
      try {
        Field f = current.getClass().getDeclaredField(expression.get(i).getSimpleName());
        f.setAccessible(true);
        current  = f.get(current);
        if (current == null) {
          isMutable = false;
          break;
        }
      } catch (NoSuchFieldException | IllegalAccessException e) {
        isMutable = false;
      }
    }
    return isMutable;
  }

  /**
   * Replace the given expression by a random value in the given object
   * @param expression is the expression to replace
   * @param o is the object to replace the expression in
   * @param mutableExpressions is the list of mutable expressions of the object
   */
  private static void replaceByRandomValue(List<CtField<?>> expression, Object o, List<List<CtField<?>>> mutableExpressions) {
    CtField<?> lastField = expression.get(expression.size() - 1);
    Object newValue;
    if (isBasicType(lastField.getType())) {
      newValue = ValueProvider.getRandomValueForPrimitiveType(lastField.getType());
    } else {
      newValue = ValueProvider.getRandomValueForReferenceType(lastField.getType(), o, mutableExpressions);
    }
    Object current = o;
    for (int i = 0; i < expression.size() - 1; i++) {
      try {
        Field f = current.getClass().getDeclaredField(expression.get(i).getSimpleName());
        f.setAccessible(true);
        current  = f.get(current);
      } catch (NoSuchFieldException | IllegalAccessException e) {
        // Do nothing
      }
    }
    try {
      Field f = current.getClass().getDeclaredField(lastField.getSimpleName());
      f.setAccessible(true);
      f.set(current, newValue);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      // Do nothing
    }
  }

  /**
   * Check if the given type is a basic type
   * @param type is the type to check
   * @return true if the type is a primitive type, false otherwise
   */
  private static boolean isBasicType(CtTypeReference<?> type) {
    return type.isPrimitive();
  }
}
