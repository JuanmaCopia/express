package evorep.spoon.processors;

import evorep.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;

public class SizeCheckProcessor extends AbstractProcessor<CtBlock<?>> {

    CtVariable<?> setVar;
    CtVariableRead<?> intField;

    public SizeCheckProcessor(CtVariable<?> setVar, CtVariableRead<?> intField) {
        super();
        this.setVar = setVar;
        this.intField = intField;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtIf ifStatement = SpoonFactory.createVisitedSizeCheck(setVar, intField);

        CtStatement lastStatement = ctBlock.getLastStatement();
        lastStatement.insertBefore(SpoonFactory.createComment("Size check:"));
        lastStatement.insertBefore(ifStatement);

    }
}