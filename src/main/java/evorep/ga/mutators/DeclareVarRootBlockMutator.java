package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.spoon.SpoonHelper;
import evorep.spoon.generators.LocalVarDeclarationGenerator;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;

public class DeclareVarRootBlockMutator implements Mutator {

    @Override
    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBlock;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        Scope scope = SpoonHelper.getScope(individual, gene);
        CtBlock mutatedGene = (CtBlock) gene.clone();
        mutatedGene.addStatement(0, LocalVarDeclarationGenerator.chooseLocalVarDeclaration(scope));
        gene.replace(mutatedGene);
    }
}
