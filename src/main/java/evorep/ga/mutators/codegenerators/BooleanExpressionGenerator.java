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

    Random random = new Random();

    int TOTAL_NUMBER_CHOICES = 2;

    public CtExpression<?> generateRandomExpression(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {

        List<Integer> choices = filterChoices(fields, localVars);

        int choice = choices.get(random.nextInt(choices.size()));

        switch (choice) {
            case 0:
                return generateNullComparison(fields, localVars);
            case 1:
                return generateCollectionMethodCallExpression(fields, localVars);
            default:
                throw new RuntimeException("Invalid choice");
        }

    }

    public List<Integer> filterChoices(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {
        List<Integer> filteredChoices = new ArrayList<>();

        if (!fields.isEmpty()) {
            for (CtVariable<?> field : fields) {
                if (field.getType().isSubtypeOf(field.getFactory().Type().createReference(Object.class))) {
                    filteredChoices.add(0);
                    break;
                }
            }
        }
        if (!localVars.isEmpty()) {
            for (CtVariable<?> vars : localVars) {
                if (vars.getType().isSubtypeOf(vars.getFactory().Type().createReference(List.class)) ||
                        vars.getType().isSubtypeOf(vars.getFactory().Type().createReference(Set.class))) {
                    filteredChoices.add(1);
                    break;
                }
            }
        }

        return filteredChoices;
    }

    public CtExpression<?> generateNullComparison(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {
        List<CtVariable<?>> referenceFields = SpoonQueries.getVariablesOfReferenceType(fields);
        List<CtVariable<?>> referenceLocalVars = SpoonQueries.getVariablesOfReferenceType(localVars);
        CtVariable<?> chosenVariable = RandomUtils.getRandomElement(referenceFields, referenceLocalVars);

        CtExpression<?> fieldRead = ReferenceExpressionGenerator.generateRandomVariableAccessRefType(chosenVariable);

        CtLiteral<?> nullExpression = fieldRead.getFactory().Code().createLiteral(null);

        return SpoonFactory.createBinaryExpression(fieldRead, nullExpression, BinaryOperatorKind.NE);
    }

    public CtExpression<?> generateCollectionMethodCallExpression(List<CtVariable<?>> fields,
            List<CtVariable<?>> localVars) {
        CtVariable<?> chosenVar = RandomUtils.getRandomElementOfType(localVars, Collection.class);

        List<CtVariable<?>> allVars = SpoonQueries.getVariablesOfReferenceType(fields);
        allVars.addAll(SpoonQueries.getVariablesOfReferenceType(localVars));

        CtTypeReference<?> varType = chosenVar.getType();
        if (varType.isSubtypeOf(chosenVar.getFactory().Type().createReference(List.class)))
            return generateListMethodCallExpression(chosenVar, allVars);
        if (varType.isSubtypeOf(chosenVar.getFactory().Type().createReference(Set.class)))
            return generateSetMethodCallExpression(chosenVar, allVars);
        assert false;
        return null;
    }

    public CtExpression<?> generateListMethodCallExpression(CtVariable<?> listVariable,
            List<CtVariable<?>> scopeVariables) {
        // Get the element type of the set
        CtTypeReference<?> elemType = listVariable.getReference().getType().getActualTypeArguments().get(0);

        CtExpression<?> argument = ReferenceExpressionGenerator.generateRandomVariableAccessOfType(
                scopeVariables, elemType);

        return SpoonFactory.createInvocation(
                listVariable,
                "add",
                Collections.singletonList(elemType),
                Collections.singletonList(argument));
    }

    public CtExpression<?> generateSetMethodCallExpression(CtVariable<?> setVariable,
            List<CtVariable<?>> scopeVariables) {
        // Get the element type of the set
        CtTypeReference<?> elemType = setVariable.getReference().getType().getActualTypeArguments().get(0);

        CtExpression<?> argument = ReferenceExpressionGenerator.generateRandomVariableAccessOfType(
                scopeVariables, elemType);

        return SpoonFactory.createInvocation(
                setVariable,
                "add",
                Collections.singletonList(elemType),
                Collections.singletonList(argument));

    }

}
