package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

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

        List<List<CtVariable<?>>> varPath = SpoonQueries.getCandidateVarReadsForNullCheck(1);
        List<CtVariable<?>> chosenVarPath = varPath.get(RandomUtils.nextInt(varPath.size()));
        CtVariableRead<?> chosenVarRead = SpoonFactory.createFieldReadOfRootObject(chosenVarPath);

        CtLocalVariable<?> visitedSetVar = SpoonQueries.getVisitedSet(chosenTraversalStatements);
        if (visitedSetVar == null) {
            System.err.println("ERROR: visitedSetVar is null.");
            System.err.println("\n\nchosenTraversalStatements:\n\n" + chosenTraversalStatements.toString());
            return false;
        }

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.generateNullComparisonClause(chosenVarRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, chosenVarRead);
        CtExpression<Boolean> conjuntion = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(nullComparisonClause, addToSetInvocation, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(conjuntion, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(conjuntion);

        CtComment endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(chosenTraversalStatements);
        if (endOfTraversalComment == null) {
            System.err.println("ERROR: endOfTraversalComment is null.");
            System.err.println("\n\nchosenTraversalStatements:\n\n" + chosenTraversalStatements.toString());
            return false;
        }
        endOfTraversalComment.insertBefore(ifStatement);

        /*System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        System.err.println("Final Block:\n" + blockGene);*/
        return true;
    }


}
