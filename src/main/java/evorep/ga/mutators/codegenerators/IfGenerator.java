package evorep.ga.mutators.codegenerators;

import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class IfGenerator {

    public static CtStatement generateIfExprReturnFalse(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        CtExpression<Boolean> condition = BooleanExpressionGenerator.generateRandomExpression(fields, localVars);
        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        return SpoonFactory.createIfThenStatement(condition, returnStatement);
    }

    public static CtStatement generateIfFalseReturnFalse(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createLiteral(false);
        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        return SpoonFactory.createIfThenStatement(condition, returnStatement);
    }
}
