package evorep.spoon.generators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtVariable;

public class BooleanExpressionGenerator {

    public static CtExpression<Boolean> generateRandomExpression(Scope scope) {

        CtExpression<Boolean> expression;
        switch (getChoice(scope)) {
            case 0 -> expression = generateNullComparison(scope);
            case 1 -> expression = MethodCallGenerator.generateRandomCollectionMethodCallExpression(scope);
            case -1 -> expression = SpoonFactory.getCodeFactory().createLiteral(false);
            default -> throw new RuntimeException("Invalid choice");
        }
        return RandomUtils.negateOrNot(expression);
    }

    public static int getChoice(Scope scope) {
        List<Integer> filteredChoices = getChoices(scope);
        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }

    public static CtExpression<Boolean> generateNullComparison(Scope scope) {
        List<CtVariable<?>> referenceFields = SpoonQueries.getVariablesOfReferenceType(scope.getFields());
        List<CtVariable<?>> referenceLocalVars = SpoonQueries.getVariablesOfReferenceType(scope.getLocalVariables());
        CtVariable<?> chosenVariable = RandomUtils.getRandomElement(referenceFields, referenceLocalVars);

        CtExpression<?> fieldRead = ReferenceExpressionGenerator.generateRandomVarReadRefType(chosenVariable, true);
        CtExpression<?> nullExpression = SpoonFactory.parseToExpression(null);
        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(fieldRead, nullExpression,
                BinaryOperatorKind.EQ);
    }

    public static List<Integer> getChoices(Scope scope) {
        List<Integer> filteredChoices = new ArrayList<>();
        if (SpoonQueries.containsVariableOfType(scope.getFields(), Object.class))
            filteredChoices.add(0);
        if (SpoonQueries.containsVariableOfType(scope.getLocalVariables(), Collection.class)) {
            filteredChoices.add(1);
        }
        if (filteredChoices.isEmpty())
            filteredChoices.add(-1);
        return filteredChoices;
    }

    public static CtExpression<Boolean> generateRandomBooleanLiteral() {
        return (CtExpression<Boolean>) SpoonFactory.createLiteral(RandomUtils.nextBoolean());
    }

    public static CtExpression<Boolean> generateRandomFieldAccessNullComparison(CtVariable<?> var) {
        BinaryOperatorKind operator = RandomUtils.nextBoolean() ? BinaryOperatorKind.EQ : BinaryOperatorKind.NE;
        CtExpression<?> fieldRead = ReferenceExpressionGenerator.generateAllFieldReads(var, false).stream().findAny()
                .get();
        CtExpression<?> nullExpression = SpoonFactory.parseToExpression(null);
        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(fieldRead, nullExpression, operator);
    }

    public static CtExpression<Boolean> createReferenceComparisonSameType(CtLocalVariable<?> var, Scope scope) {
        List<CtCodeElement> varReads = ReferenceExpressionGenerator.generateAllVarReadsSameType(var,
                scope.getAllVariables());

        List<Integer> choices = RandomUtils.getTwoRandomIndices(varReads.size());

        CtCodeElement leftExpr = varReads.get(choices.get(0));
        CtCodeElement rightExpr = varReads.get(choices.get(1));
        BinaryOperatorKind operator = RandomUtils.nextBoolean() ? BinaryOperatorKind.EQ : BinaryOperatorKind.NE;
        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(leftExpr, rightExpr, operator);
    }
}
