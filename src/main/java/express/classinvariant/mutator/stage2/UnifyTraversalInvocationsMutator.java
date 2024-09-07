package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class UnifyTraversalInvocationsMutator implements ClassInvariantMutator {

    //List<CtIf> checks;
    CtMethod<Boolean> traversal;
    List<CtMethod<?>> traversalsSameParams;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversals(state.getCtClass());
        if (traversals.size() < 2) {
            return false;
        }
        traversal = (CtMethod<Boolean>) RandomUtils.getRandomElement(traversals);

        traversalsSameParams = MutatorHelper.findTraversalsWithSameParameters(state.getCtClass(), traversal);
        return !traversalsSameParams.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        MutatorHelper.unifyTraversals(state.getCtClass(), traversal, traversalsSameParams);
    }

}
