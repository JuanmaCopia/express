package express.object.mutate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.reference.CtTypeReference;

public class ObjectInitializationMutator {

    // TODO: Make it a parameter in the configuration file
    private static final int MAX_PATH_LENGTH = 4;

    // public static boolean mutateForInitialization(Object rootObject) {
    //     List<Path> referencePaths = SpoonManager.getSubjectTypeData().getReferencePaths();
    //     List<Path> candidatePaths = referencePaths.stream().filter(
    //             path -> path.size() > 1 && path.size() < MAX_PATH_LENGTH && Reflection.canBeEvaluated(rootObject, path)
    //     ).toList();
    //     if (candidatePaths.isEmpty()) {
    //         return false;
    //     }

    //     Path chosenPath = RandomUtils.getRandomPath(candidatePaths);
    //     Pair<Field, Object> fieldTuple = Reflection.evaluatePath(rootObject, chosenPath);
    //     Field field = fieldTuple.getLeft();
    //     Object fieldValue = fieldTuple.getRight();

    //     if (fieldValue == null && !TypeUtils.isUserDefinedType(chosenPath.getTypeReference()))
    //         return false;

    //     Object newValue;
    //     if (fieldValue == null) {
    //         try {
    //             newValue = Reflection.createNewReferenceTypeInstance(field.getType());
    //             Reflection.setPathValue(rootObject, chosenPath, newValue);
    //         } catch (NewInstanceCreationException e) {
    //             throw new RuntimeException(e);
    //         }
    //     } else {
    //         newValue = null;
    //     }

    //     Reflection.setPathValue(rootObject, chosenPath, newValue);
    //     return true;
    // }

    public static boolean mutateObject(Object rootObject, int maxPathLength) {
        List<Path> referencePaths = SpoonManager.getSubjectTypeData().getReferencePathsOfMaxLengthK(maxPathLength);
        List<Path> candidatePaths = referencePaths.stream().filter(
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
        Object fieldValue = fieldTuple.getRight();

        CtTypeReference<?> pathType = chosenPath.getTypeReference();
        if (!TypeUtils.isUserDefinedType(pathType))
            return false;

        List<Object> possibleNewValues = new ArrayList<>();

        // Add a fresh instance as possible value
        possibleNewValues.add(createNewInstance(field.getType()));

        if (fieldValue != null)
            // Add null as possible value
            possibleNewValues.add(null);

        List<Path> aliasingTargetPaths = getAliasingTargetPaths(rootObject, candidatePaths, pathType, fieldValue);
        if (!aliasingTargetPaths.isEmpty()) {
            // Add another existent object as possible value
            possibleNewValues.add(getAliasingValue(rootObject, aliasingTargetPaths));
        }

        Object newValue = RandomUtils.getRandomElement(possibleNewValues);

        Reflection.setPathValue(rootObject, chosenPath, newValue);
        return true;
    }

    private static Object createNewInstance(Class<?> instanceType) {
        Object newInstance;
        try {
            newInstance = Reflection.createNewReferenceTypeInstance(instanceType);
        } catch (NewInstanceCreationException e) {
            throw new RuntimeException(e);
        }
        return newInstance;
    }

    private static List<Path> getAliasingTargetPaths(Object rootObject, List<Path> candidatePaths, CtTypeReference pathType, Object currentFieldValue) {
        Set<Path> pathsOfSameType = TypeUtils.filterPathsByType(candidatePaths, pathType);
        List<Path> aliasingTargetPaths = new ArrayList<>();
        for (Path p: pathsOfSameType) {
            Pair<Field, Object> fieldTuple = Reflection.evaluatePath(rootObject, p);
            Object fieldValue = fieldTuple.getRight();
            if (fieldValue != null && fieldValue != currentFieldValue)
                aliasingTargetPaths.add(p);
        }
        aliasingTargetPaths.sort(Comparator.comparing(Path::toString));
        return aliasingTargetPaths;
    }

    private static Object getAliasingValue(Object rootObject, List<Path> aliasingTargetPaths) {
        Path aliasingPathChosen = RandomUtils.getRandomElement(aliasingTargetPaths);
        Pair<Field, Object> fieldTuple = Reflection.evaluatePath(rootObject, aliasingPathChosen);
        Object fieldValue = fieldTuple.getRight();
        return fieldValue;
    }

}
