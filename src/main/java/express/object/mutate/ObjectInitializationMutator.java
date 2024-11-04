package express.object.mutate;

import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectInitializationMutator {

    // TODO: Make it a parameter in the configuration file
    private static final int MAX_PATH_LENGTH = 4;

    public static boolean mutateForInitialization(Object rootObject) {
        List<Path> referencePaths = SpoonManager.getSubjectTypeData().getReferencePaths();
        List<Path> candidatePaths = referencePaths.stream().filter(
                path -> path.size() > 1 && path.size() < MAX_PATH_LENGTH && Reflection.canBeEvaluated(rootObject, path)
        ).toList();
        if (candidatePaths.isEmpty()) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomPath(candidatePaths);
        Pair<Field, Object> fieldTuple = Reflection.evaluatePath(rootObject, chosenPath);
        Field field = fieldTuple.getLeft();
        Object fieldValue = fieldTuple.getRight();

        if (fieldValue == null && !TypeUtils.isUserDefinedType(chosenPath.getTypeReference()))
            return false;

        Object newValue;
        if (fieldValue == null) {
            try {
                newValue = Reflection.createNewReferenceTypeInstance(field.getType());
                Reflection.setPathValue(rootObject, chosenPath, newValue);
            } catch (NewInstanceCreationException e) {
                throw new RuntimeException(e);
            }
        } else {
            newValue = null;
        }

        Reflection.setPathValue(rootObject, chosenPath, newValue);
        return true;
    }

}
