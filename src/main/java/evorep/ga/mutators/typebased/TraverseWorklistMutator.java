package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.TraverseWorklistProcessor;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class TraverseWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return !SpoonQueries.getNonTraversedCyclicFieldReads(block).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtVariableRead<?> chosenInitialField = SpoonQueries.getNonTraversedCyclicFieldReads(blockGene).stream().findAny().get();
        List<CtField<?>> loopFields = SpoonManager.getTypeGraph().getSelfCyclicFieldsOfNode(chosenInitialField.getType());

        Processor<CtBlock<?>> p = new TraverseWorklistProcessor(chosenInitialField, loopFields);
        p.process(blockGene);
    }


}
