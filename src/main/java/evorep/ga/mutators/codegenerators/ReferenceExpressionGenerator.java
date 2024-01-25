package evorep.ga.mutators.codegenerators;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class ReferenceExpressionGenerator {

    public static CtExpression<?> generateRandomVariableAccessRefType(CtVariable<?> var) {
        if (var == null)
            throw new IllegalArgumentException();

        CtType<?> varType = var.getType().getDeclaration();
        if (varType == null)
            // if varType is null, the varType is not in src files (might be a from a library)
            return SpoonFactory.createVariableRead(var);

        List<CtVariable<?>> referenceFields = SpoonQueries.getVariablesOfReferenceType(SpoonQueries.getFields(varType));

        if (RandomUtils.chooseWithProbability(referenceFields.size() + 1))
            return SpoonFactory.createVariableRead(var);

        CtVariable<?> chosenField = RandomUtils.getRandomElement(referenceFields);
        return SpoonFactory.createFieldRead(var, chosenField);
    }

    public static CtExpression<?> generateRandomVarReadOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
        List<CtExpression<?>> varReads = generateAllVarReadsOfType(variables, typeRef);
        return varReads.get(RandomUtils.nextInt(varReads.size()));
    }

    public static List<CtExpression<?>> generateAllVarReadsOfType(List<CtVariable<?>> vars, CtTypeReference<?> typeRef) {
        List<CtExpression<?>> varReads = new ArrayList<>();

        varReads.addAll(
                SpoonQueries.getVariablesOfType(vars, typeRef).stream().map(
                        var -> SpoonFactory.createVariableRead(var)
                ).toList()
        );

        List<CtVariable<?>> refTypedVars = SpoonQueries.getVariablesOfReferenceType(vars);
        for (CtVariable<?> var : refTypedVars) {
            List<CtVariable<?>> fields = SpoonQueries.getFieldsOfType(var, typeRef);
            varReads.addAll(
                    fields.stream().map(
                            field -> SpoonFactory.createFieldRead(var, field)
                    ).toList()
            );
        }

        return varReads;
    }

}