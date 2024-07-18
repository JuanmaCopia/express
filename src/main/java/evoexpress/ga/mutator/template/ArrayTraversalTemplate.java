package evoexpress.ga.mutator.template;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayTraversalTemplate {

    public static void instantiate(CtClass<?> ctClass, Path pathToArray) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethodBody);

        CtTypeReference<?> arraySubtype = ((CtArrayTypeReference<?>) pathToArray.getTypeReference()).getComponentType();

        CtVariable<?> setVar = MutatorHelper.handleVisitedSetVariable(structureMethodBody, lastStatement, arraySubtype);

        CtMethod<?> traversalMethod = createTraversalMethod(ctClass, pathToArray, setVar);
        ctClass.addMethod(traversalMethod);
    }

    private static CtMethod<?> createTraversalMethod(CtClass<?> ctClass, Path pathToArray, CtVariable<?> setVar) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().BOOLEAN_PRIMITIVE;
        List<CtParameter<?>> parameters = createParameters(pathToArray, setVar);
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, createMethodName(), parameters);
        traversalMethod.setSimpleName(traversalMethod.getSimpleName() + LocalVarHelper.getNextTraversalId(ctClass, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX));

        CtBlock<?> traversalBody = createArrayTraversalBody(pathToArray, parameters);
        traversalMethod.setBody(traversalBody);
        return traversalMethod;
    }

    private static List<CtParameter<?>> createParameters(Path pathToArray, CtVariable<?> visitedSet) {
        List<CtParameter<?>> parameters = SpoonManager.inputTypeData.getInputs();
        parameters.add(SpoonFactory.createParameter(pathToArray.getTypeReference(), LocalVarHelper.ARRAY_PARAM_NAME));
        parameters.add(SpoonFactory.createParameter(visitedSet.getType(), visitedSet.getSimpleName()));
        return parameters;
    }


    public static String createMethodName() {
        return LocalVarHelper.ARRAY_TRAVERSAL_PREFIX;
    }


    private static CtBlock<?> createArrayTraversalBody(Path pathToArray, List<CtParameter<?>> params) {
        CtBlock<?> body = SpoonFactory.createBlock();

        CtVariable<?> arrayVar = params.get(params.size() - 2);


        CtVariable<?> visitedSet = params.get(params.size() - 1);

        // Create while statement
        CtFor forStatement = createForStatement(arrayVar);


        CtExpression<Boolean> arrayNotNullCheck = SpoonFactory.createNullComparisonClause(arrayVar, BinaryOperatorKind.NE);
        CtIf ifArrayNotNull = SpoonFactory.createIfThenStatement(arrayNotNullCheck, forStatement);

        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(ifArrayNotNull);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));
        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        return body;
    }

    private static CtFor createForStatement(CtVariable<?> arrayVar) {
        // Create the variable declaration: int i = 0;
        CtLocalVariable<?> init = SpoonFactory.createLocalVariable(
                "i",
                SpoonFactory.getTypeFactory().INTEGER_PRIMITIVE,
                SpoonFactory.getCodeFactory().createLiteral(0)
        );
        CtVariableRead<Integer> indexRead = (CtVariableRead<Integer>) SpoonFactory.createVariableRead(init);

        // Create a CtFieldRead for 'array.length'
        CtVariableRead<?> arrayRead = SpoonFactory.createVariableRead(arrayVar);
        CtFieldReference<Integer> lengthFieldRef = SpoonFactory.getFactory().Field().createReference("length");

        CtFieldRead<Integer> lengthRead = SpoonFactory.getCoreFactory().createFieldRead();
        lengthRead.setTarget(arrayRead);
        lengthRead.setVariable(lengthFieldRef);

        // Create the condition: i < array.length
        CtBinaryOperator<Boolean> condition = (CtBinaryOperator<Boolean>) SpoonFactory.createBinaryExpression(
                init,
                lengthRead,
                BinaryOperatorKind.LT
        );

        // Create the increment: i++
        CtExpression<?> increment = SpoonFactory.createUnaryExpression(init, UnaryOperatorKind.POSTINC);

        CtFor forStatement = SpoonFactory.getCoreFactory().createFor();
        forStatement.setForInit(Collections.singletonList(init));
        forStatement.setExpression(condition);
        forStatement.setForUpdate(Collections.singletonList((CtStatement) increment));

        CtBlock<?> forBody = SpoonFactory.createBlock();
        CtTypeReference<?> arraySubtype = ((CtArrayTypeReference<?>) arrayVar.getType()).getComponentType();
        CtArrayRead<?> arrayAccess = SpoonFactory.getFactory().createArrayRead();
        arrayAccess.setTarget(arrayRead);
        arrayAccess.setIndexExpression(indexRead);
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(forBody), arraySubtype, arrayAccess);
        forBody.insertBegin(currentDeclaration);
        forStatement.setBody(forBody);

        return forStatement;
    }


}
