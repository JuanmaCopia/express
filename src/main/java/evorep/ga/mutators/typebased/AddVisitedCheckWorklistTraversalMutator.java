package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.Set;

public class AddVisitedCheckWorklistTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        Set<CtTypeReference<?>> cyclicNodes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();
        List<CtWhile> loops = block.getElements(SpoonQueries::isLoopOverWorklist);
        for (CtWhile loop : loops) {
            CtBlock<?> whileBody = (CtBlock<?>) loop.getBody();
            CtLocalVariable<?> currentVarDeclaration = whileBody.getStatement(0);
            CtTypeReference<?> subtype = currentVarDeclaration.getType();
            List<CtLocalVariable<?>> setVariables = block.getElements(var -> SpoonQueries.isVisitedSet(var, subtype, cyclicNodes));
            if (!setVariables.isEmpty()) {
                if (!SpoonQueries.hasVisitedCheckForCurrent(loop))
                    return true;
            }

        }
        return false;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        Set<CtTypeReference<?>> cyclicNodes = SpoonManager.getTypesGraph().getNodesWithSelfCycles();

        CtWhile chosenLoop = blockGene.getElements(SpoonQueries::isLoopOverWorklist).stream().findAny().get();
        assert chosenLoop.getBody() instanceof CtBlock;
        CtBlock<?> whileBody = (CtBlock<?>) chosenLoop.getBody();
        CtLocalVariable<?> currentVarDeclaration = whileBody.getStatement(0);

        CtTypeReference<?> subtype = currentVarDeclaration.getType();
        List<CtLocalVariable<?>> setVariables = blockGene.getElements(var -> SpoonQueries.isVisitedSet(var, subtype, cyclicNodes));
        CtLocalVariable<?> chosenSetVariable = setVariables.stream().findAny().get();

        CtIf ifStatement = SpoonFactory.createVisitedCheck(chosenSetVariable, currentVarDeclaration);

        CtComment handleCurrentComment = (CtComment) whileBody.getElements(SpoonQueries::isEndOfHandleCurrent).get(0);

        handleCurrentComment.insertBefore(ifStatement);
    }


}
