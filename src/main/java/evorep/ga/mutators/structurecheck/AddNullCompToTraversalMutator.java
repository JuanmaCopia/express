package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.helper.LocalVarHelper;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddNullCompToTraversalMutator implements Mutator {

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
        CtBlock<?> loopBody = (CtBlock<?>) chosenLoop.getBody();

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(chosenLoop, LocalVarHelper.CURRENT_VAR_NAME);

        List<List<CtVariable<?>>> referencePaths = SpoonQueries.getAllReferencePaths(currentDeclaration.getType(), 1);
        List<CtVariable<?>> chosenPath = referencePaths.get(RandomUtils.nextInt(referencePaths.size()));
        CtVariableRead<?> chosenVarRead = SpoonFactory.createFieldRead(currentDeclaration, chosenPath.get(0));

        CtExpression<Boolean> condition = SpoonFactory.generateNullComparisonClause(chosenVarRead);
        if (SpoonQueries.checkAlreadyExist(condition, loopBody))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(loopBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + blockGene);
        return true;
    }


}
