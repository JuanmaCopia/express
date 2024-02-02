package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;

public class BlockMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBlock;
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        return null;
    }

/*    public void mutate(CtBlock<?> block, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtStatement newStatement = StatementGenerator.chooseRandomStatement(block, fields, localVariables);
        insertStatement(block, newStatement);
    }

    private void insertStatement(CtBlock<?> block, CtStatement statement) {
        CtStatement randomStatement = RandomUtils.getRandomStatementNonBlockNonExpression(block);
        if (randomStatement != null) {
            if (RandomUtils.nextBoolean())
                randomStatement.insertAfter(statement);
            else
                randomStatement.insertBefore(statement);
        } else {
            block.addStatement(statement);
        }
    }*/
}
