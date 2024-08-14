package express.object;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.HashSet;

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

}
