package evorep.spoon.generators;

import evorep.spoon.scope.Scope;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;

public class WhileGenerator {

    public static CtStatement chooseWhileGenerator(Scope scope) {
        int random = RandomUtils.nextInt(3);
        return switch (random) {
            case 0 -> generateWhileWithRandomExpression(scope);
            case 1 -> generateWhileFalse(scope);
            case 2 -> generateWhileWithIfStatement(scope);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }

    public static CtStatement generateWhileWithRandomExpression(Scope scope) {
        CtExpression<Boolean> condition = BooleanExpressionGenerator.generateRandomExpression(scope);
        return SpoonFactory.createWhileStatement(condition);
    }

    public static CtStatement generateWhileFalse(Scope scope) {
        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createLiteral(false);
        return SpoonFactory.createWhileStatement(condition);
    }

    public static CtStatement generateWhileWithIfStatement(Scope scope) {
        CtStatement ifStatement = IfGenerator.generateIfExprReturnFalse(scope);
        CtExpression<Boolean> condition = BooleanExpressionGenerator.generateRandomExpression(scope);
        return SpoonFactory.createWhileStatement(condition, ifStatement);
    }
}
