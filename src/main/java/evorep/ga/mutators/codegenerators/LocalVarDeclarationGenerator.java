package evorep.ga.mutators.codegenerators;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LocalVarDeclarationGenerator {

    private static int varCount = 0;

    private static String getVarName() {
        return "var" + varCount++;
    }

    public static CtStatement chooseLocalVarDeclaration(List<CtVariable<?>> fields, List<CtVariable<?>> localVars) {
        if (RandomUtils.nextBoolean())
            return generateUserDefinedLocalVarDeclaration(fields, getVarName());
        return generateCollectionLocalVarDeclaration(fields);
    }

    public static CtStatement chooseLocalVarDeclaration(List<CtVariable<?>> fields) {
        return generateUserDefinedLocalVarDeclaration(fields, "var");
    }

    public static CtStatement generateUserDefinedLocalVarDeclaration(List<CtVariable<?>> fields, String varName) {
        List<CtExpression<?>> refFieldReads = ReferenceExpressionGenerator.generateAllUserDefVarReadsOfReferenceType(fields);
        CtVariableRead<?> chosenFieldRead = (CtVariableRead<?>) refFieldReads.get(RandomUtils.nextInt(refFieldReads.size()));
        CtTypeReference<?> fieldType = chosenFieldRead.getVariable().getType();

        return SpoonFactory.createLocalVariable(varName, fieldType, chosenFieldRead);
    }

    public static CtStatement generateCollectionLocalVarDeclaration(List<CtVariable<?>> fields) {
        List<CtVariable<?>> userDefVars = SpoonQueries.getUserDefinedVariables(fields);
        CtVariable<?> chosenVar = userDefVars.get(RandomUtils.nextInt(userDefVars.size()));
        CtTypeReference<?> subtype = chosenVar.getType();

        CtTypeReference<?> collectionType;
        CtConstructorCall<?> constructorCall;
        String varName;
        if (RandomUtils.nextBoolean()) {
            collectionType = SpoonFactory.createTypeWithSubtypeReference(HashSet.class, subtype);
            constructorCall = SpoonFactory.createConstructorCall(collectionType);
            varName = "visited";
        } else {
            collectionType = SpoonFactory.createTypeWithSubtypeReference(LinkedList.class, subtype);
            constructorCall = SpoonFactory.createConstructorCall(collectionType);
            varName = "worklist";
        }

        return SpoonFactory.createLocalVariable(varName, collectionType, constructorCall);
    }
}
