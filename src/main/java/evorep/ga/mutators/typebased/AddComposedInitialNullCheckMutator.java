package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddComposedInitialNullCheckMutator implements Mutator {


    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return SpoonQueries.getCandidateVarReadsForNullCheck(block, 1).size() > 1;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> variableReads = SpoonQueries.getCandidateVarReadsForNullCheck(blockGene, 1);
        List<CtVariableRead<?>> chosenVarReads = SpoonQueries.chooseNVarReads(variableReads, 2);
        CtVariableRead<?> var1 = chosenVarReads.get(0);
        CtVariableRead<?> var2 = chosenVarReads.get(1);

        CtExpression<Boolean> clause1 = SpoonFactory.generateNullComparisonClause(var1);
        CtExpression<Boolean> clause2 = SpoonFactory.generateNullComparisonClause(var2);

        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtStatement endOfInitialChecksComment = SpoonQueries.getEndOfInitialChecksComment(blockGene);
        endOfInitialChecksComment.insertBefore(ifStatement);

        return true;
    }


}
