package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddVisitedCheckMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        List<CtWhile> loops = block.getElements(SpoonQueries::isLoopOverWorklist);
        for (CtWhile loop : loops) {
            if (!SpoonQueries.hasVisitedCheckForCurrent(loop))
                return true;
        }
        return false;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtWhile chosenLoop = blockGene.getElements(SpoonQueries::isLoopOverWorklist).stream().findAny().get();
        CtUnaryOperator<?> condition = (CtUnaryOperator<?>) chosenLoop.getLoopingExpression();
        CtInvocation<?> methodInvocation = (CtInvocation<?>) condition.getOperand();
        CtVariableRead<?> setVariableRead = (CtVariableRead<?>) methodInvocation.getTarget();
        CtVariable<?> setVariable = setVariableRead.getVariable().getDeclaration();

        assert chosenLoop.getBody() instanceof CtBlock;
        CtBlock<?> whileBody = (CtBlock<?>) chosenLoop.getBody();
        CtLocalVariable<?> currentVarDeclaration = whileBody.getStatement(0);

        CtIf ifStatement = SpoonFactory.createVisitedCheck(setVariable, currentVarDeclaration);
        currentVarDeclaration.insertAfter(ifStatement);
    }


}
