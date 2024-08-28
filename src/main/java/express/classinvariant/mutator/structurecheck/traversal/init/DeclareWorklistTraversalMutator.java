package express.classinvariant.mutator.structurecheck.traversal.init;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.WorklistTraversalTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class DeclareWorklistTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        Set<CtTypeReference<?>> traversedTypes = MutatorHelper.getTraversedTypes(state.getCtClass());
        Set<CtTypeReference<?>> nonTraversedTypes = new HashSet<>(SpoonManager.getSubjectTypeData().getCyclicTypes());
        nonTraversedTypes.removeAll(traversedTypes);
        if (nonTraversedTypes.isEmpty()) {
            return false;
        }

        CtTypeReference<?> chosenTypeToTraverse = Utils.getRandomElement(nonTraversedTypes);
        List<Path> paths = SpoonManager.getSubjectTypeData().getCyclicPaths().stream().filter(
                path -> path.getTypeReference().isSubtypeOf(chosenTypeToTraverse) && TypeUtils.hasOnlyOneCyclicField(path)).toList();

        if (paths.isEmpty()) {
            return false;
        }

        Path chosenPath = Utils.getRandomPath(paths);
        traversal = instantiateTraversalMethod(chosenPath, state);
        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        state.getCtClass().addMethod(traversal);
        //System.err.println("DeclareWorklistTraversalMutator:\n" + traversal.toString());
    }

    private CtMethod<?> instantiateTraversalMethod(Path chosenPath, ClassInvariantState state) {
        List<CtVariable<?>> loopFields = TypeUtils.getCyclicFieldsOfType(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        int splitIndex = RandomUtils.nextInt(1, chosenPath.size() + 1);
        return WorklistTraversalTemplate.instantiate(chosenPath, loopFields, splitIndex);
    }

}
