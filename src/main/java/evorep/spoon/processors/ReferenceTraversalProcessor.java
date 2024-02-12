package evorep.spoon.processors;

import evorep.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;

public class ReferenceTraversalProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariableRead<?> initialField;
    CtField<?> loopField;

    public ReferenceTraversalProcessor(CtField<?> initialField, CtField<?> loopField) {
        this(SpoonFactory.createFieldRead(initialField), loopField);
    }

    public ReferenceTraversalProcessor(CtVariableRead<?> initialField, CtField<?> loopField) {
        super();
        this.initialField = initialField;
        this.loopField = loopField;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtLocalVariable<?> localVariable = SpoonFactory.createLocalVariable("current", initialField.getType(), initialField);

        // Create while condition
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory
                .createBinaryExpression(localVariable, null, BinaryOperatorKind.NE);

        CtFieldRead<?> loopFieldRead = SpoonFactory.createFieldRead(localVariable, loopField);

        // reate the assignment of the "current.next" field to the local var "current"
        CtAssignment assignment = SpoonFactory.createAssignment(localVariable, loopFieldRead);

        // // Create the complete while statement: while (current != null) { ... }
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, assignment);

        // insert the if statement at the beginning of the block
        ctBlock.insertBegin(whileStatement);
        ctBlock.insertBegin(localVariable);
    }
}