package express.object;

import express.util.Utils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ValueProvider {

    public static final byte MAX_BYTE = 100;
    public static final short MAX_SHORT = 100;
    public static final int MAX_INT = 100;

    public static <K> K createNewReferenceTypeInstance(Class<K> clazz) throws NewInstanceCreationException {
        if (TypeChecker.isPrimitiveOrBoxedPrimitive(clazz) || TypeChecker.isArrayOfPrimitiveType(clazz))
            throw new IllegalArgumentException("Class is not of reference type: " + clazz.getName());
        if (clazz.isArray())
            return (K) createNewArrayInstance(clazz);

        K instance = null;
        try {
            Class<?> declaringClass = clazz.getDeclaringClass();
            if (!Modifier.isStatic(clazz.getModifiers()) && declaringClass != null) {
                Constructor<K> constructor = clazz.getDeclaredConstructor(declaringClass);
                constructor.setAccessible(true);
                Object param = declaringClass.getDeclaredConstructor().newInstance();
                instance = constructor.newInstance(param);
            } else {
                Constructor<K> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                instance = constructor.newInstance();
            }
        } catch (Exception e) {
            throw new NewInstanceCreationException(clazz.getName());
        }
        return instance;
    }

    private static <K> K createNewArrayInstance(Class<K> clazz) {
        if (!clazz.isArray()) {
            throw new IllegalArgumentException("This method is only for array types");
        }

        Class<?> componentType = clazz.getComponentType();
        int length = Utils.nextInt(MAX_INT + 1);

        @SuppressWarnings("unchecked")
        K arrayInstance = (K) Array.newInstance(componentType, length);

        return arrayInstance;
    }

    public static <K> K createNewPrimitiveTypeInstance(Class<K> clazz) throws NewInstanceCreationException {
        if (TypeChecker.isPrimitiveOrBoxedPrimitive(clazz))
            return (K) createNewRandomPrimitiveValue(clazz);
        if (clazz.isArray())
            return (K) createNewArrayInstance(clazz);
        throw new IllegalArgumentException("Class must be a primitive type or and array of primitive types");
    }

    private static <K> K createNewRandomPrimitiveValue(Class<K> clazz) {
        if (clazz.equals(Boolean.class) || clazz.equals(boolean.class))
            return clazz.cast(Utils.nextBoolean());
        if (clazz.equals(Byte.class) || clazz.equals(byte.class))
            return clazz.cast((byte) Utils.nextInt(MAX_BYTE));
        if (clazz.equals(Character.class) || clazz.equals(char.class))
            return clazz.cast((char) Utils.nextInt(Character.MAX_VALUE));
        if (clazz.equals(Short.class) || clazz.equals(short.class))
            return clazz.cast((short) Utils.nextInt(MAX_SHORT));
        if (clazz.equals(Integer.class) || clazz.equals(int.class))
            return clazz.cast(Utils.nextInt(MAX_INT));
        if (clazz.equals(Long.class) || clazz.equals(long.class))
            return clazz.cast((long) Utils.nextInt(MAX_INT));
        if (clazz.equals(Float.class) || clazz.equals(float.class))
            return clazz.cast((float) Utils.nextInt(MAX_INT));
        if (clazz.equals(Double.class) || clazz.equals(double.class))
            return clazz.cast((double) Utils.nextInt(MAX_INT));

        return null;
    }

}
