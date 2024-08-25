package express.object;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import express.util.Utils;

public class ObjectMutator {

    /**
     * Perform a random mutation on the given object
     *
     * @param rootObject is the object to mutate
     */
    public static boolean mutate(Object rootObject) {
        Set<Object> reachableObjects = ObjectHelper.collectReachableObjects(rootObject);
        List<Object> candidates = reachableObjects.stream().filter(ObjectMutator::isMutableObject).toList();
        if (candidates.isEmpty())
            return false;

        Object toBeMutated = selectObjectForMutation(candidates);
        return mutateObject(toBeMutated);
    }

    static Object selectObjectForMutation(Collection<Object> allObjects) {
        Set<Class<?>> candidateTypes = ObjectHelper.filterTypes(allObjects);

        Class<?> chosenType = Utils.getRandomElement(candidateTypes);
        Set<Object> candidatesOfChosenType = ObjectHelper.filterObjectsByType(allObjects, chosenType);

        return Utils.getRandomElement(candidatesOfChosenType);
    }

    private static boolean mutateObject(Object objectToBeMutated) {
        if (objectToBeMutated == null)
            throw new IllegalArgumentException("Object to be mutated cannot be null");

        if (objectToBeMutated instanceof Collection<?>) {
            return mutateCollection((Collection<?>) objectToBeMutated);
        } else if (objectToBeMutated instanceof Map<?, ?>) {
            return mutateMap((Map<?, ?>) objectToBeMutated);
        } else if (objectToBeMutated.getClass().isArray()) {
            return mutateArray(objectToBeMutated);
        }

        return mutateUserDefinedObject(objectToBeMutated);
    }

    private static boolean mutateCollection(Collection<Object> objectToBeMutated) {
        if (!ObjectHelper.isMutableCollection(objectToBeMutated))
            return false;

        int option = Utils.nextInt(5) + 1;
        switch (option) {
            case 1:
                removeElement(objectToBeMutated);
                break;
            case 2:
                addNewInstance(objectToBeMutated);
                break;
            case 3:
                replaceElement(objectToBeMutated);
                break;
            case 4:
                clearCollection(objectToBeMutated);
                break;
            case 5:
                swapElements(objectToBeMutated);
                break;
        }
        return true;
    }

    private static void removeElement(Collection<?> collection) {
        if (!collection.isEmpty()) {
            List<?> list = new ArrayList<>(collection);
            int index = new Random().nextInt(list.size());
            collection.remove(list.get(index));
        }
    }

    private static void addNewInstance(Collection<Object> collection) {
        try {
            Class<?> elementType = collection.iterator().next().getClass();
            Object newInstance = ValueProvider.createNewInstance(elementType);
            collection.add(newInstance);
        } catch (NewInstanceCreationException e) {
            e.printStackTrace();
        }
    }

    private static void replaceElement(Collection<Object> collection) {
        if (!collection.isEmpty()) {
            try {
                List<Object> list = new ArrayList<>(collection);
                int index = Utils.nextInt(list.size());
                Object elemToReplace = list.get(index);

                Class<?> elementType = elemToReplace.getClass();
                Object newInstance = ValueProvider.createNewInstance(elementType);

                list.set(index, newInstance);

                collection.clear();
                collection.addAll(list);
            } catch (NewInstanceCreationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void clearCollection(Collection<?> collection) {
        collection.clear();
    }

    private static void swapElements(Collection<Object> collection) {
        if (collection.size() > 1) {
            List<Object> list = new ArrayList<>(collection);
            int index1 = Utils.nextInt(list.size());
            int index2;
            do {
                index2 = Utils.nextInt(list.size());
            } while (index1 == index2);

            Object temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);

            collection.clear();
            collection.addAll(list);
        }
    }

    private static boolean mutateMap(Map<?, ?> objectToBeMutated) {
    }

    private static boolean mutateArray(Object objectToBeMutated) {
    }

    private static boolean mutateUserDefinedObject(Object objectToBeMutated) {
        Class<?> type = objectToBeMutated.getClass();
        if (!TypeChecker.isUserDefinedClass(type))
            throw new IllegalArgumentException("Object to be mutated must be a user-defined class");

        Field[] fields = type.getDeclaredFields();
        if (fields.length == 0)
            return false;

        Field

        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
                continue;
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(object);
                collectMutableObjects(fieldValue, collected);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void mutateReferenceField(Object targetObject, Field field, Collection<Object> allObjects) {
        Class<?> type = field.getType();
        if (type.isPrimitive())
            throw new IllegalArgumentException("This method is only for reference types");

        Set<Object> candidates = calculateCandidateReferenceValues(targetObject, field, allObjects);
        Object newValue = Utils.getRandomElement(candidates);
        ValueProvider.setFieldValue(targetObject, field, newValue);
    }

    public static Set<Object> calculateCandidateReferenceValues(Object targetObject, Field field,
            Collection<Object> allObjects) {
        Class<?> type = field.getType();
        if (type.isPrimitive())
            throw new IllegalArgumentException("This method is only for reference types");

        Set<Object> candidates = ObjectHelper.filterObjectsByType(allObjects, type);

        Object currentValue = ValueProvider.getFieldValue(targetObject, field);
        if (currentValue != null) {
            // Add null as a candidate
            candidates.add(null);

            // Remove the current value from the candidates
            candidates.remove(currentValue);
        }

        Object newInstance = null;
        try {
            newInstance = ValueProvider.createNewInstance(type);
        } catch (NewInstanceCreationException e) {
            if (isMutableClass(type))
                throw new RuntimeException(e);
        }
        if (newInstance != null) {
            // Add new instance of the class as a candidate
            candidates.add(newInstance);
        }

        return candidates;
    }

    public static boolean isMutableObject(Object o) {
        if (o == null)
            return false;
        if (TypeChecker.isUserDefinedClass(o.getClass()))
            return true;
        return (o instanceof Collection<?> c && ObjectHelper.isMutableCollection(c)) || o instanceof Map<?, ?>
                || o.getClass().isArray();
    }

    public static boolean isMutableClass(Class<?> clazz) {
        if (clazz == null)
            throw new IllegalArgumentException("Class cannot be null");
        if (TypeChecker.isUserDefinedClass(clazz))
            return true;
        return Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz) || clazz.isArray();
    }

}
