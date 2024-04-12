package evoexpress.spoon.generators;

import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtVariableAccess;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class ReferenceExpressionGenerator {

    /**
     * Generates a random variable read of a reference type from the possible reads from the given variable.
     *
     * @param var        the variable from which to consider possible reads.
     * @param includeVar whether to include the variable itself as a possible read
     * @return a random variable read of a reference type
     */
    public static CtVariableAccess generateRandomVarReadRefType(CtVariable<?> var, boolean includeVar) {
        return generateRandomVarReadOfType(var, SpoonFactory.getTypeFactory().OBJECT, includeVar);
    }

    /**
     * Generates a random variable read of the given type from the possible reads from the given variable.
     *
     * @param var        the variable from which to consider possible reads.
     * @param typeRef    the type of the required variable read
     * @param includeVar whether to include the variable itself as a possible read
     * @return a random variable read of the given type
     */
    public static CtVariableAccess generateRandomVarReadOfType(CtVariable<?> var, CtTypeReference<?> typeRef, boolean includeVar) {
        List<CtVariableAccess> varReads = SpoonFactory.createVariableReads(
                var,
                typeRef,
                includeVar
        );

        return varReads.get(RandomUtils.nextInt(varReads.size()));
    }

    /**
     * Generates a random variable read of a reference type from the possible reads from the given variables.
     *
     * @param variables the variables from which to consider possible reads.
     * @param typeRef   the type of the required variable read
     * @return a random variable read of type typeRef.
     */
    public static CtCodeElement generateRandomVarReadOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
        List<CtCodeElement> varReads = generateAllVarReadsOfType(variables, typeRef);
        if (varReads.isEmpty())
            return null;
        return varReads.get(RandomUtils.nextInt(varReads.size()));
    }

    /**
     * Generates all variable reads of the given type from the given variables.
     *
     * @param variables the variables from which to consider possible reads.
     * @param typeRef   the type of the required variable read
     * @return all variable reads of the given type
     */
    public static List<CtCodeElement> generateAllVarReadsOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
        List<CtCodeElement> varReads = new ArrayList<>();
        for (CtVariable<?> var : variables) {
            varReads.addAll(SpoonFactory.createVariableReads(
                    var,
                    typeRef,
                    true
            ));
        }
        return varReads;
    }

    /**
     * Generates a random variable read of a reference type from the possible reads from the given variables.
     *
     * @param variables the variables from which to consider possible reads.
     * @return a random variable read of type typeRef.
     */
    public static CtCodeElement generateRandomVarReadRefType(List<CtVariable<?>> variables) {
        List<CtCodeElement> varReads = generateAllVarReadsOfType(variables, SpoonFactory.getTypeFactory().OBJECT);
        return varReads.get(RandomUtils.nextInt(varReads.size()));
    }

    /**
     * Generates all variable reads of a reference type from the given variables.
     *
     * @param vars the variables from which to consider possible reads.
     * @return all variable reads of a reference type
     */
    public static List<CtCodeElement> generateAllVarReadsOfReferenceType(List<CtVariable<?>> vars) {
        return generateAllVarReadsOfType(vars, SpoonFactory.getTypeFactory().OBJECT);
    }

    /**
     * Generates a random variable write of a reference type from the possible writes from the given variable.
     *
     * @param var        the variable from which to consider possible reads.
     * @param includeVar whether to include the variable itself as a possible write
     * @return a random variable read of a reference type
     */
    public static CtVariableAccess generateRandomVarWriteOfRefType(CtVariable<?> var, boolean includeVar) {
        return generateRandomVarWriteOfType(var, SpoonFactory.getTypeFactory().OBJECT, includeVar);
    }


    /**
     * Generates a random variable write of the given type from the possible writes from the given variable.
     *
     * @param var        the variable from which to consider possible reads.
     * @param typeRef    the type of the required variable read
     * @param includeVar whether to include the variable itself as a possible write
     * @return a random variable read of the given type
     */
    public static CtVariableAccess generateRandomVarWriteOfType(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar
    ) {
        List<CtVariableAccess> varWrites = SpoonFactory.createVariableWrites(
                var,
                typeRef,
                includeVar
        );
        return varWrites.get(RandomUtils.nextInt(varWrites.size()));
    }

    /**
     * Generates a random variable write of the given type from the possible writes from the given variables.
     *
     * @param variables the variables from which to consider possible reads.
     * @param typeRef   the type of the required variable read
     * @return a random variable read of the given type
     */
    public static CtVariableAccess generateRandomVarWriteOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
        List<CtVariableAccess> varWrites = generateAllVarWritesOfType(variables, typeRef);
        return varWrites.get(RandomUtils.nextInt(varWrites.size()));
    }

    /**
     * Generates all variable writes of the given type from the given variables.
     *
     * @param variables the variables from which to consider possible writes.
     * @param typeRef   the type of the required variable write
     * @return all variable writes of the given type
     */
    public static List<CtVariableAccess> generateAllVarWritesOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
        List<CtVariableAccess> varReads = new ArrayList<>();
        for (CtVariable<?> var : variables) {
            varReads.addAll(SpoonFactory.createVariableReads(
                    var,
                    typeRef,
                    true
            ));
        }
        return varReads;

    }

    public static List<CtVariableAccess> generateAllVarWritesOfReferenceType(List<CtVariable<?>> vars) {
        return generateAllVarWritesOfType(vars, SpoonFactory.getTypeFactory().OBJECT);
    }

    public static List<CtVariableRead<?>> generateAllFieldReads(CtVariable<?> var, boolean includeVar) {
        CtTypeReference<?> typeRef = var.getType();
        List<CtVariable<?>> refFields = SpoonQueries.getReferenceFields(var.getType());
        List<CtVariableRead<?>> varReads = new ArrayList<>();

        if (includeVar)
            varReads.add(SpoonFactory.createVariableRead(var));

        for (CtVariable<?> field : refFields) {
            varReads.add(SpoonFactory.createFieldRead(var, field));
        }

        for (CtVariableRead<?> fieldRead : new ArrayList<>(varReads)) {
            for (CtVariable<?> field : SpoonQueries.getFieldsOfType(var, typeRef)) {
                if (!fieldRead.getVariable().equals(field))
                    varReads.add(SpoonFactory.createFieldRead(fieldRead, field));
            }
        }

        return varReads;
    }

    public static List<CtCodeElement> generateAllVarReadsSameType(CtLocalVariable<?> var, List<CtVariable<?>> allVars) {
        List<CtCodeElement> varReads = new ArrayList<>();
        List<CtVariable<?>> allVarsSameType = SpoonQueries.getVariablesOfType(allVars, var.getType());
        for (CtVariable<?> variable : allVarsSameType) {
            varReads.add(SpoonFactory.createVariableRead(variable));
        }
        varReads.addAll(ReferenceExpressionGenerator.generateAllFieldReadsSameType(var, false));
        return varReads;
    }

    public static List<CtVariableRead<?>> generateAllFieldReadsSameType(CtVariable<?> var, boolean includeVar) {
        CtTypeReference<?> typeRef = var.getType();
        List<CtVariable<?>> cyclicFields = SpoonQueries.getFieldsOfType(var, typeRef);
        List<CtVariableRead<?>> varReads = new ArrayList<>();

        if (includeVar)
            varReads.add(SpoonFactory.createVariableRead(var));

        for (CtVariable<?> field : cyclicFields) {
            varReads.add(SpoonFactory.createFieldRead(var, field));
        }

        for (CtVariableRead<?> fieldRead : new ArrayList<>(varReads)) {
            for (CtVariable<?> field : SpoonQueries.getFieldsOfType(var, typeRef)) {
                if (!fieldRead.getVariable().equals(field))
                    varReads.add(SpoonFactory.createFieldRead(fieldRead, field));
            }
        }

        return varReads;
    }

    public static CtVariableRead<?> readDistinctRandomFieldSameType(CtVariableRead<?> varRead) {
        CtVariable<?> var = varRead.getVariable().getDeclaration();
        List<CtVariable<?>> fields = new ArrayList<>(SpoonQueries.getFieldsOfType(var, var.getType()));
        if (fields.size() >= 2) {
            fields.remove(var);
        }
        CtVariable<?> chosenField = fields.get(RandomUtils.nextInt(fields.size()));
        return SpoonFactory.createFieldRead(varRead, chosenField);
    }


}