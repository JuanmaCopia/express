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
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class DeclareWorklistTraversalMutator implements ClassInvariantMutator {

    List<Path> paths;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<CtTypeReference<?>> candidateTypes = SpoonManager.getSubjectTypeData().getCyclicTypes().stream().filter(TypeUtils::hasMultipleLoopFields).toList();
        CtTypeReference<?> chosenType = RandomUtils.getRandomElement(candidateTypes);

        paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> path.getTypeReference().isSubtypeOf(chosenType) && TypeUtils.hasOnlyOneCyclicField(path)).toList();
        return !paths.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Path chosenPath = RandomUtils.getRandomPath(paths);
        CtMethod<?> newTraversal = instantiateTraversalMethod(state.getCtClass(), chosenPath);

        List<CtMethod<?>> existingTraversalsWithSameParameters = MutatorHelper.findTraversalsWithSameParameters(state.getCtClass(), newTraversal);
        int option;
        if (existingTraversalsWithSameParameters.size() > 1) {
            option = RandomUtils.nextInt(1, 4);
        } else if (existingTraversalsWithSameParameters.size() == 1) {
            option = RandomUtils.nextInt(1, 3);
        } else {
            option = 1;
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
                CtMethod<?> traversalToReplace = RandomUtils.getRandomElement(existingTraversalsWithSameParameters);
                traversalToReplace.setBody(newTraversal.getBody());
            case 3:
                CtMethod<Boolean> traversalToUnify = (CtMethod<Boolean>) RandomUtils.getRandomElement(existingTraversalsWithSameParameters);
                existingTraversalsWithSameParameters.remove(traversalToUnify);
                MutatorHelper.unifyTraversals(state.getCtClass(), traversalToUnify, existingTraversalsWithSameParameters);
                break;
        }

        //System.err.println("DeclareWorklistTraversalMutator:\n" + traversal.toString());
    }

    private CtMethod<?> instantiateTraversalMethod(CtClass<?> ctClass, Path chosenPath) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        int splitIndex = chosenPath.size();
        if (chosenPath.size() > 2) {
            splitIndex--;
        }
        return WorklistTraversalTemplate.instantiate(ctClass, chosenPath, loopFields, splitIndex);
    }

}
