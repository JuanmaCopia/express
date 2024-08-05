package evoexpress.classinvariant.mutator.structurecheck.traversal.init;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import evoexpress.util.Utils;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TraverseWorklistMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> traversedTypes = MutatorHelper.getTraversedTypes(state.getCtClass());
        Set<CtTypeReference<?>>  nonTraversedTypes = new HashSet<>(SpoonManager.getTypeData().getCyclicTypes());
        nonTraversedTypes.removeAll(traversedTypes);
        if (nonTraversedTypes.isEmpty()) {
            return false;
        }

        CtTypeReference<?> chosenTypeToTraverse = Utils.getRandomElement(nonTraversedTypes);
        List<Path> paths = SpoonManager.getTypeData().getCyclicPaths().stream().filter(
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
    public boolean mutate(ClassInvariantState state) {
        state.getCtClass().addMethod(traversal);
        //System.err.println("TraverseWorklistMutator:\n" + traversal.toString());
        return true;
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
        return WorklistTraversalTemplate.instantiate(state.getCtClass(), chosenPath, loopFields, useBreakInsteadOfReturn, splitIndex);
    }

}
