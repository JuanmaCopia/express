package evorep.spoon;

import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.PotentialVariableDeclarationFunction;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SpoonQueries {

    public static CtClass<?> getClass(String qualifiedClassName) {
        return SpoonFactory.getFactory().Class().get(qualifiedClassName);
    }

    public static List<CtVariable<?>> getFields(CtType<?> clazz) {
        if (clazz == null)
            throw new IllegalArgumentException("Class cannot be null");
        List<CtVariable<?>> result = new LinkedList<>();
        result.addAll(clazz.getFields());
        return result;
    }

    public static List<CtVariable<?>> getFieldsOfType(CtVariable<?> var, CtTypeReference<?> type) {
        CtType<?> varType = var.getType().getDeclaration();
        if (varType == null)
            return new LinkedList<>();
        return getVariablesOfType(getFields(varType), type);
    }

    public static List<CtVariable<?>> getAccessibleFields(CtVariable<?> var) {
        return getAccessibleFields(var.getType());
    }

    public static List<CtVariable<?>> getAccessibleFields(CtTypeReference<?> typeRef) {
        if (typeRef.getDeclaration() == null)
            throw new IllegalArgumentException("the type is not in source files");
        return getFields(typeRef.getDeclaration()).stream().filter(
                field -> !field.isPrivate()
        ).toList();
    }

    public static List<CtVariable<?>> getLocalVariables(CtElement element) {
        return element.getElements(e -> e instanceof CtLocalVariable);
    }

    public static List<CtVariable<?>> getVariablesOfReferenceType(List<CtVariable<?>> list) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");
        return list.stream().filter(var -> isReferenceType(var)).toList();
    }

    public static List<CtVariable<?>> getUserDefinedVariables(List<CtVariable<?>> list) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");

        return list.stream().filter(var -> isUserDefined(var)).toList();
    }

    public static boolean isUserDefined(CtVariable<?> var) {
        return isReferenceType(var) && var.getType().getDeclaration() != null;
    }

    public static boolean isAccessibleField(CtVariable<?> var) {
        return !var.isPrivate();
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, CtTypeReference<?> type) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");
        return list.stream().filter(var -> var.getType().isSubtypeOf(type)).toList();
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, Class<?> type) {
        return getVariablesOfType(list, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, CtClass<?> type) {
        return getVariablesOfType(list, type.getReference());
    }

    public static List<CtVariable<?>> getAllRecheableVariablesOfType(CtBlock<?> block, Class<?> type) {
        List<CtVariable<?>> list = getAllRecheableVariables(block.getLastStatement());
        return getVariablesOfType(list, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static List<CtVariable<?>> getAllRecheableVariablesOfType(CtBlock<?> block, CtTypeReference<?> type) {
        List<CtVariable<?>> list = getAllRecheableVariables(block.getLastStatement());
        return getVariablesOfType(list, type);
    }

    public static List<CtVariable<?>> getAllRecheableVariables(CtStatement statement) {
        return statement.map(new PotentialVariableDeclarationFunction()).list();
    }

    public static List<CtVariable<?>> getAllRecheableLocalVariables(CtStatement statement) {
        return statement.map(new PotentialVariableDeclarationFunction()).map(e -> e instanceof CtLocalVariable).list();
    }

    public static List<CtVariable<?>> getAllRecheableLocalVariablesOfType(CtStatement statement,
                                                                          CtTypeReference<?> type) {
        return statement.map(new PotentialVariableDeclarationFunction())
                .map(e -> e instanceof CtLocalVariable && ((CtVariable<?>) e).getType().isSubtypeOf(type))
                .list();
    }

    public static List<CtVariable<?>> getAllRecheableLocalVariablesOfType(CtStatement statement,
                                                                          Class<?> type) {
        return getAllRecheableLocalVariablesOfType(statement, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static boolean isReferenceType(CtVariable var) {
        return var.getType().isSubtypeOf(SpoonFactory.getTypeFactory().OBJECT);
    }

    public static boolean containsVariableOfType(Collection<CtVariable<?>> vars, Class<?> type) {
        for (CtVariable<?> var : vars) {
            if (var.getType().isSubtypeOf(SpoonFactory.createReference(type)))
                return true;
        }
        return false;
    }

    public static boolean isPrimitiveType(CtVariable var) {
        return !isReferenceType(var);
    }

    public static int getStatementPosition(CtStatement statement, CtBlock<?> block) {
        for (int i = 0; i < block.getStatements().size(); i++) {
            if (block.getStatement(i) == statement)
                return i;
        }
        return -1;
    }

    public static int getVariableDeclarationPosition(CtVariable<?> var, CtBlock<?> block) {
        for (int i = 0; i < block.getStatements().size(); i++) {
            if (block.getStatement(i) instanceof CtVariable<?> && var == block.getStatement(i)) {
                return i;
            }
        }
        return -1;
    }

    public static String getFalseFitnessString() {
        CtClass<?> clazz = SpoonManager.getTargetClass();
        CtMethod<?> method = clazz.getMethodsByName("structureRepOK").get(0);

        StringBuilder stringBuilder = new StringBuilder();
        for (CtStatement statement : method.getBody().getStatements()) {
            stringBuilder.append(statement.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static CtVariable<?> getVariableByName(List<CtVariable<?>> localVars, String varName) {
        return localVars.stream().filter(var -> var.getSimpleName().equals(varName)).findFirst().orElse(null);
    }
}
