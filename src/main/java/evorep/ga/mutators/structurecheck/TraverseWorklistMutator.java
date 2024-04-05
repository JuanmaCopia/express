package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.TraverseWorklistProcessor;
import evorep.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class TraverseWorklistMutator implements Mutator {

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

        List<CtVariable<?>> loopFields = TypeGraph.getInstance().getSelfCyclicFieldsOfNode(chosenInitialField.getType());

        Processor<CtBlock<?>> p = new TraverseWorklistProcessor(chosenInitialField, loopFields);
        p.process(blockGene);

        //System.err.println("\nTraverseWorklistMutator:\n" + blockGene);

        return true;
    }


}
