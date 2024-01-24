package repokgen.ga.mutators.processors;

import repokgen.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class AlreadyVisitedCheckProcessor extends AbstractProcessor<CtStatement> {

    CtVariable<?> setVariable;
    CtExpression<?> elem;

    public AlreadyVisitedCheckProcessor(CtVariable<?> setVariable, CtExpression<?> elem) {
        this.setVariable = setVariable;
        this.elem = elem;
    }

    public AlreadyVisitedCheckProcessor(CtVariable<?> setVariable, CtVariable<?> elem) {
        this(setVariable, SpoonFactory.createVariableRead(elem));
    }

    @Override
    public void process(CtStatement ctStatement) {
        CtTypeReference<?> elemType = setVariable.getReference().getType().getActualTypeArguments().get(0);

        CtInvocation<?> addInvocation = SpoonFactory.createInvocation(setVariable, "add", elemType, elem);

        CtUnaryOperator<Boolean> condition = (CtUnaryOperator<Boolean>) SpoonFactory
                .createUnaryExpression(addInvocation, UnaryOperatorKind.NOT);

        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));

        CtIf ifStatement = SpoonFactory.createIfThenStatement(condition, returnStatement);

        ctStatement.insertBefore(ifStatement);
    }

}
