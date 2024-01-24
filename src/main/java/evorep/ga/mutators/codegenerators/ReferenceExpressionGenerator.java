package evorep.ga.mutators.codegenerators;

import java.util.LinkedList;
import java.util.List;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class ReferenceExpressionGenerator {

    public static CtExpression<?> generateRandomVariableAccessRefType(List<CtVariable<?>> variables) {
        CtVariable<?> chosenVariable = RandomUtils.getRandomElementOfType(variables, Object.class);
        if (chosenVariable == null)
            return null;
        return generateRandomVariableAccessRefType(RandomUtils.getRandomElementOfType(variables, Object.class));
    }

    public static CtExpression<?> generateRandomVariableAccessRefType(CtVariable<?> var) {
        if (var == null)
            throw new IllegalArgumentException();

        CtType<?> type = var.getType().getDeclaration();
        if (type == null) {
            // if type is null, the type is not in src files (might be a from a library)
            return SpoonFactory.createVariableRead(var);
        }

        List<CtVariable<?>> referenceTypeVars = SpoonQueries.getVariablesOfReferenceType(SpoonQueries.getFields(type));
        referenceTypeVars.add(var);

        CtVariable<?> chosenField = RandomUtils.getRandomElement(referenceTypeVars);
        if (chosenField == var)
            return SpoonFactory.createVariableRead(chosenField);
        return SpoonFactory.createFieldRead(var, chosenField);
    }

    public static CtExpression<?> generateRandomVariableAccessOfType(List<CtVariable<?>> variables,
            CtTypeReference<?> typeRef) {
        LinkedList<CtVariable<?>> filteredVariables = new LinkedList<>();
        for (CtVariable<?> var : variables) {
            if (var.getType().isSubtypeOf(typeRef))
                filteredVariables.add(var);
            else if (SpoonQueries.isReferenceType(var)) {
                CtType<?> type = var.getType().getTypeDeclaration();
                if (type == null)
                    continue;

                List<CtVariable<?>> fields = SpoonQueries.getFields(type);

                for (CtVariable<?> field : fields) {
                    if (field.getType().isSubtypeOf(typeRef)) {
                        filteredVariables.add(var);
                        break;
                    }
                }

            }
        }
        if (filteredVariables.isEmpty())
            return null;

        CtVariable<?> chosenVar = RandomUtils.getRandomElement(filteredVariables);
        if (!SpoonQueries.isReferenceType(chosenVar))
            return SpoonFactory.createVariableRead(chosenVar);
        return generateRandomVariableAccessOfType(chosenVar, typeRef);
    }

    public static CtExpression<?> generateRandomVariableAccessOfType(CtVariable<?> var, CtTypeReference<?> typeRef) {
        if (var == null)
            throw new IllegalArgumentException();

        CtType<?> type = var.getType().getDeclaration();

        List<CtVariable<?>> variables = SpoonQueries.getVariablesOfType(SpoonQueries.getFields(type), typeRef);
        if (var.getType().isSubtypeOf(typeRef))
            variables.add(var);

        CtVariable<?> chosenField = RandomUtils.getRandomElement(variables);
        if (chosenField == var)
            return SpoonFactory.createVariableRead(var);

        return SpoonFactory.createFieldRead(var, chosenField);
    }

}