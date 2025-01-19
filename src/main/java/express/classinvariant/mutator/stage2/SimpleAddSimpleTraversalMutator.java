package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
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

    List<Path> paths;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<CtTypeReference<?>> candidateTypes = SpoonManager.getSubjectTypeData().getCyclicTypes();
        CtTypeReference<?> chosenType = RandomUtils.getRandomElement(candidateTypes);

        paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> path.getTypeReference().isSubtypeOf(chosenType) && TypeUtils.hasOnlyOneCyclicField(path)).toList();
        return !paths.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Path chosenPath = RandomUtils.getRandomPath(paths);
        CtMethod<?> newTraversal = instantiateTraversalMethod(state.getCtClass(), chosenPath);
        state.getCtClass().addMethod(newTraversal);
        //System.err.println("SimpleAddSimpleTraversalMutator:\n" + traversal.toString());
    }

    private CtMethod<?> instantiateTraversalMethod(CtClass<?> ctClass, Path chosenPath) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        CtVariable<?> chosenLoopField = RandomUtils.getRandomElement(loopFields);

        boolean checkCircular = RandomUtils.nextBoolean();
        return SimpleTraversalTemplate.instantiate(ctClass, chosenPath, chosenLoopField, checkCircular);
    }

}
