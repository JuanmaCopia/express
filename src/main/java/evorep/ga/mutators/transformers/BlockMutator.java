package evorep.ga.mutators.transformers;

import evorep.ga.mutators.codegenerators.StatementGenerator;
import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class BlockMutator {

    public static void mutate(CtBlock<?> block, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        CtStatement newStatement = StatementGenerator.chooseRandomStatement(block, fields, localVariables);
        CtStatement randomStatement = RandomUtils.getRandomStatementNonBlockNonExpression(block);
        if (randomStatement != null)
            randomStatement.insertBefore(newStatement);
        else {
            block.addStatement(newStatement);
        }
    }
}
