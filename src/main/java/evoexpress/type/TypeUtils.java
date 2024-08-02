package evoexpress.type;

import evoexpress.type.typegraph.Path;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;
import spoon.support.reflect.reference.CtTypeReferenceImpl;

import java.util.*;
import java.util.function.Predicate;

public class TypeUtils {

    public static List<CtVariable<?>> getFields(CtTypeReference<?> typeRef) {
        CtType<?> declaration = typeRef.getTypeDeclaration();
        if (declaration == null)
            throw new IllegalArgumentException("Type is not declared in the current project");

        return new ArrayList<>(declaration.getFields());
    }

    public static boolean isUserDefined(CtVariable<?> var) {
        return isUserDefined(var.getType());
    }

    public static boolean isUserDefined(CtTypeReference<?> type) {
        return isReferenceType(type) && isInSourcePath(type);
    }

    public static boolean isInSourcePath(CtTypeReference<?> type) {
        return !type.getTypeDeclaration().isShadow();
    }

    public static Set<CtTypeReference<?>> filterTypes(Collection<CtTypeReference<?>> typeRefs, Predicate<CtTypeReference<?>> predicate) {
        Set<CtTypeReference<?>> resultTypes = new HashSet<>();
        for (CtTypeReference<?> typeRef : typeRefs) {
            if (predicate.test(typeRef)) {
                resultTypes.add(typeRef);
            }
        }
        return resultTypes;
    }

    public static Set<CtVariable<?>> filterFields(Collection<CtVariable<?>> fields, Predicate<CtTypeReference<?>> predicate) {
        Set<CtVariable<?>> resultFields = new HashSet<>();
        for (CtVariable<?> field : fields) {
            if (predicate.test(field.getType())) {
                resultFields.add(field);
            }
        }
        return resultFields;
    }

    public static Set<Path> filterPaths(Collection<Path> paths, Predicate<CtTypeReference<?>> predicate) {
        Set<Path> resultPaths = new HashSet<>();
        for (Path path : paths) {
            CtTypeReference<?> type = path.getTypeReference();
            if (predicate.test(type)) {
                resultPaths.add(path);
            }
        }
        return resultPaths;
    }

    public static boolean isReferenceType(CtTypeReference<?> typeRef) {
        return !typeRef.isPrimitive() && !isBoxedPrimitive(typeRef);
    }

    public static boolean isPrimitiveOrBoxedPrimitiveType(CtTypeReference<?> typeRef) {
        return typeRef.isPrimitive() || isBoxedPrimitive(typeRef);
    }

    public static boolean isBoxedPrimitive(CtTypeReference<?> typeRef) {
        String typeName = typeRef.getQualifiedName();
        return "java.lang.Integer".equals(typeName) ||
                "java.lang.Long".equals(typeName) ||
                "java.lang.Short".equals(typeName) ||
                "java.lang.Byte".equals(typeName) ||
                "java.lang.Float".equals(typeName) ||
                "java.lang.Double".equals(typeName) ||
                "java.lang.Character".equals(typeName) ||
                "java.lang.Boolean".equals(typeName);
    }

    public static boolean isIntegerType(CtTypeReference<?> typeRef) {
        String typeName = typeRef.getQualifiedName();
        return "java.lang.Integer".equals(typeName) || "int".equals(typeName) ||
                "java.lang.Long".equals(typeName) || "long".equals(typeName) ||
                "java.lang.Short".equals(typeName) || "short".equals(typeName) ||
                "java.lang.Byte".equals(typeName) || "byte".equals(typeName);
    }

    public static boolean isBooleanType(CtTypeReference<?> typeRef) {
        String typeName = typeRef.getQualifiedName();
        return "java.lang.Boolean".equals(typeName) || "boolean".equals(typeName);
    }

    public static boolean isCharType(CtTypeReference<?> typeRef) {
        String typeName = typeRef.getQualifiedName();
        return "java.lang.Character".equals(typeName) || "char".equals(typeName);
    }

    public static boolean isFloatingPointType(CtTypeReference<?> typeRef) {
        String typeName = typeRef.getQualifiedName();
        return "java.lang.Float".equals(typeName) || "float".equals(typeName) ||
                "java.lang.Double".equals(typeName) || "double".equals(typeName);
    }

    public static boolean isCyclicType(CtTypeReference<?> typeRef) {
        CtType<?> type = typeRef.getTypeDeclaration();
        if (type == null)
            return false;

        for (CtVariable<?> field : type.getFields()) {
            if (field.getType().equals(typeRef))
                return true;
        }
        return false;
    }

    public static List<CtVariable<?>> getFieldsOfType(CtTypeReference<?> type) {
        if (type == null)
            throw new IllegalArgumentException("Type is null");
        CtType<?> typeDeclaration = type.getTypeDeclaration();
        if (typeDeclaration == null)
            throw new IllegalArgumentException("Type is not declared in the current project");

        return new ArrayList<>(typeDeclaration.getFields());
    }

    public static List<CtVariable<?>> getCyclicFieldsOfType(CtTypeReference<?> type) {
        if (type == null)
            throw new IllegalArgumentException("Type is null");
        CtType<?> typeDeclaration = type.getTypeDeclaration();
        if (typeDeclaration == null)
            throw new IllegalArgumentException("Type is not declared in the current project");

        List<CtVariable<?>> cyclicFields = new ArrayList<>();
        for (CtVariable<?> field : typeDeclaration.getFields()) {
            if (field.getType().equals(type))
                cyclicFields.add(field);
        }
        return cyclicFields;
    }

    public static boolean isArrayType(CtTypeReference<?> typeRef) {
        return typeRef.isArray();
    }

    public static boolean isIterableType(CtTypeReference<?> typeRef) {
        CtTypeReference<?> iterableType = new CtTypeReferenceImpl<>();
        iterableType.setSimpleName("java.lang.Iterable");

        // Check if the type itself is Iterable
        if (typeRef.isSubtypeOf(iterableType)) {
            return true;
        }

        // Check all implemented interfaces
        for (CtTypeReference<?> superInterface : typeRef.getSuperInterfaces()) {
            if (superInterface.isSubtypeOf(iterableType)) {
                return true;
            }
        }

        // Also check the superclass (if any)
        CtTypeReference<?> superClass = typeRef.getSuperclass();
        if (superClass != null && superClass.isSubtypeOf(iterableType)) {
            return true;
        }

        return false;
    }
}
