package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class HandleWorlistCycleMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return !block.getElements(SpoonQueries::isLoopOverWorklist).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtWhile chosenLoop = blockGene.getElements(SpoonQueries::isLoopOverWorklist).stream().findAny().get();
        assert chosenLoop.getBody() instanceof CtBlock;
        CtBlock<?> whileBody = (CtBlock<?>) chosenLoop.getBody();
        List<CtBlock<?>> dividedBlocks = SpoonQueries.divideBlocksOfWorklistLoop(whileBody);

        CtBlock<?> handleBlock = dividedBlocks.get(1);
        assert handleBlock != null;

    }


}
