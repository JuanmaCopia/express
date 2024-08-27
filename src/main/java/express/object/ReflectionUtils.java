package express.object;

import java.lang.reflect.*;
import java.util.Collection;
import java.util.Map;

public class ReflectionUtils {

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

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClassOfObjectsInCollection(Collection<T> collection) {
        return (Class<T>) getGenericClass(collection.getClass(), 0);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Class<K> getKeyClass(Map<K, V> map) {
        return (Class<K>) getGenericClass(map.getClass(), 0);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Class<V> getValueClass(Map<K, V> map) {
        return (Class<V>) getGenericClass(map.getClass(), 1);
    }

    public static Class<?> getGenericClass(Class<?> clazz, int index) {
        Type[] types = clazz.getGenericSuperclass() instanceof ParameterizedType
                ? ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()
                : clazz.getGenericInterfaces().length > 0 && clazz.getGenericInterfaces()[0] instanceof ParameterizedType
                ? ((ParameterizedType) clazz.getGenericInterfaces()[0]).getActualTypeArguments()
                : null;

        if (types != null && types.length > index) {
            Type type = types[index];
            if (type instanceof Class<?>) {
                return (Class<?>) type;
            } else if (type instanceof ParameterizedType) {
                return (Class<?>) ((ParameterizedType) type).getRawType();
            } else if (type instanceof GenericArrayType) {
                Type componentType = ((GenericArrayType) type).getGenericComponentType();
                if (componentType instanceof Class<?>) {
                    return Array.newInstance((Class<?>) componentType, 0).getClass();
                }
            } else if (type instanceof TypeVariable) {
                // You might want to resolve the type variable if you have the context
                // For now, return Object.class as a fallback
                //return Object.class;
                return null;
            } else if (type instanceof WildcardType) {
                // Handle wildcard types (e.g., "? extends Number")
                Type[] bounds = ((WildcardType) type).getUpperBounds();
                if (bounds.length > 0 && bounds[0] instanceof Class<?>) {
                    return (Class<?>) bounds[0];
                }
            }
        }
        //return Object.class; // Default to Object if type cannot be determined
        return null;
    }

}
