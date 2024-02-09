package evorep.spoon.processors;

import evorep.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

public class NullCheckAllFieldsProcessor extends AbstractProcessor<CtMethod<?>> {

    @Override
    public void process(CtMethod<?> method) {

        for (CtField<?> field : method.getDeclaringType().getFields()) {
            if (SpoonQueries.isReferenceType(field))
                new NullCheckProcessor(field).process(method);
        }

    }
}