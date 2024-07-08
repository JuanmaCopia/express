package evoexpress.spoon.template;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonHelper;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorklistTraversal {


    public static CtMethod<?> createTraversalMethod(CtClass<?> ctClass, Path initialField, List<CtParameter<?>> parameters, List<CtVariable<?>> loopFields, boolean useBreakInsteadOfReturn) {
        Set<ModifierKind> modifiers = new HashSet<>();
        modifiers.add(ModifierKind.PRIVATE);
        modifiers.add(ModifierKind.STATIC);

        CtTypeReference<?> returnType = SpoonFactory.getTypeFactory().BOOLEAN_PRIMITIVE;
        CtMethod<?> traversalMethod = SpoonFactory.createMethod(modifiers, returnType, createMethodName(loopFields), parameters);
        traversalMethod.setSimpleName(traversalMethod.getSimpleName() + "_" + LocalVarHelper.getNextTraversalId(ctClass));

        CtBlock<?> traversalBody = createTraversalBody(initialField, parameters, loopFields, useBreakInsteadOfReturn);
        traversalMethod.setBody(traversalBody);
        return traversalMethod;
    }

    public static String createMethodName(List<CtVariable<?>> loopFields) {
        return LocalVarHelper.TRAVERSAL_PREFIX + loopFields.get(0).getType().getSimpleName() + "_" + SpoonHelper.getStringFromVariableList(loopFields);
    }


    private static CtBlock<?> createTraversalBody(Path initialField, List<CtParameter<?>> params, List<CtVariable<?>> loopFields, boolean useBreakInsteadOfReturn) {
        CtBlock<?> body = SpoonFactory.createBlock();

        CtVariable<?> initFieldParent = params.get(params.size() - 2);
        CtVariableRead<?> initFieldRead = SpoonFactory.createFieldRead(initFieldParent, initialField.getLast());
        CtVariable<?> visitedSet = params.get(params.size() - 1);

        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(initFieldRead.getType(), body);

        CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, initFieldRead);
        CtInvocation<?> addToSetCall = (CtInvocation<?>) SpoonFactory.createAddToSetInvocation(visitedSet, initFieldRead);
        CtBlock<?> ifBlock = SpoonFactory.createBlock();
        ifBlock.insertEnd(addToWorklistCall);
        ifBlock.insertEnd(addToSetCall);


        CtExpression<Boolean> ifCondition = SpoonFactory.createNullComparisonClause(initFieldRead, BinaryOperatorKind.NE);
        CtIf initialFieldNullCheck = SpoonFactory.createIfThenStatement(ifCondition, ifBlock);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);

        // Create while body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(body), subtypeOfWorklist, removeFirstMethodCall);
        //CtAssignment<?, ?> assignRemoveFirst = SpoonFactory.createAssignment(currentDeclaration, removeFirstMethodCall);
        whileBody.insertEnd(currentDeclaration);

        // Add visited check
        //CtIf ifStatement = SpoonFactory.createVisitedCheck(visitedSet, currentDeclaration, true);
        //whileBody.insertEnd(ifStatement);

        // Create comment: // Handle current:
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));

        // Create comment: // Add children to worklist:
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtVariable<?> loopField : loopFields) {
            CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
            CtExpression<Boolean> fieldNullComp = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);

            CtInvocation<?> addToListCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, loopFieldRead);
            CtIf ifNotNull = SpoonFactory.createIfThenStatement(fieldNullComp, addToListCall);

            CtIf visitedCheck = SpoonFactory.createVisitedCheck(visitedSet, loopFieldRead, true, useBreakInsteadOfReturn);
            addToListCall.insertBefore(visitedCheck);

            whileBody.insertEnd(ifNotNull);
        }

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);


        body.insertEnd(SpoonFactory.createComment("Begin of traversal"));
        body.insertEnd(worklist);
        body.insertEnd(SpoonFactory.createComment("Initialize root element:"));
        body.insertEnd(initialFieldNullCheck);
        body.insertEnd(SpoonFactory.createComment("Cycle over cyclic references:"));
        body.insertEnd(whileStatement);
        body.insertEnd(SpoonFactory.createComment("End of traversal"));
        body.insertEnd(SpoonFactory.createComment("Return True"));
        body.insertEnd(SpoonFactory.createReturnTrueStatement());

        return body;
    }
}
