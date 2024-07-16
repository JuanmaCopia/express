package evoexpress.ga.mutator.structurecheck.traversal.init;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class IfNullReturnInTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!MutatorHelper.isTraversalBlock(gene))
            return false;
        CtMethod<?> traversal = gene.getParent(CtMethod.class);
        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        List<Path> paths = SpoonManager.inputTypeData.getAllReferencePaths(traversedElement, 2).stream().filter(p -> p.depth() >= 1).toList();
        return !paths.isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtMethod<?> traversal = blockGene.getParent(CtMethod.class);
        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        List<Path> paths = SpoonManager.inputTypeData.getAllReferencePaths(traversedElement, 2).stream().filter(p -> p.depth() >= 1).toList();
        Path chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> condition = null;
        if (chosenPath.depth() == 1) {
            condition = SpoonFactory.createNullComparisonClause(chosenVarRead);
        } else if (chosenPath.depth() == 2) {
            CtVariableRead<?> owner = chosenPath.getVariableReadOwner();
            condition = SpoonFactory.createBooleanBinaryExpression(
                    SpoonFactory.createNullComparisonClause(owner, BinaryOperatorKind.NE),
                    SpoonFactory.createNullComparisonClause(chosenVarRead),
                    BinaryOperatorKind.AND
            );
        }

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getBeginOfTraversalComment(blockGene);
        comment.insertBefore(ifStatement);

        //System.err.println("\nIfNullReturnInTraversalMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
