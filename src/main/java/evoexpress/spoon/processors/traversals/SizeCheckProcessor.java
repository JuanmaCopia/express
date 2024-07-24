package evoexpress.spoon.processors.traversals;

import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;

public class SizeCheckProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariable<?> setVar;
    CtVariableRead<?> intField;
    int minus;

    public SizeCheckProcessor(CtVariable<?> setVar, CtVariableRead<?> intField, int minus) {
        super();
        this.setVar = setVar;
        this.intField = intField;
        this.minus = minus;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtIf ifStatement = SpoonFactory.createVisitedSizeCheck(setVar, intField, minus);

        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(ctBlock);
        lastStatement.insertBefore(SpoonFactory.createComment("Size check:"));
        lastStatement.insertBefore(ifStatement);

    }
}