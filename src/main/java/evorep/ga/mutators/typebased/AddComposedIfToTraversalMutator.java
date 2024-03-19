package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.typesgraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddComposedIfToTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        return !block.getElements(SpoonQueries::isTraversalLoop).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> block = (CtBlock<?>) gene;
        CtWhile chosenLoop = (CtWhile) RandomUtils.getRandomElement(block.getElements(SpoonQueries::isTraversalLoop));
        CtBlock<?> loopBody = (CtBlock<?>) chosenLoop.getBody();
        
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getCurrentVarDeclaration(chosenLoop);

        CtExpression<Boolean> composedCondition = generateComposedCondition(currentDeclaration);
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(composedCondition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(loopBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);
    }

    private CtExpression<Boolean> generateComposedCondition(CtLocalVariable<?> currentDeclaration) {
        TypeGraph typeGraph = SpoonManager.getTypeGraph();
        List<CtField<?>> cyclicFields = typeGraph.getSelfCyclicFieldsOfNode(currentDeclaration.getType());

        List<Integer> chosenIndices = SpoonQueries.generateRandomIntegers(cyclicFields.size() - 1, 2);
        CtField<?> chosenField = cyclicFields.get(chosenIndices.get(0));
        CtField<?> chosenField2 = cyclicFields.get(chosenIndices.get(1));
        CtVariableRead<?> fieldRead1 = SpoonFactory.createFieldRead(currentDeclaration, chosenField);
        CtVariableRead<?> fieldRead2 = SpoonFactory.createFieldRead(fieldRead1, chosenField2);

        CtExpression<Boolean> clause1 = SpoonFactory.generateNullComparisonClause(fieldRead1, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                fieldRead2, SpoonFactory.createVariableRead(currentDeclaration), BinaryOperatorKind.NE);

        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);
    }


}
