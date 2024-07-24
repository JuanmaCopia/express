package evoexpress.ga.mutator.primitivecheck;

import evoexpress.ga.helper.LocalVarHelper;
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

import java.util.List;

public class CheckSizeEndOfTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("traverse_"))
            return false;
        if (SpoonQueries.getInitialSizeVariable(block) != null)
            return false;
        return !SpoonManager.inputTypeData.getAllPathsOfType(SpoonFactory.getTypeFactory().integerPrimitiveType(), 2).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        CtMethod<?> traversal = blockGene.getParent(CtMethod.class);

        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        CtVariable<?> visitedSetVar = SpoonQueries.getVisitedSetParameter(traversal);

        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(visitedSetVar, "size");
        CtLocalVariable<?> initialSizeVar = SpoonFactory.createLocalVariable(LocalVarHelper.getInitialSizeVarName(), SpoonFactory.getTypeFactory().INTEGER_PRIMITIVE, sizeInvocation);

        CtExpression<?> leftExpr = SpoonFactory.createBinaryExpression(sizeInvocation, initialSizeVar, BinaryOperatorKind.MINUS);

        List<Path> candidates = SpoonManager.inputTypeData.getAllPathsOfType(traversedElement, SpoonFactory.getTypeFactory().integerPrimitiveType(), 1);
        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(leftExpr, chosenVarRead, BinaryOperatorKind.NE);
        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtStatement beginOfTraversalComment = SpoonQueries.getBeginOfTraversalComment(blockGene);
        beginOfTraversalComment.insertAfter(initialSizeVar);
        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(blockGene);
        endOfTraversalComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + blockGene);
        return true;
    }


}
