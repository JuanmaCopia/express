package evorep.ga.randomgen;

import evorep.scope.Scope;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

public class AssignmentGenerator {

    public static CtStatement generateRandomAssignment(Scope scope) {
        CtVariable<?> chosenVar = SpoonQueries.getRandomUserDefLocalVar(scope.getLocalVariables());
        CtExpression<?> chosenFieldRead = ReferenceExpressionGenerator.generateRandomVarReadOfType(
                scope.getAllVariables(),
                chosenVar.getType()
        );
        CtAssignment assignment = SpoonFactory.createAssignment(chosenVar, chosenFieldRead);
        //System.err.println("AssignmentGenerator: " + assignment.toString());
        return assignment;
    }


}
