package evoexpress.classinvariant.mutator.all;

import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import spoon.reflect.code.CtIf;

import java.util.List;

public class RemoveCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        return !MutatorHelper.getMutablesIfReturnFalse(state.getCtClass()).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtIf> checks = MutatorHelper.getMutablesIfReturnFalse(state.getCtClass());
        CtIf chosenCheck = checks.get(RandomUtils.nextInt(checks.size()));
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
