package evorep.ga.mutators.codegenerators;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class AssignmentGenerator {

    public static CtStatement generateRandomAssignment(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        CtVariable<?> chosenVar = SpoonQueries.getRandomUserDefLocalVar(localVars);
        CtTypeReference<?> varType = chosenVar.getType();

        List<CtVariable<?>> allVars = new ArrayList<>();
        allVars.addAll(fields);
        allVars.addAll(localVars);
        CtExpression<?> chosenFieldRead = ReferenceExpressionGenerator.generateRandomUserDefVarReadOfType(allVars, varType);

        return SpoonFactory.createAssignment(chosenVar, chosenFieldRead);
    }


}
