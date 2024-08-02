package evoexpress.classinvariant.mutator.structurecheck.traversal.array;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.template.ArrayTraversalTemplate;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class TraverseArrayMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        return !SpoonManager.getTypeData().getArrayPaths().isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<Path> pathsToArrays = SpoonManager.getTypeData().getArrayPaths();
        List<Path> paths = pathsToArrays.stream().filter(
                path -> state.getNonTraversedArrays().contains(path.getTypeReference())
        ).toList();

        Path chosenPath;
        if (!paths.isEmpty()) {
            chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
            state.setTypeAsTraversed(chosenPath.getTypeReference());
            ArrayTraversalTemplate.instantiate(state.getCtClass(), chosenPath);
        } else {
            chosenPath = pathsToArrays.get(RandomUtils.nextInt(pathsToArrays.size()));
        }

        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        if (!addTraversalInvocation(chosenPath, state, structureMethodBody)) {
            //System.err.println("TraverseWorklistMutator: Could not add traversal invocation");
            return false;
        }

        System.err.println("TraverseArrayMutator:\n" + state.getCtClass().toString());

        return true;
    }



    private boolean addTraversalInvocation(Path chosenPath, ClassInvariantState state, CtBlock<?> blockGene) {
        CtMethod<?> traversal = SpoonQueries.getTraversalOfArray(state.getCtClass(), chosenPath.getTypeReference());
        assert traversal != null;

        CtVariableRead<?> pathRead = chosenPath.getVariableRead();

        CtExpression<?>[] args = createArguments(traversal.getParameters(), pathRead);
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversal, args);

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(SpoonFactory.negateExpresion(traversalCall));
        if (SpoonQueries.checkAlreadyExistSimple(ifStatement.getCondition(), blockGene))
            return false;

        CtMethod<?> structureMethod = blockGene.getParent(CtMethod.class);
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethod.getBody());
        lastStatement.insertBefore(ifStatement);

        return true;
    }

    private CtExpression<?>[] createArguments(List<CtParameter<?>> params, CtVariableRead pathRead) {
        CtExpression<?>[] args = new CtExpression[params.size()];
        args[0] = SpoonFactory.createVariableRead(params.get(0));
        args[1] = pathRead;
        return args;
    }

}
