package evorep.ga.mutators;

import evorep.scope.Scope;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtCodeElement;

public class AssignmentMutator implements Mutator {

    public boolean isApplicable(CtCodeElement element) {
        return element instanceof CtAssignment;
    }

    @Override
    public void mutate(CtCodeElement elementToMutate, Scope scope) {
        /*if (!isApplicable(elementToMutate))
            throw new RuntimeException("AssignmentMutator is not applicable to " + elementToMutate);
        CtAssignment assignmentToMutate = (CtAssignment) elementToMutate;
        int random = RandomUtils.nextInt(2);
        switch (random) {
            case 0 -> mutateRightOfAssignment(assignmentToMutate, scope);
            case 1 -> mutateLeftOfAssignment(assignmentToMutate, scope);
            default -> throw new RuntimeException("Invalid random number: " + random);
        }*/
    }

/*
    private void mutateRightOfAssignment(CtAssignment assignment, Scope scope) {
        if (assignment.getAssignment() instanceof CtVariableRead<?>) {
            CtVariable<?> var = ((CtVariableRead<?>) assignment.getAssignment()).getVariable().getDeclaration();
            if (SpoonQueries.isUserDefined(var)) {
                CtExpression<?> newAssignment = ReferenceExpressionGenerator.generateRandomUserDefVarReadOfType(scope.getAllVariables(), var.getType());
                assignment.setAssignment(newAssignment);
            }
        }
    }

    private void mutateLeftOfAssignment(CtAssignment assignment, Scope scope) {
        if (assignment.getAssigned() instanceof CtVariableWrite<?>) {
            CtVariable<?> var = ((CtVariableWrite<?>) assignment.getAssigned()).getVariable().getDeclaration();
            if (SpoonQueries.isUserDefined(var)) {
                CtVariable<?> newAssigned = SpoonQueries.getRandomUserDefLocalVar(scope.getAllVariables());
                assignment.setAssigned(SpoonFactory.createVariableWrite(newAssigned));
            }
        }
    }
*/

}
