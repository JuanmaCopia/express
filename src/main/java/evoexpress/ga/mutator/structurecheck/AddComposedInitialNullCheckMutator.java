package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddComposedInitialNullCheckMutator implements Mutator {


    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return MutatorHelper.isInitialCheckBlock(gene) || MutatorHelper.isTraversalBlock(gene);
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<Path> paths;
        if (MutatorHelper.isInitialCheckBlock(gene)) {
            paths = SpoonManager.inputTypeData.getAllReferencePaths(1).stream().filter(p -> p.depth() >= 1).toList();
        } else {
            CtMethod<?> traversal = blockGene.getParent(CtMethod.class);
            CtVariable<?> parentOfElement = SpoonQueries.getParentOfElementParameter(traversal);
            paths = SpoonManager.inputTypeData.getAllReferencePaths(parentOfElement, 1).stream().filter(p -> p.depth() >= 1).toList();
        }

        List<Path> chosenVarReads = SpoonQueries.chooseNPaths(paths, 2);
        CtVariableRead<?> var1 = chosenVarReads.get(0).getVariableRead();
        CtVariableRead<?> var2 = chosenVarReads.get(1).getVariableRead();

        CtExpression<Boolean> clause1 = SpoonFactory.createNullComparisonClause(var1);
        CtExpression<Boolean> clause2 = SpoonFactory.createNullComparisonClause(var2);

        CtExpression<Boolean> condition = SpoonFactory.createBooleanBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtStatement comment;
        if (MutatorHelper.isInitialCheckBlock(gene)) {
            comment = SpoonQueries.getReturnTrueComment(blockGene);
        } else {
            comment = SpoonQueries.getBeginOfTraversalComment(blockGene);
        }

        comment.insertBefore(ifStatement);


        //System.err.println("\nAddComposedInitialNullCheckMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}