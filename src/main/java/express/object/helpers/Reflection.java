package express.object.helpers;

import express.object.mutate.values.ValueProvider;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.declaration.CtVariable;
import sun.misc.Unsafe;

import java.lang.reflect.*;
import java.util.*;

public class Reflection {

    @SuppressWarnings("unchecked")
    public static <K> K createNewReferenceTypeInstance(Class<K> clazz) throws NewInstanceCreationException {
        if (Types.isPrimitiveOrBoxedPrimitive(clazz) || Types.isArrayOfPrimitiveType(clazz))
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

    public static Field getFieldByName(Object object, String fieldName) {
        Field result = getAccessibleFields(object).stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        if (result == null) {
            throw new IllegalArgumentException("Field not found: " + fieldName);
        }
        return result;
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
        java.lang.reflect.Type[] types = clazz.getGenericSuperclass() instanceof ParameterizedType
                ? ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()
                : clazz.getGenericInterfaces().length > 0 && clazz.getGenericInterfaces()[0] instanceof ParameterizedType
                ? ((ParameterizedType) clazz.getGenericInterfaces()[0]).getActualTypeArguments()
                : null;

        if (types != null && types.length > index) {
            java.lang.reflect.Type type = types[index];
            if (type instanceof Class<?>) {
                return (Class<?>) type;
            } else if (type instanceof ParameterizedType) {
                return (Class<?>) ((ParameterizedType) type).getRawType();
            } else if (type instanceof GenericArrayType) {
                java.lang.reflect.Type componentType = ((GenericArrayType) type).getGenericComponentType();
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

    public static List<Field> getPrimitiveFields(Object object) {
        return Reflection.getAccessibleFields(object.getClass()).stream()
                .filter(f -> Types.isPrimitiveOrBoxedPrimitive(f.getType()))
                .toList();
    }

    public static List<Field> getReferenceFields(Class<?> type) {
        return Reflection.getAccessibleFields(type).stream()
                .filter(f -> !f.getType().isPrimitive())
                .toList();
    }

    public static List<Field> getAccessibleFields(Object object) {
        return getAccessibleFields(object.getClass());
    }

    public static List<Field> getAccessibleFields(Class<?> clazz) {
        List<Field> accessibleFields = new LinkedList<>(Arrays.stream(clazz.getDeclaredFields()).filter(f -> !Modifier.isStatic(f.getModifiers())).toList());
        Class<?> subClass = clazz;
        Class<?> current = clazz.getSuperclass();
        while (current != null && Types.isUserDefinedClass(current)) {
            Field[] fields = current.getDeclaredFields();
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers())) {
                    if (subClass.getPackageName().equals(current.getPackageName())) {
                        accessibleFields.add(field);
                    } else if (Modifier.isPublic(field.getModifiers())) {
                        accessibleFields.add(field);
                    }
                }
            }
            subClass = current;
            current = current.getSuperclass();
        }
        return accessibleFields;
    }


    public static boolean canBeEvaluated(Object rootObject, Path path) {
        if (rootObject == null || path == null || path.size() < 2) {
            throw new IllegalArgumentException();
        }
        if (path.size() == 2) {
            return true;
        }
        LinkedList<CtVariable<?>> fields = path.getFieldChain();
        fields.removeFirst();
        fields.removeLast();
        Object currentObject = rootObject;
        for (CtVariable<?> field : fields) {
            Field fieldObject = getFieldByName(currentObject, field.getSimpleName());
            currentObject = getFieldValue(currentObject, fieldObject);
            if (currentObject == null) {
                return false;
            }
        }
        return true;
    }

    public static Pair<Field, Object> evaluatePath(Object rootObject, Path path) {
        if (rootObject == null || path == null || path.size() < 2) {
            throw new IllegalArgumentException();
        }
        LinkedList<CtVariable<?>> fields = path.getFieldChain();
        fields.removeFirst();
        Object currentObject = rootObject;
        Field fieldObject = null;
        for (CtVariable<?> field : fields) {
            fieldObject = getFieldByName(currentObject, field.getSimpleName());
            currentObject = getFieldValue(currentObject, fieldObject);
        }
        return Pair.of(fieldObject, currentObject);
    }

    public static void setPathValue(Object rootObject, Path path, Object newValue) {
        if (rootObject == null || path == null || path.size() < 2) {
            throw new IllegalArgumentException();
        }
        if (path.size() == 2) {
            setFieldValue(rootObject, getFieldByName(rootObject, path.getLast().getSimpleName()), newValue);
        }
        LinkedList<CtVariable<?>> fields = path.getFieldChain();
        fields.removeFirst();
        CtVariable<?> lastField = fields.removeLast();
        Object currentObject = rootObject;
        Field fieldObject = null;
        for (CtVariable<?> field : fields) {
            fieldObject = getFieldByName(currentObject, field.getSimpleName());
            currentObject = getFieldValue(currentObject, fieldObject);
        }
        Field fieldToSet = getFieldByName(currentObject, lastField.getSimpleName());
        setFieldValue(currentObject, fieldToSet, newValue);
    }
}
