package express.classinvariant.mutator.anystage;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RemoveUnusedLocalVarMutator implements ClassInvariantMutator {

    List<CtLocalVariable<?>> unusedLocalVars;

    public boolean isApplicable(ClassInvariantState state) {
        Set<CtMethod<?>> methods = MutatorHelper.getMutableMethods(state.getCtClass());
        CtBlock<?> methodBody = RandomUtils.getRandomElement(methods).getBody();

        List<CtLocalVariable<?>> localVars = methodBody.getElements(Objects::nonNull);
        unusedLocalVars = localVars.stream().filter(
                v -> MutatorHelper.isUnusedLocalVar(methodBody, v)).toList();
        if (unusedLocalVars.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtLocalVariable<?> chosenVar = RandomUtils.getRandomElement(unusedLocalVars);
        chosenVar.delete();
        //System.err.println("RemoveUnusedLocalVarMutator:" + chosenVar);
    }

}
