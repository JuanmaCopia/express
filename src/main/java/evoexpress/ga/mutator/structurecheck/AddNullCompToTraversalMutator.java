package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtMethod;

public class AddNullCompToTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        if (block.getElements(SpoonQueries::isTraversalLoop).isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
//        CtBlock<?> blockGene = (CtBlock<?>) gene;
//        CtWhile chosenLoop = (CtWhile) RandomUtils.getRandomElement(blockGene.getElements(SpoonQueries::isTraversalLoop));
//        CtBlock<?> loopBody = (CtBlock<?>) chosenLoop.getBody();
//
//        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(chosenLoop, LocalVarHelper.CURRENT_VAR_NAME);
//
//        List<List<CtVariable<?>>> referencePaths = SpoonQueries.getAllReferencePaths(currentDeclaration.getType(), 1);
//        List<CtVariable<?>> chosenPath = referencePaths.get(RandomUtils.nextInt(referencePaths.size()));
//        CtVariableRead<?> chosenVarRead = SpoonFactory.createFieldRead(currentDeclaration, chosenPath.get(0));
//
//        CtExpression<Boolean> condition = SpoonFactory.createNullComparisonClause(chosenVarRead);
//        if (SpoonQueries.checkAlreadyExist(condition, loopBody))
//            return false;
//
//        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
//
//        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(loopBody);
//        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + blockGene);
        return true;
    }


}
