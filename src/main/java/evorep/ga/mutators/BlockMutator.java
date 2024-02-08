package evorep.ga.mutators;

import evorep.ga.randomgen.StatementGenerator;
import evorep.scope.Scope;
import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;

import java.util.ArrayList;
import java.util.List;

public class BlockMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBlock<?>;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtBlock<?> block = (CtBlock<?>) gene.clone();
        CtStatement newStatement = StatementGenerator.chooseRandomStatement(block, scope);
        CtStatement selectedStatement = RandomUtils.getRandomStatementNonBlockNonExpression(block);
        switch (getChoice(newStatement, selectedStatement)) {
            case 0 -> block.addStatement(newStatement);
            case 1 -> selectedStatement.insertBefore(newStatement);
            case 2 -> selectedStatement.insertAfter(newStatement);
            case 3 -> selectedStatement.replace(newStatement);
            case 4 -> block.removeStatement(selectedStatement);
            default -> throw new RuntimeException("Invalid choice");
        }
        return block;
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
