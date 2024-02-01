package evorep.ga.randomgen;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class WhileGenerator {

    public static CtStatement chooseWhileGenerator(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        int random = RandomUtils.nextInt(3);
        return switch (random) {
            case 0 -> generateWhileWithRandomExpression(fields, localVars);
            case 1 -> generateWhileFalse(fields, localVars);
            case 2 -> generateWhileWithIfStatement(fields, localVars);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }

    public static CtStatement generateWhileWithRandomExpression(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        CtExpression<Boolean> condition = BooleanExpressionGenerator.generateRandomExpression(fields, localVars);
        return SpoonFactory.createWhileStatement(condition);
    }

    public static CtStatement generateWhileFalse(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createLiteral(false);
        return SpoonFactory.createWhileStatement(condition);
    }

    public static CtStatement generateWhileWithIfStatement(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        CtStatement ifStatement = IfGenerator.generateIfExprReturnFalse(fields, localVars);
        CtExpression<Boolean> condition = BooleanExpressionGenerator.generateRandomExpression(fields, localVars);
        return SpoonFactory.createWhileStatement(condition, ifStatement);
    }
}
