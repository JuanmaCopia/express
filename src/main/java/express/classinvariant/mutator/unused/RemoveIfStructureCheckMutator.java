package express.classinvariant.mutator.unused;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.util.Utils;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveIfStructureCheckMutator implements ClassInvariantMutator {

    List<CtIf> checks;

    public boolean isApplicable(ClassInvariantState state) {
        CtMethod<?> method = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME);
        checks = MutatorHelper.getMutableIfs(method);
        return !checks.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf chosenCheck = Utils.getRandomElement(checks);
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }

}
