package express.object.mutate;

import express.object.helpers.*;
import express.object.mutate.values.ValueProvider;
import express.spoon.RandomUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReferenceTypeMutator {

    /**
     * Perform a random mutation on the given object
     *
     * @param rootObject is the object to mutate
     */
    public static boolean mutateHeap(Object rootObject) {
        Set<Object> reachableObjects = Collect.collectReachableObjects(rootObject);
        List<Object> candidates = reachableObjects.stream().filter(ReferenceTypeMutator::isMutableHeapObject).toList();

        if (candidates.isEmpty())
            return false;

        Object toBeMutated = selectObjectForMutation(candidates);
        return mutateHeapOfObject(toBeMutated, reachableObjects);
    }

    static Object selectObjectForMutation(Collection<Object> allObjects) {
        if (RandomUtils.nextInt(0, 100) < 10)
            return RandomUtils.getRandomElement(allObjects);

        Set<Class<?>> candidateTypes = Objects.filterTypes(allObjects);

        Class<?> chosenType = RandomUtils.getRandomElement(candidateTypes);
        Set<Object> candidatesOfChosenType = Objects.filterObjectsByType(allObjects, chosenType);

        return RandomUtils.getRandomElement(candidatesOfChosenType);
    }

    private static boolean mutateHeapOfObject(Object objectToBeMutated, Collection<Object> reachableObjects) {
        if (objectToBeMutated == null)
            throw new IllegalArgumentException("Object to be mutated cannot be null");

        if (Types.isUserDefinedClass(objectToBeMutated.getClass()))
            return mutateHeapUserDefinedObject(objectToBeMutated, reachableObjects);
        if (objectToBeMutated instanceof Collection<?> collection)
            return CollectionMutatorUtils.mutateCollection(collection);
        if (objectToBeMutated instanceof Map<?, ?> map)
            return MapMutatorUtils.mutateMap(map);
        if (objectToBeMutated.getClass().isArray())
            return ArrayMutatorUtils.mutateArray(objectToBeMutated, reachableObjects);

        return false;
    }

    private static boolean mutateHeapUserDefinedObject(Object objectToBeMutated, Collection<Object> allObjects) {
        Class<?> type = objectToBeMutated.getClass();
        if (!Types.isUserDefinedClass(type))
            throw new IllegalArgumentException("Object to be mutated must be a user-defined class");

        List<Field> fields = Reflection.getReferenceFields(type);
        if (fields.isEmpty())
            return false;

        Field fieldToMutate = RandomUtils.getRandomElement(fields);

        int attempts = 0;
        boolean mutated = false;
        do {
            if (Types.isBoxedPrimitive(fieldToMutate)) {
                mutated = mutateBoxedPrimitiveField(objectToBeMutated, fieldToMutate);
            } else {
                mutated = mutateReferenceField(objectToBeMutated, fieldToMutate, allObjects);
            }
        } while (!mutated && attempts++ < 10);

        return mutateReferenceField(objectToBeMutated, fieldToMutate, allObjects);
    }

    private static boolean mutateBoxedPrimitiveField(Object targetObject, Field field) {
        Object currentValue = Reflection.getFieldValue(targetObject, field);
        if (currentValue == null)
            Reflection.setFieldValue(targetObject, field, ValueProvider.createNewRandomPrimitiveWrapperValue(field.getType()));
        else
            Reflection.setFieldValue(targetObject, field, null);
        return true;
    }

    public static boolean mutateReferenceField(Object targetObject, Field field, Collection<Object> allObjects) {
        Class<?> type = field.getType();
        if (type.isPrimitive())
            throw new IllegalArgumentException("This method is only for reference types");

        Set<Object> candidates = calculateCandidateReferenceValues(targetObject, field, allObjects);
        if (candidates.isEmpty())
            return false;
        Object newValue = RandomUtils.getRandomElement(candidates);
        Reflection.setFieldValue(targetObject, field, newValue);
        return true;
    }

    public static Set<Object> calculateCandidateReferenceValues(Object targetObject, Field field,
                                                                Collection<Object> allObjects) {
        Class<?> type = field.getType();
        if (type.isPrimitive())
            throw new IllegalArgumentException("This method is only for reference types");

        Set<Object> candidates = Objects.filterObjectsByType(allObjects, type);

        Object currentValue = Reflection.getFieldValue(targetObject, field);
        if (currentValue != null) {
            // Add null as a candidate
            candidates.add(null);

            // Remove the current value from the candidates
            candidates.remove(currentValue);
        }

        Object newInstance = null;
        try {
            newInstance = Reflection.createNewReferenceTypeInstance(type);
        } catch (NewInstanceCreationException e) {
            if (isMutableHeapClass(type))
                throw new RuntimeException(e);
        }
        if (newInstance != null) {
            // Add new instance of the class as a candidate
            candidates.add(newInstance);
        }

        return candidates;
    }

    public static boolean isMutableHeapObject(Object o) {
        if (o == null)
            return false;
        return isMutableHeapClass(o.getClass());
    }

    public static boolean isMutableHeapClass(Class<?> clazz) {
        if (clazz == null)
            throw new IllegalArgumentException("Class cannot be null");
        if (Types.isUserDefinedClass(clazz))
            return true;
        if (Types.isCollectionOfReferenceType(clazz))
            return true;
        if (Types.isMapOfReferenceType(clazz))
            return true;
        if (Types.isArrayOfReferenceType(clazz))
            return true;
        return false;
    }

}
