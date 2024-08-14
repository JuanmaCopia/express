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
        Target target = selectTarget(candidates);
//        System.err.println("Target field: " + target);
        if (target == null)
            return false;

        Object newFieldValue = getNewValueForTheTarget(target, candidates);
//        System.err.println("Current field value: " + target.getValue());
//        System.err.println("New field value: " + newFieldValue);
        if (newFieldValue == target.getValue())
            return false;

        target.setValue(newFieldValue);
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
                        if (o != null && !TypeChecker.isPrimitiveOrBoxedPrimitive(o.getClass())) {
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

        System.err.println("Collected Objects from array: " + Arrays.toString(collectedObjects));

        return collectedObjects;
    }


    /**
     * Select a random field to mutate from the given list of candidates
     *
     * @param candidates is the list of objects to select the field from
     * @return a random field to mutate
     */
    static Target selectTarget(List<Object> candidates) {
        List<CtTypeReference<?>> candidateTypes = selectCandidateTypes(candidates);
        if (candidateTypes.isEmpty())
            return null;

        CtTypeReference<?> chosenType = Utils.getRandomElement(candidateTypes);
        List<Object> objectsOfType = getCandidatesOfType(candidates, chosenType);
        Object chosenObject = Utils.getRandomElement(objectsOfType);

        Target targetField;
        if (!chosenType.isArray()) {
            List<CtVariable<?>> referenceFields = TypeUtils.getReferenceFields(chosenType);
            CtVariable<?> chosenField = Utils.getRandomElement(referenceFields);
            targetField = new TargetField(chosenObject, chosenField);
        } else {
            int index = new Random().nextInt(Array.getLength(chosenObject));
            targetField = new TargetIndex(chosenObject, index);
        }

        return targetField;
    }

    private static List<CtTypeReference<?>> selectCandidateTypes(List<Object> candidates) {
        List<CtTypeReference<?>> result = new ArrayList<>();
        List<CtTypeReference<?>> candidateTypes = new LinkedList<>(SpoonManager.getTypeData().getUserDefinedTypes()
                .stream().filter(TypeUtils::hasReferenceFields).toList());
        candidateTypes.addAll(SpoonManager.getTypeData().getArrayTypes().stream().filter(
                TypeUtils::isUserDefinedArrayType
        ).toList());
        for (CtTypeReference<?> type : candidateTypes) {
            if (!getCandidatesOfType(candidates, type).isEmpty())
                result.add(type);
        }
        return result;
    }

    /**
     * Get a new value for the given field
     *
     * @param target is the field to get the new value for
     * @param candidates  is the list of objects to get the new value from
     * @return a new value for the given field
     */
    static Object getNewValueForTheTarget(Target target, List<Object> candidates) {
        List<Object> possibleChoices = new ArrayList<>(getCandidatesOfType(candidates, target));

        // Add a fresh object to the possible choices
        Class<?> fieldClass = target.getClassOfObjective();
        if (fieldClass != null && !fieldClass.isInterface() && isUserDefinedClass(fieldClass)) {
            Object freshObject = ObjectHelper.createNewInstance(fieldClass);
            if (freshObject != null)
                possibleChoices.add(freshObject);
        }

        // Add null to the possible choices
        Object currentValue = target.getValue();
        if (currentValue != null)
            possibleChoices.add(null);

        if (possibleChoices.isEmpty())
            return null;
        return Utils.getRandomElement(possibleChoices);
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
    static List<Object> getCandidatesOfType(List<Object> candidates, Target targetField) {
        return candidates.stream().filter(o -> o != targetField.getValue() &&
                o.getClass().getName().equals(targetField.getClassOfObjective().getName())).toList();
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

    public interface Target {
        Object getValue();
        void setValue(Object newValue);
        Class<?> getClassOfObjective();
    }

    /**
     * This record represents a field of an object to mutate
     */
    public static class TargetField implements Target {

        private final Object owner;
        private final CtVariable<?> field;

        public TargetField(Object owner, CtVariable<?> field) {
            this.owner = owner;
            this.field = field;
        }

        public Object getOwner() {
            return owner;
        }

        public CtVariable<?> getField() {
            return field;
        }

        @Override
        public Class<?> getClassOfObjective() {
            try {
                Field f = owner.getClass().getDeclaredField(field.getSimpleName());
                return f.getType();
            } catch (NoSuchFieldException e) {
                return null;
            }
        }

        @Override
        public Object getValue() {
            Object currentValue = null;
            try {
                Field f = owner.getClass().getDeclaredField(field.getSimpleName());
                f.setAccessible(true);
                currentValue = f.get(owner);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return null;
            }
            return currentValue;
        }

        @Override
        public void setValue(Object newValue) {
            try {
                Field f = owner.getClass().getDeclaredField(field.getSimpleName());
                f.setAccessible(true);
                f.set(owner, newValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Do nothing
                e.printStackTrace();
            }
        }

        public String toString() {
            return "TargetField{" +
                    "ownerType=" + owner.getClass() +
                    ", field=" + field.getSimpleName() +
                    '}';
        }

    }

    public static class TargetIndex implements Target {

        private final Object owner;
        private final int index;


        public TargetIndex(Object array, int index) {
            this.owner = array;
            this.index = index;
        }

        public Object getOwner() {
            return owner;
        }

        public int getIndex() {
            return index;
        }

        public Object getValue() {
            Object currentValue = null;
            try {
                currentValue = Array.get(owner, index);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return currentValue;
        }

        public void setValue(Object newValue) {
            try {
                Array.set(owner, index, newValue);
            } catch (Exception e) {
                // Do nothing
                e.printStackTrace();
            }
        }

        @Override
        public Class<?> getClassOfObjective() {
            try {
                return owner.getClass().getComponentType();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

}
