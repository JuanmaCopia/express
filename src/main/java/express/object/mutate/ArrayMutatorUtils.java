package express.object.mutate;

import java.lang.reflect.Array;
import java.util.List;

import express.object.ObjectGenerator;
import express.object.helpers.Objects;
import express.object.helpers.Types;
import express.object.mutate.values.ValueProvider;
import express.spoon.RandomUtils;

public class ArrayMutatorUtils {

    public static boolean mutateArray(Object objectToBeMutated, List<Object> allObjects) {
        if (!objectToBeMutated.getClass().isArray())
            throw new IllegalArgumentException("Object to be mutated must be an array");

        int length = Array.getLength(objectToBeMutated);
        if (length == 0)
            return false;

        boolean success;
        int attempts = 0;
        do {
            attempts++;
            int option = RandomUtils.nextInt(2);
            success = switch (option) {
                case 0 -> {
                    if (Types.isPrimitiveOrBoxedPrimitive(objectToBeMutated.getClass().getComponentType()))
                        yield ArrayMutatorUtils.mutateRandomIndexOfArray(objectToBeMutated);
                    else
                        yield ArrayMutatorUtils.mutateRandomIndexOfReferenceArray(objectToBeMutated, allObjects);
                }
                case 1 -> ArrayMutatorUtils.swapRandomElementsOfArray(objectToBeMutated);
                default -> false;
            };
        } while (!success && attempts < 10);

        if (!success) {
            ObjectGenerator.logger
                    .warning("Could not mutate the array of type: " + objectToBeMutated.getClass().getName());
        }

        return success;
    }

    public static boolean mutateRandomIndexOfArray(Object array) {
        int length = Array.getLength(array);
        if (length == 0)
            throw new IllegalArgumentException("Array must have at least one element");

        int index = RandomUtils.nextInt(length);
        Class<?> componentType = array.getClass().getComponentType();

        if (!componentType.isPrimitive() && RandomUtils.nextBoolean()) {
            Array.set(array, index, null);
        } else {
            Array.set(array, index, ValueProvider.createNewInstance(componentType));
        }
        return true;
    }

    public static boolean mutateRandomIndexOfReferenceArray(Object array, List<Object> allObjects) {
        if (allObjects == null)
            throw new IllegalArgumentException("Collection of objects cannot be null");

        int length = Array.getLength(array);
        if (length == 0)
            throw new IllegalArgumentException("Array must have at least one element");

        int index = RandomUtils.nextInt(length);
        Class<?> componentType = array.getClass().getComponentType();

        List<Object> candidateValues = calculateCandidateValues(allObjects, componentType);

        Array.set(array, index, RandomUtils.getRandomElement(candidateValues));

        return true;
    }

    private static List<Object> calculateCandidateValues(List<Object> allObjects, Class<?> componentType) {
        List<Object> candidateValues = Objects.filterObjectsByType(allObjects, componentType);
        candidateValues.add(ValueProvider.createNewInstance(componentType));
        candidateValues.add(null);
        return candidateValues;
    }

    public static boolean swapRandomElementsOfArray(Object array) {
        int length = Array.getLength(array);
        if (length <= 1)
            return false;

        int index1 = RandomUtils.nextInt(length);
        int index2 = RandomUtils.nextInt(length);
        while (index1 == index2) {
            index2 = RandomUtils.nextInt(length);
        }
        Object temp = Array.get(array, index1);
        Array.set(array, index1, Array.get(array, index2));
        Array.set(array, index2, temp);
        return true;
    }

}
