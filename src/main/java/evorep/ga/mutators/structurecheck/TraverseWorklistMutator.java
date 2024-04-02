package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.TraverseWorklistProcessor;
import evorep.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class TraverseWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return !SpoonQueries.getNonTraversedCyclicFieldReads(block).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> varReads = SpoonQueries.getNonTraversedCyclicFieldReads(blockGene);
        CtVariableRead<?> chosenInitialField = varReads.get(RandomUtils.nextInt(varReads.size()));

        List<CtVariable<?>> loopFields = TypeGraph.getInstance().getSelfCyclicFieldsOfNode(chosenInitialField.getType());

        Processor<CtBlock<?>> p = new TraverseWorklistProcessor(chosenInitialField, loopFields);
        p.process(blockGene);

        return true;
    }


}
