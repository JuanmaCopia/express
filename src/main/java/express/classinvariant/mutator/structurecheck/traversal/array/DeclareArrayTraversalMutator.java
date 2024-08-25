package express.classinvariant.mutator.structurecheck.traversal.array;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.ArrayTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonManager;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeclareArrayTraversalMutator implements ClassInvariantMutator {

    List<Path> paths;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> traversedArrayTypes = MutatorHelper.getTraversedArrayTypes(state.getCtClass());
        Set<CtTypeReference<?>> nonTraversedArrayTypes = new HashSet<>(SpoonManager.getSubjectTypeData().getArrayTypes());
        nonTraversedArrayTypes.removeAll(traversedArrayTypes);
        if (nonTraversedArrayTypes.isEmpty()) {
            return false;
        }

        CtTypeReference<?> chosenTypeToTraverse = Utils.getRandomElement(nonTraversedArrayTypes);
        paths = SpoonManager.getSubjectTypeData().getArrayPaths().stream().filter(
                path -> path.getTypeReference().equals(chosenTypeToTraverse)
        ).toList();

        return !paths.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Path chosenPath = Utils.getRandomPath(paths);
        CtMethod<?> traversal = ArrayTraversalTemplate.instantiate(state.getCtClass(), chosenPath);
        state.getCtClass().addMethod(traversal);
        //System.err.println("DeclareArrayTraversalMutator:\n" + traversal.toString());
    }

}
