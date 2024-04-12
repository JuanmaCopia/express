package evorep.spoon.processors.traversals;

import evorep.ga.helper.LocalVarHelper;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseWorklistProcessor extends AbstractProcessor<CtBlock<?>> {

    List<CtVariable<?>> loopFields;
    CtVariableRead<?> initialField;

    public TraverseWorklistProcessor(CtVariableRead<?> initialField, List<CtVariable<?>> loopFields) {
        super();
        this.loopFields = loopFields;
        this.initialField = initialField;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtLocalVariable<?> visitedSet = SpoonFactory.createVisitedSetDeclaration(initialField.getType(), ctBlock);
        CtLocalVariable<?> worklist = SpoonFactory.createWorkListDeclaration(initialField.getType(), ctBlock);

        CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        CtInvocation<?> addToWorklistCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, initialField);

        CtExpression<Boolean> ifCondition = SpoonFactory.createNullComparisonClause(initialField, BinaryOperatorKind.NE);
        CtIf initialFieldNullCheck = SpoonFactory.createIfThenStatement(ifCondition, addToWorklistCall);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);

        // Create while body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");

        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable(LocalVarHelper.getCurrentVarName(ctBlock), subtypeOfWorklist, removeFirstMethodCall);
        //CtAssignment<?, ?> assignRemoveFirst = SpoonFactory.createAssignment(currentDeclaration, removeFirstMethodCall);
        whileBody.insertEnd(currentDeclaration);

        // Add visited check
        CtIf ifStatement = SpoonFactory.createVisitedCheck(visitedSet, currentDeclaration, true);
        whileBody.insertEnd(ifStatement);

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
            whileBody.insertEnd(ifNotNull);
        }

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(ctBlock);
        lastStatement.insertBefore(SpoonFactory.createComment("Begin of traversal"));
        lastStatement.insertBefore(visitedSet);
        lastStatement.insertBefore(worklist);
        lastStatement.insertBefore(SpoonFactory.createComment("Initialize root element:"));
        lastStatement.insertBefore(initialFieldNullCheck);
        lastStatement.insertBefore(SpoonFactory.createComment("Cycle over cyclic references:"));
        lastStatement.insertBefore(whileStatement);
        lastStatement.insertBefore(SpoonFactory.createComment("End of traversal"));
    }
}