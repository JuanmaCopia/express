package evoexpress.classinvariant.mutator.primitivecheck;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class RemoveTraversalSizeCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        if (MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX).isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtMethod<?>> traversalMethods = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversalMethods.get(RandomUtils.nextInt(traversalMethods.size()));
        CtBlock<?> traversalBody = traversal.getBody();
        CtVariable<?> initialSizeVar = SpoonQueries.getInitialSizeVariable(traversalBody);
        if (initialSizeVar == null)
            return false;

        List<CtIf> sizeChecks = MutatorHelper.getIfsWithVariableInCondition(traversalBody, initialSizeVar);

        for (CtIf sizeCheck : sizeChecks) {
            sizeCheck.delete();
        }
        initialSizeVar.delete();

        return true;
    }


}
