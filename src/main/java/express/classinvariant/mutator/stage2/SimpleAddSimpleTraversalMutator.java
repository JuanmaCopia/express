package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.SimpleTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class SimpleAddSimpleTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> newTraversal;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<CtTypeReference<?>> candidateTypes = SpoonManager.getSubjectTypeData().getCyclicTypes();
        CtTypeReference<?> chosenType = RandomUtils.getRandomElement(candidateTypes);

        List<Path> paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> path.getTypeReference().isSubtypeOf(chosenType) && TypeUtils.hasOnlyOneCyclicField(path)).toList();
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
        //System.err.println("SimpleAddSimpleTraversalMutator:\n" + traversal.toString());
    }

    private CtMethod<?> instantiateTraversalMethod(CtClass<?> ctClass, Path chosenPath) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());
        CtVariable<?> chosenLoopField = RandomUtils.getRandomElement(loopFields);
        return SimpleTraversalTemplate.instantiate(ctClass, chosenPath, chosenLoopField);
    }

}
