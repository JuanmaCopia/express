package express.type;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import express.type.typegraph.Path;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;
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

    public static LinkedHashSet<CtTypeReference<?>> filterTypes(List<CtTypeReference<?>> typeRefs,
                                                      Predicate<CtTypeReference<?>> predicate) {
        LinkedHashSet<CtTypeReference<?>> resultTypes = new LinkedHashSet<>();
        for (CtTypeReference<?> typeRef : typeRefs) {
            if (predicate.test(typeRef)) {
                resultTypes.add(typeRef);
            }
        }
        return resultTypes;
    }

    public static LinkedHashSet<CtVariable<?>> filterFields(List<CtVariable<?>> fields,
                                                  Predicate<CtTypeReference<?>> predicate) {
        LinkedHashSet<CtVariable<?>> resultFields = new LinkedHashSet<>();
        for (CtVariable<?> field : fields) {
            if (predicate.test(field.getType())) {
                resultFields.add(field);
            }
        }
        return resultFields;
    }

    public static LinkedHashSet<Path> filterPaths(List<Path> paths, Predicate<CtTypeReference<?>> predicate) {
        LinkedHashSet<Path> resultPaths = new LinkedHashSet<>();
        for (Path path : paths) {
            CtTypeReference<?> type = path.getTypeReference();
            if (predicate.test(type)) {
                resultPaths.add(path);
            }
        }
        return resultPaths;
    }

    public static LinkedHashSet<Path> filterPathsByType(List<Path> paths, CtTypeReference<?> type) {
        LinkedHashSet<Path> resultPaths = new LinkedHashSet<>();
        for (Path path : paths) {
            CtTypeReference<?> pathType = path.getTypeReference();
            if (pathType.isSubtypeOf(type)) {
                resultPaths.add(path);
            }
        }
        return resultPaths;
    }

    public static LinkedHashSet<CtTypeReference<?>> filterTypes(LinkedHashSet<CtTypeReference<?>> typeRefs,
                                                      Predicate<CtTypeReference<?>> predicate) {
        return filterTypes(new ArrayList<>(typeRefs), predicate);
    }

    public static LinkedHashSet<CtVariable<?>> filterFields(LinkedHashSet<CtVariable<?>> fields,
                                                  Predicate<CtTypeReference<?>> predicate) {
        return filterFields(new ArrayList<>(fields), predicate);
    }

    public static LinkedHashSet<Path> filterPaths(LinkedHashSet<Path> paths, Predicate<CtTypeReference<?>> predicate) {
        return filterPaths(new ArrayList<>(paths), predicate);
    }

    public static LinkedHashSet<Path> filterPathsByType(LinkedHashSet<Path> paths, CtTypeReference<?> type) {
        return filterPathsByType(new ArrayList<>(paths), type);
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

    public static CtTypeReference<?> getBoxedPrimitive(CtTypeReference<?> typeRef) {
        if (typeRef.isPrimitive()) {
            String qualifiedName = typeRef.getQualifiedName();
            if (qualifiedName.equals("int"))
                return typeRef.getFactory().Type().integerType();
            if (qualifiedName.equals("long"))
                return typeRef.getFactory().Type().longType();
            if (qualifiedName.equals("short"))
                return typeRef.getFactory().Type().shortType();
            if (qualifiedName.equals("byte"))
                return typeRef.getFactory().Type().byteType();
            if (qualifiedName.equals("float"))
                return typeRef.getFactory().Type().floatType();
            if (qualifiedName.equals("double"))
                return typeRef.getFactory().Type().doubleType();
            if (qualifiedName.equals("char"))
                return typeRef.getFactory().Type().characterType();
            if (qualifiedName.equals("boolean"))
                return typeRef.getFactory().Type().booleanType();
        }
        return typeRef;
    }

    public static boolean isNumericType(CtTypeReference<?> typeRef) {
        return isIntegerType(typeRef) || isFloatingPointType(typeRef) || isCharType(typeRef);
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

        for (CtVariable<?> field : getAccessibleFields(typeDeclaration)) {
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
        for (CtVariable<?> field : getAccessibleFields(typeDeclaration)) {
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

    public static CtTypeReference<?> convertGenericsToWildcard(CtTypeReference<?> typeRef) {
        List<CtTypeReference<?>> originalTypeArguments = typeRef.getActualTypeArguments();
        if (originalTypeArguments.isEmpty()) {
            if (typeRef.isGenerics()) {
                return typeRef.getFactory().Core().createWildcardReference();
            }
            return typeRef;
        }

        List<CtTypeReference<?>> newTypeArguments = new ArrayList<>();
        for (CtTypeReference<?> typeArgument : originalTypeArguments) {
            newTypeArguments.add(convertGenericsToWildcard(typeArgument));
        }

        // Create a copy of the original type reference
        CtTypeReference<?> wildcardTypeRef = typeRef.clone();
        wildcardTypeRef.setActualTypeArguments(newTypeArguments);
        return wildcardTypeRef;
    }

    public static List<CtField<?>> getAccessibleFields(CtTypeReference<?> type) {
        if (type == null || !isUserDefinedType(type))
            throw new IllegalArgumentException("Type is null or not user-defined");
        return getAccessibleFields(type.getTypeDeclaration());
    }

    public static List<CtField<?>> getAccessibleFields(CtType<?> type) {
        List<CtField<?>> accessibleFields = type.getFields().stream().filter(f -> !f.isStatic()).collect(Collectors.toList());
        CtTypeReference<?> subClass = type.getReference();
        CtTypeReference<?> current = type.getSuperclass();
        while (current != null && isUserDefinedType(current)) {
            for (CtField<?> field : current.getTypeDeclaration().getFields()) {
                if (!field.isStatic() && !field.isPrivate()) {
                    if (subClass.getPackage().equals(current.getPackage())) {
                        accessibleFields.add(field);
                    } else if (field.isPublic()) {
                        accessibleFields.add(field);
                    }
                }
            }
            subClass = current;
            current = current.getSuperclass();
        }
        accessibleFields.sort(Comparator.comparing(CtField::getSimpleName));
        return accessibleFields;
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

    public static LinkedHashSet<CtClass<?>> getAllUserDefinedClassesInModel(CtModel model) {
        List<CtClass<?>> classes = model.getRootPackage().getElements(new TypeFilter<>(CtClass.class));
        List<CtClass<?>> userDefClasses = new ArrayList<>();
        for (CtClass<?> clazz : classes) {
            if (TypeUtils.isUserDefinedType(clazz.getReference())) {
                userDefClasses.add(clazz);
            }
        }
        // Sort user-defined classes by name
        userDefClasses.sort(Comparator.comparing(CtClass::getSimpleName));
        return new LinkedHashSet<>(userDefClasses);
    }

}
