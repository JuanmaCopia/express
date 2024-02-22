package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonHelper;
import evorep.spoon.generators.StatementGenerator;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;

import java.util.ArrayList;
import java.util.List;

public class BlockMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return gene instanceof CtBlock<?>;
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        Scope scope = SpoonHelper.getScope(individual, gene);
        CtBlock<?> mutatedGene = (CtBlock<?>) gene.clone();
        CtStatement newStatement = StatementGenerator.chooseRandomStatement(mutatedGene, scope);
        CtStatement selectedStatement = RandomUtils.getRandomStatementNonBlockNonExpression(mutatedGene);
        switch (getChoice(newStatement, selectedStatement)) {
            case 0 -> mutatedGene.addStatement(newStatement);
            case 1 -> selectedStatement.insertBefore(newStatement);
            case 2 -> selectedStatement.insertAfter(newStatement);
            case 3 -> selectedStatement.replace(newStatement);
            case 4 -> mutatedGene.removeStatement(selectedStatement);
            default -> throw new RuntimeException("Invalid choice");
        }
        gene.replace(mutatedGene);
    }

    public static int getChoice(CtStatement newStatement, CtStatement selectedStatement) {
        if (newStatement == null || selectedStatement == null)
            return 0;

        List<Integer> filteredChoices = new ArrayList<>();
        filteredChoices.add(1);
        if (!(selectedStatement instanceof CtReturn)) {
            filteredChoices.add(2);
            filteredChoices.add(3);
            filteredChoices.add(4);
        }
        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }


}
