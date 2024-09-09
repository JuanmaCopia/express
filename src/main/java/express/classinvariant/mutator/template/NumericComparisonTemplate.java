package express.classinvariant.mutator.template;

import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.type.typegraph.Path;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;

import java.util.List;

public class NumericComparisonTemplate {

    public static CtExpression<Boolean> instantiateTemplate(Path path1, Path path2, boolean negate) {
        return instantiateTemplate(path1, path2, RandomUtils.getRandomBinaryOperator(), negate);
    }

    public static CtExpression<Boolean> instantiateTemplate(Path path1, Path path2, BinaryOperatorKind operator, boolean negate) {
        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(List.of(path1, path2));

        CtExpression<Boolean> expr = SpoonFactory.createBinaryExpression(path1.getVariableRead(), path2.getVariableRead(), operator);
        if (negate) {
            expr = SpoonFactory.negateExpresion(expr);
        }

        clauses.add(expr);
        return SpoonFactory.conjunction(clauses);
    }


}
