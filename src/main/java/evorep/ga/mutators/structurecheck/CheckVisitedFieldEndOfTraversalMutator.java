package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.helper.LocalVarHelper;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class CheckVisitedFieldEndOfTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || block != individual.getStructureCheck())
            return false;

        if (block.getElements(SpoonQueries::isTraversalLoop).isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtWhile chosenLoop = (CtWhile) RandomUtils.getRandomElement(blockGene.getElements(SpoonQueries::isTraversalLoop));

        CtLocalVariable<?> visitedSetVar = SpoonQueries.getLocalVarMatchingPrefix(chosenLoop, LocalVarHelper.SET_VAR_NAME);
        if (visitedSetVar == null) {
            System.err.println("ERROR: visitedSetVar is null.");
            return false;
        }

        List<List<CtVariable<?>>> varPath = SpoonQueries.getAllReferencePaths(TypeGraph.getInstance().getRoot(), 1);
        List<CtVariable<?>> chosenVarPath = varPath.get(RandomUtils.nextInt(varPath.size()));
        CtVariableRead<?> chosenVarRead = SpoonFactory.createFieldReadOfRootObject(chosenVarPath);

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.generateNullComparisonClause(chosenVarRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, chosenVarRead);
        CtExpression<Boolean> conjunction = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(nullComparisonClause, addToSetInvocation, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(conjunction, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(conjunction);
        chosenLoop.insertAfter(ifStatement);

        /*System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        System.err.println("Final Block:\n" + blockGene);*/
        return true;
    }


}
