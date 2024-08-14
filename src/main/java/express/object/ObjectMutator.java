package express.object;

import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.util.Utils;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * This class provides methods to perform random mutations on a given object
 *
 * @author Facundo Molina <facundo.molina@imdea.org>
 * @author Juan Manuel Copia <juanmanuel.copia@imdea.org>
 */
public class ObjectMutator {

    /**
     * Perform a random mutation on the given object
     *
     * @param rootObject is the object to mutate
     */
    public static boolean mutate(Object rootObject) {
        List<Object> candidates = collectCandidatesForMutation(rootObject);
//        System.err.println("\n\nNumber of candidates for mutation: " + candidates.size());
//        System.err.println("Candidates for mutation: " + candidates);
        TargetField targetField = selectTargetField(candidates);
//        System.err.println("Target field: " + targetField);
        if (targetField == null)
            return false;

        Object newFieldValue = getNewValueForField(targetField, candidates);
//        System.err.println("Current field value: " + targetField.getValue());
//        System.err.println("New field value: " + newFieldValue);
        if (newFieldValue == targetField.getValue())
            return false;

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

                Class<?> currentClass = currentObject.getClass();
                if (currentClass.isArray()) {
                    Object[] array = collectObjectsFromArray(currentObject);
                    for (Object o : array) {
                        if (o != null && !o.getClass().isPrimitive()) {
                            queue.offer(o);
                        }
                    }
                } else {
                    Field[] fields = currentClass.getDeclaredFields();
                    for (Field field : fields) {
                        if (field.getType().isArray()) {
                            queue.offer(field);
                            continue;
                        }
                        if (Modifier.isStatic(field.getModifiers()) || !isUserDefinedClass(field.getType())) {
                            continue;
                        }
                        try {
                            field.setAccessible(true);
                            Object fieldValue = field.get(currentObject);
                            if (fieldValue != null) {
                                queue.offer(fieldValue);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return visited.stream().toList();
    }

    private static boolean isUserDefinedClass(Class<?> cls) {
        List<CtTypeReference<?>> userDefTypes = SpoonManager.getTypeData().getUserDefinedTypes();
        return userDefTypes.stream().anyMatch(t -> t.getQualifiedName().equals(cls.getName()));
    }

    public static Object[] collectObjectsFromArray(Object array) {
        // Check if the provided object is an array
        if (!array.getClass().isArray()) {
            throw new IllegalArgumentException("Provided object is not an array");
        }

        // Get the length of the array
        int length = Array.getLength(array);

        // Create an array to hold the collected objects
        Object[] collectedObjects = new Object[length];

        // Iterate over the array and collect each element
        for (int i = 0; i < length; i++) {
            collectedObjects[i] = Array.get(array, i);
        }

        return collectedObjects;
    }


    /**
     * Select a random field to mutate from the given list of candidates
     *
     * @param candidates is the list of objects to select the field from
     * @return a random field to mutate
     */
    static TargetField selectTargetField(List<Object> candidates) {
        List<CtTypeReference<?>> candidateTypes = selectCandidateTypes(candidates);
        if (candidateTypes.isEmpty())
            return null;

        CtTypeReference<?> chosenType = Utils.getRandomElement(candidateTypes);
        List<Object> objectsOfType = getCandidatesOfType(candidates, chosenType);
        Object chosenObject = Utils.getRandomElement(objectsOfType);

        List<CtVariable<?>> referenceFields = TypeUtils.getReferenceFields(chosenType);
        CtVariable<?> chosenField = Utils.getRandomElement(referenceFields);

        return new TargetField(chosenObject, chosenField);
    }

    private static List<CtTypeReference<?>> selectCandidateTypes(List<Object> candidates) {
        List<CtTypeReference<?>> candidateTypes = new ArrayList<>();
        List<CtTypeReference<?>> userDefTypes = SpoonManager.getTypeData().getUserDefinedTypes()
                .stream().filter(TypeUtils::hasReferenceFields).toList();
        for (CtTypeReference<?> type : userDefTypes) {
            if (!getCandidatesOfType(candidates, type).isEmpty())
                candidateTypes.add(type);
        }
        return candidateTypes;
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

        // Add a fresh object to the possible choices
        Class<?> fieldClass = targetField.getFieldClass();
        if (fieldClass != null && !fieldClass.isInterface() && isUserDefinedClass(fieldClass)) {
            Object freshObject = ObjectHelper.createNewInstance(fieldClass);
            if (freshObject != null)
                possibleChoices.add(freshObject);
        }

        // Add null to the possible choices
        Object currentValue = targetField.getValue();
        if (currentValue != null)
            possibleChoices.add(null);

        if (possibleChoices.isEmpty())
            return null;
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
                o.getClass().getName().equals(targetField.getField().getType().getQualifiedName())).toList();
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

        Class<?> getFieldClass() {
            try {
                Field f = target.getClass().getDeclaredField(field.getSimpleName());
                return f.getType();
            } catch (NoSuchFieldException e) {
                return null;
            }
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

        public String toString() {
            return "TargetField{" +
                    "targetType=" + target.getClass() +
                    ", field=" + field.getSimpleName() +
                    '}';
        }

    }

}
