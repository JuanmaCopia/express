package express.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import express.type.typegraph.Path;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.reference.CtWildcardReference;
import spoon.support.reflect.reference.CtTypeReferenceImpl;

public class TypeUtils {

    public static boolean isUserDefinedType(CtVariable<?> var) {
        return isUserDefinedType(var.getType());
    }

    public static boolean isUserDefinedType(CtTypeReference<?> type) {
        return isReferenceType(type) && !isArrayType(type) && isInSourcePath(type);
    }

    public static boolean isInSourcePath(CtTypeReference<?> type) {
        return !type.getTypeDeclaration().isShadow();
    }

    public static Set<CtTypeReference<?>> filterTypes(Collection<CtTypeReference<?>> typeRefs,
            Predicate<CtTypeReference<?>> predicate) {
        Set<CtTypeReference<?>> resultTypes = new HashSet<>();
        for (CtTypeReference<?> typeRef : typeRefs) {
            if (predicate.test(typeRef)) {
                resultTypes.add(typeRef);
            }
        }
        return resultTypes;
    }

    public static Set<CtVariable<?>> filterFields(Collection<CtVariable<?>> fields,
            Predicate<CtTypeReference<?>> predicate) {
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

    public static Set<Path> filterPathsByType(Collection<Path> paths, CtTypeReference<?> type) {
        Set<Path> resultPaths = new HashSet<>();
        for (Path path : paths) {
            CtTypeReference<?> pathType = path.getTypeReference();
            if (pathType.isSubtypeOf(type)) {
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
        if (typeRef == null || !isUserDefinedType(typeRef))
            return false;
        CtType<?> typeDeclaration = typeRef.getTypeDeclaration();

        for (CtVariable<?> field : getAllFields(typeDeclaration)) {
            if (field.getType().isSubtypeOf(typeRef))
                return true;
        }
        return false;
    }

    public static List<CtVariable<?>> getCyclicFieldsOfType(CtTypeReference<?> typeRef) {
        if (typeRef == null || !isUserDefinedType(typeRef))
            throw new IllegalArgumentException("Type is null or not user-defined");

        CtType<?> typeDeclaration = typeRef.getTypeDeclaration();
        List<CtVariable<?>> cyclicFields = new ArrayList<>();
        for (CtVariable<?> field :  getAllFields(typeDeclaration)) {
            if (field.getType().isSubtypeOf(typeRef))
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

    public static CtTypeReference<?> getActualTypeArgument(CtTypeReference<?> typeRef, int subtypeIndex) {
        return typeRef.getActualTypeArguments().get(subtypeIndex);
    }

    public static CtTypeReference<?> getComponentType(CtArrayTypeReference<?> typeRef) {
        return typeRef.getComponentType();
    }

    public static boolean isAssignableArray(CtArrayTypeReference<?> array1, CtArrayTypeReference<?> array2) {
        CtTypeReference<?> componentType1 = getComponentType(array1);
        int count1 = 0;
        while (componentType1.isArray()) {
            count1++;
            componentType1 = getComponentType((CtArrayTypeReference<?>) componentType1);
        }

        CtTypeReference<?> componentType2 = getComponentType(array2);
        int count2 = 0;
        while (componentType2.isArray()) {
            count2++;
            componentType2 = getComponentType((CtArrayTypeReference<?>) componentType2);
        }

        return count1 == count2 && componentType2.isSubtypeOf(componentType1);
    }

    public static boolean isUserDefinedArrayType(CtTypeReference<?> a) {
        if (!a.isArray())
            return false;
        return isUserDefinedType(getComponentType((CtArrayTypeReference<?>) a));
    }

    public static boolean areRelated(CtTypeReference<?> a, CtTypeReference<?> b) {
        return a.isSubtypeOf(b) || b.isSubtypeOf(a);
    }

    // public static boolean areEquals(CtTypeReference<?> a, CtTypeReference<?> b) {
    // CtTypeReference<?> aWildcard = convertGenericsToWildcard(a);
    // CtTypeReference<?> bWildcard = convertGenericsToWildcard(b);
    // return aWildcard.getQualifiedName().equals(bWildcard.getQualifiedName());
    // }

    public static CtTypeReference<?> convertGenericsToWildcard(CtTypeReference<?> typeRef) {
        List<CtTypeReference<?>> originalTypeArguments = typeRef.getActualTypeArguments();
        if (originalTypeArguments.isEmpty()) {
            if (typeRef.isGenerics())
                return typeRef.getFactory().Core().createWildcardReference();
            return typeRef;
        }

        // Create wildcard references for each type argument
        List<CtWildcardReference> wildcardArguments = originalTypeArguments.stream()
                .map(arg -> typeRef.getFactory().Core().createWildcardReference())
                .collect(Collectors.toList());

        // Create a copy of the original type reference
        CtTypeReference<?> wildcardTypeRef = typeRef.clone();

        wildcardTypeRef.setActualTypeArguments(wildcardArguments);
        return wildcardTypeRef;
    }

    public static Set<CtField<?>> getAllFields(CtTypeReference<?> type) {
        if (type == null || !isUserDefinedType(type))
            throw new IllegalArgumentException("Type is null or not user-defined");
        return getAllFields(type.getTypeDeclaration());
    }

    public static Set<CtField<?>> getAllFields(CtType<?> type) {
        Set<CtField<?>> fields = new HashSet<>();

        // Collect fields from the current type
        fields.addAll(type.getFields());

        // Traverse the superclasses and collect accessible fields
        CtTypeReference<?> superClassRef = type.getSuperclass();
        while (superClassRef != null) {
            CtType<?> superClass = superClassRef.getTypeDeclaration();
            if (superClass != null) {
                for (CtField<?> field : superClass.getFields()) {
                    // Add the field if it's public or protected
                    if (field.isPublic() || field.isProtected()) {
                        fields.add(field);
                    }
                }
                superClassRef = superClass.getSuperclass();
            } else {
                break;
            }
        }

        return fields;
    }

    public static boolean hasOnlyOneCyclicField(Path path) {
        List<CtVariable<?>> fields = path.getFieldChain();
        int count = 0;
        for (CtVariable<?> field : fields) {
            if (isCyclicType(field.getType())) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasMultipleLoopFields(CtTypeReference<?> type) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(type);
        return loopFields.size() > 1;
    }
}
