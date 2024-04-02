package evorep.object;

import evorep.spoon.SpoonQueries;
import evorep.typegraph.TypeGraph;
import evorep.util.Utils;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.lang.reflect.Field;
import java.util.*;

/**
 * This class provides methods to perform random mutations on a given object
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class ObjectMutator {

    /**
     * Perform a random mutation on the given object
     *
     * @param rootObject is the object to mutate
     */
    public static boolean mutate(Object rootObject) {
        List<Object> candidates = collectCandidatesForMutation(rootObject);
        TargetField targetField = selectTargetField(candidates);
        if (targetField == null)
            return false;

        Object newFieldValue = getNewValueForField(targetField, candidates);
        targetField.setValue(newFieldValue);
        return true;
    }

    /**
     * Collect all the objects that can be mutated from the given root object
     *
     * @param rootObject is the root object to start the search from
     * @return a list of objects that can be mutated
     */
    static List<Object> collectCandidatesForMutation(Object rootObject) {
        Queue<Object> queue = new ArrayDeque<>();
        Set<Object> visited = new HashSet<>();
        queue.offer(rootObject);

        while (!queue.isEmpty()) {
            Object currentObject = queue.poll();
            if (!visited.contains(currentObject)) {
                visited.add(currentObject);

                Class<?> clazz = currentObject.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        Object fieldValue = field.get(currentObject);
                        if (fieldValue != null && !field.getType().isPrimitive()) {
                            queue.offer(fieldValue);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return visited.stream().toList();
    }

    /**
     * Select a random field to mutate from the given list of candidates
     *
     * @param candidates is the list of objects to select the field from
     * @return a random field to mutate
     */
    static TargetField selectTargetField(List<Object> candidates) {
        int maxAttempts = 10;
        List<CtTypeReference<?>> userDefTypes = TypeGraph.getInstance().getUserDefinedTypes().stream().toList();
        CtTypeReference<?> targetType = userDefTypes.get(new Random().nextInt(userDefTypes.size()));

        Object targetObject = getRandomReferenceOfType(candidates, targetType);
        CtVariable<?> fieldToMutate = selectReferenceField(targetType);
        int i = 0;
        while ((targetObject == null || fieldToMutate == null) && i < maxAttempts) {
            targetType = userDefTypes.get(new Random().nextInt(userDefTypes.size()));
            targetObject = getRandomReferenceOfType(candidates, targetType);
            fieldToMutate = selectReferenceField(targetType);
            i++;
        }

        if (i == maxAttempts)
            return null;

        return new TargetField(targetObject, fieldToMutate);
    }

    /**
     * Get a new value for the given field
     *
     * @param targetField is the field to get the new value for
     * @param candidates  is the list of objects to get the new value from
     * @return a new value for the given field
     */
    static Object getNewValueForField(TargetField targetField, List<Object> candidates) {
        List<Object> possibleChoices = new ArrayList<>(getCandidatesOfType(candidates, targetField));

        // Remove its current value from the possible choices
        Object currentValue = targetField.getValue();
        possibleChoices.remove(currentValue);

        // Add a fresh object to the possible choices
        Object freshObject = ObjectHelper.createNewInstance(targetField.getFieldClass());
        if (freshObject != null)
            possibleChoices.add(freshObject);

        // Add null to the possible choices
        if (currentValue != null)
            possibleChoices.add(null);

        return possibleChoices.get(new Random().nextInt(possibleChoices.size()));
    }

    /**
     * Get all the possible candidates for the given target field. A candidate
     * is an object of the same type as the field and different from the current
     * value (to avoid assigning the same value to the field that it already has)
     *
     * @param candidates  is the list of objects to get the candidates from
     * @param targetField is the field to get the candidates for
     * @return a list of candidates of the given type
     */
    static List<Object> getCandidatesOfType(List<Object> candidates, TargetField targetField) {
        return candidates.stream().filter(o -> o != targetField.getValue() &&
                o.getClass().getTypeName().equals(targetField.getFieldTypeQualifiedName())).toList();
    }

    /**
     * Select a random field to mutate from the given type
     *
     * @param type is the type to select the field from
     * @return a random field to mutate
     */
    static CtVariable<?> selectReferenceField(CtTypeReference<?> type) {
        TypeGraph typeGraph = TypeGraph.getInstance();
        List<CtVariable<?>> fields = typeGraph.getOutgoingFields(type).stream().filter(
                f -> !f.getType().isPrimitive() && !SpoonQueries.isBoxedPrimitive(f.getType())).toList();
        if (fields.isEmpty())
            return null;
        return fields.get(Utils.nextInt(fields.size()));
    }

    /**
     * Get all the possible candidates for the given type
     *
     * @param candidates is the list of objects to get the candidates from
     * @param type       is the type to get the candidates for
     * @return a list of candidates of the given type
     */
    static List<Object> getCandidatesOfType(List<Object> candidates, CtTypeReference<?> type) {
        return candidates.stream().filter(o -> o.getClass().getTypeName().equals(type.getQualifiedName())).toList();
    }

    /**
     * Get a random reference of the given type from the given list of references
     *
     * @param references is the list of references to get the random reference from
     * @param type       is the type of the reference to get
     * @return a random reference of the given type
     */
    static Object getRandomReferenceOfType(List<Object> references, CtTypeReference<?> type) {
        List<Object> objectsOfType = getCandidatesOfType(references, type);
        if (objectsOfType.isEmpty())
            return null;
        return objectsOfType.get(Utils.nextInt(objectsOfType.size()));
    }

    /**
     * This record represents a field of an object to mutate
     */
    record TargetField(Object target, CtVariable<?> field) {

        public Object getTarget() {
            return target;
        }

        public CtVariable<?> getField() {
            return field;
        }

        CtTypeReference<?> getFieldType() {
            return field.getType();
        }

        Class<?> getFieldClass() {
            try {
                Field f = target.getClass().getDeclaredField(field.getSimpleName());
                return f.getType();
            } catch (NoSuchFieldException e) {
                return null;
            }
        }

        String getFieldTypeQualifiedName() {
            return field.getType().getQualifiedName();
        }

        String getTargetTypeName() {
            return target.getClass().getTypeName();
        }

        Object getValue() {
            Object currentValue = null;
            try {
                Field f = target.getClass().getDeclaredField(field.getSimpleName());
                f.setAccessible(true);
                currentValue = f.get(target);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return null;
            }
            return currentValue;
        }

        void setValue(Object newValue) {
            try {
                Field f = target.getClass().getDeclaredField(field.getSimpleName());
                f.setAccessible(true);
                f.set(target, newValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Do nothing
                e.printStackTrace();
            }
        }

    }

}
