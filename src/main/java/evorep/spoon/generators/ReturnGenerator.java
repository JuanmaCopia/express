package evorep.spoon.generators;

import evorep.spoon.scope.Scope;
import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtStatement;

public class ReturnGenerator {

    public static CtStatement chooseReturnGenerator(Scope scope) {
        int random = evorep.spoon.RandomUtils.nextInt(2);
        return switch (random) {
            case 0 -> generateReturnFalse();
            case 1 -> generateReturnTrue();
            //case 2 -> generateReturnRandomExpression(fields, localVars);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }

    public static CtStatement generateReturnFalse() {
        return SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false));
    }

    public static CtStatement generateReturnTrue() {
        return SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(true));
    }

    public static CtStatement generateReturnRandomExpression(Scope scope) {
        return SpoonFactory.createReturnStatement(BooleanExpressionGenerator.generateRandomExpression(scope));
    }
}
