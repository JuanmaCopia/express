package express.classinvariant.mutator.stage2;

import java.util.List;
import java.util.Set;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.ArrayTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.LinkedIdentityHashSet;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;

public class DeclareArrayTraversalMutator implements ClassInvariantMutator {

    List<Path> paths;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> traversedArrayTypes = MutatorHelper.getTraversedArrayTypes(state.getCtClass());
        LinkedIdentityHashSet<CtTypeReference<?>> nonTraversedArrayTypes = new LinkedIdentityHashSet<>(
                SpoonManager.getSubjectTypeData().getArrayTypes());
        nonTraversedArrayTypes.removeAll(traversedArrayTypes);
        if (nonTraversedArrayTypes.isEmpty()) {
            return false;
        }

        CtTypeReference<?> chosenTypeToTraverse = RandomUtils.getRandomElement(nonTraversedArrayTypes);
        paths = SpoonManager.getSubjectTypeData().getArrayPaths().stream().filter(
                path -> TypeUtils.isAssignableArray((CtArrayTypeReference<?>) chosenTypeToTraverse, (CtArrayTypeReference<?>) path.getTypeReference())).toList();

        return !paths.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        Path chosenPath = RandomUtils.getRandomPath(paths);
        CtMethod<?> traversal = ArrayTraversalTemplate.instantiate(state.getCtClass(), chosenPath);
        state.getCtClass().addMethod(traversal);
        // System.err.println("DeclareArrayTraversalMutator:\n" + traversal.toString());
    }

}
