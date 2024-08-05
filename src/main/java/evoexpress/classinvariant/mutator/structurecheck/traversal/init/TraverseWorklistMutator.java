package evoexpress.classinvariant.mutator.structurecheck.traversal.init;

import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class TraverseWorklistMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        return !SpoonManager.getTypeData().getCyclicPaths().isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<Path> pathsToCyclicNodes = new ArrayList<>(SpoonManager.getTypeData().getCyclicPaths());
        List<Path> paths = pathsToCyclicNodes.stream().filter(
                path -> state.getNonTraversedNodesWithCycles().contains(path.getTypeReference())
        ).toList();

        if (paths.isEmpty()) {
            return false;
        }

        Path chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
        chosenPath = trimPath(chosenPath);
        state.setTypeAsTraversed(chosenPath.getTypeReference());

        CtMethod<?> traversal = instantiateTraversalMethod(chosenPath, state);

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
