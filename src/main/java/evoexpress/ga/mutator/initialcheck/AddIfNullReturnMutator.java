package evoexpress.ga.mutator.initialcheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddIfNullReturnMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("initialCheck"))
            return false;

        return SpoonManager.inputTypeData.getAllReferencePaths(2).size() > 1;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<Path> paths = SpoonManager.inputTypeData.getAllReferencePaths(2).stream().filter(p -> p.depth() >= 1).toList();
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
        CtStatement returnTrueComment = SpoonQueries.getReturnTrueComment(blockGene);
        returnTrueComment.insertBefore(ifStatement);

        /*System.err.println("\nAddIfNullReturnMutator:\n" + ifStatement);
        System.err.println("\nFinal Block:\n\n" + blockGene);*/
        return true;
    }


}
