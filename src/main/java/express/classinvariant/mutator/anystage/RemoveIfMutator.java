package express.classinvariant.mutator.anystage;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import spoon.reflect.code.CtIf;

import java.util.List;

public class RemoveIfMutator implements ClassInvariantMutator {

    List<CtIf> checks;
    String stageLabel;

    public RemoveIfMutator(int stageNumber) {
        stageLabel = LocalVarHelper.getStageLabel(stageNumber);
    }

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        checks = MutatorHelper.getMutableIfs(state.getCtClass(), stageLabel);
        return !checks.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        RandomUtils.getRandomElement(checks).delete();
    }

}
