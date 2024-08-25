package express.object;

import express.util.Utils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;


public class ValueProvider {

    public static final byte MAX_BYTE = 100;
    public static final short MAX_SHORT = 100;
    public static final int MAX_INT = 100;

    public static Object getFieldValue(Object owner, Field field) {
        Object currentValue = null;
        try {
            //Field f = owner.getClass().getDeclaredField(field.getName());
            field.setAccessible(true);
            currentValue = field.get(owner);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return currentValue;
    }

    public static void setFieldValue(Object owner, Field field, Object newValue) {
        try {
            //Field f = owner.getClass().getDeclaredField(field.getName());
            field.setAccessible(true);
            field.set(owner, newValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object createNewInstance(Class<?> clazz) throws NewInstanceCreationException {
        if (TypeChecker.isBoxedPrimitive(clazz))
            return createNewBoxedPrimitiveInstance(clazz);
        if (clazz.isArray())
            return createNewArrayInstance(clazz);

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
            throw new NewInstanceCreationException(clazz.getName());
        }
        return instance;
    }

    private static Object createNewBoxedPrimitiveInstance(Class<?> clazz) {
        if (clazz.equals(Boolean.class))
            return Utils.nextBoolean();
        if (clazz.equals(Byte.class))
            return (byte) Utils.nextInt(MAX_BYTE);
        if (clazz.equals(Character.class))
            return (char) Utils.nextInt(Character.MAX_VALUE);
        if (clazz.equals(Short.class))
            return (short) Utils.nextInt(MAX_SHORT);
        if (clazz.equals(Integer.class))
            return Utils.nextInt(MAX_INT);
        if (clazz.equals(Long.class))
            return Utils.nextInt(MAX_INT);
        if (clazz.equals(Float.class))
            return Utils.nextInt(MAX_INT);
        if (clazz.equals(Double.class))
            return Utils.nextInt(MAX_INT);
        return null;
    }

    private static Object createNewArrayInstance(Class<?> clazz) {
        if (!clazz.isArray())
            throw new IllegalArgumentException("This method is only for array types");
        Class<?> componentType = clazz.getComponentType();
        int length = Utils.nextInt(MAX_INT + 1);

        return Array.newInstance(componentType, length);
    }



}
