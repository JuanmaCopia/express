package evoexpress.classinvariant.mutator.structurecheck.traversal;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.util.Utils;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveTraversalInvocationMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    List<CtIf> checks;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversals(state.getCtClass());
        if (traversals.isEmpty()) {
            return false;
        }
        traversal = Utils.getRandomElement(traversals);

        List<CtIf> allChecks = MutatorHelper.getMutableIfs(state.getCtClass());
        checks = allChecks.stream().filter(check -> MutatorHelper.callsMethod(check, traversal)).toList();
        if (checks.isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtIf chosenCheck = Utils.getRandomElement(checks);
        chosenCheck.delete();

        //System.err.println("\nRemoveCheckMutator:\n" + chosenCheck);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
