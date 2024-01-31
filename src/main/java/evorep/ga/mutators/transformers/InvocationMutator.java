package evorep.ga.mutators.transformers;

import evorep.ga.mutators.codegenerators.BooleanExpressionGenerator;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class InvocationMutator {

    public static void mutate(CtInvocation<?> invocation, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtExpression<Boolean> newInv = BooleanExpressionGenerator.generateRandomCollectionMethodCallExpression(fields, localVariables);
        invocation.replace(newInv);
    }
}
