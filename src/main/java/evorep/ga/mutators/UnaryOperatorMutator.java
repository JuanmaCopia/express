package evorep.ga.mutators;

import evorep.ga.Individual;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.UnaryOperatorKind;

public class UnaryOperatorMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return gene instanceof CtUnaryOperator;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtUnaryOperator<?> unaryOperator = (CtUnaryOperator<?>) gene;
        CtExpression<?> mutatedGene;
        UnaryOperatorKind operator = unaryOperator.getKind();
        switch (operator) {
            case NOT -> mutatedGene = unaryOperator.getOperand();
            default -> throw new RuntimeException("Unsupported unary operator: " + operator.toString());
        }
        gene.replace(mutatedGene);
    }

}
