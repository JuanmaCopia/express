package express.object.mutate;

import express.object.helpers.NewInstanceCreationException;
import express.object.helpers.Reflection;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectInitializationMutator {

    public static boolean mutateForInitialization(Object rootObject) {
        List<Path> referencePaths = SpoonManager.getSubjectTypeData().getReferencePaths();
        List<Path> candidatePaths = referencePaths.stream().filter(
                path -> path.size() > 1 && path.size() < 4 && Reflection.canBeEvaluated(rootObject, path)
        ).toList();
        if (candidatePaths.isEmpty()) {
            return false;
        }

        Path chosenPath = Utils.getRandomPath(candidatePaths);
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
