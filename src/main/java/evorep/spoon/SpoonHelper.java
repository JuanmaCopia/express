package evorep.spoon;

import spoon.reflect.code.CtVariableAccess;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SpoonHelper {

    public static List<CtVariableAccess> createVariableWrites(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar
    ) {
        return createVariableAccesses(
                var,
                typeRef,
                includeVar,
                SpoonFactory::createVariableWrite,
                SpoonFactory::createFieldWrite
        );
    }

    public static List<CtVariableAccess> createVariableReads(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar
    ) {
        return createVariableAccesses(
                var,
                typeRef,
                includeVar,
                SpoonFactory::createVariableRead,

                SpoonFactory::createFieldRead
        );
    }

    /**
     * Creates a list of variable accesses of the given type from the given variable.
     *
     * @param var               the variable from which to consider possible reads.
     * @param typeRef           the type of the required variable read
     * @param createFieldAccess the function to create the variable access
     * @return a list of variable accesses of the given type
     */
    public static List<CtVariableAccess> createVariableAccesses(
            CtVariable<?> var,
            CtTypeReference<?> typeRef,
            boolean includeVar,
            Function<CtVariable<?>, CtVariableAccess> createVariableAccess,
            BiFunction<CtVariable<?>, CtVariable<?>, CtVariableAccess> createFieldAccess
    ) {
        List<CtVariableAccess> varAccesses = new ArrayList<>();
        if (includeVar && var.getType().isSubtypeOf(typeRef))
            varAccesses.add(createVariableAccess.apply(var));

        varAccesses.addAll(SpoonQueries.getFieldsOfType(var, typeRef).stream().map(
                field -> createFieldAccess.apply(var, field)
        ).toList());
        return varAccesses;
    }

}
