package evoexpress.classinvariant.mutator.template;

import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.support.reflect.reference.CtArrayTypeReferenceImpl;

import java.util.*;

public class ArrayTraversalTemplate {

    public static CtMethod<?> instantiate(CtClass<?> ctClass, Path pathToArray) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethodBody);

        CtTypeReference<?> arraySubtype = ((CtArrayTypeReference<?>) pathToArray.getTypeReference()).getComponentType();

        CtVariable<?> setVar = MutatorHelper.handleVisitedSetVariable(structureMethodBody, lastStatement, arraySubtype);

        return createTraversalMethod(ctClass, pathToArray, setVar);
    }

    private static CtMethod<?> createTraversalMethod(CtClass<?> ctClass, Path pathToArray, CtVariable<?> setVar) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().booleanPrimitiveType();
        List<CtParameter<?>> parameters = createParameters(pathToArray, setVar);
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, createMethodName(), parameters);
        traversalMethod.setSimpleName(traversalMethod.getSimpleName() + LocalVarHelper.getNextTraversalId(ctClass, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX));

        CtBlock<?> traversalBody = createArrayTraversalBody(pathToArray, parameters);
        traversalMethod.setBody(traversalBody);
        return traversalMethod;
    }

    private static List<CtParameter<?>> createParameters(Path pathToArray, CtVariable<?> visitedSet) {
        List<CtParameter<?>> parameters = new ArrayList<>();
        parameters.add((CtParameter<?>) SpoonManager.getTypeData().getThisVariable());
        parameters.add(SpoonFactory.createParameter(pathToArray.getTypeReference(), LocalVarHelper.ARRAY_PARAM_NAME));
        parameters.add(SpoonFactory.createParameter(visitedSet.getType(), LocalVarHelper.SET_VAR_NAME));
        return parameters;
    }


    public static String createMethodName() {
        return LocalVarHelper.ARRAY_TRAVERSAL_PREFIX;
    }


    private static CtBlock<?> createArrayTraversalBody(Path pathToArray, List<CtParameter<?>> params) {
        CtBlock<?> body = SpoonFactory.createBlock();
        CtVariable<?> arrayVar = params.get(params.size() - 2);
        CtFor forStatement = createForStatement(arrayVar);

//        CtExpression<Boolean> arrayNotNullCheck = SpoonFactory.createNullComparisonClause(arrayVar, BinaryOperatorKind.NE);
//        CtIf ifArrayNotNull = SpoonFactory.createIfThenStatement(arrayNotNullCheck, forStatement);

        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(forStatement);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));
        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        return body;
    }

    private static CtFor createForStatement(CtVariable<?> arrayVar) {
        // Create the variable declaration: int i = 0;
        CtLocalVariable<?> init = SpoonFactory.createLocalVariable(
                "i",
                SpoonFactory.getTypeFactory().integerPrimitiveType(),
                SpoonFactory.getCodeFactory().createLiteral(0)
        );
        CtVariableRead<Integer> indexRead = (CtVariableRead<Integer>) SpoonFactory.createVariableRead(init);

        // Create a CtFieldRead for 'array.length'
        CtVariableRead<?> arrayRead = SpoonFactory.createVariableRead(arrayVar);



        // Create a CtFieldReference for the "length" field of the array
        CtFieldReference<Integer> lengthFieldReference = SpoonFactory.getFactory().createFieldReference();
        lengthFieldReference.setSimpleName("length");
        lengthFieldReference.setDeclaringType(arrayRead.getType()); // Array type reference
        lengthFieldReference.setType(SpoonFactory.getFactory().Type().integerPrimitiveType());

        // Create a CtFieldRead for the "length" field access
        CtFieldRead<Integer> lengthFieldRead = SpoonFactory.getFactory().createFieldRead();
        lengthFieldRead.setVariable(lengthFieldReference);
        lengthFieldRead.setTarget(arrayRead);

        // Create the condition: i < array.length
        CtBinaryOperator<Boolean> condition = (CtBinaryOperator<Boolean>) SpoonFactory.createBinaryExpression(
                init,
                lengthFieldRead,
                BinaryOperatorKind.LT
        );

        // Create the increment: i++
        CtExpression<?> increment = SpoonFactory.createUnaryExpression(init, UnaryOperatorKind.POSTINC);

        CtFor forStatement = SpoonFactory.getCoreFactory().createFor();
        forStatement.setForInit(Collections.singletonList(init));
        forStatement.setExpression(condition);
        forStatement.setForUpdate(Collections.singletonList((CtStatement) increment));

        CtBlock<?> forBody = SpoonFactory.createBlock();
        CtTypeReference<?> arraySubtype = ((CtArrayTypeReferenceImpl<?>) arrayVar.getType()).getComponentType();
        CtArrayRead<?> arrayAccess = SpoonFactory.getFactory().createArrayRead();
        arrayAccess.setTarget(arrayRead);
        arrayAccess.setIndexExpression(indexRead);
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(forBody), arraySubtype, arrayAccess);
        forBody.insertBegin(currentDeclaration);
        forBody.insertEnd(SpoonFactory.createComment("Handle current:"));
        forBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        forStatement.setBody(forBody);

        return forStatement;
    }

    public static boolean isReferenceArrayTraversal(CtMethod<?> traversal) {
        CtTypeReference<?> traversedElement = traversal.getParameters().get(1).getType();
        if (!traversedElement.isArray())
            return false;
        CtArrayTypeReference<?> arrayType = (CtArrayTypeReference<?>) traversedElement;
        return TypeUtils.isReferenceType(arrayType.getComponentType());
    }


}
