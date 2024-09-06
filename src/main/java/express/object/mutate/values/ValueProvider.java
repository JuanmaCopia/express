package express.object.mutate.values;

import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Types;
import express.util.Utils;

import java.lang.reflect.Array;

public class ValueProvider {

    public static final byte MAX_BYTE = 100;
    public static final short MAX_SHORT = 100;
    public static final int MAX_INT = 100;

    public static <K> K createNewArrayInstance(Class<K> clazz) {
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
        if (Types.isPrimitiveOrBoxedPrimitive(clazz))
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
