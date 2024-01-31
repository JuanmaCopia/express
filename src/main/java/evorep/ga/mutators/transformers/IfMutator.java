package evorep.ga.mutators.transformers;

import evorep.ga.mutators.codegenerators.BooleanExpressionGenerator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class IfMutator {

    public static void mutate(CtIf ifStatement, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newCondition = BooleanExpressionGenerator.generateRandomExpression(fields, localVariables);
        ifStatement.setCondition(newCondition);
    }
}
