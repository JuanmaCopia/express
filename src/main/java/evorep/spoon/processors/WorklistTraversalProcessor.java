package evorep.spoon.processors;

import evorep.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class WorklistTraversalProcessor extends AbstractProcessor<CtBlock<?>> {

    CtLocalVariable<?> worklist;
    List<CtField<?>> loopFields;

    public WorklistTraversalProcessor(CtLocalVariable<?> worklist, List<CtField<?>> loopFields) {
        super();
        this.worklist = worklist;
        this.loopFields = loopFields;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtTypeReference<?> subtypeOfWorklist = worklist.getType().getActualTypeArguments().get(0);

        // create condition: !workList.isEmpty()
        CtInvocation<?> isEmptyMethodCall = SpoonFactory.createInvocation(worklist, "isEmpty");
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory.createUnaryExpression(isEmptyMethodCall, UnaryOperatorKind.NOT);

        // Create while body
        CtBlock<?> whileBody = SpoonFactory.createBlock();

        // Create current = worklist.removeFirst();
        CtInvocation<?> removeFirstMethodCall = SpoonFactory.createInvocation(worklist, "removeFirst");
        CtLocalVariable<?> currentDeclaration = SpoonFactory.createLocalVariable("current", subtypeOfWorklist, removeFirstMethodCall);
        whileBody.insertEnd(currentDeclaration);

        // Create comment: // Handle current:
        whileBody.insertEnd(SpoonFactory.createComment("Handle current:"));

        // Create comment: // Add children to worklist:
        whileBody.insertEnd(SpoonFactory.createComment("End of Handle current:"));

        // Create worklist.add(current.<loopField>); for each loopField
        for (CtField<?> loopField : loopFields) {
            CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(currentDeclaration, loopField);
            CtExpression<Boolean> fieldNullComp = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(loopFieldRead, null, BinaryOperatorKind.NE);

            CtInvocation<?> addToListCall = SpoonFactory.createInvocation(worklist, "add", subtypeOfWorklist, loopFieldRead);
            CtIf ifNotNull = SpoonFactory.createIfThenStatement(fieldNullComp, addToListCall);
            whileBody.insertEnd(ifNotNull);
        }

        // Create while statement
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, whileBody);

        CtStatement lastStatement = ctBlock.getLastStatement();
        lastStatement.insertBefore(whileStatement);
    }
}