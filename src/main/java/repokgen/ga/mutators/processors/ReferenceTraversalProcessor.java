package repokgen.ga.mutators.processors;

import repokgen.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldRead;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtField;

public class ReferenceTraversalProcessor extends AbstractProcessor<CtBlock<?>> {

    CtField<?> rootField;
    CtField<?> nextField;

    public ReferenceTraversalProcessor(CtField<?> rootField, CtField<?> nextField) {
        super();
        this.rootField = rootField;
        this.nextField = nextField;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtLocalVariable<?> localVariable = SpoonFactory.createLocalVariable("current", rootField.getType(), rootField);

        // Create while condition
        CtExpression<Boolean> whileCondition = (CtExpression<Boolean>) SpoonFactory
                .createBinaryExpression(localVariable, null, BinaryOperatorKind.NE);

        CtFieldRead<?> nextFieldRead = SpoonFactory.createFieldRead(localVariable, nextField);

        // reate the assignment of the "current.next" field to the local var "current"
        CtAssignment assignment = SpoonFactory.createAssignment(localVariable, nextFieldRead);

        // // Create the complete while statement: while (current != null) { ... }
        CtWhile whileStatement = SpoonFactory.createWhileStatement(whileCondition, assignment);

        // insert the if statement at the beginning of the block
        ctBlock.getLastStatement().insertBefore(localVariable);
        ctBlock.getLastStatement().insertBefore(whileStatement);

    }
}