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

public class AddNullCompToTraversalMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!MutatorHelper.isTraversalBlock(gene))
            return false;
        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(gene, LocalVarHelper.CURRENT_VAR_NAME);
        List<Path> candidates = SpoonManager.inputTypeData.getAllReferencePaths(currentDeclaration, 1).stream().filter(p -> p.depth() >= 1).toList();
        return !candidates.isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(blockGene, LocalVarHelper.CURRENT_VAR_NAME);

        List<Path> candidates = SpoonManager.inputTypeData.getAllReferencePaths(currentDeclaration, 1).stream().filter(p -> p.depth() >= 1).toList();

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> condition = SpoonFactory.createNullComparisonClause(chosenVarRead);
        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(blockGene);
        endOfHandleCurrentComment.insertBefore(ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + blockGene);
        return true;
    }


}
