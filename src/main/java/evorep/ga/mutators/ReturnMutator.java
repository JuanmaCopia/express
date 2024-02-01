package evorep.ga.mutators;

import evorep.ga.randomgen.BooleanExpressionGenerator;
import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtReturn;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class ReturnMutator {

    public static void mutate(CtReturn returnStatement, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        returnStatement.setReturnedExpression(chooseNewBooleanExpression(fields, localVariables));
    }

    private static CtExpression<Boolean> chooseNewBooleanExpression(List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        int random = RandomUtils.nextInt(2);
        return switch (random) {
            case 0 -> BooleanExpressionGenerator.generateRandomExpression(fields, localVariables);
            case 1 -> BooleanExpressionGenerator.generateRandomBooleanLiteral();
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }
}
