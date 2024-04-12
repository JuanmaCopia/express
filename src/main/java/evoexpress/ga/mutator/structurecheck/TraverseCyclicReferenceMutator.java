package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.processors.traversals.TraverseCyclicReferenceProcessor;
import evoexpress.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseCyclicReferenceMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || block != individual.getStructureCheck())
            return false;

        return !SpoonQueries.getNonUsedInitialPathsToCyclicField(block).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<List<CtVariable<?>>> paths = SpoonQueries.getNonUsedInitialPathsToCyclicField(blockGene);
        List<CtVariable<?>> chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
        CtVariableRead<?> chosenInitialField = SpoonFactory.createFieldReadOfRootObject(chosenPath);

        CtTypeReference<?> cyclicNode = chosenInitialField.getVariable().getType();
        List<CtVariable<?>> loopFields = TypeGraph.getInstance().getSelfCyclicFieldsOfNode(cyclicNode);
        CtVariable<?> chosenLoopField = loopFields.get(RandomUtils.nextInt(loopFields.size()));

        Processor<CtBlock<?>> p = new TraverseCyclicReferenceProcessor(chosenInitialField, chosenLoopField);
        p.process(blockGene);

        return true;
    }


}
