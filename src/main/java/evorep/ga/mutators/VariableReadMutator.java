package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.spoon.SpoonHelper;
import evorep.spoon.generators.ReferenceExpressionGenerator;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.path.CtRole;

public class VariableReadMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return gene instanceof CtVariableRead && !gene.getRoleInParent().equals(CtRole.TARGET);
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        Scope scope = SpoonHelper.getScope(individual, gene);
        CtVariableRead<?> varRead = (CtVariableRead<?>) gene;
        CtCodeElement mutatedGene = ReferenceExpressionGenerator.generateRandomVarReadOfType(scope.getAllVariables(), varRead.getType());
        if (mutatedGene != null)
            gene.replace(mutatedGene);
    }

}
