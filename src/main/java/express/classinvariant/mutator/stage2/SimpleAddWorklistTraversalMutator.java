package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.WorklistTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class SimpleAddWorklistTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> newTraversal;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> TypeUtils.hasOnlyOneCyclicField(path)).toList();
        if (paths.isEmpty()) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomPath(paths);
        newTraversal = instantiateTraversalMethod(state.getCtClass(), chosenPath);

        if (!MutatorHelper.getEquivalentTraversals(state.getCtClass(), newTraversal).isEmpty())
            return false;

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        state.getCtClass().addMethod(newTraversal);
    }

    private CtMethod<?> instantiateTraversalMethod(CtClass<?> ctClass, Path chosenPath) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);
        return WorklistTraversalTemplate.instantiate(ctClass, chosenPath, loopFields);
    }

}
