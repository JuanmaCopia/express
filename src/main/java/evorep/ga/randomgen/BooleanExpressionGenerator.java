package evorep.ga.randomgen;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BooleanExpressionGenerator {

    public static CtExpression<Boolean> generateRandomExpression(List<CtVariable<?>> fields,
                                                                 List<CtVariable<?>> localVars) {

        CtExpression<Boolean> expression;
        switch (getChoice(fields, localVars)) {
            case 0 -> expression = generateNullComparison(fields, localVars);
            case 1 -> expression = generateRandomCollectionMethodCallExpression(fields, localVars);
            case -1 -> expression = SpoonFactory.getCodeFactory().createLiteral(false);
            default -> throw new RuntimeException("Invalid choice");
        }
        ;
        return RandomUtils.negateOrNot(expression);
    }

    public static int getChoice(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        List<Integer> filteredChoices = getChoices(fields, localVars);
        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }

    public static List<Integer> getChoices(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        List<Integer> filteredChoices = new ArrayList<>();
        if (SpoonQueries.containsVariableOfType(fields, Object.class))
            filteredChoices.add(0);
        if (SpoonQueries.containsVariableOfType(localVars, Collection.class))
            filteredChoices.add(1);
        if (filteredChoices.isEmpty())
            filteredChoices.add(-1);
        return filteredChoices;
    }

    public static CtExpression<Boolean> generateNullComparison(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        List<CtVariable<?>> referenceFields = SpoonQueries.getVariablesOfReferenceType(fields);
        List<CtVariable<?>> referenceLocalVars = SpoonQueries.getVariablesOfReferenceType(localVars);
        CtVariable<?> chosenVariable = RandomUtils.getRandomElement(referenceFields, referenceLocalVars);

        CtExpression<?> fieldRead = ReferenceExpressionGenerator.generateRandomVarReadRefType(chosenVariable, true);

        CtExpression<?> nullExpression = SpoonFactory.parseToExpression(null);

        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(fieldRead, nullExpression, BinaryOperatorKind.EQ);
    }

    public static CtExpression<Boolean> generateRandomCollectionMethodCallExpression(
            List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars
    ) {

        CtVariable<?> collection = RandomUtils.getRandomElementOfType(localVars, Collection.class);

        List<CtVariable<?>> scopeVariables = new ArrayList<>();
        scopeVariables.addAll(fields);
        scopeVariables.addAll(localVars);
        return generateCollectionMethodCallExpression(collection, "add", scopeVariables);
    }

    public static CtExpression<Boolean> generateCollectionMethodCallExpression(
            CtVariable<?> collection,
            String methodName,
            List<CtVariable<?>> scopeVariables
    ) {
        // The type of the argument of the method call is the type of the elements of the collection
        CtTypeReference<?> argType = collection.getReference().getType().getActualTypeArguments().get(0);

        CtExpression<?> argument = ReferenceExpressionGenerator.generateRandomVarReadOfType(
                scopeVariables, argType);
        return (CtExpression<Boolean>) SpoonFactory.createInvocation(collection, methodName, argType, argument);

    }

    public static CtExpression<Boolean> generateRandomBooleanLiteral() {
        return (CtExpression<Boolean>) SpoonFactory.createLiteral(RandomUtils.nextBoolean());
    }


}
