package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.util.Utils;
import spoon.reflect.code.CtIf;

import java.util.List;

public class RemoveIfStage2Mutator implements ClassInvariantMutator {

    List<CtIf> checks;

    public boolean isApplicable(ClassInvariantState state) {
        checks = MutatorHelper.getMutableIfs(state.getCtClass(), LocalVarHelper.STAGE_2_LABEL);
        return !checks.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Utils.getRandomElement(checks).delete();
        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }
    
}
