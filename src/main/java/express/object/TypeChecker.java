package express.object;

import express.spoon.SpoonManager;
import spoon.reflect.reference.CtTypeReference;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TypeChecker {

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
        List<CtTypeReference<?>> userDefTypes = SpoonManager.getSubjectTypeData().getUserDefinedTypes();
        return userDefTypes.stream().anyMatch(t -> t.getQualifiedName().equals(cls.getName()));
    }

}
