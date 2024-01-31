package evorep.spoon;

import org.apache.commons.lang3.ClassUtils;
import spoon.SpoonAPI;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.factory.CodeFactory;
import spoon.reflect.factory.CoreFactory;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.TypeFactory;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collections;
import java.util.List;

public class SpoonFactory {

    private static SpoonAPI launcher;
    private static Factory factory;
    private static CodeFactory codeFactory;
    private static CoreFactory coreFactory;
    private static TypeFactory typeFactory;

    public static void initialize(SpoonAPI spoonLauncher) {
        launcher = spoonLauncher;
        factory = launcher.getFactory();
        codeFactory = launcher.getFactory().Code();
        coreFactory = launcher.getFactory().Core();
        typeFactory = launcher.getFactory().Type();
    }

    // ==================== Getters ====================

    public static SpoonAPI getLauncher() {
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

    // ==================== Methods for creating new elements ====================

    public static CtMethod<Boolean> createRepOK(String name) {
        CtMethod<Boolean> newMethod = createMethod(ModifierKind.PUBLIC, typeFactory.BOOLEAN_PRIMITIVE, name);

        CtBlock<Boolean> block = coreFactory.createBlock();
        block.addStatement(createReturnStatement(codeFactory.createLiteral(true)));
        newMethod.setBody(block);
        return newMethod;
    }

    public static CtMethod<Boolean> createMethod(ModifierKind modifier, CtTypeReference<?> returnType,
                                                 String name) {
        CtMethod<Boolean> newMethod = coreFactory.createMethod();
        newMethod.addModifier(modifier);
        newMethod.setType(returnType);
        newMethod.setSimpleName(name);
        return newMethod;
    }

    public static CtBlock<?> createBlock() {
        return coreFactory.createBlock();
    }

    public static CtReturn createReturnStatement(CtExpression returnExpression) {
        return coreFactory.createReturn().setReturnedExpression(returnExpression);
    }

    public static CtReturn createReturnTrueStatement() {
        return createReturnStatement(codeFactory.createLiteral(true));
    }

    public static CtTypeReference<?> createReference(Class<?> type) {
        return typeFactory.createReference(type);
    }

    public static CtIf createIfThenStatement(CtExpression<Boolean> condition, CtStatement thenStatement) {
        if (!(thenStatement instanceof CtBlock<?>))
            thenStatement = encapsulateStatement(thenStatement);
        CtIf ifStatement = coreFactory.createIf();
        ifStatement.setCondition(condition);
        ifStatement.setThenStatement(thenStatement);
        return ifStatement;
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


    public static CtBlock<?> encapsulateStatement(CtStatement statement) {
        CtBlock<?> block = coreFactory.createBlock();
        block.addStatement(statement);
        return block;
    }

    public static CtBlock<?> createStatementBlock(List<CtStatement> statements) {
        CtBlock<?> block = coreFactory.createBlock();
        for (CtStatement statement : statements)
            block.addStatement(statement.clone());
        return block;
    }

    public static CtExpression<?> createLiteral(Object value) {
        if (value == null)
            return codeFactory.createLiteral(null);
        if (!ClassUtils.isPrimitiveOrWrapper(value.getClass()))
            throw new IllegalArgumentException("Value must be a primitive or a wrapper");
        return codeFactory.createLiteral(value);
    }

    public static CtLocalVariable<?> createLocalVariable(String varName, CtTypeReference<?> type,
                                                         Object assignment) {
        CtLocalVariable localVariable = coreFactory.createLocalVariable();

        localVariable.setSimpleName(varName);
        localVariable.setType(type);
        localVariable.setAssignment(parseToExpression(assignment));
        return localVariable;
    }

    public static CtVariableWrite createVariableWrite(CtVariable<?> variable) {
        CtVariableWrite variableWrite = coreFactory.createVariableWrite();
        variableWrite.setVariable(variable.getReference());
        return variableWrite;
    }

    public static CtVariableRead<?> createVariableRead(CtVariable variable) {
        CtVariableRead<?> variableRead = coreFactory.createVariableRead();
        variableRead.setVariable(variable.getReference());
        return variableRead;
    }

    public static CtFieldRead<?> createFieldRead(CtExpression<?> variable, CtVariable<?> field) {
        CtFieldRead fieldRead = coreFactory.createFieldRead();
        fieldRead.setTarget(variable);
        fieldRead.setVariable(field.getReference());
        return fieldRead;
    }

    public static CtFieldRead<?> createFieldRead(CtVariable<?> variable, CtVariable<?> field) {
        return createFieldRead(createVariableRead(variable), field);
    }

    public static CtTypeReference<?> createTypeReference(Class<?> type) {
        return typeFactory.createReference(type);
    }

    public static CtTypeReference<?> createTypeWithSubtypeReference(Class<?> type, Class<?> subtype) {
        CtTypeReference<?> resultType = typeFactory.createReference(type);
        resultType.addActualTypeArgument(typeFactory.createReference(subtype));
        return resultType;
    }

    public static CtTypeReference<?> createTypeWithSubtypeReference(Class<?> type, CtTypeReference<?> subtype) {
        CtTypeReference<?> resultType = typeFactory.createReference(type);
        resultType.addActualTypeArgument(subtype);
        return resultType;
    }

    public static CtConstructorCall<?> createConstructorCall(Class<?> type) {
        return createConstructorCall(typeFactory.createReference(type));
    }

    public static CtConstructorCall<?> createConstructorCall(CtTypeReference<?> type) {
        return codeFactory.createConstructorCall(type);
    }

/*    public static CtConstructorCall<?> createConstructorCall(CtTypeReference<?> type, CtTypeReference<?> subtype) {
        CtConstructorCall<?> constructorCall = codeFactory.createConstructorCall(type);
    }*/

    public static CtInvocation createInvocation(CtVariable<?> target, String methodName,
                                                CtTypeReference<?> argsTypes,
                                                CtExpression<?> args) {

        return createInvocation(target, methodName, Collections.singletonList(argsTypes),
                Collections.singletonList(args));
    }

    public static CtInvocation createInvocation(CtVariable<?> target, String methodName,
                                                List<CtTypeReference<?>> argsTypes,
                                                List<CtExpression<?>> args) {

        CtExecutableReference<?> method = createExecutableReference(target.getType(), methodName, argsTypes);
        return createMethodCall(target, method, args);
    }

    public static CtExecutableReference createExecutableReference(CtTypeReference<?> targetType, String methodName,
                                                                  List<CtTypeReference<?>> args) {
        CtExecutableReference method = coreFactory.createExecutableReference();
        method.setDeclaringType(targetType);
        method.setSimpleName(methodName);
        method.setParameters(args);
        return method;
    }

    public static CtInvocation createMethodCall(CtVariable<?> target, CtExecutableReference<?> method,
                                                List<CtExpression<?>> args) {
        CtInvocation invocation = coreFactory.createInvocation();
        invocation.setTarget(createVariableRead(target));
        invocation.setExecutable(method);
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

    public static CtAssignment createAssignment(CtVariable<?> assigned, Object assignment) {
        CtAssignment ctAssignment = coreFactory.createAssignment();
        ctAssignment.setAssigned(createVariableWrite(assigned));
        ctAssignment.setAssignment(parseToExpression(assignment));
        return ctAssignment;
    }

    // public static CtAssignment createAssignment(CtVariable<?> assigned,
    // CtExpression<?> assignment) {
    // CtAssignment ctAssignment = coreFactory.createAssignment();
    // ctAssignment.setAssigned(createVariableWrite(assigned));
    // ctAssignment.setAssignment(assignment);
    // return ctAssignment;
    // }

}
