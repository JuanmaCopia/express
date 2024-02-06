package evorep.ga.mutators;

import evorep.ga.randomgen.BooleanExpressionGenerator;
import evorep.scope.Scope;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtUnaryOperator;

public class ExpressionMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBinaryOperator || gene instanceof CtUnaryOperator<?>;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        return BooleanExpressionGenerator.generateRandomExpression(scope);
    }

}
