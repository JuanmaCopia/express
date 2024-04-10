package evorep.ga.mutators.initialcheck;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddComposedInitialNullCheckMutator implements Mutator {


    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || block != individual.getInitialCheck())
            return false;
        return SpoonQueries.getAllReferencePaths(TypeGraph.getInstance().getRoot(), 1).size() > 1;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<List<CtVariable<?>>> variableReads = SpoonQueries.getAllReferencePaths(TypeGraph.getInstance().getRoot(), 1);
        List<List<CtVariable<?>>> chosenVarReads = SpoonQueries.chooseNVariablePaths(variableReads, 2);
        CtVariableRead<?> var1 = SpoonFactory.createFieldReadOfRootObject(chosenVarReads.get(0));
        CtVariableRead<?> var2 = SpoonFactory.createFieldReadOfRootObject(chosenVarReads.get(1));

        CtExpression<Boolean> clause1 = SpoonFactory.generateNullComparisonClause(var1);
        CtExpression<Boolean> clause2 = SpoonFactory.generateNullComparisonClause(var2);

        CtExpression<Boolean> condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement returnTrueComment = SpoonQueries.getReturnTrueComment(blockGene);
        returnTrueComment.insertBefore(ifStatement);

        /*System.err.println("\nAddComposedInitialNullCheckMutator:\n" + ifStatement);
        System.err.println("\nFinal Block:\n\n" + blockGene);*/
        return true;
    }


}
