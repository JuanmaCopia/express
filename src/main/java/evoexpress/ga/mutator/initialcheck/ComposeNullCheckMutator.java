package evoexpress.ga.mutator.initialcheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;

import java.util.List;

public class ComposeNullCheckMutator implements Mutator {


    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        List<Path> paths = SpoonManager.inputTypeData.getAllReferencePaths(1).stream().filter(p -> p.depth() >= 1).toList();
        return paths.size() > 1 && MutatorHelper.isInitialCheckBlock(gene);
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        List<Path> paths = SpoonManager.inputTypeData.getAllReferencePaths(1).stream().filter(p -> p.depth() >= 1).toList();

        List<Path> chosenVarReads = SpoonQueries.chooseNPaths(paths, 2);
        CtVariableRead<?> var1 = chosenVarReads.get(0).getVariableRead();
        CtVariableRead<?> var2 = chosenVarReads.get(1).getVariableRead();

        CtExpression<Boolean> clause1 = SpoonFactory.createNullComparisonClause(var1);
        CtExpression<Boolean> clause2 = SpoonFactory.createNullComparisonClause(var2);

        CtExpression<Boolean> condition = SpoonFactory.createBooleanBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getReturnTrueComment(blockGene);
        comment.insertBefore(ifStatement);

        //System.err.println("\nAddComposedInitialNullCheckMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}