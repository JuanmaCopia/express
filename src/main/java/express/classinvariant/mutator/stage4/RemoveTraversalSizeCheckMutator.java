package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;

public class RemoveTraversalSizeCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        if (MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX).isEmpty())
            return false;
        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
//        List<CtMethod<?>> traversalMethods = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
//        CtMethod<?> traversal = traversalMethods.get(RandomUtils.nextInt(traversalMethods.size()));
//        CtBlock<?> traversalBody = traversal.getBody();
//        CtVariable<?> initialSizeVar = SpoonQueries.getInitialSizeVariable(traversalBody);
//        if (initialSizeVar == null)
//            return false;
//
//        List<CtIf> sizeChecks = MutatorHelper.getIfsWithVariableInCondition(traversalBody, initialSizeVar);
//
//        for (CtIf sizeCheck : sizeChecks) {
//            sizeCheck.delete();
//        }
//        initialSizeVar.delete();

    }


}