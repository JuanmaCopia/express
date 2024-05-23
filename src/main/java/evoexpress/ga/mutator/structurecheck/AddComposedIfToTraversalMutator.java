package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.Individual;
import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import evoexpress.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddComposedIfToTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        if (block.getElements(SpoonQueries::isTraversalLoop).isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> block = (CtBlock<?>) gene;
        CtWhile chosenLoop = (CtWhile) RandomUtils.getRandomElement(block.getElements(SpoonQueries::isTraversalLoop));
        CtBlock<?> loopBody = (CtBlock<?>) chosenLoop.getBody();

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(chosenLoop, LocalVarHelper.CURRENT_VAR_NAME);

        CtExpression<Boolean> composedCondition = generateComposedCondition(currentDeclaration);
        if (composedCondition == null || SpoonQueries.checkAlreadyExist(composedCondition, loopBody))
            return false;


        CtIf ifStatement = SpoonFactory.createIfReturnFalse(composedCondition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(loopBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);
        return true;
    }

    private CtExpression<Boolean> generateComposedCondition(CtLocalVariable<?> currentDeclaration) {
        TypeGraph typeGraph = TypeGraph.getInstance();
        List<CtVariable<?>> cyclicFields = typeGraph.getSelfCyclicFieldsOfNode(currentDeclaration.getType());

        if (cyclicFields.size() < 2)
            return null;
        List<Integer> chosenIndices = SpoonQueries.generateRandomIntegers(cyclicFields.size() - 1, 2);
        CtVariable<?> chosenField = cyclicFields.get(chosenIndices.get(0));
        CtVariable<?> chosenField2 = cyclicFields.get(chosenIndices.get(1));
        CtVariableRead<?> fieldRead1 = SpoonFactory.createFieldRead(currentDeclaration, chosenField);
        CtVariableRead<?> fieldRead2 = SpoonFactory.createFieldRead(fieldRead1, chosenField2);

        CtExpression<Boolean> clause1 = SpoonFactory.createNullComparisonClause(fieldRead1, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = SpoonFactory.createBooleanBinaryExpression(
                fieldRead2, SpoonFactory.createVariableRead(currentDeclaration), BinaryOperatorKind.NE);

        return SpoonFactory.createBooleanBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);
    }


}
