package evorep.ga.mutators.codegenerators;

import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class ReturnGenerator {

    public static CtStatement chooseReturnGenerator(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
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

    public static CtStatement generateReturnRandomExpression(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        return SpoonFactory.createReturnStatement(BooleanExpressionGenerator.generateRandomExpression(fields, localVars));
    }
}
