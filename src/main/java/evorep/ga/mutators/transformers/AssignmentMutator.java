package evorep.ga.mutators.transformers;

import evorep.ga.mutators.codegenerators.ReferenceExpressionGenerator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.code.CtVariableWrite;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.List;

public class AssignmentMutator {

    public static void mutate(CtAssignment assignment, List<CtVariable<?>> fields, List<CtVariable<?>> localVariables) {
        List<CtVariable<?>> allVars = new ArrayList<>();
        allVars.addAll(fields);
        allVars.addAll(localVariables);

        int random = RandomUtils.nextInt(2);
        switch (random) {
            case 0 -> mutateRightOfAssignment(assignment, allVars);
            case 1 -> mutateLeftOfAssignment(assignment, allVars);
            default -> throw new RuntimeException("Invalid random number: " + random);
        }
    }

    private static void mutateRightOfAssignment(CtAssignment assignment, List<CtVariable<?>> allVars) {
        if (assignment.getAssignment() instanceof CtVariableRead<?>) {
            CtVariable<?> var = ((CtVariableRead<?>) assignment.getAssignment()).getVariable().getDeclaration();
            if (SpoonQueries.isUserDefined(var)) {
                CtExpression<?> newAssignment = ReferenceExpressionGenerator.generateRandomUserDefVarReadOfType(allVars, var.getType());
                assignment.setAssignment(newAssignment);
            }
        }
    }

    private static void mutateLeftOfAssignment(CtAssignment assignment, List<CtVariable<?>> allVars) {
        if (assignment.getAssigned() instanceof CtVariableWrite<?>) {
            CtVariable<?> var = ((CtVariableWrite<?>) assignment.getAssigned()).getVariable().getDeclaration();
            if (SpoonQueries.isUserDefined(var)) {
                CtVariable<?> newAssigned = SpoonQueries.getRandomUserDefLocalVar(allVars);
                assignment.setAssigned(SpoonFactory.createVariableWrite(newAssigned));
            }
        }
    }

}
