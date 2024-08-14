package express.classinvariant.mutator.structurecheck;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveIfStructureCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
        return !MutatorHelper.getMutableIfs(method).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
        List<CtIf> checks = MutatorHelper.getMutableIfs(method);
        CtIf chosenCheck = checks.get(RandomUtils.nextInt(checks.size()));
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
