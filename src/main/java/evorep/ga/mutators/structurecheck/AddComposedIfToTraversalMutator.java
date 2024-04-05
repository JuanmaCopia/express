package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddComposedIfToTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || block != individual.getStructureCheck())
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

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getCurrentVarDeclaration(chosenLoop);

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

        CtExpression<Boolean> clause1 = SpoonFactory.generateNullComparisonClause(fieldRead1, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                fieldRead2, SpoonFactory.createVariableRead(currentDeclaration), BinaryOperatorKind.NE);

        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);
    }


}
