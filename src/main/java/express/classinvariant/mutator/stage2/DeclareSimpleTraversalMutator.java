package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.SimpleTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeclareSimpleTraversalMutator implements ClassInvariantMutator {

    List<Path> paths;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> candidateTypes = new HashSet<>(SpoonManager.getSubjectTypeData().getCyclicTypes());
        CtTypeReference<?> chosenType = Utils.getRandomElement(candidateTypes);

        paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> path.getTypeReference().isSubtypeOf(chosenType) && TypeUtils.hasOnlyOneCyclicField(path)).toList();
        return !paths.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Path chosenPath = Utils.getRandomElement(paths);
        CtMethod<?> newTraversal = instantiateTraversalMethod(state.getCtClass(), chosenPath);

        List<CtMethod<?>> existingTraversalsWithSameParameters = MutatorHelper.findTraversalsWithSameParameters(state.getCtClass(), newTraversal);
        int option = 1;
        if (!existingTraversalsWithSameParameters.isEmpty()) {
            option = RandomUtils.nextInt(1, 3);
        }

        switch (option) {
            case 1:
                state.getCtClass().addMethod(newTraversal);
                InvokeFieldTraversalMutator invokeFieldTraversalMutator = new InvokeFieldTraversalMutator();
                if (invokeFieldTraversalMutator.isApplicable(state, newTraversal)) {
                    invokeFieldTraversalMutator.mutate(state);
                }
                break;
            case 2:
                CtMethod<?> traversalToReplace = Utils.getRandomElement(existingTraversalsWithSameParameters);
                traversalToReplace.setBody(newTraversal.getBody());
                break;
        }

        //System.err.println("DeclareSimpleTraversalMutator:\n" + traversal.toString());
    }

    private CtMethod<?> instantiateTraversalMethod(CtClass<?> ctClass, Path chosenPath) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        CtVariable<?> chosenLoopField = Utils.getRandomElement(loopFields);

        int splitIndex;
        if (chosenPath.size() <= 2) {
            splitIndex = RandomUtils.nextInt(chosenPath.size(), chosenPath.size() + 1);
        } else {
            splitIndex = RandomUtils.nextInt(2, chosenPath.size());
        }
        boolean checkCircular = RandomUtils.nextBoolean();
        return SimpleTraversalTemplate.instantiate(ctClass, chosenPath, chosenLoopField, splitIndex, checkCircular);
    }

}
