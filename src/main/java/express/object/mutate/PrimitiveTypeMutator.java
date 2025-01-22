package express.object.mutate;

import express.object.helpers.Collect;
import express.object.helpers.Reflection;
import express.object.helpers.Types;
import express.object.mutate.values.ValueProvider;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrimitiveTypeMutator {

    public static boolean mutatePrimitiveValuesByPath(Object rootObject, int maxPathLength) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getPathsOfMaxLengthK(maxPathLength);
        List<Path> candidatePaths = TypeUtils.filterPaths(paths, TypeUtils::isPrimitiveOrBoxedPrimitiveType).stream().filter(
                path -> path.size() >= 2 && Reflection.canBeEvaluated(rootObject, path)
        ).collect(Collectors.toList());
        candidatePaths.sort(Comparator.comparing(Path::toString));
        if (candidatePaths.isEmpty()) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomElement(candidatePaths);
        candidatePaths.remove(chosenPath);

        Pair<Field, Object> fieldTuple = Reflection.evaluatePath(rootObject, chosenPath);
        Field field = fieldTuple.getLeft();

        Class<?> fieldType = field.getType();
        Object newValue = ValueProvider.createNewInstance(fieldType);

        Reflection.setPathValue(rootObject, chosenPath, newValue);
        return true;
    }

    public static boolean mutatePrimitiveValuesByObjects(Object rootObject) {
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
