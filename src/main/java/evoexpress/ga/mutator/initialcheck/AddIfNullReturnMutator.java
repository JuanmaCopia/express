package evoexpress.ga.mutator.initialcheck;

import evoexpress.ga.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import evoexpress.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddIfNullReturnMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || block != individual.getInitialCheck())
            return false;

        return !SpoonQueries.getAllReferencePaths(TypeGraph.getInstance().getRoot(), 2).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<List<CtVariable<?>>> paths = SpoonQueries.getAllReferencePaths(TypeGraph.getInstance().getRoot(), 2);
        List<CtVariable<?>> chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
        CtVariableRead<?> chosenVarRead = SpoonFactory.createFieldReadOfRootObject(chosenPath);

        CtExpression<Boolean> condition = null;
        if (chosenPath.size() == 1) {
            condition = SpoonFactory.createNullComparisonClause(chosenVarRead);
        } else if (chosenPath.size() == 2) {
            CtVariableRead<?> owner = SpoonFactory.createFieldReadOfRootObject(chosenPath.get(0));
            condition = SpoonFactory.createBooleanBinaryExpression(
                    SpoonFactory.createNullComparisonClause(owner, BinaryOperatorKind.NE),
                    SpoonFactory.createNullComparisonClause(chosenVarRead),
                    BinaryOperatorKind.AND
            );
        }

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement returnTrueComment = SpoonQueries.getReturnTrueComment(blockGene);
        returnTrueComment.insertBefore(ifStatement);

        /*System.err.println("\nAddIfNullReturnMutator:\n" + ifStatement);
        System.err.println("\nFinal Block:\n\n" + blockGene);*/
        return true;
    }


}
