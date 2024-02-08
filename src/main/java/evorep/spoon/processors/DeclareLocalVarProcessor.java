package evorep.spoon.processors;

import evorep.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.reference.CtTypeReference;

public class DeclareLocalVarProcessor extends AbstractProcessor<CtStatement> {

    CtTypeReference<?> varType;
    CtExpression<?> initExpression;
    String varName;

    public DeclareLocalVarProcessor(CtTypeReference<?> varType, String varName, CtExpression<?> initExpression) {
        super();
        this.varType = varType;
        this.varName = varName;
        this.initExpression = initExpression;
    }

    @Override
    public void process(CtStatement ctStatement) {
        CtLocalVariable<?> localVariable = SpoonFactory.createLocalVariable(varName, varType, initExpression);

        ctStatement.insertBefore(localVariable);
    }
}