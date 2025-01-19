package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class SimpleRemoveTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }
        traversal = RandomUtils.getRandomElement(traversals);
        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtBlock<?> targetMethodBody = TemplateHelper.getStructureMethod(state).getBody();

        List<CtIf> invocations = MutatorHelper.getIfsCallingMethod(targetMethodBody, LocalVarHelper.STAGE_2_LABEL, traversal.getSimpleName());
        for (CtIf check : invocations) {
            check.delete();
        }

        state.getCtClass().removeMethod(traversal);

        //System.err.println("RemovedTraversal: " + traversal.getSimpleName());
        //System.err.println("Result: " + state);
    }


}
