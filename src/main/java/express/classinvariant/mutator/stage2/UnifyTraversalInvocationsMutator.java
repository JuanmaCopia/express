package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.util.Utils;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtExecutableReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnifyTraversalInvocationsMutator implements ClassInvariantMutator {

    //List<CtIf> checks;
    CtMethod<Boolean> traversal;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversals(state.getCtClass());
        if (traversals.isEmpty()) {
            return false;
        }
        traversal = (CtMethod<Boolean>) Utils.getRandomElement(traversals);
        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtClass<?> ctClass = state.getCtClass();
        List<CtMethod<?>> traversals = MutatorHelper.findTraversalsWithSameParameters(ctClass, traversal);
        int option = 1;
        if (!traversals.isEmpty())
            option = RandomUtils.nextInt(1, 3);

        switch (option) {
            case 1:
                MutatorHelper.removeTraversalFromClass(ctClass, traversal);
                break;
            case 2:
                unifyTraversalInvocations(ctClass, traversals);
                break;
        }
    }

    private void unifyTraversalInvocations(CtClass<?> ctClass, List<CtMethod<?>> traversals) {
        for (CtMethod<?> t : traversals) {
            List<CtIf> checks = MutatorHelper.getIfsCallingMethod(ctClass, LocalVarHelper.STAGE_2_LABEL, t.getSimpleName());
            for (CtIf check : checks) {
                CtInvocation<Boolean> invocation = (CtInvocation<Boolean>) MutatorHelper.extractInvocation(check);
                invocation.setExecutable(traversal.getReference());
            }
        }
        for (CtMethod<?> t : traversals) {
            ctClass.removeMethod(t);
        }
    }

}
