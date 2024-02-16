package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.WorklistTraversalProcessor;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class LoopOverWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return SpoonQueries.getNonTraversedWorklists(block).size() > 0;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtLocalVariable<?> chosenWorklist = SpoonQueries.getNonTraversedWorklists(blockGene).stream().findAny().get();
        CtTypeReference<?> subtype = chosenWorklist.getType().getActualTypeArguments().get(0);
        List<CtField<?>> loopFields = SpoonManager.getTypesGraph().getSelfCyclicFieldsOfNode(subtype);

        Processor<CtBlock<?>> p = new WorklistTraversalProcessor(chosenWorklist, loopFields);
        p.process(blockGene);
    }


}
