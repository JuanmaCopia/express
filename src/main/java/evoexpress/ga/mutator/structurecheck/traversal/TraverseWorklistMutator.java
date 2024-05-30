package evoexpress.ga.mutator.structurecheck.traversal;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.processors.traversals.TraverseWorklistProcessor;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import type.typegraph.Path;
import type.typegraph.TypeGraph;

import java.util.List;
import java.util.Set;

public class TraverseWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        return individual.hasNonTraversedPaths();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        Set<Path> paths = individual.getNonTraversedPathsToCyclicNodes();
        Path chosenPath = paths.stream().toList().get(RandomUtils.nextInt(paths.size()));
        paths.remove(chosenPath);

        CtVariableRead<?> chosenInitialField = chosenPath.getVariableRead();

        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(chosenInitialField.getType());

        Processor<CtBlock<?>> p = new TraverseWorklistProcessor(chosenInitialField, loopFields);
        p.process(blockGene);

        //System.err.println("\nTraverseWorklistMutator:\n" + blockGene);

        return true;
    }


}
