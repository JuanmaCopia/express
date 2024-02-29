package evorep.spoon;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import evorep.ga.Individual;
import evorep.ga.helper.LocalVarHelper;
import evorep.spoon.generators.ReferenceExpressionGenerator;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.code.CtVariableWrite;
import spoon.reflect.code.CtWhile;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.PotentialVariableDeclarationFunction;

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

    public static List<CtVariable<?>> getReferenceFields(CtTypeReference<?> type) {
        if (type.getDeclaration() == null)
            throw new IllegalArgumentException("the type is not in source files");
        return getVariablesOfType(getFields(type.getDeclaration()), SpoonFactory.getTypeFactory().OBJECT);
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
        return (type.equals(SpoonFactory.getTypeFactory().BOOLEAN) ||
                type.equals(SpoonFactory.getTypeFactory().CHARACTER) ||
                type.equals(SpoonFactory.getTypeFactory().BYTE) ||
                type.equals(SpoonFactory.getTypeFactory().SHORT) ||
                type.equals(SpoonFactory.getTypeFactory().INTEGER) ||
                type.equals(SpoonFactory.getTypeFactory().LONG) ||
                type.equals(SpoonFactory.getTypeFactory().FLOAT) ||
                type.equals(SpoonFactory.getTypeFactory().DOUBLE));
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

    public static CtVariable<?> getVariableByName(List<CtVariable<?>> localVars, String varName) {
        return localVars.stream().filter(var -> var.getSimpleName().equals(varName)).findFirst().orElse(null);
    }

    public static CtVariable<?> getRandomUserDefLocalVar(List<CtVariable<?>> localVars) {
        List<CtVariable<?>> userDefLocalVars = SpoonQueries.getUserDefinedVariables(localVars).stream().filter(
                var -> var instanceof CtLocalVariable<?>).toList();
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
            String varNamePrefix) {
        Set<CtTypeReference<?>> selfCyclicTypes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();
        List<CtLocalVariable<?>> localVars = SpoonQueries.getDeclaredLocalVars(block);

        Set<CtTypeReference<?>> candidateTypes = new HashSet<>();
        for (CtTypeReference type : selfCyclicTypes) {
            if (localVars.stream().noneMatch(var -> var.getSimpleName().startsWith(varNamePrefix) &&
                    var.getReference().getType().getActualTypeArguments().get(0).getQualifiedName()
                            .equals(type.getQualifiedName())))
                candidateTypes.add(type);
        }
        return candidateTypes;
    }

    public static List<CtLocalVariable<?>> getDeclaredLocalVars(CtBlock<?> block) {
        return block.getElements(Objects::nonNull);
    }

    public static Set<CtField<?>> getCandidateFields(
            CtBlock<?> block) {
        TypesGraph typesGraph = SpoonManager.getTypesGraph();
        CtTypeReference<?> root = typesGraph.getRoot();

        List<CtField<?>> fields = typesGraph.getOutgoingUserDefinedFields(root);
        List<CtLocalVariable<?>> localVars = SpoonQueries.getDeclaredLocalVars(block);

        Set<CtField<?>> candidateFields = new HashSet<>();
        for (CtField<?> field : fields) {
            if (localVars.stream().noneMatch(var -> var.getAssignment() instanceof CtVariableRead varRead &&
                    varRead.getVariable().getSimpleName().equals(field.getSimpleName())))
                candidateFields.add(field);
        }
        return candidateFields;
    }

    public static List<CtVariableRead<?>> getCandidateVarReadsForNullCheck(CtBlock<?> block) {
        TypesGraph typesGraph = SpoonManager.getTypesGraph();

        List<CtVariable<?>> referenceFields = typesGraph.getOutgoingReferenceFields(typesGraph.getRoot());

        List<CtCodeElement> candidateFieldReads = ReferenceExpressionGenerator
                .generateAllVarReadsOfReferenceType(referenceFields);
        Set<String> candidateFieldStrings = new HashSet<>();
        for (CtCodeElement element : candidateFieldReads) {
            candidateFieldStrings.add(element.toString());
        }

        List<CtIf> ifStatements = block.getStatements().stream().filter(e -> e instanceof CtIf).map(e -> (CtIf) e)
                .toList();
        for (CtIf ifStatement : ifStatements) {
            if (ifStatement.getCondition() instanceof CtBinaryOperator<?> binaryOperator) {
                if (binaryOperator.getKind().equals(BinaryOperatorKind.EQ)) {
                    if (binaryOperator.getLeftHandOperand() instanceof CtVariableRead<?> varRead &&
                            binaryOperator.getRightHandOperand().toString().equals("null")) {
                        if (candidateFieldStrings.contains(varRead.toString())) {
                            candidateFieldReads.remove(varRead);
                        }
                    }
                }
            }
        }
        return candidateFieldReads.stream().map(e -> (CtVariableRead<?>) e).collect(Collectors.toList());
    }

    public static List<CtLocalVariable<?>> getWorklistDeclared(CtBlock<?> block) {
        Set<CtTypeReference<?>> cyclicNodes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();
        return block.getElements(var -> isWorklist(var, cyclicNodes));
    }

    public static boolean isWorklist(CtLocalVariable<?> var, Set<CtTypeReference<?>> cyclicNodes) {
        return var.getType().isSubtypeOf(SpoonFactory.getTypeFactory().createReference(List.class)) &&
                cyclicNodes.contains(var.getType().getActualTypeArguments().get(0));
    }

    public static List<CtLocalVariable<?>> getVisitedSetDeclared(CtBlock<?> block) {
        Set<CtTypeReference<?>> cyclicNodes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();
        return block.getElements(var -> isVisitedSet(var, cyclicNodes));
    }

    public static boolean isVisitedSet(CtLocalVariable<?> var, Set<CtTypeReference<?>> cyclicNodes) {
        return var.getType().isSubtypeOf(SpoonFactory.getTypeFactory().createReference(Set.class)) &&
                var.getSimpleName().startsWith(LocalVarHelper.SET_VAR_NAME) &&
                cyclicNodes.contains(var.getType().getActualTypeArguments().get(0));
    }

    public static List<CtField<?>> filterFieldsByType(List<CtField<?>> candidateFields,
            CtTypeReference<?> ctTypeReference) {
        return candidateFields.stream().filter(field -> field.getType().isSubtypeOf(ctTypeReference)).toList();
    }

    public static boolean isNullCheck(CtStatement statement) {
        if (!(statement instanceof CtIf ifStatement))
            return false;
        if (!(ifStatement.getCondition() instanceof CtBinaryOperator<?> binaryOperator))
            return false;
        if (!binaryOperator.getKind().equals(BinaryOperatorKind.EQ))
            return false;
        if (!(binaryOperator.getLeftHandOperand() instanceof CtVariableRead<?> varRead))
            return false;
        return binaryOperator.getRightHandOperand().toString().equals("null");
    }

    public static CtBlock<?> getBlockOfHandleCurrent(CtBlock<?> block) {
        List<CtStatement> statements = block.getStatements();
        int i = 0;
        while (!isHandleCurrentComment(statements.get(i))) {
            i++;
        }
        assert i < statements.size();
        CtBlock<?> handleBlock = SpoonFactory.createBlock();
        i++;
        while (i < statements.size() && !isEndOfHandleCurrent(statements.get(i))) {
            handleBlock.addStatement(statements.get(i).clone());
            i++;
        }
        return handleBlock;
    }

    public static boolean isHandleCurrentComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Handle current:");
    }

    public static boolean isEndOfHandleCurrent(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        // System.out.println("The content of the comment is:" + comment.getContent());
        return comment.getContent().equals("End of Handle current:");
    }

    public static CtBlock<?> generateMutatedBody(CtBlock<?> loopBody, CtBlock<?> newBlock) {
        CtBlock<?> newBody = SpoonFactory.createBlock();
        int i = 0;
        while (!isHandleCurrentComment(loopBody.getStatement(i))) {
            newBody.addStatement(loopBody.getStatement(i).clone());
            i++;
        }
        newBody.addStatement(loopBody.getStatement(i).clone());

        for (CtStatement statement : newBlock.getStatements()) {
            newBody.addStatement(statement.clone());
        }

        while (!isEndOfHandleCurrent(loopBody.getStatement(i))) {
            i++;
        }

        for (int j = i; j < loopBody.getStatements().size(); j++) {
            newBody.addStatement(loopBody.getStatement(j).clone());
        }

        return newBody;
    }

    public static CtStatement getEndHandleCurrentComment(CtBlock<?> block) {
        return (CtStatement) block.getElements(e -> e instanceof CtComment).stream()
                .filter(SpoonQueries::isEndOfHandleCurrent).findAny().orElse(null);
    }

    public static List<CtVariableRead<?>> getNonTraversedCyclicFieldReads(CtBlock<?> code) {
        List<CtVariableRead<?>> nonTraversedCyclicVarReads = new LinkedList<>();

        TypesGraph typesGraph = SpoonManager.getTypesGraph();
        Set<CtVariableRead<?>> cyclicVarReads = typesGraph.getReacheableCyclicFieldReads();

        List<CtLocalVariable<?>> currentVars = getLocalVariablesMathingPrefix(code, LocalVarHelper.CURRENT_VAR_NAME);
        for (CtVariableRead<?> varRead : cyclicVarReads) {
            if (currentVars.stream().noneMatch(var -> var.getAssignment().equals(varRead)))
                nonTraversedCyclicVarReads.add(varRead);
        }

        return nonTraversedCyclicVarReads;
    }

    public static List<CtLocalVariable<?>> getLocalVariablesMathingPrefix(CtBlock<?> code, String varPrefix) {
        return code.getElements(var -> var.getSimpleName().startsWith(varPrefix));
    }

    public static List<CtVariable<?>> getLocalVariablesFromElement(CtElement element) {
        return element.getElements(e -> e instanceof CtLocalVariable);
    }

    public static Set<CtLocalVariable<?>> getCurrentVarsChecked(CtBlock<?> code) {
        Set<CtLocalVariable<?>> currentVarsChecked = new HashSet<>();

        List<CtIf> ifStatements = code.getElements(SpoonQueries::isVisitedCurrentVarCheck);
        for (CtIf ifStatement : ifStatements) {
            CtUnaryOperator<?> operator = (CtUnaryOperator<?>) ifStatement.getCondition();
            CtInvocation<?> invocation = (CtInvocation<?>) operator.getOperand();
            CtVariableRead<?> currentRead = (CtVariableRead<?>) invocation.getArguments().get(0);
            currentVarsChecked.add((CtLocalVariable<?>) currentRead.getVariable().getDeclaration());

        }
        return currentVarsChecked;
    }

    public static boolean isVisitedCurrentVarCheck(CtStatement statement) {
        if (!(statement instanceof CtIf ifStatement))
            return false;
        if (!(ifStatement.getCondition() instanceof CtUnaryOperator<?> operator))
            return false;
        if (!operator.getKind().equals(UnaryOperatorKind.NOT))
            return false;
        if (!(operator.getOperand() instanceof CtInvocation<?> invocation))
            return false;
        if (!invocation.getExecutable().getSimpleName().equals("add"))
            return false;
        if (!(invocation.getArguments().get(0) instanceof CtVariableRead<?> currentRead))
            return false;
        if (!currentRead.getVariable().getSimpleName().startsWith(LocalVarHelper.CURRENT_VAR_NAME))
            return false;
        if (!(invocation.getTarget() instanceof CtVariableRead<?> varRead))
            return false;
        return varRead.getVariable().getSimpleName().startsWith(LocalVarHelper.SET_VAR_NAME);
    }

    public static boolean isTraversalLoop(CtElement element) {
        if (!(element instanceof CtWhile loop))
            return false;
        return isCyclicReferenceTraversal(loop) || isWorklistTraversal(loop);
    }

    public static boolean isCyclicReferenceTraversal(CtWhile loop) {
        String condition = loop.getLoopingExpression().toString();
        return condition.startsWith(LocalVarHelper.CURRENT_VAR_NAME) && condition.endsWith("!= null");
    }

    public static boolean isWorklistTraversal(CtWhile loop) {
        String condition = loop.getLoopingExpression().toString();
        return condition.startsWith("!" + LocalVarHelper.WORKLIST_VAR_NAME) && condition.endsWith(".isEmpty()");
    }

    public static CtLocalVariable<?> getCurrentVarDeclaration(CtWhile loop) {
        CtBlock<?> whileBody = (CtBlock<?>) loop.getBody();
        CtAssignment<?, ?> assignment = null;
        if (isCyclicReferenceTraversal(loop)) {
            assignment = whileBody.getLastStatement();
        } else if (isWorklistTraversal(loop)) {
            assignment = whileBody.getStatement(0);
        }
        CtVariableWrite<?> varWrite = (CtVariableWrite<?>) assignment.getAssigned();
        return (CtLocalVariable<?>) varWrite.getVariable().getDeclaration();
    }

}
