package express.object;

import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class ObjectMutator {

    public static boolean mutateForInitialization(Object rootObject) {
        List<Path> referencePaths = SpoonManager.getSubjectTypeData().getReferencePaths();
        List<Path> candidatePaths = referencePaths.stream().filter(
                path -> path.size() > 1 && path.size() < 4 && ReflectionUtils.canBeEvaluated(rootObject, path)
        ).toList();
        if (candidatePaths.isEmpty()) {
            return false;
        }

        Path chosenPath = Utils.getRandomPath(candidatePaths);
        Pair<Field, Object> fieldTuple = ReflectionUtils.evaluatePath(rootObject, chosenPath);
        Field field = fieldTuple.getLeft();
        Object fieldValue = fieldTuple.getRight();

        if (fieldValue == null && !TypeUtils.isUserDefinedType(chosenPath.getTypeReference()))
            return false;

        Object newValue;
        if (fieldValue == null) {
            try {
                newValue = ReflectionUtils.createNewReferenceTypeInstance(field.getType());
                ReflectionUtils.setPathValue(rootObject, chosenPath, newValue);
            } catch (NewInstanceCreationException e) {
                throw new RuntimeException(e);
            }
        } else {
            newValue = null;
        }

        ReflectionUtils.setPathValue(rootObject, chosenPath, newValue);
        return true;
    }

    /**
     * Perform a random mutation on the given object
     *
     * @param rootObject is the object to mutate
     */
    public static boolean mutateHeap(Object rootObject) {
        Set<Object> reachableObjects = ObjectHelper.collectReachableObjects(rootObject);
        List<Object> candidates = reachableObjects.stream().filter(ObjectMutator::isMutableHeapObject).toList();

        if (candidates.isEmpty())
            return false;

        Object toBeMutated = selectObjectForMutation(candidates);
        return mutateHeapOfObject(toBeMutated, reachableObjects);
    }

    static Object selectObjectForMutation(Collection<Object> allObjects) {
        if (RandomUtils.nextBoolean())
            return Utils.getRandomElement(allObjects);
        
        Set<Class<?>> candidateTypes = ObjectHelper.filterTypes(allObjects);

        Class<?> chosenType = Utils.getRandomElement(candidateTypes);
        Set<Object> candidatesOfChosenType = ObjectHelper.filterObjectsByType(allObjects, chosenType);

        return Utils.getRandomElement(candidatesOfChosenType);
    }

    private static boolean mutateHeapOfObject(Object objectToBeMutated, Collection<Object> reachableObjects) {
        if (objectToBeMutated == null)
            throw new IllegalArgumentException("Object to be mutated cannot be null");

        if (TypeChecker.isUserDefinedClass(objectToBeMutated.getClass()))
            return mutateHeapUserDefinedObject(objectToBeMutated, reachableObjects);
        if (objectToBeMutated instanceof Collection<?> collection)
            return mutateCollection(collection);
        if (objectToBeMutated instanceof Map<?, ?> map)
            return mutateMap(map);
        if (objectToBeMutated.getClass().isArray())
            return mutateArray(objectToBeMutated);

        return false;
    }

    private static boolean mutateCollection(Collection<?> objectToBeMutated) {
        boolean success;
        int attempts = 0;
        do {
            attempts++;
            int option = Utils.nextInt(5);
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
            Class<T> elementType = ReflectionUtils.getClassOfObjectsInCollection(collection);
            T newInstance = ReflectionUtils.createNewReferenceTypeInstance(elementType);
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
            Class<T> elementType = ReflectionUtils.getClassOfObjectsInCollection(collection);
            T newInstance = ReflectionUtils.createNewReferenceTypeInstance(elementType);

            List<T> list = new ArrayList<>(collection);
            int index = Utils.nextInt(list.size());
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
        int index1 = Utils.nextInt(list.size());
        int index2;
        do {
            index2 = Utils.nextInt(list.size());
        } while (index1 == index2);

        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);

        collection.clear();
        collection.addAll(list);
        return true;
    }

    private static boolean mutateMap(Map<?, ?> objectToBeMutated) {
        if (objectToBeMutated == null) {
            throw new IllegalArgumentException("Map to be mutated cannot be null");
        }

        boolean success;
        int attempts = 0;
        do {
            attempts++;
            int option = Utils.nextInt(4);
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
        int index = Utils.nextInt(map.size());
        Object key = map.keySet().toArray()[index];
        map.remove(key);
        return true;
    }

    private static <K, V> boolean addNewEntry(Map<K, V> map) {
        Class<K> keyClass = ReflectionUtils.getKeyClass(map);
        Class<V> valueClass = ReflectionUtils.getValueClass(map);
        try {
            K key = ReflectionUtils.createNewReferenceTypeInstance(keyClass);
            V value = ReflectionUtils.createNewReferenceTypeInstance(valueClass);
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

    private static boolean mutateArray(Object objectToBeMutated) {
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
            newValue = ReflectionUtils.createNewReferenceTypeInstance(componentType);
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

    private static boolean mutateHeapUserDefinedObject(Object objectToBeMutated, Collection<Object> allObjects) {
        Class<?> type = objectToBeMutated.getClass();
        if (!TypeChecker.isUserDefinedClass(type))
            throw new IllegalArgumentException("Object to be mutated must be a user-defined class");

        List<Field> fields = ReflectionUtils.getAccessibleFields(type);
        if (fields.isEmpty())
            return false;

        Field fieldToMutate = selectRandomReferenceField(fields);

        return mutateReferenceField(objectToBeMutated, fieldToMutate, allObjects);
    }

    private static Field selectRandomReferenceField(List<Field> fields) {
        List<Field> candidates = fields.stream().filter(f -> !TypeChecker.isPrimitiveOrBoxedPrimitive(f.getType())).toList();
        return Utils.getRandomElement(candidates);
    }


    public static boolean mutateReferenceField(Object targetObject, Field field, Collection<Object> allObjects) {
        Class<?> type = field.getType();
        if (type.isPrimitive())
            throw new IllegalArgumentException("This method is only for reference types");

        Set<Object> candidates = calculateCandidateReferenceValues(targetObject, field, allObjects);
        if (candidates.isEmpty())
            return false;
        Object newValue = Utils.getRandomElement(candidates);
        ReflectionUtils.setFieldValue(targetObject, field, newValue);
        return true;
    }

    public static Set<Object> calculateCandidateReferenceValues(Object targetObject, Field field,
                                                                Collection<Object> allObjects) {
        Class<?> type = field.getType();
        if (type.isPrimitive())
            throw new IllegalArgumentException("This method is only for reference types");

        Set<Object> candidates = ObjectHelper.filterObjectsByType(allObjects, type);

        Object currentValue = ReflectionUtils.getFieldValue(targetObject, field);
        if (currentValue != null) {
            // Add null as a candidate
            candidates.add(null);

            // Remove the current value from the candidates
            candidates.remove(currentValue);
        }

        Object newInstance = null;
        try {
            newInstance = ReflectionUtils.createNewReferenceTypeInstance(type);
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
        if (TypeChecker.isUserDefinedClass(clazz))
            return true;
        if (TypeChecker.isCollectionOfReferenceType(clazz))
            return true;
        if (TypeChecker.isMapOfReferenceType(clazz))
            return true;
        if (TypeChecker.isArrayOfReferenceType(clazz))
            return true;
        return false;
    }

}
