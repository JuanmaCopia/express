package evoexpress.ga.mutator.structurecheck.traversal.inner;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedFieldEndOfTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("traverse_"))
            return false;

        return true;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtVariable<?> visitedSetVar = SpoonQueries.getVisitedSetParameter(blockGene.getParent(CtMethod.class));
        CtTypeReference<?> setSubType = visitedSetVar.getType().getActualTypeArguments().get(0);

        List<Path> candidates = SpoonManager.inputTypeData.getAllReferencePathsOfType(setSubType, 1).stream().filter(p -> p.depth() >= 1).toList();

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

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

        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(blockGene);
        endOfTraversalComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + blockGene);
        return true;
    }


}
