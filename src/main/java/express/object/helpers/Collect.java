package express.object.helpers;

import express.object.ObjectMutator;

import java.lang.reflect.Field;
import java.util.*;

public class Collect {

    public static Set<Object> collectReachableObjects(Object object) {
        Set<Object> collected = Collections.newSetFromMap(new IdentityHashMap<>());
        collectReachableObjects(object, collected);
        return collected;
    }

    public static void collectReachableObjects(Object object, Set<Object> collected) {
        if (object == null)
            return;
        Class<?> clazz = object.getClass();
        // The object it is always collected
        if (Types.isString(clazz) ||
                Types.isBoxedPrimitive(clazz) ||
                !collected.add(object) ||
                !ObjectMutator.isMutableHeapClass(clazz))
            return;

        if (Types.isUserDefinedClass(object.getClass())) {
            collectUserDefinedObject(object, collected);
        } else if (object instanceof Collection<?>) {
            collectCollection((Collection<?>) object, collected);
        } else if (object instanceof Map<?, ?>) {
            collectMap((Map<?, ?>) object, collected);
        } else if (object.getClass().isArray()) {
            collectArray(object, collected);
        }
    }

    private static void collectArray(Object object, Set<Object> collected) {
        Object[] array = (Object[]) object;
        for (Object element : array) {
            collectReachableObjects(element, collected);
        }
    }

    private static void collectMap(Map<?, ?> object, Set<Object> collected) {
        for (Map.Entry<?, ?> entry : object.entrySet()) {
            collectReachableObjects(entry.getKey(), collected);
            collectReachableObjects(entry.getValue(), collected);
        }
    }

    private static void collectCollection(Collection<?> object, Set<Object> collected) {
        for (Object element : object) {
            collectReachableObjects(element, collected);
        }
    }

    private static void collectUserDefinedObject(Object object, Set<Object> collected) {
        List<Field> fields = Reflection.getAccessibleFields(object.getClass());
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = Reflection.getFieldValue(object, field);
                collectReachableObjects(fieldValue, collected);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
