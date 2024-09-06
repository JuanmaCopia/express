package express.object.helpers;

import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Types {

    // Set of all boxed primitive types
    private static final Set<Class<?>> BOXED_PRIMITIVES = new HashSet<>();

    static {
        BOXED_PRIMITIVES.add(Boolean.class);
        BOXED_PRIMITIVES.add(Byte.class);
        BOXED_PRIMITIVES.add(Character.class);
        BOXED_PRIMITIVES.add(Short.class);
        BOXED_PRIMITIVES.add(Integer.class);
        BOXED_PRIMITIVES.add(Long.class);
        BOXED_PRIMITIVES.add(Float.class);
        BOXED_PRIMITIVES.add(Double.class);
        BOXED_PRIMITIVES.add(String.class);
    }

    public static boolean isBoxedPrimitive(Field field) {
        Class<?> fieldType = field.getType();
        return BOXED_PRIMITIVES.contains(fieldType);
    }

    public static boolean isBoxedPrimitive(Class<?> type) {
        return BOXED_PRIMITIVES.contains(type);
    }

    public static boolean isPrimitiveOrBoxedPrimitive(Field field) {
        return field.getType().isPrimitive() || isBoxedPrimitive(field);
    }

    public static boolean isPrimitiveOrBoxedPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || BOXED_PRIMITIVES.contains(clazz);
    }

    public static boolean isString(Field field) {
        return field.getType().equals(String.class);
    }

    public static boolean isString(Class<?> clazz) {
        return clazz.equals(String.class);
    }

    public static boolean isWrapperType(Object obj) {
        return BOXED_PRIMITIVES.contains(obj.getClass());
    }

    public static boolean isUserDefinedClass(Class<?> cls) {
        Set<CtClass<?>> userDefTypes = SpoonManager.getSubjectTypeData().getUserDefinedClasses();
        return userDefTypes.stream().anyMatch(t -> t.getQualifiedName().equals(cls.getName()));
    }

    public static boolean isArrayOfReferenceType(Class<?> clazz) {
        if (!clazz.isArray())
            return false;

        Class<?> componentType = clazz.getComponentType();
        return !Types.isPrimitiveOrBoxedPrimitive(componentType);
    }

    public static boolean isArrayOfPrimitiveType(Class<?> clazz) {
        if (!clazz.isArray())
            return false;

        Class<?> componentType = clazz.getComponentType();
        return Types.isPrimitiveOrBoxedPrimitive(componentType);
    }

    public static boolean isMapOfReferenceType(Class<?> clazz) {
        if (!Map.class.isAssignableFrom(clazz))
            return false;

        Class<?> typeOfKeys = Reflection.getGenericClass(clazz, 0);
        if (typeOfKeys != null && !Types.isPrimitiveOrBoxedPrimitive(typeOfKeys))
            return true;

        Class<?> typeOfValues = Reflection.getGenericClass(clazz, 1);
        if (typeOfValues != null && !Types.isPrimitiveOrBoxedPrimitive(typeOfValues))
            return true;

        return false;
    }

    public static boolean isCollectionOfReferenceType(Class<?> clazz) {
        if (!Collection.class.isAssignableFrom(clazz))
            return false;

        Class<?> typeOfObjects = Reflection.getGenericClass(clazz, 0);
        if (typeOfObjects == null)
            return false;

        return !Types.isPrimitiveOrBoxedPrimitive(typeOfObjects);
    }

}
