package express.object.helpers;

import java.lang.reflect.Field;
import java.util.*;

public class Copy {

    public static Object deepCopy(Object original) {
        return deepCopy(original, new IdentityHashMap<>());
    }

    public static Object deepCopy(Object original, Map<Object, Object> objectMap) {
        if (original == null) {
            return null;
        } else if (Types.isUserDefinedClass(original.getClass())) {
            return copyObject(original, objectMap);
        } else if (Types.isWrapperType(original)) {
            return copyPrimitiveWrapper(original);
        } else if (original instanceof String) {
            return String.copyValueOf(((String) original).toCharArray());
        } else if (original instanceof Collection<?>) {
            return copyCollection((Collection<?>) original, objectMap);
        } else if (original instanceof Map<?, ?>) {
            return copyMap((Map<?, ?>) original, objectMap);
        } else if (original.getClass().isArray()) {
            return copyArray(original, objectMap);
        }
        return copyObject(original, objectMap);
    }

    private static Object copyObject(Object original, Map<Object, Object> objectMap) {
        if (objectMap.containsKey(original))
            return objectMap.get(original);

        Object copy;
        try {
            copy = Reflection.createNewReferenceTypeInstance(original.getClass());
        } catch (NewInstanceCreationException e) {
            throw new RuntimeException(e);
        }

        objectMap.put(original, copy);

        List<Field> fields = Reflection.getAccessibleFields(original.getClass());
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(original);
                Object fieldCopy = null;
                if (objectMap.containsKey(fieldValue))
                    fieldCopy = objectMap.get(fieldValue);
                else {
                    fieldCopy = deepCopy(fieldValue, objectMap);
                }
                /*
                 * if (copy == null)
                 * System.out.println("ERROR: copy is null");
                 * if (fieldCopy == null)
                 * System.out.println("FieldCopy is null");
                 */
                field.set(copy, fieldCopy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return copy;
    }

    private static Object copyArray(Object array, Map<Object, Object> objectMap) {
        if (objectMap.containsKey(array))
            return objectMap.get(array);

        Class<?> componentType = array.getClass().getComponentType();
        Object arrayCopy = null;
        if (componentType.isPrimitive()) {
            arrayCopy = copyPrimitiveArray(array);
            objectMap.put(array, arrayCopy);
        } else {
            arrayCopy = copyObjectArray(array, objectMap);
            objectMap.put(array, arrayCopy);
        }

        return arrayCopy;
    }

    private static Object copyObjectArray(Object array, Map<Object, Object> objectMap) {
        Object[] original = (Object[]) array;
        Object[] copy = Arrays.copyOf(original, original.length);
        for (int i = 0; i < original.length; i++) {
            copy[i] = deepCopy(original[i], objectMap);
        }
        return copy;
    }

    private static Object copyPrimitiveArray(Object array) {
        if (array instanceof int[]) {
            return Arrays.copyOf((int[]) array, ((int[]) array).length);
        } else if (array instanceof double[]) {
            return Arrays.copyOf((double[]) array, ((double[]) array).length);
        } else if (array instanceof float[]) {
            return Arrays.copyOf((float[]) array, ((float[]) array).length);
        } else if (array instanceof long[]) {
            return Arrays.copyOf((long[]) array, ((long[]) array).length);
        } else if (array instanceof short[]) {
            return Arrays.copyOf((short[]) array, ((short[]) array).length);
        } else if (array instanceof byte[]) {
            return Arrays.copyOf((byte[]) array, ((byte[]) array).length);
        } else if (array instanceof char[]) {
            return Arrays.copyOf((char[]) array, ((char[]) array).length);
        } else if (array instanceof boolean[]) {
            return Arrays.copyOf((boolean[]) array, ((boolean[]) array).length);
        } else {
            throw new RuntimeException("Invalid array type: " + array.getClass());
        }
    }

    private static <T extends Collection<E>, E> T copyCollection(T collection, Map<Object, Object> objectMap) {
        try {
            if (objectMap.containsKey(collection))
                return (T) objectMap.get(collection);

            T copy = (T) Reflection.createNewReferenceTypeInstance(collection.getClass());
            objectMap.put(collection, copy);

            for (E e : collection) {
                copy.add((E) deepCopy(e, objectMap));
            }

            return copy;
        } catch (Exception e) {
            // Handle exception if instantiation fails
            e.printStackTrace();
            return null;
        }
    }

    private static <T extends Map<K, V>, K, V> T copyMap(T map, Map<Object, Object> objectMap) {
        try {
            if (objectMap.containsKey(map))
                return (T) objectMap.get(map);

            T copy = (T) Reflection.createNewReferenceTypeInstance(map.getClass());
            objectMap.put(map, copy);

            for (Map.Entry<K, V> entry : map.entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();
                key = (K) deepCopy(key, objectMap);
                value = (V) deepCopy(value, objectMap);
                copy.put(key, value);
            }

            return copy;
        } catch (Exception e) {
            // Handle exception if instantiation fails
            e.printStackTrace();
            return null;
        }
    }

    private static Object copyPrimitiveWrapper(Object original) {
        if (original instanceof Integer) {
            return Integer.valueOf((Integer) original);
        } else if (original instanceof Double) {
            return Double.valueOf((Double) original);
        } else if (original instanceof Float) {
            return Float.valueOf((Float) original);
        } else if (original instanceof Long) {
            return Long.valueOf((Long) original);
        } else if (original instanceof Short) {
            return Short.valueOf((Short) original);
        } else if (original instanceof Byte) {
            return Byte.valueOf((Byte) original);
        } else if (original instanceof Character) {
            return Character.valueOf((Character) original);
        } else if (original instanceof Boolean) {
            return Boolean.valueOf((Boolean) original);
        } else {
            throw new RuntimeException("Invalid object: " + original.getClass());
        }
    }
}
