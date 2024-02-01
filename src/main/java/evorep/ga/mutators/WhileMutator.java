package evorep.ga.mutators;

import evorep.ga.randomgen.BooleanExpressionGenerator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class WhileMutator {

    public static void mutate(CtWhile whileStatement, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newCondition = BooleanExpressionGenerator.generateRandomExpression(fields, localVariables);
        whileStatement.setLoopingExpression(newCondition);
    }
}
