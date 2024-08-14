package express.classinvariant.mutator.all;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.util.Utils;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveCheckMutator implements ClassInvariantMutator {

    CtIf chosenCheck;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtIf> checks = MutatorHelper.getMutableIfs(state.getCtClass()).stream().filter(
                c -> !c.getParent(CtMethod.class).getSimpleName().startsWith(LocalVarHelper.INITIAL_METHOD_NAME) &&
                        !c.getCondition().toString().contains(LocalVarHelper.TRAVERSAL_PREFIX) &&
                        !c.getCondition().toString().contains(LocalVarHelper.ARRAY_TRAVERSAL_PREFIX)
        ).toList();
        if (checks.isEmpty())
            return false;
        chosenCheck = Utils.getRandomElement(checks);
        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
