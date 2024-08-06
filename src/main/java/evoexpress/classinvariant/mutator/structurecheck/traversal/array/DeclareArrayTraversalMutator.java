package evoexpress.classinvariant.mutator.structurecheck.traversal.array;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.template.ArrayTraversalTemplate;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeclareArrayTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> traversedArrayTypes = MutatorHelper.getTraversedArrayTypes(state.getCtClass());
        Set<CtTypeReference<?>>  nonTraversedArrayTypes = new HashSet<>(SpoonManager.getTypeData().getArrayTypes());
        nonTraversedArrayTypes.removeAll(traversedArrayTypes);
        if (nonTraversedArrayTypes.isEmpty()) {
            return false;
        }

        CtTypeReference<?> chosenTypeToTraverse = Utils.getRandomElement(nonTraversedArrayTypes);
        List<Path> paths = SpoonManager.getTypeData().getArrayPaths().stream().filter(
                path -> path.getTypeReference().equals(chosenTypeToTraverse)
        ).toList();

        if (paths.isEmpty()) {
            return false;
        }

        Path chosenPath = Utils.getRandomPath(paths);
        traversal = ArrayTraversalTemplate.instantiate(state.getCtClass(), chosenPath);
        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        state.getCtClass().addMethod(traversal);
        //System.err.println("DeclareArrayTraversalMutator:\n" + traversal.toString());
        return true;
    }

}
