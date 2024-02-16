package evorep.spoon;

import evorep.ga.Individual;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.PotentialVariableDeclarationFunction;

import java.util.*;

public class SpoonQueries {

    public static CtClass<?> getClass(String qualifiedClassName) {
        return SpoonFactory.getFactory().Class().get(qualifiedClassName);
    }

    public static List<CtVariable<?>> getFieldsOfType(CtVariable<?> var, CtTypeReference<?> type) {
        CtType<?> varType = var.getType().getDeclaration();
        if (varType == null)
            return new LinkedList<>();
        return getVariablesOfType(getFields(varType), type);
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, CtTypeReference<?> type) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");
        return list.stream().filter(var -> var.getType().isSubtypeOf(type)).toList();
    }

    public static List<CtVariable<?>> getFields(CtType<?> clazz) {
        if (clazz == null)
            throw new IllegalArgumentException("Class cannot be null");
        List<CtVariable<?>> result = new LinkedList<>();
        result.addAll(clazz.getFields());
        return result;
    }

    public static List<CtVariable<?>> getFieldsOfType(CtType<?> varType, CtTypeReference<?> type) {
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
        return getFields(typeRef.getDeclaration());
    }

    public static List<CtStatement> getStatements(CtElement element) {
        return element.getElements(Objects::nonNull);
    }

    public static List<CtVariable<?>> getVariablesOfReferenceType(List<CtVariable<?>> list) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");
        return list.stream().filter(SpoonQueries::isReferenceType).toList();
    }

    public static boolean isReferenceType(CtVariable<?> var) {
        return !var.getType().isPrimitive();
    }

    public static boolean isPrimitiveType(CtVariable<?> var) {
        return var.getType().isPrimitive();
    }

    public static boolean isBoxedPrimitive(CtVariable<?> var) {
        CtTypeReference<?> type = var.getType();
        return (
                type.equals(SpoonFactory.getTypeFactory().BOOLEAN) ||
                        type.equals(SpoonFactory.getTypeFactory().CHARACTER) ||
                        type.equals(SpoonFactory.getTypeFactory().BYTE) ||
                        type.equals(SpoonFactory.getTypeFactory().SHORT) ||
                        type.equals(SpoonFactory.getTypeFactory().INTEGER) ||
                        type.equals(SpoonFactory.getTypeFactory().LONG) ||
                        type.equals(SpoonFactory.getTypeFactory().FLOAT) ||
                        type.equals(SpoonFactory.getTypeFactory().DOUBLE)
        );
    }

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, Class<?> type) {
        return getVariablesOfType(list, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static List<CtVariable<?>> getAllReachableVariablesFromMethod(CtMethod method) {
        return getAllReachableVariables(method.getBody().getLastStatement());
    }

    public static List<CtVariable<?>> getAllReachableVariables(CtElement statement) {
        return statement.map(new PotentialVariableDeclarationFunction()).list();
    }

    public static List<CtVariable<?>> getAllReachableVariablesFromIndividual(Individual individual) {
        return getAllReachableVariables(individual.getLastGene());
    }

    public static List<CtVariable<?>> getAllReachableLocalVariablesOfType(CtStatement statement,
                                                                          Class<?> type) {
        return getAllReachableLocalVariablesOfType(statement, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static List<CtVariable<?>> getAllReachableLocalVariablesOfType(CtStatement statement,
                                                                          CtTypeReference<?> type) {
        return statement.map(new PotentialVariableDeclarationFunction())
                .map(e -> e instanceof CtLocalVariable && ((CtVariable<?>) e).getType().isSubtypeOf(type))
                .list();
    }

    public static boolean containsVariableOfType(Collection<CtVariable<?>> vars, Class<?> type) {
        for (CtVariable<?> var : vars) {
            if (var.getType().isSubtypeOf(SpoonFactory.createReference(type)))
                return true;
        }
        return false;
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

    public static CtVariable<?> getVariableByName(List<CtVariable<?>> localVars, String varName) {
        return localVars.stream().filter(var -> var.getSimpleName().equals(varName)).findFirst().orElse(null);
    }

    public static CtVariable<?> getRandomUserDefLocalVar(List<CtVariable<?>> localVars) {
        List<CtVariable<?>> userDefLocalVars = SpoonQueries.getUserDefinedVariables(localVars).stream().filter(
                var -> var instanceof CtLocalVariable<?>
        ).toList();
        if (userDefLocalVars.isEmpty())
            return null;
        return userDefLocalVars.get(RandomUtils.nextInt(userDefLocalVars.size()));
    }

    public static List<CtVariable<?>> getUserDefinedVariables(List<CtVariable<?>> list) {
        if (list == null)
            throw new IllegalArgumentException("List cannot be null");

        return list.stream().filter(var -> isUserDefined(var)).toList();
    }

    public static boolean isUserDefined(CtVariable<?> var) {
        return isReferenceType(var) && var.getType().getDeclaration() != null;
    }

    public static boolean containsReturnStatement(CtBlock<?> block) {
        return !block.getElements(e -> e instanceof CtReturn).isEmpty();
    }

    public static Set<CtTypeReference<?>> getCandidateCyclicTypes(
            CtBlock<?> block,
            String varNamePrefix
    ) {
        Set<CtTypeReference<?>> selfCyclicTypes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();
        List<CtLocalVariable<?>> localVars = SpoonQueries.getDeclaredLocalVars(block);

        Set<CtTypeReference<?>> candidateTypes = new HashSet<>();
        for (CtTypeReference type : selfCyclicTypes) {
            if (localVars.stream().noneMatch(var ->
                    var.getSimpleName().startsWith(varNamePrefix) &&
                            var.getReference().getType().getActualTypeArguments().get(0).getQualifiedName().equals(type.getQualifiedName())
            ))
                candidateTypes.add(type);
        }
        return candidateTypes;
    }

/*
    public static List<CtLocalVariable<?>> getDeclaredLocalVars(CtBlock<?> block) {
        List<CtLocalVariable<?>> localVars = new LinkedList<>();
        for (CtStatement statement : block.getStatements()) {
            if (statement instanceof CtLocalVariable<?> localVar)
                localVars.add(localVar);
        }
        return localVars;
    }
*/

    public static List<CtLocalVariable<?>> getDeclaredLocalVars(CtBlock<?> block) {
        return block.getElements(Objects::nonNull);
    }

    public static Set<CtField<?>> getCandidateFields(
            CtBlock<?> block
    ) {
        TypesGraph typesGraph = SpoonManager.getTypesGraph();
        CtTypeReference<?> root = typesGraph.getRoot();

        List<CtField<?>> fields = typesGraph.getOutgoingFields(root).stream().filter(var -> isUserDefined(var)).toList();
        List<CtLocalVariable<?>> localVars = SpoonQueries.getDeclaredLocalVars(block);

        Set<CtField<?>> candidateFields = new HashSet<>();
        for (CtField<?> field : fields) {
            if (localVars.stream().noneMatch(var ->
                    var.getAssignment() instanceof CtVariableRead varRead &&
                            varRead.getVariable().getSimpleName().equals(field.getSimpleName()))
            )
                candidateFields.add(field);
        }
        return candidateFields;
    }

    /*public static boolean hasWorklistDeclared(CtBlock<?> block) {
        Set<CtTypeReference<?>> cyclicNodes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();

        List<CtLocalVariable<?>> localVars = getDeclaredLocalVars(block).stream().filter(var ->
                var.getType().isSubtypeOf(SpoonFactory.getTypeFactory().createReference(List.class)) &&
                cyclicNodes.contains(var.getType().getActualTypeArguments().get(0))

        ).toList();

        return !localVars.isEmpty();
    }*/

    public static boolean hasWorklistDeclared(CtBlock<?> block) {
        return !getWorklistDeclared(block).isEmpty();
    }

    public static List<CtLocalVariable<?>> getWorklistDeclared(CtBlock<?> block) {
        Set<CtTypeReference<?>> cyclicNodes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();
        return block.getElements(var -> isWorklist(var, cyclicNodes));
    }

    public static boolean isWorklist(CtLocalVariable<?> var, Set<CtTypeReference<?>> cyclicNodes) {
        return var.getType().isSubtypeOf(SpoonFactory.getTypeFactory().createReference(List.class)) &&
                cyclicNodes.contains(var.getType().getActualTypeArguments().get(0));
    }

    public static List<CtLocalVariable<?>> getNonTraversedWorklists(CtBlock<?> block) {
        List<CtLocalVariable<?>> worklists = getWorklistDeclared(block);
        List<CtLocalVariable<?>> nonTraversedWorklists = new LinkedList<>();

        List<CtWhile> loops = block.getElements(Objects::nonNull);

        for (CtLocalVariable<?> worklist : worklists) {
            boolean isTraversed = false;
            for (CtWhile loop : loops) {
                if (isWorklistTraversed(worklist, loop))
                    isTraversed = true;
            }
            if (!isTraversed)
                nonTraversedWorklists.add(worklist);
        }

        return nonTraversedWorklists;
    }

    private static boolean isWorklistTraversed(CtLocalVariable<?> worklist, CtWhile loop) {
        List<CtVariableRead<?>> varReads = loop.getLoopingExpression().getElements(Objects::nonNull);
        for (CtVariableRead<?> varRead : varReads) {
            if (varRead.getVariable().getSimpleName().equals(worklist.getSimpleName()))
                return true;
        }
        return false;
    }

}
