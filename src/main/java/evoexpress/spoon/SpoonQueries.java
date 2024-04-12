package evoexpress.spoon;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.typegraph.TypeGraph;
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

    public static List<CtVariable<?>> getVariablesOfType(List<CtVariable<?>> list, Class<?> type) {
        return getVariablesOfType(list, SpoonFactory.getTypeFactory().createReference(type));
    }

    public static List<CtVariable<?>> getAllReachableVariablesFromMethod(CtMethod method) {
        return getAllReachableVariables(method.getBody().getLastStatement());
    }

    public static List<CtVariable<?>> getAllReachableVariables(CtElement statement) {
        return statement.map(new PotentialVariableDeclarationFunction()).list();
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

    public static boolean isUserDefined(CtTypeReference<?> var) {
        return var.getDeclaration() != null;
    }

    public static boolean containsReturnStatement(CtBlock<?> block) {
        return !block.getElements(e -> e instanceof CtReturn).isEmpty();
    }


    public static List<List<CtVariable<?>>> getAllReferencePaths(CtTypeReference<?> sourceNode, int depth) {
        TypeGraph typesGraph = TypeGraph.getInstance();
        List<List<CtVariable<?>>> paths = typesGraph.getAllPaths(sourceNode, depth);
        List<List<CtVariable<?>>> referencePaths = new ArrayList<>();

        for (List<CtVariable<?>> path : paths) {
            if (!path.get(path.size() - 1).getType().isPrimitive())
                referencePaths.add(path);
        }

        if (referencePaths.isEmpty())
            throw new RuntimeException("No reference paths found.");

        return referencePaths;
    }

    public static boolean isHandleCurrentComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Handle current:");
    }

    public static boolean isEndOfHandleCurrentComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        // System.out.println("The content of the comment is:" + comment.getContent());
        return comment.getContent().equals("End of Handle current:");
    }

    public static boolean isEndOfInitialChecksComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("End of Initial Checks");
    }

    public static boolean isSizeCheckComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Size check:");
    }

    public static boolean isBeginOfTraversalComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Begin of traversal");
    }

    public static boolean isEndOfTraversalComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("End of traversal");
    }

    public static boolean isReturnTrueComment(CtElement element) {
        if (!(element instanceof CtComment comment))
            return false;
        return comment.getContent().equals("Return true");
    }

    public static CtStatement getEndHandleCurrentComment(CtBlock<?> block) {
        List<CtElement> handleCurrentEndComments = block.getElements(e -> e instanceof CtComment).stream().filter(SpoonQueries::isEndOfHandleCurrentComment).toList();
        if (handleCurrentEndComments.isEmpty())
            return null;
        return (CtStatement) handleCurrentEndComments.get(RandomUtils.nextInt(handleCurrentEndComments.size()));
    }

    public static CtStatement getReturnTrueComment(CtBlock<?> block) {
        List<CtElement> returnTrueComments = block.getElements(e -> e instanceof CtComment).stream().filter(SpoonQueries::isReturnTrueComment).toList();
        if (returnTrueComments.isEmpty())
            return null;
        return (CtStatement) returnTrueComments.get(RandomUtils.nextInt(returnTrueComments.size()));
    }

    public static List<List<CtVariable<?>>> getNonUsedInitialPathsToCyclicField(CtBlock<?> code) {
        List<List<CtVariable<?>>> nonUsedInitialPathsToCyclicField = new LinkedList<>();

        TypeGraph typeGraph = TypeGraph.getInstance();
        List<List<CtVariable<?>>> pathsToCyclicFields = typeGraph.getPathsToCyclicFields();

        List<CtLocalVariable<?>> currentVars = getLocalVariablesMathingPrefix(code, LocalVarHelper.CURRENT_VAR_NAME);
        for (List<CtVariable<?>> path : pathsToCyclicFields) {
            CtVariableRead<?> varRead = SpoonFactory.createFieldReadOfRootObject(path);
            if (currentVars.stream().noneMatch(var -> var.getAssignment().equals(varRead)))
                nonUsedInitialPathsToCyclicField.add(path);
        }

        return nonUsedInitialPathsToCyclicField;
    }

    public static List<CtVariable<?>> getIntegerFieldsOfRoot() {
        TypeGraph typeGraph = TypeGraph.getInstance();
        List<CtVariable<?>> rootFields = typeGraph.getOutgoingFields(typeGraph.getRoot());
        return rootFields.stream().filter(
                field -> field.getType().isSubtypeOf(SpoonFactory.getTypeFactory().INTEGER) ||
                        field.getType().isSubtypeOf(SpoonFactory.getTypeFactory().INTEGER_PRIMITIVE)
        ).toList();
    }

    public static List<CtLocalVariable<?>> getLocalVariablesMathingPrefix(CtBlock<?> code, String varPrefix) {
        return code.getElements(var -> var.getSimpleName().startsWith(varPrefix));
    }

    public static CtElement getElementMatchingPrefix(CtElement code, String prefix) {
        return code.getElements(elem -> prefixMatch(elem, prefix)).get(0);
    }

    public static boolean prefixMatch(CtElement elem, String prefix) {
        if (elem instanceof CtLocalVariable<?> var)
            return var.getSimpleName().startsWith(prefix);
        if (elem instanceof CtVariableAccess<?> varAccess)
            return varAccess.getVariable().getSimpleName().startsWith(prefix);
        return false;
    }

    public static List<CtLocalVariable<?>> getLocalVariablesMathingPrefix(List<CtStatement> statements, String varPrefix) {
        List<CtLocalVariable<?>> setVars = new ArrayList<>();
        for (CtStatement statement : statements) {
            if (statement instanceof CtLocalVariable<?> var && var.getSimpleName().startsWith(varPrefix))
                setVars.add(var);
        }
        return setVars;
    }

    public static List<CtVariable<?>> getLocalVariablesFromElement(CtElement element) {
        return element.getElements(e -> e instanceof CtLocalVariable);
    }

    public static boolean isTraversalLoop(CtElement element) {
        if (!(element instanceof CtWhile loop))
            return false;
        String condition = loop.getLoopingExpression().toString();
        return condition.contains(LocalVarHelper.CURRENT_VAR_NAME);
    }

    public static CtLocalVariable<?> getLocalVarMatchingPrefix(CtElement element, String prefix) {
        CtElement matchingElement = getElementMatchingPrefix(element, prefix);
        if (matchingElement instanceof CtLocalVariable<?> var)
            return var;
        if (matchingElement instanceof CtVariableAccess<?> varWrite)
            return (CtLocalVariable<?>) varWrite.getVariable().getDeclaration();
        return null;
    }

    public static List<CtLocalVariable<?>> getVisitedSetLocalVars(CtBlock<?> block) {
        return getLocalVariablesMathingPrefix(block, LocalVarHelper.SET_VAR_NAME);
    }

    public static List<CtLocalVariable<?>> getVisitedSetLocalVarsOfType(CtBlock<?> block, CtTypeReference<?> type) {
        return getLocalVariablesMathingPrefix(block, LocalVarHelper.SET_VAR_NAME).stream().filter(
                var -> var.getType().getActualTypeArguments().get(0).isSubtypeOf(type)).toList();
    }

    public static boolean containsSizeCheck(CtBlock<?> block) {
        return !block.getElements(SpoonQueries::isSizeCheckComment).isEmpty();
    }

    public static List<List<CtVariable<?>>> chooseNVariablePaths(List<List<CtVariable<?>>> varPaths, int n) {
        List<List<CtVariable<?>>> chosenPaths = new ArrayList<>();
        List<Integer> indices = generateRandomIntegers(varPaths.size() - 1, n);
        for (int index : indices) {
            chosenPaths.add(varPaths.get(index));
        }
        return chosenPaths;
    }

    public static List<Integer> generateRandomIntegers(int max, int n) {
        if (n > max + 1) {
            throw new IllegalArgumentException("Cannot generate more distinct integers than the range allows.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, n);
    }

    public static CtComment getEndOfInitialChecksComment(CtBlock<?> block) {
        List<CtComment> comments = block.getElements(SpoonQueries::isEndOfInitialChecksComment);
        return comments.get(0);
    }

    public static CtComment getEndOfHandleCurrentComment(CtBlock<?> block) {
        List<CtComment> comments = block.getElements(SpoonQueries::isEndOfHandleCurrentComment);
        return comments.get(0);
    }

    public static CtComment getEndOfTraversalComment(List<CtStatement> statements) {
        for (CtStatement statement : statements) {
            if (isEndOfTraversalComment(statement))
                return (CtComment) statement;
        }
        return null;
    }

    public static boolean checkAlreadyExist(CtElement condition, CtBlock<?> block) {
        List<CtIf> ifs = block.getElements(Objects::nonNull);
        for (CtIf ifStatement : ifs) {
            if (ifStatement.getCondition().toString().equals(condition.toString())) {
                return true;
            } else if (condition instanceof CtBinaryOperator<?> binaryOperator) {
                if (ifStatement.getCondition() instanceof CtBinaryOperator<?> ifBinaryOperator) {
                    if (areBinaryOperationsEqual(binaryOperator, ifBinaryOperator))
                        return true;
                }
            }

        }
        return false;
    }

    public static boolean areBinaryOperationsEqual(CtBinaryOperator<?> condition1, CtBinaryOperator<?> condition2) {
        if (!condition1.getKind().equals(condition2.getKind()))
            return false;
        CtExpression<?> leftOperand1 = condition1.getLeftHandOperand();
        CtExpression<?> rightOperand1 = condition1.getRightHandOperand();
        CtExpression<?> leftOperand2 = condition2.getLeftHandOperand();
        CtExpression<?> rightOperand2 = condition2.getRightHandOperand();
        if (!leftOperand1.toString().equals(leftOperand2.toString()) && !leftOperand1.toString().equals(rightOperand2.toString()))
            return false;
        if (!rightOperand1.toString().equals(leftOperand2.toString()) && !rightOperand1.toString().equals(rightOperand2.toString()))
            return false;
        return true;
    }


}