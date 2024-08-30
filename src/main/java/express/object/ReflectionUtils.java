package express.object;

import sun.misc.Unsafe;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionUtils {

    @SuppressWarnings("unchecked")
    public static <K> K createNewReferenceTypeInstance(Class<K> clazz) throws NewInstanceCreationException {
        if (TypeChecker.isPrimitiveOrBoxedPrimitive(clazz) || TypeChecker.isArrayOfPrimitiveType(clazz))
            throw new IllegalArgumentException("Class is not of reference type: " + clazz.getName());
        if (clazz.isArray())
            return (K) ValueProvider.createNewArrayInstance(clazz);

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
            try {
                Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                Unsafe unsafe = (Unsafe) f.get(null);
                // Create instance without calling constructor
                return (K) unsafe.allocateInstance(clazz);
            } catch (Exception ex) {
                throw new NewInstanceCreationException(clazz, ex);
            }
        }
        return instance;
    }

    public static Object getFieldValue(Object owner, Field field) {
        Object currentValue = null;
        try {
            field.setAccessible(true);
            currentValue = field.get(owner);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return currentValue;
    }

    public static void setFieldValue(Object owner, Field field, Object newValue) {
        try {
            // Make the field accessible if it's private or protected
            field.setAccessible(true);

            // Check if the field is final
            if (Modifier.isFinal(field.getModifiers())) {
                // Use Unsafe to modify the final field
                Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
                unsafeField.setAccessible(true);
                Unsafe unsafe = (Unsafe) unsafeField.get(null);

                unsafe.putObject(owner, unsafe.objectFieldOffset(field), newValue);
            } else {
                // For non-final fields, use regular reflection
                field.set(owner, newValue);
            }
        } catch (Exception e) {
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

    public static List<Field> getAccessibleFields(Object object) {
        return getAccessibleFields(object.getClass());
    }

    public static List<Field> getAccessibleFields(Class<?> clazz) {
        List<Field> accessibleFields = new LinkedList<>(Arrays.stream(clazz.getDeclaredFields()).filter(f -> !Modifier.isStatic(f.getModifiers())).toList());
        Class<?> subClass = clazz;
        Class<?> current = clazz.getSuperclass();
        while (current != null && TypeChecker.isUserDefinedClass(current)) {
            Field[] fields = current.getDeclaredFields();
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers())) {
                    if (subClass.getPackageName().equals(current.getPackageName())) {
                        accessibleFields.add(field);
                    } else if (Modifier.isPublic(field.getModifiers())){
                        accessibleFields.add(field);
                    }
                }
            }
            subClass = current;
            current = current.getSuperclass();
        }
        return accessibleFields;
    }
    
}
