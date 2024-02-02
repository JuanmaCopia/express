package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeElement;

public class BinaryOperatorMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBinaryOperator;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtBinaryOperator<?> mutant = (CtBinaryOperator<?>) gene.clone();
        BinaryOperatorKind operator = mutant.getKind();
        switch (operator) {
            case PLUS -> mutant.setKind(BinaryOperatorKind.MINUS);
            case MINUS -> mutant.setKind(BinaryOperatorKind.PLUS);
            case MUL -> mutant.setKind(BinaryOperatorKind.DIV);
            case DIV -> mutant.setKind(BinaryOperatorKind.MUL);
            case AND -> mutant.setKind(BinaryOperatorKind.OR);
            case OR -> mutant.setKind(BinaryOperatorKind.AND);
            case EQ -> mutant.setKind(BinaryOperatorKind.NE);
            case NE -> mutant.setKind(BinaryOperatorKind.EQ);
            default -> throw new RuntimeException("Unsupported binary operator");
        }
        return mutant;
    }

}
