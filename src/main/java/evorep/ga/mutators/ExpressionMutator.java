package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.spoon.SpoonHelper;
import evorep.spoon.generators.BooleanExpressionGenerator;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtUnaryOperator;

public class ExpressionMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return gene instanceof CtBinaryOperator || gene instanceof CtUnaryOperator<?>;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        Scope scope = SpoonHelper.getScope(individual, gene);
        CtCodeElement mutatedGene = BooleanExpressionGenerator.generateRandomExpression(scope);
        gene.replace(mutatedGene);
    }

}
