package evorep.object;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class ObjectHelperBackuo {

    public static Object deepCopy(Object original, Class<?> copyClass) {
        return deepCopy(original, copyClass, new HashMap<>());
    }

    public static Object deepCopy(Object original, Class<?> copyClass, HashMap<Object, Object> objectMap) {
        if (original == null) {
            return null;
        } else if (isWrapperType(original)) {
            return copyPrimitiveWrapper(original);
        } else if (original instanceof String) {
            return String.copyValueOf(((String) original).toCharArray());
/*        } else if (original instanceof Collection<?>) {
            return copyCollection((Collection<?>) original, copyClass, objectMap);*/
        } else if (original.getClass().isArray()) {
            return copyArray(original, copyClass, objectMap);
        }
        return copyObject(original, copyClass, objectMap);
    }

    private static Object copyObject(Object original, Class<?> copyClass, HashMap<Object, Object> objectMap) {
        if (original == null)
            return null;
        if (objectMap.containsKey(original))
            return objectMap.get(original);

        /*Object copy = createNewInstance(original.getClass());
        if (copy == null) {
            throw new RuntimeException("Copy is null, its class was: " + original.getClass().getName());
        }*/
        Object copy = createNewInstance(copyClass);
        objectMap.put(original, copy);

        Field[] fields = original.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(original);
                Field copyField = copyClass.getDeclaredField(field.getName());
                Class<?> fieldClass = copyField.getType();
                //Class<?> fieldClass = copyClass.getField(field.getName()).getClass();
                Object fieldCopy = null;
                if (objectMap.containsKey(fieldValue))
                    fieldCopy = objectMap.get(fieldValue);
                else {
                    fieldCopy = deepCopy(fieldValue, fieldClass, objectMap);
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


    private static Object copyArray(Object array, Class<?> copyClass, HashMap<Object, Object> objectMap) {
        if (objectMap.containsKey(array))
            return objectMap.get(array);

        Class<?> copyComponentType = copyClass.getComponentType();
        Object arrayCopy = null;
        if (copyComponentType.isPrimitive()) {
            arrayCopy = copyPrimitiveArray(array);
            objectMap.put(array, arrayCopy);
        } else {
            arrayCopy = copyObjectArray(array, copyComponentType, objectMap);
        }

        return arrayCopy;
    }

    private static Object copyObjectArray(Object array, Class<?> copyComponentType, HashMap<Object, Object> objectMap) {
        Object[] original = (Object[]) array;
        Object[] copy = (Object[]) Array.newInstance(copyComponentType, original.length);
        //Object[] copy = Arrays.copyOf(original, original.length);
        objectMap.put(array, copy);
        for (int i = 0; i < original.length; i++) {
            copy[i] = deepCopy(original[i], copyComponentType, objectMap);
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


/*    public static <T extends Collection<E>, E> T copyCollection(T collection, Class<?> copyClass, HashMap<Object, Object> objectMap) {
        try {
            if (objectMap.containsKey(collection))
                return (T) objectMap.get(collection);

            T copy = (T) createNewInstance(copyClass);
            objectMap.put(collection, copy);

            Class<?> OrigComponentType = getComponentType(collection);

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

    public static Class<?> getComponentType(Collection<?> collection) {
        // Iterate over the collection to find the first non-null element
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element != null) {
                return element.getClass();
            }
        }

        // Return null if the collection is empty or contains only null elements
        return null;
    }

    public static Class<?> getEquivalentClassInCopy(Class<?> original, Class<?> copyClass) {
        Set<Class<?>> visited = new HashSet<>();
        List<Class<?>> worklist = new LinkedList<>();
        worklist.add(copyClass);
        while (!worklist.isEmpty()) {
            Class<?> current = worklist.remove(0);
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            if (current.getTypeName().equals(original.getTypeName())) {
                return current;
            }
            Field[] fields = current.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Class<?> fieldClass = field.getType();
                if (fieldClass.isArray()) {
                    worklist.add(fieldClass.getComponentType());
                } else if (!fieldClass.isPrimitive() && !isWrapperClass(fieldClass)) {
                    worklist.add(fieldClass);
                }

            }
        }
        return null;
    }*/

    public static Object createNewInstance(Class<?> clazz) {
        Object instance = null;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
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

    public static boolean isWrapperClass(Class<?> clazz) {
        return clazz.equals(Integer.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Boolean.class);
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
