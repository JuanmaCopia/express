package evorep.spoon.generators;

import evorep.spoon.scope.Scope;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StatementGenerator {


    private static List<Integer> getChoices(CtBlock<?> block, Scope scope) {
        List<Integer> choices = new ArrayList<>();
        choices.add(0);
        choices.add(1);

        if (SpoonQueries.getRandomUserDefLocalVar(scope.getLocalVariables()) != null)
            choices.add(2);
        if (!SpoonQueries.containsReturnStatement(block))
            choices.add(3);
        if (SpoonQueries.containsVariableOfType(scope.getLocalVariables(), Collection.class))
            choices.add(4);
        /*if (!SpoonQueries.getUserDefinedVariables(scope.getFields()).isEmpty())
            choices.add(5);*/

        return choices;
    }

    public static CtStatement chooseRandomStatement(CtBlock<?> block, Scope scope) {
        List<Integer> choices = getChoices(block, scope);
        int random = choices.get(RandomUtils.nextInt(choices.size()));
        return switch (random) {
            case 0 -> IfGenerator.chooseIfGenerator(scope);
            case 1 -> WhileGenerator.chooseWhileGenerator(scope);
            case 2 -> AssignmentGenerator.generateRandomAssignment(scope);
            case 3 -> ReturnGenerator.chooseReturnGenerator(scope);
            case 4 -> MethodCallGenerator.generateAddToCollectionMethodCall(scope);
            //case 5 -> LocalVarDeclarationGenerator.chooseLocalVarDeclaration(scope);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }
}
