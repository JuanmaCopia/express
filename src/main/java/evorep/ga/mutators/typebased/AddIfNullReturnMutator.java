package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.typesgraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddIfNullReturnMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getCandidateVarReadsForNullCheck(block, 2).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        TypeGraph typesGraph = SpoonManager.getTypeGraph();
        List<List<CtField<?>>> paths = typesGraph.getAllPaths(typesGraph.getRoot(), 2);
        List<CtField<?>> chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
        CtVariableRead<?> chosenVarRead = SpoonFactory.createFieldRead(chosenPath);

        CtExpression<Boolean> condition = null;
        if (chosenPath.size() == 1) {
            condition = SpoonFactory.generateNullComparisonClause(chosenVarRead);
        } else if (chosenPath.size() == 2) {
            condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(
                    SpoonFactory.generateNullComparisonClause(SpoonFactory.createFieldRead(chosenPath.get(0)), BinaryOperatorKind.NE),
                    SpoonFactory.generateNullComparisonClause(chosenVarRead),
                    BinaryOperatorKind.AND);
        }

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement endOfInitialChecksComment = SpoonQueries.getEndOfInitialChecksComment(blockGene);
        endOfInitialChecksComment.insertBefore(ifStatement);

        //System.err.println("\nAddIfNullReturnMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
