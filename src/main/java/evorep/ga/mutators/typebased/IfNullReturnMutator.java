package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class IfNullReturnMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getCandidateVarReadsForNullCheck(block).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> variableReads = SpoonQueries.getCandidateVarReadsForNullCheck(blockGene);
        CtVariableRead<?> chosenVarRead = variableReads.get(RandomUtils.nextInt(variableReads.size()));

        BinaryOperatorKind operator = RandomUtils.nextBoolean() ? BinaryOperatorKind.EQ : BinaryOperatorKind.NE;

        CtIf ifStatement = SpoonFactory.createIfThenStatement(
                (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(chosenVarRead, null, operator),
                SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(false))
        );

        blockGene.insertBegin(ifStatement);
    }


}
