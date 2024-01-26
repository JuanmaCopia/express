package evorep.ga.mutators.codegenerators;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class LocalVarDeclarationGenerator {

    public static CtStatement generateRandomLocalVarDeclaration(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static CtStatement generateUserDefinedLocalVarDeclaration(List<CtVariable<?>> fields, String varName) {
        List<CtExpression<?>> refFieldReads = ReferenceExpressionGenerator.generateAllUserDefVarReadsOfReferenceType(fields);
        CtVariableRead<?> chosenFieldRead = (CtVariableRead<?>) refFieldReads.get(RandomUtils.nextInt(refFieldReads.size()));
        CtTypeReference<?> fieldType = chosenFieldRead.getVariable().getType();

        return SpoonFactory.createLocalVariable(varName, fieldType, chosenFieldRead);
    }

    public static CtStatement generateCollectionLocalVarDeclaration() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
