package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtIf;

import java.util.List;

public class RemoveCheckMutator implements Mutator {


    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!MutatorHelper.isInitialCheckBlock(gene) && !MutatorHelper.isTraversalBlock(gene)) {
            return false;
        }
        return !SpoonQueries.getIfsReturnFalses((CtBlock<?>) gene).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtIf> checks = SpoonQueries.getIfsReturnFalses(blockGene);
        CtIf chosenCheck = checks.get(RandomUtils.nextInt(checks.size()));
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
