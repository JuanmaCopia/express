package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.util.Utils;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveCheckMutator implements ClassInvariantMutator {

    List<CtIf> checks;

    public boolean isApplicable(ClassInvariantState state) {
        checks = MutatorHelper.getMutableIfs(state.getCtClass()).stream().filter(
                c -> !c.getParent(CtMethod.class).getSimpleName().startsWith(LocalVarHelper.INITIAL_METHOD_NAME) &&
                        !c.getCondition().toString().contains(LocalVarHelper.TRAVERSAL_PREFIX) &&
                        !c.getCondition().toString().contains(LocalVarHelper.ARRAY_TRAVERSAL_PREFIX)
        ).toList();
        return !checks.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Utils.getRandomElement(checks).delete();
        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }

}
