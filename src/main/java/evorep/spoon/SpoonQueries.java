package evorep.spoon;

import evorep.ga.helper.LocalVarHelper;
import evorep.typegraph.TypeGraph;
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

    public static Set<CtTypeReference<?>> getCandidateCyclicTypes(
            CtBlock<?> block,
            String varNamePrefix) {
        Set<CtTypeReference<?>> selfCyclicTypes = TypeGraph.getInstance().getNodesWithSelfCycles();
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

    public static Set<CtVariable<?>> getCandidateFields(
            CtBlock<?> block) {
        TypeGraph typesGraph = TypeGraph.getInstance();
        CtTypeReference<?> root = typesGraph.getRoot();

        List<CtVariable<?>> fields = typesGraph.getOutgoingUserDefinedFields(root);
        List<CtLocalVariable<?>> localVars = SpoonQueries.getDeclaredLocalVars(block);

        Set<CtVariable<?>> candidateFields = new HashSet<>();
        for (CtVariable<?> field : fields) {
            if (localVars.stream().noneMatch(var -> var.getAssignment() instanceof CtVariableRead varRead &&
                    varRead.getVariable().getSimpleName().equals(field.getSimpleName())))
                candidateFields.add(field);
        }
        return candidateFields;
    }

/*    public static List<CtVariableRead<?>> getCandidateVarReadsForNullCheck(CtBlock<?> block) {
        TypeGraph typesGraph = TypeGraph.getInstance();
        List<CtVariable<?>> referenceFields = typesGraph.getOutgoingReferenceFields(typesGraph.getRoot());
        List<CtVariableRead<?>> varReads = new ArrayList<>();
        for (CtVariable<?> field : referenceFields) {
            CtVariableRead<?> varRead = SpoonFactory.createVariableRead(field);
            varReads.add(varRead);
            for (CtVariable<?> subField : typesGraph.getOutgoingReferenceFields(field.getType())) {
                varReads.add(SpoonFactory.createFieldRead(varRead, subField));
            }
        }

        return varReads;
    }*/

    public static List<List<CtVariable<?>>> getCandidateVarReadsForNullCheck(int depth) {
        TypeGraph typesGraph = TypeGraph.getInstance();
        List<List<CtVariable<?>>> paths = typesGraph.getAllPaths(typesGraph.getRoot(), depth);
        List<List<CtVariable<?>>> referencePaths = new ArrayList<>();

        for (List<CtVariable<?>> path : paths) {
            if (!path.get(path.size() - 1).getType().isPrimitive())
                referencePaths.add(path);
        }

        if (referencePaths.isEmpty())
            throw new RuntimeException("No reference paths found.");

        return referencePaths;
    }

    public static List<CtStatement> getInitialCheckStatements(CtBlock<?> block) {
        List<CtStatement> statements = new ArrayList<>();
        for (CtStatement statement : block.getStatements()) {
            if (isEndOfInitialChecksComment(statement))
                return statements;
            statements.add(statement);
        }
        return statements;
    }

    public static List<CtIf> getInitialSingleNullChecks(CtBlock<?> block) {
        List<CtStatement> statements = getInitialCheckStatements(block);
        return statements.stream().filter(SpoonQueries::isNullCheck).map(e -> (CtIf) e).toList();
    }

    public static boolean isNullComparison(CtExpression<?> expr) {
        if (!(expr instanceof CtBinaryOperator<?> binaryOperator))
            return false;
        if (!(binaryOperator.getKind().equals(BinaryOperatorKind.EQ) || binaryOperator.getKind().equals(BinaryOperatorKind.NE)))
            return false;
        if (!(binaryOperator.getLeftHandOperand() instanceof CtVariableRead<?> varRead))
            return false;
        return binaryOperator.getRightHandOperand().toString().equals("null");
    }

    public static List<CtLocalVariable<?>> getWorklistDeclared(CtBlock<?> block) {
        Set<CtTypeReference<?>> cyclicNodes = TypeGraph.getInstance().getNodesWithSelfCycles();
        return block.getElements(var -> isWorklist(var, cyclicNodes));
    }

    public static boolean isWorklist(CtLocalVariable<?> var, Set<CtTypeReference<?>> cyclicNodes) {
        return var.getType().isSubtypeOf(SpoonFactory.getTypeFactory().createReference(List.class)) &&
                cyclicNodes.contains(var.getType().getActualTypeArguments().get(0));
    }

    public static List<CtLocalVariable<?>> getVisitedSetDeclared(CtBlock<?> block) {
        Set<CtTypeReference<?>> cyclicNodes = TypeGraph.getInstance().getNodesWithSelfCycles();
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
        return isNullComparison(ifStatement.getCondition());
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
        while (i < statements.size() && !isEndOfHandleCurrentComment(statements.get(i))) {
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

        while (!isEndOfHandleCurrentComment(loopBody.getStatement(i))) {
            i++;
        }

        for (int j = i; j < loopBody.getStatements().size(); j++) {
            newBody.addStatement(loopBody.getStatement(j).clone());
        }

        return newBody;
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

    public static List<List<CtStatement>> getTraversalBlocks(CtBlock<?> block) {
        //System.out.println("\nThe block is:\n" + block.toString());
        List<List<CtStatement>> traversalBlocks = new ArrayList<>();
        List<CtStatement> currentTraversal = null;
        for (CtStatement statement : block.getStatements()) {
            //System.out.println("\nCurrent Statement: " + statement.toString());
            if (currentTraversal != null) {
                //System.out.println("Adding statement to current traversal.");
                currentTraversal.add(statement);
            }
            if (isBeginOfTraversalComment(statement)) {
                //System.out.println("Begin of traversal comment found.");
                currentTraversal = new ArrayList<>();
                currentTraversal.add(statement);
                traversalBlocks.add(currentTraversal);
            }
            if (isEndOfTraversalComment(statement)) {
                //System.out.println("End of traversal comment found.");
                currentTraversal = null;
            }
        }

        // Print each Statement List
/*        if (traversalBlocks.isEmpty())
            System.out.println("No traversal blocks found.");
        else
            System.out.println("Traversal blocks found.");
        for (List<CtStatement> traversalBlock : traversalBlocks) {
            System.out.println("\nTraversal Block:");
            for (CtStatement statement : traversalBlock) {
                System.out.println(statement.toString());
            }
        }*/
        return traversalBlocks;
    }

    public static CtLocalVariable<?> getVisitedSet(List<CtStatement> statements) {
        List<CtLocalVariable<?>> visitedSets = getLocalVariablesMathingPrefix(statements, LocalVarHelper.SET_VAR_NAME);
        if (visitedSets.isEmpty())
            return null;
        return visitedSets.get(0);
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
