package evorep.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class ObjectHelper {

    public static Object deepCopy(Object original) {
        return deepCopy(original, new HashMap<>());
    }

    public static Object deepCopy(Object original, HashMap<Object, Object> objectMap) {
        if (original == null) {
            return null;
        } else if (isWrapperType(original)) {
            return copyPrimitiveWrapper(original);
        } else if (original instanceof String) {
            return String.copyValueOf(((String) original).toCharArray());
        } else if (original instanceof Collection<?>) {
            return copyCollection((Collection<?>) original, objectMap);
        } else if (original.getClass().isArray()) {
            return copyArray(original, objectMap);
        }
        return copyObject(original, objectMap);
    }

    private static Object copyObject(Object original, HashMap<Object, Object> objectMap) {
        if (objectMap.containsKey(original))
            return objectMap.get(original);

        Object copy = createNewInstance(original.getClass());
        if (copy == null) {
            throw new RuntimeException("Copy is null, its class was: " + original.getClass().getName());
        }

        objectMap.put(original, copy);

        Field[] fields = original.getClass().getDeclaredFields();
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
/*                if (copy == null)
                    System.out.println("ERROR: copy is null");
                if (fieldCopy == null)
                    System.out.println("FieldCopy is null");*/
                field.set(copy, fieldCopy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return copy;
    }


    private static Object copyArray(Object array, HashMap<Object, Object> objectMap) {
        if (objectMap.containsKey(array))
            return objectMap.get(array);

        Class<?> componentType = array.getClass().getComponentType();
        Object arrayCopy = null;
        if (componentType.isPrimitive()) {
            arrayCopy = copyPrimitiveArray(array);
            objectMap.put(array, arrayCopy);
        } else {
            arrayCopy = copyObjectArray(array, objectMap);
        }

        return arrayCopy;
    }

    private static Object copyObjectArray(Object array, HashMap<Object, Object> objectMap) {
        Object[] original = (Object[]) array;
        Object[] copy = Arrays.copyOf(original, original.length);
        objectMap.put(array, copy);
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


    public static <T extends Collection<E>, E> T copyCollection(T collection, HashMap<Object, Object> objectMap) {
        try {
            if (objectMap.containsKey(collection))
                return (T) objectMap.get(collection);

            T copy = (T) createNewInstance(collection.getClass());
            objectMap.put(collection, copy);

            for (E e : collection) {
                if (e instanceof Collection<?>) {
                    copy.add((E) copyCollection((Collection<?>) e, objectMap));
                } else if (isWrapperType(e)) {
                    copy.add((E) copyPrimitiveWrapper(e));
                } else {
                    copy.add((E) deepCopy(e, objectMap));
                }
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
                //System.err.println("creating isntance for Declaring class: " + declaringClass.getName());
                Constructor<?> constructor = clazz.getDeclaredConstructor(declaringClass);
                Object param = declaringClass.getDeclaredConstructor().newInstance();
                instance = constructor.newInstance(param);
            } else {
                instance = clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating new instance of class: " + clazz.getName());
        }
        return instance;
    }

    public static boolean isWrapperType(Object obj) {
        return obj instanceof Integer ||
                obj instanceof Double ||
                obj instanceof Float ||
                obj instanceof Long ||
                obj instanceof Short ||
                obj instanceof Byte ||
                obj instanceof Character ||
                obj instanceof Boolean;
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
}