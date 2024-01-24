package repokgen.ga.mutators.processors;

import repokgen.spoon.SpoonFactory;
import repokgen.spoon.SpoonQueries;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtReturn;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

public class NullCheckProcessor extends AbstractProcessor<CtMethod<?>> {

    CtVariable<?> field;

    public NullCheckProcessor(CtVariable<?> field) {
        super();
        if (field == null || SpoonQueries.isPrimitiveType(field))
            throw new IllegalArgumentException("Field cannot be null or primitive type");
        this.field = field;
    }

    @Override
    public void process(CtMethod<?> method) {
        CtBlock<?> methodBody = method.getBody();
        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(field,
                null,
                BinaryOperatorKind.EQ);

        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        CtIf ifStatement = SpoonFactory.createIfThenStatement(condition, returnStatement);
        methodBody.insertBegin(ifStatement);
    }
}