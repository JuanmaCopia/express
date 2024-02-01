package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtBlock;
import spoon.reflect.declaration.CtElement;

public class BlockMutator implements Mutator {

    public boolean isApplicable(CtElement element) {
        return element instanceof CtBlock;
    }

    @Override
    public void mutate(CtElement elementToMutate, Scope scope) {

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
