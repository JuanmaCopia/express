package evoexpress.ga.mutator.structurecheck.traversal;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;

import java.util.List;

public class AddRandomComparisonToCurrent implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!MutatorHelper.isTraversalBlock(gene))
            return false;
        int depth = 2;
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(gene, LocalVarHelper.CURRENT_VAR_NAME);
        List<Path> candidates = SpoonManager.inputTypeData
                .getAllSimpleReferencePathsOfType(currentDeclaration, currentDeclaration.getType(), depth)
                .stream()
                .filter(p -> p.depth() >= depth)
                .toList();
        return !candidates.isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(blockGene, LocalVarHelper.CURRENT_VAR_NAME);

        int depth = 2;
        List<Path> candidates = SpoonManager.inputTypeData
                .getAllSimpleReferencePathsOfType(currentDeclaration, currentDeclaration.getType(), depth)
                .stream()
                .filter(p -> p.depth() >= depth)
                .toList();

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        Path chosenPathOwner = chosenPath.getParentPath();
        Path currentPath = chosenPathOwner.getParentPath();
        CtVariableRead<?> chosenPathRead = chosenPath.getVariableRead();
        CtVariableRead<?> chosenPathReadOwner = chosenPathOwner.getVariableRead();
        CtVariableRead<?> currentRead = currentPath.getVariableRead();

        CtExpression<Boolean> clause1 = SpoonFactory.createNullComparisonClause(chosenPathReadOwner, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = SpoonFactory.createBooleanBinaryExpression(chosenPathRead, currentRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> condition = SpoonFactory.createBooleanBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(blockGene);
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("AddRandomComparisonToCurrent:\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + blockGene);
        return true;
    }


}
