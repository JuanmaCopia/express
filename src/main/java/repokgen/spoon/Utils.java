package repokgen.spoon;

import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtStatementList;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

public class Utils {

    public static String methodBodyToString(CtMethod<?> method) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CtStatement statement : method.getBody().getStatements()) {
            stringBuilder.append(statement.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void replace(CtElement e, CtElement op) {
        if (e instanceof CtStatement && op instanceof CtStatement) {
            e.replace(op);
            return;
        }
        if (e instanceof CtExpression && op instanceof CtExpression) {
            e.replace(op);
            return;
        }
        throw new IllegalArgumentException(e.getClass() + " " + op.getClass());
    }

    public static void insertAt(CtStatementList statements, CtBlock<?> block, int position) {
        if (position >= 0 && position < block.getStatements().size())
            throw new IllegalArgumentException("Position must be between 0 and " + (block.getStatements().size() - 1));

        int i = 0;
        while (i < position) {
            i++;
        }
        block.getStatement(i).insertBefore(statements);
    }

    public static void insertAt(CtStatement statement, CtBlock<?> block, int position) {
        if (position >= 0 && position < block.getStatements().size())
            throw new IllegalArgumentException("Position must be between 0 and " + (block.getStatements().size() - 1));

        int i = 0;
        while (i < position) {
            i++;
        }
        block.getStatement(i).insertBefore(statement);
    }

}
