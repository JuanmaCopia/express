package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.util.Utils;
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
