package evoexpress.type;

import evoexpress.spoon.SpoonFactory;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class TypeUtils {

    public static boolean isUserDefined(CtVariable<?> var) {
        return isUserDefined(var.getType());
    }

    public static boolean isUserDefined(CtTypeReference<?> type) {
        return isReferenceType(type) && isInSourcePath(type);
    }

    public static boolean isInSourcePath(CtTypeReference<?> type) {
        return !type.getTypeDeclaration().isShadow();
    }

    public static boolean isReferenceType(CtTypeReference<?> type) {
        return !type.isPrimitive();
    }

    public static boolean isPrimitiveOrBoxedPrimitiveType(CtTypeReference<?> typeRef) {
        return typeRef.isPrimitive() || isBoxedPrimitive(typeRef);
    }

    public static boolean isBoxedPrimitive(CtTypeReference<?> type) {
        return (type.equals(SpoonFactory.getTypeFactory().BOOLEAN) ||
                type.equals(SpoonFactory.getTypeFactory().CHARACTER) ||
                type.equals(SpoonFactory.getTypeFactory().BYTE) ||
                type.equals(SpoonFactory.getTypeFactory().SHORT) ||
                type.equals(SpoonFactory.getTypeFactory().INTEGER) ||
                type.equals(SpoonFactory.getTypeFactory().LONG) ||
                type.equals(SpoonFactory.getTypeFactory().FLOAT) ||
                type.equals(SpoonFactory.getTypeFactory().DOUBLE));
    }
}
