package evorep.ga.mutators;

import evorep.ga.randomgen.StatementGenerator;
import evorep.scope.Scope;
import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
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
        CtStatement toRemoveStatement = RandomUtils.getRandomStatementNonBlockNonExpressionNonReturn(block);
        switch (getChoice(block, newStatement, toRemoveStatement)) {
            case 0 -> appendRandomStatement(block, scope);
            case 1 -> insertBeforeAStatement(block, newStatement);
            case 2 -> insertAfterAStatement(block, newStatement);
            case 3 -> replaceStatement(block, newStatement, toRemoveStatement);
            case 4 -> removeStatement(block, toRemoveStatement);
            default -> throw new RuntimeException("Invalid choice");
        }
        return block;
    }

    public static int getChoice(CtBlock block, CtStatement newStatement, CtStatement toRemoveStatement) {
        List<Integer> filteredChoices = new ArrayList<>();

        if (newStatement == null)
            filteredChoices.add(0);
        else {
            filteredChoices.add(1);
            filteredChoices.add(2);
            if (toRemoveStatement != null) {
                filteredChoices.add(3);
                filteredChoices.add(4);
            }
        }

        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }


    private void appendRandomStatement(CtBlock<?> block, Scope scope) {
        block.addStatement(StatementGenerator.chooseRandomStatement(block, scope));
    }

    private void insertBeforeAStatement(CtBlock<?> block, CtStatement statement) {
        CtStatement randomStatement = RandomUtils.getRandomStatementNonBlockNonExpression(block);
        if (randomStatement != null)
            randomStatement.insertBefore(statement);
    }

    private void insertAfterAStatement(CtBlock<?> block, CtStatement statement) {
        CtStatement randomStatement = RandomUtils.getRandomStatementNonBlockNonExpressionNonReturn(block);
        if (randomStatement != null)
            randomStatement.insertAfter(statement);
    }

    private void replaceStatement(CtBlock<?> block, CtStatement newStatement, CtStatement toRemoveStatement) {
        toRemoveStatement.replace(newStatement);
    }

    private void removeStatement(CtBlock<?> block, CtStatement toRemoveStatement) {
        block.removeStatement(toRemoveStatement);
    }

}
