package express.classinvariant.mutator.structurecheck.traversal;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.util.Utils;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversals(state.getCtClass());
        if (traversals.isEmpty()) {
            return false;
        }
        traversal = Utils.getRandomElement(traversals);
        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        //System.err.println("RemoveTraverseWorklistMutator:\n" + traversal.toString());

        List<CtIf> checks = MutatorHelper.getIfsCallingMethod(state.getCtClass(), traversal.getSimpleName());
        for (CtIf check : checks) {
            check.delete();
        }

        state.getCtClass().removeMethod(traversal);
        return true;
    }



}
