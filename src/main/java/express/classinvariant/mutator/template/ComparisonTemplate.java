package express.classinvariant.mutator.template;

import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.type.typegraph.Path;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;

import java.util.List;

public class ComparisonTemplate {

    public static CtExpression<Boolean> instantiateComparableTemplate(Path path1, Path path2) {
        return instantiateTemplate(path1, path2, RandomUtils.getRandomComparableBinaryOperator());
    }

    public static CtExpression<Boolean> instantiateBooleanTemplate(Path path1, Path path2) {
        return instantiateTemplate(path1, path2, RandomUtils.getRandomBooleanBinaryOperator());
    }

    public static CtExpression<Boolean> instantiateTemplate(Path path1, Path path2, BinaryOperatorKind operator) {
        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(List.of(path1, path2));
        CtExpression<Boolean> expr = SpoonFactory.createBinaryExpression(path1.getVariableRead(), path2.getVariableRead(), operator);
        clauses.add(expr);
        return SpoonFactory.conjunction(clauses);
    }

    public static CtExpression<Boolean> instantiateComparableTemplate(Path path1, CtExpression<?> variableRead) {
        return instantiateTemplate(path1, variableRead, RandomUtils.getRandomComparableBinaryOperator());
    }

    public static CtExpression<Boolean> instantiateBooleanTemplate(Path path1, CtExpression<?> variableRead) {
        return instantiateTemplate(path1, variableRead, RandomUtils.getRandomBooleanBinaryOperator());
    }

    public static CtExpression<Boolean> instantiateTemplate(Path path1, CtExpression<?> variableRead, BinaryOperatorKind operator) {
        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(List.of(path1));
        CtExpression<Boolean> expr = SpoonFactory.createBinaryExpression(path1.getVariableRead(), variableRead, operator);
        clauses.add(expr);
        return SpoonFactory.conjunction(clauses);
    }


}
