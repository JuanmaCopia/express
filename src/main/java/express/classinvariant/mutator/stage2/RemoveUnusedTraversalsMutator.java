package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class RemoveUnusedTraversalsMutator implements ClassInvariantMutator {

    List<CtMethod<?>> unusedTraversals;

    public boolean isApplicable(ClassInvariantState state) {
        unusedTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX)
                .stream().filter(t -> MutatorHelper.isUnusedTraversal(state.getCtClass(), t)).toList();

        return !unusedTraversals.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        for (CtMethod<?> m : unusedTraversals) {
            state.getCtClass().removeMethod(m);
            //System.out.println("Removed traversal: " + m.getSimpleName());
        }
    }


}
