package evoexpress.spoon.generators;

import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.scope.Scope;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;

public class IfGenerator {

    public static CtStatement chooseIfGenerator(Scope scope) {
        int random = RandomUtils.nextInt(2);
        return switch (random) {
            case 0 -> generateIfExprReturnFalse(scope);
            case 1 -> generateIfFalseReturnFalse(scope);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }

    public static CtStatement generateIfExprReturnFalse(Scope scope) {
        CtExpression<Boolean> condition = BooleanExpressionGenerator.generateRandomExpression(scope);
        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        return SpoonFactory.createIfThenStatement(condition, returnStatement);
    }

    public static CtStatement generateIfFalseReturnFalse(Scope scope) {
        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createLiteral(false);
        CtReturn<?> returnStatement = SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
        return SpoonFactory.createIfThenStatement(condition, returnStatement);
    }
}
