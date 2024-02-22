package evorep.ga.mutators;

import evorep.ga.Individual;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeElement;

public class BinaryOperatorMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return gene instanceof CtBinaryOperator;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBinaryOperator<?> mutatedGene = (CtBinaryOperator<?>) gene.clone();
        BinaryOperatorKind operator = mutatedGene.getKind();
        switch (operator) {
            case PLUS -> mutatedGene.setKind(BinaryOperatorKind.MINUS);
            case MINUS -> mutatedGene.setKind(BinaryOperatorKind.PLUS);
            case MUL -> mutatedGene.setKind(BinaryOperatorKind.DIV);
            case DIV -> mutatedGene.setKind(BinaryOperatorKind.MUL);
            case AND -> mutatedGene.setKind(BinaryOperatorKind.OR);
            case OR -> mutatedGene.setKind(BinaryOperatorKind.AND);
            case EQ -> mutatedGene.setKind(BinaryOperatorKind.NE);
            case NE -> mutatedGene.setKind(BinaryOperatorKind.EQ);
            default -> throw new RuntimeException("Unsupported binary operator");
        }
        gene.replace(mutatedGene);
    }

}
