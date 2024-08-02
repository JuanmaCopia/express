package evoexpress.classinvariant.mutator.structurecheck.traversal.init;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class RemoveTraverseMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        return !MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));

        List<CtIf> checks = MutatorHelper.getIfsCallingMethod(state.getCtClass(), traversal.getSimpleName());

        for (CtIf check : checks) {
            check.delete();
        }

        state.getCtClass().removeMethod(traversal);

        CtTypeReference<?> traversedType = SpoonQueries.getTraversalSetParameter(traversal).getType().getActualTypeArguments().get(0);
        state.setTypeAsNonTraversed(traversedType);

        //System.err.println("TraverseWorklistMutator:\n" + state.getCtClass().toString());
        return true;
    }



}
