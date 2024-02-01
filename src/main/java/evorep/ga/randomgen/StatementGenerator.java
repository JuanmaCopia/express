package evorep.ga.randomgen;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.List;

public class StatementGenerator {


    private static List<Integer> getChoices(CtBlock<?> block, List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        List<Integer> choices = new ArrayList<>();
        choices.add(1);
        choices.add(2);

        if (SpoonQueries.getRandomUserDefLocalVar(localVars) != null)
            choices.add(Integer.valueOf(0));

        if (!SpoonQueries.getUserDefinedVariables(fields).isEmpty())
            choices.add(Integer.valueOf(3));

        if (!SpoonQueries.containsReturnStatement(block))
            choices.add(Integer.valueOf(4));
        return choices;

    }

    public static CtStatement chooseRandomStatement(CtBlock<?> block, List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        List<Integer> choices = getChoices(block, fields, localVars);
        //System.out.println("\nchoices: " + choices);
        int random = choices.get(RandomUtils.nextInt(choices.size()));
        return switch (random) {
            case 0 -> AssignmentGenerator.generateRandomAssignment(fields, localVars);
            case 1 -> IfGenerator.chooseIfGenerator(fields, localVars);
            case 2 -> WhileGenerator.chooseWhileGenerator(fields, localVars);
            case 3 -> LocalVarDeclarationGenerator.chooseLocalVarDeclaration(fields);
            case 4 -> ReturnGenerator.chooseReturnGenerator(fields, localVars);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }
}
