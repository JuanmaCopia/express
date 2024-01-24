package evorep.ga.mutators.codegenerators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class BooleanExpressionGenerator {

    public static CtExpression<Boolean> generateRandomExpression(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {

        CtExpression<Boolean> expression;
        switch (getChoice(fields, localVars)) {
            case 0 -> expression = generateNullComparison(fields, localVars);
            case 1 -> expression = generateCollectionMethodCallExpression(fields, localVars);
            case -1 -> expression = SpoonFactory.getCodeFactory().createLiteral(false);
            default -> throw new RuntimeException("Invalid choice");
        };
        return RandomUtils.negateOrNot(expression);
    }

    public static int getChoice(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {
        List<Integer> filteredChoices = new ArrayList<>();


        if (SpoonQueries.containsVariableOfType(fields, Object.class))
            filteredChoices.add(0);
        if (SpoonQueries.containsVariableOfType(localVars, Object.class))
            filteredChoices.add(1);

        if (filteredChoices.isEmpty())
            return -1;
        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }

    public static CtExpression<Boolean> generateNullComparison(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {
        List<CtVariable<?>> referenceFields = SpoonQueries.getVariablesOfReferenceType(fields);
        List<CtVariable<?>> referenceLocalVars = SpoonQueries.getVariablesOfReferenceType(localVars);
        CtVariable<?> chosenVariable = RandomUtils.getRandomElement(referenceFields, referenceLocalVars);

        CtExpression<?> fieldRead = ReferenceExpressionGenerator.generateRandomVariableAccessRefType(chosenVariable);

        CtExpression<?> nullExpression = SpoonFactory.parseToExpression(null);

        return (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(fieldRead, nullExpression, BinaryOperatorKind.EQ);
    }

    public static CtExpression<Boolean> generateCollectionMethodCallExpression(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {
        CtVariable<?> chosenVar = RandomUtils.getRandomElementOfType(localVars, Collection.class);
        assert chosenVar != null;

        List<CtVariable<?>> allVars = SpoonQueries.getVariablesOfReferenceType(fields);
        allVars.addAll(SpoonQueries.getVariablesOfReferenceType(localVars));

        return (CtExpression<Boolean>)  generateCollectionMethodCallSingleArg(chosenVar,"add", allVars);
    }

    public static CtExpression<Boolean> generateCollectionMethodCallSingleArg(CtVariable<?> collection, String methodName,
            List<CtVariable<?>> scopeVariables) {
        // Get the element type of the set
        CtTypeReference<?> elemType = collection.getReference().getType().getActualTypeArguments().get(0);

        CtExpression<?> argument = ReferenceExpressionGenerator.generateRandomVariableAccessOfType(
                scopeVariables, elemType);

        return (CtExpression<Boolean>)  SpoonFactory.createInvocation(collection, methodName, elemType, argument);
    }


}
