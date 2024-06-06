package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class CheckVisitedFieldEndOfTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
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

        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(SpoonManager.inputTypeData.getInputs().get(0));

        List<Path> varPath = typeGraph.getAllReferencePaths(1);
        Path chosenVarPath = varPath.get(RandomUtils.nextInt(varPath.size()));
        CtVariableRead<?> chosenVarRead = chosenVarPath.getVariableRead();

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.createNullComparisonClause(chosenVarRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, chosenVarRead);
        CtExpression<Boolean> conjunction = SpoonFactory.createBooleanBinaryExpression(
                nullComparisonClause,
                addToSetInvocation,
                BinaryOperatorKind.AND
        );

        if (SpoonQueries.checkAlreadyExist(conjunction, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(conjunction);
        chosenLoop.insertAfter(ifStatement);

        /*System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        System.err.println("Final Block:\n" + blockGene);*/
        return true;
    }


}
