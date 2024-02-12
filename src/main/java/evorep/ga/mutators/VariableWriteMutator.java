package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.spoon.SpoonHelper;
import evorep.spoon.generators.ReferenceExpressionGenerator;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableWrite;

public class VariableWriteMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtVariableWrite;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        Scope scope = SpoonHelper.getScope(individual, gene);
        CtVariableWrite<?> varWrite = (CtVariableWrite<?>) gene;
        CtCodeElement mutatedGene = ReferenceExpressionGenerator.generateRandomVarWriteOfType(scope.getLocalVariables(), varWrite.getType());
        gene.replace(mutatedGene);
    }

}
