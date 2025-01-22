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

    List<Path> paths;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> TypeUtils.hasOnlyOneCyclicField(path)).toList();
        if (paths.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Path chosenPath = RandomUtils.getRandomPath(paths);
        CtMethod<?> newTraversal = instantiateTraversalMethod(state.getCtClass(), chosenPath);
        state.getCtClass().addMethod(newTraversal);
    }

    private CtMethod<?> instantiateTraversalMethod(CtClass<?> ctClass, Path chosenPath) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);
        return WorklistTraversalTemplate.instantiate(ctClass, chosenPath, loopFields);
    }

}
