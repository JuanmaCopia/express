package evorep.spoon.generators;

import evorep.spoon.scope.Scope;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LocalVarDeclarationGenerator {

    private static int varCount = 0;

    private static String getVarName() {
        return "current";
        //return "var" + varCount++;
    }

    public static CtStatement chooseLocalVarDeclaration(Scope scope) {
        if (RandomUtils.nextBoolean())
            return generateUserDefinedLocalVarDeclaration(scope.getFields(), getVarName());
        return generateCollectionLocalVarDeclaration(scope.getFields());

    }

    public static CtStatement generateUserDefinedLocalVarDeclaration(List<CtVariable<?>> fields, String varName) {
        List<CtVariable<?>> userDefFields = SpoonQueries.getUserDefinedVariables(fields);
        List<CtVariableAccess> refFieldReads = ReferenceExpressionGenerator.generateAllVarReadsOfReferenceType(userDefFields);
        CtVariableRead<?> chosenFieldRead = (CtVariableRead<?>) refFieldReads.get(RandomUtils.nextInt(refFieldReads.size()));
        CtTypeReference<?> fieldType = chosenFieldRead.getVariable().getType();

        CtLocalVariable varDecl = SpoonFactory.createLocalVariable(varName, fieldType, chosenFieldRead);
        //System.err.println("LocalVarDeclarationGenerator: " + varDecl.toString());
        return varDecl;
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
