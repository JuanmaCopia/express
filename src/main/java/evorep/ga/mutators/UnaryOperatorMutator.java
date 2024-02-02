package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.UnaryOperatorKind;

public class UnaryOperatorMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtUnaryOperator;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtUnaryOperator<?> unaryOperator = (CtUnaryOperator<?>) gene;
        CtExpression<?> mutant;
        UnaryOperatorKind operator = unaryOperator.getKind();
        switch (operator) {
            case NEG -> mutant = unaryOperator.getOperand();
            default -> throw new RuntimeException("Unsupported unary operator");
        }
        return mutant;
    }

}
