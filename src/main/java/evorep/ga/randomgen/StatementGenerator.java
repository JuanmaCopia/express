package evorep.ga.randomgen;

import evorep.scope.Scope;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;

import java.util.ArrayList;
import java.util.List;

public class StatementGenerator {


    private static List<Integer> getChoices(CtBlock<?> block, Scope scope) {
        List<Integer> choices = new ArrayList<>();
        choices.add(1);
        choices.add(2);

        if (SpoonQueries.getRandomUserDefLocalVar(scope.getLocalVariables()) != null)
            choices.add(Integer.valueOf(0));

        if (!SpoonQueries.getUserDefinedVariables(scope.getFields()).isEmpty())
            choices.add(Integer.valueOf(3));

        if (!SpoonQueries.containsReturnStatement(block))
            choices.add(Integer.valueOf(4));
        return choices;

    }

    public static CtStatement chooseRandomStatement(CtBlock<?> block, Scope scope) {
        List<Integer> choices = getChoices(block, scope);
        int random = choices.get(RandomUtils.nextInt(choices.size()));
        return switch (random) {
            case 0 -> AssignmentGenerator.generateRandomAssignment(scope);
            case 1 -> IfGenerator.chooseIfGenerator(scope);
            case 2 -> WhileGenerator.chooseWhileGenerator(scope);
            case 3 -> LocalVarDeclarationGenerator.chooseLocalVarDeclaration(scope);
            case 4 -> ReturnGenerator.chooseReturnGenerator(scope);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }
}
