package evorep.ga.mutators.codegenerators;

import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class StatementGenerator {

    public static CtStatement chooseRandomStatement(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        int random = RandomUtils.nextInt(5);
        return switch (random) {
            case 0 -> AssignmentGenerator.generateRandomAssignment(fields, localVars);
            case 1 -> IfGenerator.chooseIfGenerator(fields, localVars);
            case 2 -> WhileGenerator.chooseWhileGenerator(fields, localVars);
            case 3 -> LocalVarDeclarationGenerator.chooseLocalVarDeclaration(fields, localVars);
            case 4 -> ReturnGenerator.chooseReturnGenerator(fields, localVars);
            default -> throw new RuntimeException("Invalid random number: " + random);
        };
    }
}
