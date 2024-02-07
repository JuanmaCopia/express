package evorep.ga.randomgen;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtVariableAccess;
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
    public static CtVariableAccess generateRandomVarReadOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
        List<CtVariableAccess> varReads = generateAllVarReadsOfType(variables, typeRef);
        if (varReads.isEmpty())
            return null;
        return varReads.get(RandomUtils.nextInt(varReads.size()));
    }

    /**
     * Generates a random variable read of a reference type from the possible reads from the given variables.
     *
     * @param variables the variables from which to consider possible reads.
     * @return a random variable read of type typeRef.
     */
    public static CtVariableAccess generateRandomVarReadRefType(List<CtVariable<?>> variables) {
        List<CtVariableAccess> varReads = generateAllVarReadsOfType(variables, SpoonFactory.getTypeFactory().OBJECT);
        return varReads.get(RandomUtils.nextInt(varReads.size()));
    }

    /**
     * Generates all variable reads of a reference type from the given variables.
     *
     * @param vars the variables from which to consider possible reads.
     * @return all variable reads of a reference type
     */
    public static List<CtVariableAccess> generateAllVarReadsOfReferenceType(List<CtVariable<?>> vars) {
        return generateAllVarReadsOfType(vars, SpoonFactory.getTypeFactory().OBJECT);
    }

    /**
     * Generates all variable reads of the given type from the given variables.
     *
     * @param variables the variables from which to consider possible reads.
     * @param typeRef   the type of the required variable read
     * @return all variable reads of the given type
     */
    public static List<CtVariableAccess> generateAllVarReadsOfType(List<CtVariable<?>> variables, CtTypeReference<?> typeRef) {
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


    public static List<CtVariableAccess> generateAllVarWritesOfReferenceType(List<CtVariable<?>> vars) {
        return generateAllVarWritesOfType(vars, SpoonFactory.getTypeFactory().OBJECT);
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


}