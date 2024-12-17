package express.object.mutate;

import java.lang.reflect.Field;
import java.util.List;

import express.object.helpers.Collect;
import express.object.helpers.Reflection;
import express.object.helpers.Types;
import express.object.mutate.values.ValueProvider;
import express.spoon.RandomUtils;

public class PrimitiveTypeMutator {

    public static boolean mutatePrimitiveValues(Object rootObject) {
        List<Object> reachableObjects = Collect.collectReachableObjects(rootObject);
        List<Object> candidates = reachableObjects.stream().filter(PrimitiveTypeMutator::isMutableHeapObjectForPrimitiveValues).toList();

        if (candidates.isEmpty())
            return false;

        Object toBeMutated = ReferenceTypeMutator.selectObjectForMutation(candidates);
        return mutatePrimitiveValueOfObject(toBeMutated);
    }

    private static boolean mutatePrimitiveValueOfObject(Object objectToBeMutated) {
        if (Types.isUserDefinedClass(objectToBeMutated.getClass()))
            return mutatePrimitiveField(objectToBeMutated);
        if (Types.isArrayOfPrimitiveType(objectToBeMutated.getClass()))
            return ArrayMutatorUtils.mutateArray(objectToBeMutated, null);

        throw new IllegalArgumentException("Object to be mutated must be a user-defined class or an array of primitive types");
    }

    private static boolean mutatePrimitiveField(Object objectToBeMutated) {
        List<Field> fields = Reflection.getPrimitiveFields(objectToBeMutated);
        if (fields.isEmpty())
            return false;

        Field fieldToMutate = RandomUtils.getRandomElement(fields);

        Reflection.setFieldValue(objectToBeMutated, fieldToMutate, ValueProvider.createNewInstance(fieldToMutate.getType()));
        return true;
    }

    private static boolean isMutableHeapObjectForPrimitiveValues(Object o) {
        if (Types.isArrayOfPrimitiveType(o.getClass()))
            return true;
        if (!Types.isUserDefinedClass(o.getClass()))
            return false;
        return true;
    }

}
