package express.classinvariant.mutator.template;

import express.classinvariant.mutator.LocalVarHelper;
import express.spoon.SpoonFactory;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.support.reflect.reference.CtArrayTypeReferenceImpl;

import java.util.Collections;

public class ArrayTraversalTemplate {

    public static CtMethod<?> instantiate(CtClass<?> ctClass, Path pathToArray) {
        CtMethod<?> arrayTraversal = TemplateHelper.createTraversalMethod(ctClass, pathToArray, LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        createArrayTraversalBody(arrayTraversal);
        return arrayTraversal;
    }

    private static CtBlock<?> createArrayTraversalBody(CtMethod<?> arrayTraversal) {
        CtBlock<?> body = SpoonFactory.createBlock();
        CtVariable<?> arrayVar = TemplateHelper.getTraversedElementParameter(arrayTraversal);
        CtVariableRead<?> arrayRead = SpoonFactory.createVariableRead(arrayVar);

        CtVariable<?> mapOfVisited = TemplateHelper.getMapOfVisitedParameter(arrayTraversal);
        //CtLocalVariable<?> visitedSetDeclaration = TemplateHelper.createVisitedElementsSet(mapOfVisited, arrayRead);

        CtFor forStatement = createForStatement(arrayVar);

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
        CtExpression<Boolean> condition = SpoonFactory.createBinaryExpression(
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
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.CURRENT_VAR_NAME, arraySubtype, arrayAccess);
        forBody.insertBegin(currentDeclaration);
        forBody.insertEnd(SpoonFactory.createComment("Handle current:"));
        forBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        forStatement.setBody(forBody);

        return forStatement;
    }

}
