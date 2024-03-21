package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class CheckVisitedFieldEndOfTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getTraversalBlocks(block).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<List<CtStatement>> traversalBlocks = SpoonQueries.getTraversalBlocks(blockGene);
        List<CtStatement> chosenTraversalStatements = traversalBlocks.get(RandomUtils.nextInt(traversalBlocks.size()));

        List<CtVariableRead<?>> varReads = SpoonQueries.getCandidateVarReadsForNullCheck(blockGene, 1);
        CtVariableRead<?> chosenVarRead = varReads.get(RandomUtils.nextInt(varReads.size()));

        CtLocalVariable<?> visitedSetVar = SpoonQueries.getVisitedSet(chosenTraversalStatements);
        if (visitedSetVar == null) {
            System.err.println("ERROR: visitedSetVar is null.");
            System.err.println("\n\nchosenTraversalStatements:\n\n" + chosenTraversalStatements.toString());
            return false;
        }
        CtIf ifStatement = SpoonFactory.createVisitedCheck(visitedSetVar, chosenVarRead);

        CtComment endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(chosenTraversalStatements);
        endOfTraversalComment.insertBefore(ifStatement);

        /*System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        System.err.println("Final Block:\n" + blockGene);*/
        return true;
    }


}
