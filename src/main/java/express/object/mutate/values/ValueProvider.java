package express.object.mutate.values;

import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.object.helpers.Types;
import express.util.Utils;

import java.lang.reflect.Array;

public class ValueProvider {

    public static final byte MIN_BYTE = -100;
    public static final short MIN_SHORT = -100;
    public static final int MIN_INT = -100;
    public static final long MIN_LONG = -100;
    public static final double MIN_DOUBLE = -100.0;
    public static final float MIN_FLOAT = -100.0f;

    public static final byte MAX_BYTE = 100;
    public static final short MAX_SHORT = 100;
    public static final int MAX_INT = 100;
    public static final long MAX_LONG = 100;
    public static final double MAX_DOUBLE = 100.0;
    public static final float MAX_FLOAT = 100.0f;

    @SuppressWarnings("unchecked")
    public static <K> K createNewArrayInstance(Class<K> clazz) {
        if (!clazz.isArray()) {
            throw new IllegalArgumentException("This method is only for array types");
        }

        Class<?> componentType = clazz.getComponentType();
        int length = Utils.nextInt(MAX_INT + 1);

        return (K) Array.newInstance(componentType, length);
    }

    @SuppressWarnings("unchecked")
    public static <K> K createNewInstance(Class<K> clazz) {
        if (clazz.isPrimitive())
            return (K) createNewRandomPrimitiveValue(clazz);
        if (Types.isBoxedPrimitive(clazz))
            return createNewRandomPrimitiveWrapperValue(clazz);
        if (clazz.isArray())
            return createNewArrayInstance(clazz);

        K instance;
        try {
            instance = Reflection.createNewReferenceTypeInstance(clazz);
        } catch (NewInstanceCreationException e) {
            throw new RuntimeException(e);
        }

        return instance;
    }

    public static <K> K createNewRandomPrimitiveWrapperValue(Class<K> clazz) {
        if (clazz.equals(Boolean.class))
            return clazz.cast(Utils.nextBoolean());
        if (clazz.equals(Byte.class))
            return clazz.cast(Utils.nextByte(MIN_BYTE, MAX_BYTE));
        if (clazz.equals(Character.class))
            return clazz.cast((char) Utils.nextInt(Character.MAX_VALUE));
        if (clazz.equals(Short.class))
            return clazz.cast(Utils.nextShort(MIN_SHORT, MAX_SHORT));
        if (clazz.equals(Integer.class))
            return clazz.cast(Utils.nextInt(MIN_INT, MAX_INT));
        if (clazz.equals(Long.class))
            return clazz.cast(Utils.nextLong(MIN_LONG, MAX_LONG));
        if (clazz.equals(Float.class))
            return clazz.cast(Utils.nextFloat(MIN_FLOAT, MAX_FLOAT));
        if (clazz.equals(Double.class))
            return clazz.cast(Utils.nextDouble(MIN_DOUBLE, MAX_DOUBLE));

        throw new IllegalArgumentException("Class must be a primitive type or its wrapper.");
    }

    public static Object createNewRandomPrimitiveValue(Class<?> clazz) {
        if (clazz.equals(boolean.class))
            return Utils.nextBoolean();
        if (clazz.equals(byte.class))
            return Utils.nextByte(MIN_BYTE, MAX_BYTE);
        if (clazz.equals(char.class))
            return Utils.nextInt(Character.MAX_VALUE);
        if (clazz.equals(short.class))
            return Utils.nextShort(MIN_SHORT, MAX_SHORT);
        if (clazz.equals(int.class))
            return Utils.nextInt(MIN_INT, MAX_INT);
        if (clazz.equals(long.class))
            return Utils.nextLong(MIN_LONG, MAX_LONG);
        if (clazz.equals(float.class))
            return Utils.nextFloat(MIN_FLOAT, MAX_FLOAT);
        if (clazz.equals(double.class))
            return Utils.nextDouble(MIN_DOUBLE, MAX_DOUBLE);

        throw new IllegalArgumentException("Class must be a primitive type.");
    }
    
}
