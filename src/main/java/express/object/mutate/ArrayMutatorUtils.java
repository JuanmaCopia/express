package express.object.mutate;

import express.object.ObjectGenerator;
import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.util.Utils;

import java.lang.reflect.Array;

public class ArrayMutatorUtils {

    static boolean mutateArray(Object objectToBeMutated) {
        if (!objectToBeMutated.getClass().isArray()) {
            throw new IllegalArgumentException("Object to be mutated must be an array");
        }

        boolean success;
        int attempts = 0;
        do {
            attempts++;
            int option = Utils.nextInt(3);
            success = switch (option) {
                case 0 -> assignNullToRandomIndex(objectToBeMutated);
                case 1 -> setNewValueAtRandomIndex(objectToBeMutated);
                case 2 -> swapRandomElements(objectToBeMutated);
                default -> false;
            };
        } while (!success && attempts < 10);

        if (!success) {
            ObjectGenerator.logger
                    .warning("Could not mutate the array of type: " + objectToBeMutated.getClass().getName());
        }

        return success;
    }

    private static boolean assignNullToRandomIndex(Object array) {
        int length = Array.getLength(array);
        if (length == 0) {
            return false;
        }
        int index = Utils.nextInt(length);
        Array.set(array, index, null);
        return true;
    }

    private static boolean setNewValueAtRandomIndex(Object array) {
        int length = Array.getLength(array);
        if (length == 0) {
            return false;
        }
        int index = Utils.nextInt(length);
        Class<?> componentType = array.getClass().getComponentType();

        Object newValue = null;
        try {
            newValue = Reflection.createNewReferenceTypeInstance(componentType);
        } catch (NewInstanceCreationException e) {
            ObjectGenerator.logger.warning(e.getMessage());
            return false;
        }
        Array.set(array, index, newValue);
        return true;
    }

    private static boolean swapRandomElements(Object array) {
        int length = Array.getLength(array);
        if (length <= 1) {
            return false;
        }
        int index1 = Utils.nextInt(length);
        int index2 = Utils.nextInt(length);
        while (index1 == index2) {
            index2 = Utils.nextInt(length);
        }
        Object temp = Array.get(array, index1);
        Array.set(array, index1, Array.get(array, index2));
        Array.set(array, index2, temp);
        return true;
    }
}
