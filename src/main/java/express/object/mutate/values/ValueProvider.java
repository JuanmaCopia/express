package express.object.mutate.values;

import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.object.helpers.Types;
import express.spoon.RandomUtils;

import java.lang.reflect.Array;

public class ValueProvider {

    public static final byte MIN_BYTE = -10;
    public static final short MIN_SHORT = -10;
    public static final int MIN_INT = -10;
    public static final long MIN_LONG = -10;
    public static final double MIN_DOUBLE = -10.0;
    public static final float MIN_FLOAT = -10.0f;

    public static final byte MAX_BYTE = 10;
    public static final short MAX_SHORT = 10;
    public static final int MAX_INT = 10;
    public static final long MAX_LONG = 10;
    public static final double MAX_DOUBLE = 10.0;
    public static final float MAX_FLOAT = 10.0f;

    public static final int[] INTEGER_CONSTANT_POOL = {-1, 0, 1};
    public static final double[] DOUBLE_CONSTANT_POOL = {-1.0, -0.5, 0.0, 0.5, 1.0};

    public static final int MAX_STRING_LENGTH = 10;

    @SuppressWarnings("unchecked")
    public static <K> K createNewArrayInstance(Class<K> clazz) {
        if (!clazz.isArray()) {
            throw new IllegalArgumentException("This method is only for array types");
        }

        Class<?> componentType = clazz.getComponentType();
        int length = RandomUtils.nextInt(MAX_INT + 1);

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
            return clazz.cast(RandomUtils.nextBoolean());
        if (clazz.equals(Byte.class))
            return clazz.cast(RandomUtils.nextByte(MIN_BYTE, MAX_BYTE));
        if (clazz.equals(Character.class))
            return clazz.cast((char) RandomUtils.nextInt(Character.MAX_VALUE));
        if (clazz.equals(Short.class))
            return clazz.cast(RandomUtils.nextShort(MIN_SHORT, MAX_SHORT));
        if (clazz.equals(Integer.class))
            return clazz.cast(RandomUtils.nextInt(MIN_INT, MAX_INT));
        if (clazz.equals(Long.class))
            return clazz.cast(RandomUtils.nextLong(MIN_LONG, MAX_LONG));
        if (clazz.equals(Float.class))
            return clazz.cast(RandomUtils.nextFloat(MIN_FLOAT, MAX_FLOAT));
        if (clazz.equals(Double.class))
            return clazz.cast(RandomUtils.nextDouble(MIN_DOUBLE, MAX_DOUBLE));
        if (clazz.equals(String.class))
            return clazz.cast(RandomUtils.generateRandomString(MAX_STRING_LENGTH));

        throw new IllegalArgumentException("Class must be a primitive type or its wrapper.");
    }

    public static Object createNewRandomPrimitiveValue(Class<?> clazz) {
        if (clazz.equals(boolean.class))
            return RandomUtils.nextBoolean();
        if (clazz.equals(byte.class))
            return RandomUtils.nextByte(MIN_BYTE, MAX_BYTE);
        if (clazz.equals(char.class))
            return RandomUtils.nextInt(Character.MAX_VALUE);
        if (clazz.equals(short.class))
            return RandomUtils.nextShort(MIN_SHORT, MAX_SHORT);
        if (clazz.equals(int.class))
            return RandomUtils.nextInt(MIN_INT, MAX_INT);
        if (clazz.equals(long.class))
            return RandomUtils.nextLong(MIN_LONG, MAX_LONG);
        if (clazz.equals(float.class))
            return RandomUtils.nextFloat(MIN_FLOAT, MAX_FLOAT);
        if (clazz.equals(double.class))
            return RandomUtils.nextDouble(MIN_DOUBLE, MAX_DOUBLE);

        throw new IllegalArgumentException("Class must be a primitive type.");
    }

    public static int getRandomIntegerConstant() {
        return INTEGER_CONSTANT_POOL[RandomUtils.nextInt(INTEGER_CONSTANT_POOL.length)];
    }

    public static double getRandomDoubleConstant() {
        return DOUBLE_CONSTANT_POOL[RandomUtils.nextInt(DOUBLE_CONSTANT_POOL.length)];
    }

}
