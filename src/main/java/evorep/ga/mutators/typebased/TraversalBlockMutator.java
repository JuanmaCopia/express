package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtMethod;

public class TraversalBlockMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return !block.getElements(SpoonQueries::isTraversalLoop).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtWhile chosenLoop = (CtWhile) blockGene.getElements(SpoonQueries::isTraversalLoop).stream().findAny().get();
        CtBlock<?> handleBlock = SpoonQueries.getBlockOfHandleCurrent((CtBlock<?>) chosenLoop.getBody());

    }


}
