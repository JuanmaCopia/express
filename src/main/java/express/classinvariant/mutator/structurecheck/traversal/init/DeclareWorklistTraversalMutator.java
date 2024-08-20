package express.classinvariant.mutator.structurecheck.traversal.init;

import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.template.WorklistTraversalTemplate;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeclareWorklistTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> traversedTypes = MutatorHelper.getTraversedTypes(state.getCtClass());
        Set<CtTypeReference<?>>  nonTraversedTypes = new HashSet<>(SpoonManager.getSubjectTypeData().getCyclicTypes());
        nonTraversedTypes.removeAll(traversedTypes);
        if (nonTraversedTypes.isEmpty()) {
            return false;
        }

        CtTypeReference<?> chosenTypeToTraverse = Utils.getRandomElement(nonTraversedTypes);
        List<Path> paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> path.getTypeReference().equals(chosenTypeToTraverse)
        ).toList();

        if (paths.isEmpty()) {
            return false;
        }

        Path chosenPath = trimPath(Utils.getRandomPath(paths));
        traversal = instantiateTraversalMethod(chosenPath, state);
        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        state.getCtClass().addMethod(traversal);
        //System.err.println("TraverseWorklistMutator:\n" + traversal.toString());
    }

    private Path trimPath(Path path) {
        CtTypeReference<?> type = path.getTypeReference();
        int i = 0;
        for (CtVariable<?> field : path.getFieldChain()) {
            i++;
            if (field.getType().equals(type) && i < path.size() ) {
                return path.subPath(i);
            }
        }
        return path;
    }

    private CtMethod<?> instantiateTraversalMethod(Path chosenPath, ClassInvariantState state) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        boolean useBreakInsteadOfReturn = RandomUtils.nextBoolean();
        int splitIndex = RandomUtils.nextInt(1, chosenPath.size());
        return WorklistTraversalTemplate.instantiate(chosenPath, loopFields, useBreakInsteadOfReturn, splitIndex);
    }

}
