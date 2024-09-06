package express.object.mutate;

import express.object.ObjectGenerator;
import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.spoon.RandomUtils;

import java.util.Map;

public class MapMutatorUtils {

    static boolean mutateMap(Map<?, ?> objectToBeMutated) {
        if (objectToBeMutated == null) {
            throw new IllegalArgumentException("Map to be mutated cannot be null");
        }

        boolean success;
        int attempts = 0;
        do {
            attempts++;
            int option = RandomUtils.nextInt(4);
            success = switch (option) {
                case 0 -> removeRandomEntry(objectToBeMutated);
                case 1 -> addNewEntry(objectToBeMutated);
                case 2 -> removeAndAddEntry(objectToBeMutated);
                case 3 -> clearMap(objectToBeMutated);
                default -> false;
            };
        } while (!success && attempts < 10);

        if (!success) {
            ObjectGenerator.logger
                    .warning("Could not mutate the map of type: " + objectToBeMutated.getClass().getName());
        }

        return success;
    }

    private static boolean removeRandomEntry(Map<?, ?> map) {
        if (map.isEmpty())
            return false;
        int index = RandomUtils.nextInt(map.size());
        Object key = map.keySet().toArray()[index];
        map.remove(key);
        return true;
    }

    private static <K, V> boolean addNewEntry(Map<K, V> map) {
        Class<K> keyClass = Reflection.getKeyClass(map);
        Class<V> valueClass = Reflection.getValueClass(map);
        try {
            K key = Reflection.createNewReferenceTypeInstance(keyClass);
            V value = Reflection.createNewReferenceTypeInstance(valueClass);
            map.put(key, value);
            return true;
        } catch (NewInstanceCreationException e) {
            ObjectGenerator.logger.warning(e.getMessage());
        }
        return false;
    }

    private static boolean removeAndAddEntry(Map<?, ?> map) {
        boolean removed = removeRandomEntry(map);
        boolean added = addNewEntry(map);
        return removed || added;
    }

    private static boolean clearMap(Map<?, ?> map) {
        if (map.isEmpty())
            return false;
        map.clear();
        return true;
    }

}
