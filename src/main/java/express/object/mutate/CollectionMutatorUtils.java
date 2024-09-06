package express.object.mutate;

import express.object.ObjectGenerator;
import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.spoon.RandomUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CollectionMutatorUtils {

    static boolean mutateCollection(Collection<?> objectToBeMutated) {
        boolean success;
        int attempts = 0;
        do {
            attempts++;
            int option = RandomUtils.nextInt(5);
            success = switch (option) {
                case 0 -> removeElement(objectToBeMutated);
                case 1 -> addNewInstance(objectToBeMutated);
                case 2 -> replaceElement(objectToBeMutated);
                case 3 -> clearCollection(objectToBeMutated);
                case 4 -> swapElements(objectToBeMutated);
                default -> false;
            };
        } while (!success && attempts < 10);

        if (!success) {
            ObjectGenerator.logger
                    .warning("Could not mutate the collection of type: " + objectToBeMutated.getClass().getName());
        }

        return success;
    }

    private static boolean removeElement(Collection<?> collection) {
        if (collection.isEmpty())
            return false;
        List<?> list = new ArrayList<>(collection);
        int index = new Random().nextInt(list.size());
        collection.remove(list.get(index));
        return true;
    }

    private static <T> boolean addNewInstance(Collection<T> collection) {
        try {
            Class<T> elementType = Reflection.getClassOfObjectsInCollection(collection);
            T newInstance = Reflection.createNewReferenceTypeInstance(elementType);
            collection.add(newInstance);
            return true;
        } catch (NewInstanceCreationException e) {
            ObjectGenerator.logger.warning(e.getMessage());
        }
        return false;
    }

    private static <T> boolean replaceElement(Collection<T> collection) {
        if (collection.isEmpty())
            return false;

        try {
            Class<T> elementType = Reflection.getClassOfObjectsInCollection(collection);
            T newInstance = Reflection.createNewReferenceTypeInstance(elementType);

            List<T> list = new ArrayList<>(collection);
            int index = RandomUtils.nextInt(list.size());
            list.set(index, newInstance);

            collection.clear();
            collection.addAll(list);
            return true;
        } catch (NewInstanceCreationException e) {
            ObjectGenerator.logger.warning(e.getMessage());
        }
        return false;
    }

    private static boolean clearCollection(Collection<?> collection) {
        if (collection.isEmpty())
            return false;
        collection.clear();
        return true;
    }

    private static <T> boolean swapElements(Collection<T> collection) {
        if (collection.size() <= 1)
            return false;

        List<T> list = new ArrayList<>(collection);
        int index1 = RandomUtils.nextInt(list.size());
        int index2;
        do {
            index2 = RandomUtils.nextInt(list.size());
        } while (index1 == index2);

        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);

        collection.clear();
        collection.addAll(list);
        return true;
    }

}
