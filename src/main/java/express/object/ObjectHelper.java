package express.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ObjectHelper {

    public static Object deepCopy(Object original) {
        return deepCopy(original, new HashMap<>());
    }

    public static Object deepCopy(Object original, Map<Object, Object> objectMap) {
        if (original == null) {
            return null;
        } else if (TypeChecker.isUserDefinedClass(original.getClass())) {
            return copyObject(original, objectMap);
        } else if (TypeChecker.isWrapperType(original)) {
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

        Object copy = createNewInstance(original.getClass());
        if (copy == null) {
            throw new RuntimeException("Copy is null, its class was: " + original.getClass().getName());
        }

        objectMap.put(original, copy);

        Field[] fields = original.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
                continue;
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

    public static <T extends Collection<E>, E> T copyCollection(T collection, Map<Object, Object> objectMap) {
        try {
            if (objectMap.containsKey(collection))
                return (T) objectMap.get(collection);

            T copy = (T) createNewInstance(collection.getClass());
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

    public static <T extends Map<K, V>, K, V> T copyMap(T map, Map<Object, Object> objectMap) {
        try {
            if (objectMap.containsKey(map))
                return (T) objectMap.get(map);

            T copy = (T) createNewInstance(map.getClass());
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

    public static Object createNewInstance(Class<?> clazz) {
        Object instance = null;
        try {
            Class<?> declaringClass = clazz.getDeclaringClass();
            if (!Modifier.isStatic(clazz.getModifiers()) && declaringClass != null) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(declaringClass);
                constructor.setAccessible(true);
                Object param = declaringClass.getDeclaredConstructor().newInstance();
                instance = constructor.newInstance(param);
            } else {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                instance = constructor.newInstance();
            }
        } catch (Exception e) {
            // System.err.println("\n\nError creating new instance of class: " +
            // clazz.getName());
            e.printStackTrace();
            throw new RuntimeException("Error creating new instance of class: " + clazz.getName());
        }
        return instance;
    }

    public static Object copyPrimitiveWrapper(Object original) {
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

    public static String calculateHash(Object object) {
        id = 0;
        List<String> hashList = new LinkedList<>();
        calculateHash(object, new HashMap<>(), hashList);
        return String.join("", hashList);
    }

    public static void calculateHash(Object object, Map<Object, String> objToHash, List<String> hashList) {
        if (object == null) {
            hashList.add("null");
        } else if (TypeChecker.isUserDefinedClass(object.getClass())) {
            hashObject(object, objToHash, hashList);
        } else if (TypeChecker.isWrapperType(object) || object instanceof String) {
            // hashList.add(object.getClass().getSimpleName());
        } else if (object instanceof Collection<?>) {
            hashCollection((Collection<?>) object, objToHash, hashList);
        } else if (object instanceof Map<?,?>) {
            hashMap((Map<?,?>) object, objToHash, hashList);
        } else if (object.getClass().isArray()) {
            hashArray(object, objToHash, hashList);
        } else {
            hashObject(object, objToHash, hashList);
        }
    }

    private static void hashArray(Object object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String arrayHash = createObjectHash(object);
        objToHash.put(object, arrayHash);
        hashList.add(arrayHash);

        Object[] array = (Object[]) object;
        for (Object element : array) {
            calculateHash(element, objToHash, hashList);
        }
    }

    private static void hashCollection(Collection<?> object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String objectHash = createObjectHash(object);
        objToHash.put(object, objectHash);
        hashList.add(objectHash);

        for (Object element : object) {
            calculateHash(element, objToHash, hashList);
        }
    }

    private static void hashMap(Map<?, ?> object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String objectHash = createObjectHash(object);
        objToHash.put(object, objectHash);
        hashList.add(objectHash);

        for (Map.Entry<?, ?> entry : object.entrySet()) {
            calculateHash(entry.getKey(), objToHash, hashList);
            calculateHash(entry.getValue(), objToHash, hashList);
        }
    }

    private static void hashObject(Object object, Map<Object, String> objToHash, List<String> hashList) {
        if (objToHash.containsKey(object)) {
            hashList.add(objToHash.get(object));
            return;
        }

        String objectHash = createObjectHash(object);
        objToHash.put(object, objectHash);
        hashList.add(objectHash);

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
                continue;
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(object);
                calculateHash(fieldValue, objToHash, hashList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static long id = 0;

    private static String createObjectHash(Object object) {
        return object.getClass().getSimpleName() + id++;
    }

    public static Object getFieldValue(Object object, Field field) {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
