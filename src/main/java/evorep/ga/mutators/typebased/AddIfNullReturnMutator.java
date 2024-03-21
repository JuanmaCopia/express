package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddIfNullReturnMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getCandidateVarReadsForNullCheck(block, 2).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> variableReads = SpoonQueries.getCandidateVarReadsForNullCheck(blockGene, 2);
        CtVariableRead<?> chosenVarRead = variableReads.get(RandomUtils.nextInt(variableReads.size()));

        CtExpression<Boolean> condition = SpoonFactory.generateNullComparisonClause(chosenVarRead);
        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtStatement endOfInitialChecksComment = SpoonQueries.getEndOfInitialChecksComment(blockGene);
        endOfInitialChecksComment.insertBefore(ifStatement);
        
        return true;
    }


}
