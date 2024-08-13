package evoexpress.classinvariant.mutator.initialcheck;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveIfInitialCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.INITIAL_METHOD_NAME);
        return !MutatorHelper.getMutableIfs(method).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.INITIAL_METHOD_NAME);
        List<CtIf> checks = MutatorHelper.getMutableIfs(method);
        CtIf chosenCheck = checks.get(RandomUtils.nextInt(checks.size()));
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
