package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddComposedInitialNullCheckMutator implements Mutator {

    public static CtExpression<Boolean> generateNullComparisonClause(CtVariableRead<?> varRead) {
        BinaryOperatorKind operator = RandomUtils.nextBoolean() ? BinaryOperatorKind.EQ : BinaryOperatorKind.NE;
        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(varRead, null, operator);
    }

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return SpoonQueries.getCandidateVarReadsForNullCheck(block).size() > 1;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> variableReads = SpoonQueries.getCandidateVarReadsForNullCheck(blockGene);
        List<CtVariableRead<?>> chosenVarReads = SpoonQueries.chooseNVarReads(variableReads, 2);
        CtVariableRead<?> var1 = chosenVarReads.get(0);
        CtVariableRead<?> var2 = chosenVarReads.get(1);

        CtExpression<Boolean> clause1 = generateNullComparisonClause(var1);
        CtExpression<Boolean> clause2 = generateNullComparisonClause(var2);

        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                clause1, clause2, BinaryOperatorKind.AND);

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtStatement endOfInitialChecksComment = SpoonQueries.getEndOfInitialChecksComment(blockGene);
        endOfInitialChecksComment.insertBefore(ifStatement);

        //System.err.println(blockGene.toString());
    }


}
