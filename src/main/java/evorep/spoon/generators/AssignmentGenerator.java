package evorep.spoon.generators;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;

public class AssignmentGenerator {

    public static CtStatement generateRandomAssignment(Scope scope) {
        CtVariable<?> chosenVar = SpoonQueries.getRandomUserDefLocalVar(scope.getLocalVariables());
        CtExpression<?> chosenFieldRead = (CtExpression<?>) ReferenceExpressionGenerator.generateRandomVarReadOfType(
                scope.getAllVariables(),
                chosenVar.getType()
        );
        CtAssignment assignment = SpoonFactory.createAssignment(chosenVar, chosenFieldRead);
        //System.err.println("AssignmentGenerator: " + assignment.toString());
        return assignment;
    }


}
