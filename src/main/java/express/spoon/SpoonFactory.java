package express.spoon;

import express.config.Config;
import express.classinvariant.mutator.LocalVarHelper;
import express.type.typegraph.Path;
import express.type.typegraph.TypeData;
import org.apache.commons.lang3.ClassUtils;
import spoon.Launcher;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.factory.CodeFactory;
import spoon.reflect.factory.CoreFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.TypeFactory;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SpoonFactory {

    private static Launcher launcher;
    private static Factory factory;
    private static CodeFactory codeFactory;
    private static CoreFactory coreFactory;
    private static TypeFactory typeFactory;

    public static void initialize(Launcher spoonLauncher) {
        launcher = spoonLauncher;
        factory = launcher.getFactory();
        codeFactory = launcher.getFactory().Code();
        coreFactory = launcher.getFactory().Core();
        typeFactory = launcher.getFactory().Type();
    }

    // ==================== Getters ====================

    public static Launcher getLauncher() {
        return launcher;
    }

    public static Factory getFactory() {
        return factory;
    }

    public static CodeFactory getCodeFactory() {
        return codeFactory;
    }

    public static CoreFactory getCoreFactory() {
        return coreFactory;
    }

    public static TypeFactory getTypeFactory() {
        return typeFactory;
    }


    public static CtExpression<?>[] createArgumentsFromParameters(CtMethod<?> method) {
        List<CtParameter<?>> parameters = method.getParameters();
        CtExpression<?>[] args = new CtExpression<?>[parameters.size()];
        for (int i = 0; i < args.length; i++) {
            args[i] = createVariableRead(parameters.get(i));
        }
        return args;
    }

    public static CtExpression<?>[] createArgumentsFromParameters(List<CtParameter<?>> parameters) {
        CtExpression<?>[] args = new CtExpression<?>[parameters.size()];
        for (int i = 0; i < args.length; i++) {
            args[i] = createVariableRead(parameters.get(i));
        }
        return args;
    }

    public static CtBlock<?> createReturnTrueBlock() {
        CtBlock<Boolean> block = coreFactory.createBlock();
        block.addStatement(createComment("Mark1"));
        block.addStatement(createComment("Return true"));
        block.addStatement(createReturnStatement(codeFactory.createLiteral(true)));
        return block;
    }

    public static CtReturn<Boolean> createReturnTrueStatement() {
        return createReturnStatement(codeFactory.createLiteral(true));
    }

    public static CtMethod<Boolean> createMethod(
            Set<ModifierKind> modifiers,
            CtTypeReference<?> returnType,
            String name, List<CtParameter<?>> parameters
    ) {
        CtMethod<Boolean> newMethod = coreFactory.createMethod();
        newMethod.setModifiers(modifiers);
        newMethod.setType(returnType);
        newMethod.setSimpleName(name);
        newMethod.setParameters(parameters);
        return newMethod;
    }

    public static CtReturn createReturnStatement(CtExpression returnExpression) {
        return coreFactory.createReturn().setReturnedExpression(returnExpression);
    }

    public static CtBlock<?> createBlock() {
        return coreFactory.createBlock();
    }

    public static CtTypeReference<?> createReference(Class<?> type) {
        return typeFactory.createReference(type);
    }

    public static CtIf createIfThenElseStatement(CtExpression<Boolean> condition, CtStatement thenStatement,
                                                 CtStatement elseStatement) {
        if (!(thenStatement instanceof CtBlock<?>))
            thenStatement = encapsulateStatement(thenStatement);
        if (!(elseStatement instanceof CtBlock<?>))
            elseStatement = encapsulateStatement(elseStatement);
        CtIf ifStatement = coreFactory.createIf();
        ifStatement.setCondition(condition);
        ifStatement.setThenStatement(thenStatement);
        ifStatement.setElseStatement(elseStatement);
        return ifStatement;
    }

    public static CtBlock<?> encapsulateStatement(CtStatement statement) {
        CtBlock<?> block = coreFactory.createBlock();
        block.addStatement(statement);
        return block;
    }

    public static CtWhile createWhileStatement(CtExpression<Boolean> condition, CtStatement body) {
        if (!(body instanceof CtBlock<?>))
            body = encapsulateStatement(body);
        CtWhile whileStatement = coreFactory.createWhile();
        whileStatement.setLoopingExpression(condition);
        whileStatement.setBody(body);
        return whileStatement;
    }

    public static CtWhile createWhileStatement(CtExpression<Boolean> condition) {
        CtBlock<?> emptyBlock = coreFactory.createBlock();
        CtWhile whileStatement = coreFactory.createWhile();
        whileStatement.setLoopingExpression(condition);
        whileStatement.setBody(emptyBlock);
        return whileStatement;
    }

    public static CtBlock<?> createStatementBlock(List<CtStatement> statements) {
        CtBlock<?> block = coreFactory.createBlock();
        for (CtStatement statement : statements)
            block.addStatement(statement.clone());
        return block;
    }

    public static CtVariableRead<?> createFieldRead(List<CtVariable<?>> path) {
        if (path.isEmpty())
            throw new IllegalArgumentException("Path must not be empty");
        CtVariableRead<?> fieldRead = createFieldRead(path.get(0));
        for (int i = 1; i < path.size(); i++)
            fieldRead = createFieldRead(fieldRead, path.get(i));
        return fieldRead;
    }

    public static CtVariableRead<?> createFieldRead(CtVariable<?> variable) {
        return createVariableRead(variable);
    }

    public static CtFieldRead<?> createFieldRead(CtExpression<?> variable, CtVariable<?> field) {
        CtFieldRead fieldRead = coreFactory.createFieldRead();
        fieldRead.setTarget(variable);
        fieldRead.setVariable(field.getReference());
        return fieldRead;
    }

    public static CtVariableRead<?> createVariableRead(CtVariable variable) {
        CtVariableRead<?> variableRead = coreFactory.createVariableRead();
        variableRead.setVariable(variable.getReference());
        return variableRead;
    }

    public static CtTypeReference<?> createTypeReference(Class<?> type) {
        return typeFactory.createReference(type);
    }

    public static CtTypeReference<?> createTypeWithSubtypeReference(Class<?> type, Class<?> subtype) {
        CtTypeReference<?> resultType = typeFactory.createReference(type);
        resultType.addActualTypeArgument(typeFactory.createReference(subtype));
        return resultType;
    }

    public static CtInvocation<?> createStaticInvocation(CtTypeReference<?> targetClassRef, String methodName, CtExpression<?>[] args) {
        CtMethod<?> staticMethod = targetClassRef.getTypeDeclaration().getMethodsByName(methodName).get(0);
        CtExecutableReference<?> staticMethodRef = factory.Executable().createReference(staticMethod);
        return factory.Code().createInvocation(null, staticMethodRef, args);
    }

    public static CtInvocation<?> createStaticInvocation(CtClass<?> targetClass, String methodName, CtExpression<?>[] args) {
        CtMethod<?> staticMethod = targetClass.getMethodsByName(methodName).get(0);
        CtExecutableReference<?> staticMethodRef = factory.Executable().createReference(staticMethod);
        return factory.Code().createInvocation(null, staticMethodRef, args);
    }

    public static CtInvocation<?> createStaticInvocation(CtMethod<?> staticMethod, CtExpression<?>[] args) {
        CtExecutableReference<?> staticMethodRef = factory.Executable().createReference(staticMethod);
        return factory.Code().createInvocation(null, staticMethodRef, args);
    }

    public static CtInvocation createInvocation(CtVariable<?> target, String methodName) {
        return createInvocation(target, methodName, new LinkedList<>(), new LinkedList<>());
    }

    public static CtInvocation createInvocation(CtVariable<?> target, String methodName,
                                                List<CtTypeReference<?>> argsTypes,
                                                List<Object> args) {

        CtExecutableReference<?> method = createExecutableReference(target.getType(), methodName, argsTypes);
        List<CtExpression<?>> callArguments = new LinkedList<>();
        for (Object arg : args)
            callArguments.add(parseToExpression(arg));
        return createMethodCall(target, method, callArguments);
    }

    public static CtExecutableReference createExecutableReference(CtTypeReference<?> targetType, String methodName,
                                                                  List<CtTypeReference<?>> argsTypes) {
        CtExecutableReference method = coreFactory.createExecutableReference();
        method.setDeclaringType(targetType);
        method.setSimpleName(methodName);
        if (!argsTypes.isEmpty())
            method.setParameters(argsTypes);
        return method;
    }

    public static CtExpression<?> parseToExpression(Object o) {
        CtExpression<?> expr;
        if (o == null || ClassUtils.isPrimitiveOrWrapper(o.getClass())) {
            expr = codeFactory.createLiteral(o);
        } else if (o instanceof CtVariable) {
            expr = createVariableRead((CtVariable<?>) o);
        } else if (o instanceof CtExpression) {
            expr = (CtExpression<?>) o;
        } else {
            throw new IllegalArgumentException("varLeft must be a CtVariable or a CtExpression");
        }
        return expr;
    }

    public static CtInvocation createMethodCall(CtVariable<?> target, CtExecutableReference<?> method,
                                                List<CtExpression<?>> args) {
        CtInvocation invocation = coreFactory.createInvocation();
        invocation.setTarget(createVariableRead(target));
        invocation.setExecutable(method);
        if (!args.isEmpty())
            invocation.setArguments(args);
        return invocation;
    }

    public static CtExpression<?> createUnaryExpression(Object operand, UnaryOperatorKind operator) {
        return createUnaryExpression(parseToExpression(operand), operator);
    }

    public static CtExpression<?> createUnaryExpression(CtExpression<?> operand, UnaryOperatorKind operator) {
        CtUnaryOperator<Object> expression = coreFactory.createUnaryOperator();
        expression.setOperand(operand);
        expression.setKind(operator);
        return expression;
    }

    public static CtExpression<?> createBinaryExpression(
            Object varLeft,
            Object varRight,
            BinaryOperatorKind op) {
        CtExpression<?> left = parseToExpression(varLeft);
        CtExpression<?> right = parseToExpression(varRight);

        return createBinaryExpression(left, right, op);
    }

    private static CtExpression<?> createBinaryExpression(CtExpression<?> left, CtExpression<?> right,
                                                          BinaryOperatorKind op) {
        CtBinaryOperator<?> expression = coreFactory.createBinaryOperator();
        expression.setLeftHandOperand(left);
        expression.setRightHandOperand(right);
        expression.setKind(op);
        return expression;
    }

    public static CtAssignment createAssignment(CtVariable<?> assigned, Object assignment) {
        CtAssignment ctAssignment = coreFactory.createAssignment();
        ctAssignment.setAssigned(createVariableWrite(assigned));
        ctAssignment.setAssignment(parseToExpression(assignment));
        return ctAssignment;
    }

    public static CtVariableWrite createVariableWrite(CtVariable<?> variable) {
        CtVariableWrite variableWrite = coreFactory.createVariableWrite();
        variableWrite.setVariable(variable.getReference());
        return variableWrite;
    }

    public static CtLocalVariable<?> createVisitedSetDeclaration(CtTypeReference<?> subType) {
        CtTypeReference<?> setType = createTypeWithSubtypeReference(Set.class, subType);
        CtTypeReference<?> hashSetType =  typeFactory.createReference(HashSet.class);
        CtConstructorCall<?> hashSetConstructorCall = createConstructorCall(hashSetType);
        String varName = LocalVarHelper.SET_VAR_NAME ;
        if (subType.isArray()) {
            varName = varName + LocalVarHelper.ARRAY_VAR_PREFIX + ((CtArrayTypeReference<?>)subType).getComponentType().getSimpleName();
        } else {
            varName = varName + subType.getSimpleName();
        }
        return createLocalVariable(varName, setType, hashSetConstructorCall);
    }

    public static CtConstructorCall<?> createConstructorCall(CtTypeReference<?> typeRef) {
        List<CtTypeReference<?>> actualTypeArguments = new ArrayList<>();
        actualTypeArguments.add(factory.createTypeParameterReference(""));
        typeRef.setActualTypeArguments(actualTypeArguments);

        CtConstructorCall<?> constructorCall = factory.Core().createConstructorCall();
        constructorCall.setType(typeRef);
        return constructorCall;
    }

    public static CtTypeReference<?> createTypeWithSubtypeReference(Class<?> type, CtTypeReference<?> subtype) {
        CtTypeReference<?> resultType = typeFactory.createReference(type);
        resultType.addActualTypeArgument(subtype);
        return resultType;
    }

//    public static CtTypeReference<?> createTypeWithSubtypeReference(Class<?> type, CtTypeReference<?> subtype) {
//        CtTypeReference<?> resultType = typeFactory.createReference(type);
//        if (!subtype.isGenerics()) {
//            resultType.addActualTypeArgument(subtype);
//            return resultType;
//        }
//
//        if (!subtype.isParameterized()) {
//            resultType.addActualTypeArgument(coreFactory.createWildcardReference());
//            return resultType;
//        }
//
//        int numberOfArgs = subtype.getActualTypeArguments().size();
//        List<CtTypeReference<?>> wildcardTypeArgs = new ArrayList<>();
//        for (int i = 0; i < numberOfArgs; i++) {
//            wildcardTypeArgs.add(coreFactory.createWildcardReference());
//        }
//
//        subtype.setActualTypeArguments(wildcardTypeArgs);
//        resultType.addActualTypeArgument(subtype);
//        return resultType;
//    }

    public static CtLocalVariable<?> createLocalVariable(String varName, CtTypeReference<?> type,
                                                         Object assignment) {
        CtLocalVariable localVariable = coreFactory.createLocalVariable();

        localVariable.setSimpleName(varName);
        localVariable.setType(type);
        localVariable.setAssignment(parseToExpression(assignment));
        return localVariable;
    }

    public static CtParameter<?> createParameter(CtTypeReference<?> typeRef, String name) {
        CtParameter<?> parameter = coreFactory.createParameter();
        parameter.setType(typeRef);
        parameter.setSimpleName(name);
        return parameter;
    }

    public static CtIf createVisitedCheck(CtVariable<?> setVariable, Object argument, boolean negate, boolean useBreak) {
        CtExpression<?> condition = SpoonFactory.createAddToSetInvocation(setVariable, argument);
        if (negate)
            condition = SpoonFactory.createUnaryExpression(condition, UnaryOperatorKind.NOT);

        CtStatement thenBlock;
        if (useBreak)
            thenBlock = SpoonFactory.createBreakStatement();
        else
            thenBlock = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));

        return SpoonFactory.createIfThenStatement((CtExpression<Boolean>) condition, thenBlock);
    }

    public static CtExpression<Boolean> negateExpresion(CtExpression<Boolean> expression) {
        return (CtExpression<Boolean>) createUnaryExpression(expression, UnaryOperatorKind.NOT);
    }

    public static CtExpression<Boolean> createAddToSetInvocation(CtVariable<?> setVariable, Object argument) {
        CtTypeReference<?> elemType = setVariable.getReference().getType().getActualTypeArguments().get(0);
        return SpoonFactory.createInvocation(setVariable, "add", elemType, argument);
    }

    public static CtIf createVisitedSizeCheck(CtVariable<?> setVariable, CtExpression<?> integerField, int minus) {
        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(setVariable, "size");
        CtExpression<?> sizeMinus = sizeInvocation;
        if (minus > 0)
            sizeMinus = createBinaryExpression(sizeInvocation, minus, BinaryOperatorKind.MINUS);

        CtBinaryOperator<Boolean> condition = (CtBinaryOperator<Boolean>) SpoonFactory
                .createBinaryExpression(sizeMinus, integerField, BinaryOperatorKind.NE);
        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        return SpoonFactory.createIfThenStatement(condition, returnStatement);
    }

    public static CtInvocation createInvocation(CtVariable<?> target, String methodName,
                                                CtTypeReference<?> argsTypes,
                                                Object arg) {

        return createInvocation(target, methodName, Collections.singletonList(argsTypes),
                Collections.singletonList(arg));
    }

    public static CtExpression<?> createLiteral(Object value) {
        if (value == null)
            return codeFactory.createLiteral(null);
        if (!ClassUtils.isPrimitiveOrWrapper(value.getClass()))
            throw new IllegalArgumentException("Value must be a primitive or a wrapper");
        return codeFactory.createLiteral(value);
    }

    public static CtIf createIfThenStatement(CtExpression<Boolean> condition, CtStatement thenStatement) {
        if (!(thenStatement instanceof CtBlock<?>))
            thenStatement = encapsulateStatement(thenStatement);
        CtIf ifStatement = coreFactory.createIf();
        ifStatement.setCondition(condition);
        ifStatement.setThenStatement(thenStatement);
        return ifStatement;
    }

    public static CtLocalVariable<?> createWorkListDeclaration(CtTypeReference<?> subType, CtBlock<?> code) {
        CtTypeReference<?> listType = createTypeWithSubtypeReference(LinkedList.class, subType);
        CtTypeReference<?> linkedListType = createTypeWithSubtypeReference(LinkedList.class, subType);
        CtConstructorCall<?> linkedListConstructorCall = createConstructorCall(linkedListType);
        return createLocalVariable(LocalVarHelper.getWorklistVarName(code), listType, linkedListConstructorCall);
    }

    public static CtContinue createContinueStatement() {
        return coreFactory.createContinue();
    }

    public static CtBreak createBreakStatement() {
        return coreFactory.createBreak();
    }

    public static List<CtVariableAccess> createVariableWrites(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar) {
        return createVariableAccesses(
                var,
                typeRef,
                includeVar,
                SpoonFactory::createVariableWrite,
                SpoonFactory::createFieldWrite);
    }

    /**
     * Creates a list of variable accesses of the given type from the given
     * variable.
     *
     * @param var               the variable from which to consider possible reads.
     * @param typeRef           the type of the required variable read
     * @param createFieldAccess the function to create the variable access
     * @return a list of variable accesses of the given type
     */
    public static List<CtVariableAccess> createVariableAccesses(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar,
            Function<CtVariable<?>, CtVariableAccess> createVariableAccess,
            BiFunction<CtVariable<?>, CtVariable<?>, CtVariableAccess> createFieldAccess) {
        List<CtVariableAccess> varAccesses = new ArrayList<>();
        if (includeVar && var.getType().isSubtypeOf(typeRef))
            varAccesses.add(createVariableAccess.apply(var));

        varAccesses.addAll(SpoonQueries.getFieldsOfType(var, typeRef).stream().map(
                field -> createFieldAccess.apply(var, field)).toList());
        return varAccesses;
    }

    public static CtFieldWrite<?> createFieldWrite(CtVariable<?> variable, CtVariable<?> field) {
        return createFieldWrite(createVariableRead(variable), field);
    }

    public static CtFieldWrite<?> createFieldWrite(CtExpression<?> variable, CtVariable<?> field) {
        CtFieldWrite fieldWrite = coreFactory.createFieldWrite();
        fieldWrite.setTarget(variable);
        fieldWrite.setVariable(field.getReference());
        return fieldWrite;
    }

    public static List<CtVariableAccess> createVariableReads(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar) {
        return createVariableAccesses(
                var,
                typeRef,
                includeVar,
                SpoonFactory::createVariableRead,

                SpoonFactory::createFieldRead);
    }

    public static CtFieldRead<?> createFieldRead(CtVariable<?> variable, CtVariable<?> field) {
        return createFieldRead(createVariableRead(variable), field);
    }

    public static CtComment createComment(String content) {
        return coreFactory.createComment().setContent(content);
    }

    public static CtIf createIfReturnFalse(CtExpression<Boolean> condition) {
        return createIfThenStatement(condition, createReturnStatement(createLiteral(false)));
    }

    public static CtIf createIfReturnTrue(CtExpression<Boolean> condition) {
        return createIfThenStatement(condition, createReturnStatement(createLiteral(true)));
    }

    public static CtExpression<Boolean> generateAndConcatenationOfNullComparisons(Path path) {
        BinaryOperatorKind operator = RandomUtils.nextBoolean() ? BinaryOperatorKind.EQ : BinaryOperatorKind.NE;
        return generateAndConcatenationOfNullComparisons(path, operator);
    }


    public static CtExpression<Boolean> generateAndConcatenationOfNullComparisons(Path path, BinaryOperatorKind operator) {
        return conjunction(generateNullComparisonClauses(path, operator));
    }

    public static List<CtExpression<Boolean>> generateNullComparisonClauses(Path path) {
        return generateNullComparisonClauses(path, BinaryOperatorKind.NE);
    }

    public static List<CtExpression<Boolean>> generateNullComparisonClauses(Path path, BinaryOperatorKind operator) {
        List<CtExpression<Boolean>> clauses = new LinkedList<>();
        for (int end = 1; end < path.size(); end++) {
            CtVariableRead<?> varRead = path.subPath(end).getVariableRead();
            clauses.add(createNullComparisonClause(varRead, BinaryOperatorKind.NE));
        }
        clauses.add(createNullComparisonClause(path.getVariableRead(), operator));
        return clauses;
    }

    public static List<CtExpression<Boolean>> generateParentPathNullComparisonClauses(Path path) {
        List<CtExpression<Boolean>> clauses = new LinkedList<>();
        for (int end = 1; end < path.size(); end++) {
            CtVariableRead<?> varRead = path.subPath(end).getVariableRead();
            clauses.add(createNullComparisonClause(varRead, BinaryOperatorKind.NE));
        }
        return clauses;
    }

    public static CtExpression<Boolean> generateOrConcatenationOfNullComparisons(Path path) {
        List<CtExpression<Boolean>> clauses = new LinkedList<>();
        for (int end = 1; end < path.size(); end++) {
            CtVariableRead<?> varRead = path.subPath(end).getVariableRead();
            clauses.add(createNullComparisonClause(varRead, BinaryOperatorKind.EQ));
        }
        clauses.add(createNullComparisonClause(path.getVariableRead(), BinaryOperatorKind.EQ));
        return disjunction(clauses);
    }

    private static CtExpression<Boolean> disjunction(List<CtExpression<Boolean>> clauses) {
        if (clauses.isEmpty())
            throw new IllegalArgumentException("List of clauses must not be empty");
        if (clauses.size() == 1)
            return clauses.get(0);

        CtExpression<Boolean> result = clauses.get(0);
        for (int i = 1; i < clauses.size(); i++) {
            result = (CtExpression<Boolean>) createBinaryExpression(result, clauses.get(i), BinaryOperatorKind.OR);
        }
        return result;
    }


    public static CtExpression<Boolean> conjunction(List<CtExpression<Boolean>> clauses) {
        if (clauses.isEmpty())
            throw new IllegalArgumentException("List of clauses must not be empty");
        if (clauses.size() == 1)
            return clauses.get(0);

        CtExpression<Boolean> result = clauses.get(0);
        for (int i = 1; i < clauses.size(); i++) {
            result = (CtExpression<Boolean>) createBinaryExpression(result, clauses.get(i), BinaryOperatorKind.AND);
        }
        return result;
    }

    public static CtExpression<Boolean> createNullComparisonClause(Path path, BinaryOperatorKind operator) {
        return createNullComparisonClause(path.getVariableRead(), operator);
    }

    public static CtExpression<Boolean> createNullComparisonClause(CtVariableRead<?> varRead) {
        BinaryOperatorKind operator = RandomUtils.nextBoolean() ? BinaryOperatorKind.EQ : BinaryOperatorKind.NE;
        return (CtExpression<Boolean>) createBinaryExpression(varRead, parseToExpression(null), operator);
    }

    public static CtExpression<Boolean> createNullComparisonClause(CtVariableRead<?> varRead, BinaryOperatorKind operator) {
        return (CtExpression<Boolean>) createBinaryExpression(varRead, parseToExpression(null), operator);
    }

    public static CtExpression<Boolean> createNullComparisonClause(CtVariable<?> varRead, BinaryOperatorKind operator) {
        return (CtExpression<Boolean>) createBinaryExpression(createVariableRead(varRead), parseToExpression(null), operator);
    }

    public static CtExpression<Boolean> createNotEqualComparisonClause(CtVariableRead<?> varRead, CtVariableRead<?> varRead2) {
        return (CtExpression<Boolean>) createBinaryExpression(varRead, varRead2, BinaryOperatorKind.NE);
    }

    public static CtExpression<Boolean> createBooleanBinaryExpression(Object left, Object right, BinaryOperatorKind operator) {
        return (CtExpression<Boolean>) createBinaryExpression(left, right, operator);
    }


}
