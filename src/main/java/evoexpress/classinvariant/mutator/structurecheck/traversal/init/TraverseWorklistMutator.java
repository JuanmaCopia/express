package evoexpress.classinvariant.mutator.structurecheck.traversal.init;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
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

public class TraverseWorklistMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<Path> pathsToCyclicNodes = new ArrayList<>(SpoonManager.inputTypeData.getPathsToCyclicNodes());
        List<Path> paths = pathsToCyclicNodes.stream().filter(
                path -> state.getNonTraversedNodesWithCycles().contains(path.getTypeReference())
        ).toList();

        Path chosenPath;
        if (!paths.isEmpty()) {
            chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
            state.setTypeAsTraversed(chosenPath.getTypeReference());
            instantiateTraversalMethod(chosenPath, state);

        } else {
            chosenPath = pathsToCyclicNodes.get(RandomUtils.nextInt(pathsToCyclicNodes.size()));
        }

        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        if (!addTraversalInvocation(chosenPath, state, structureMethodBody)) {
            //System.err.println("TraverseWorklistMutator: Could not add traversal invocation");
            return false;
        }

        //System.err.println("TraverseWorklistMutator:\n" + state.getCtClass().toString());

        return true;
    }

    private void instantiateTraversalMethod(Path chosenPath, ClassInvariantState state) {
        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        boolean useBreakInsteadOfReturn = RandomUtils.nextBoolean();
        boolean useParent = RandomUtils.nextBoolean();
        WorklistTraversalTemplate.instantiate(state.getCtClass(), chosenPath, loopFields, useBreakInsteadOfReturn, useParent);
    }

    private boolean addTraversalInvocation(Path chosenPath, ClassInvariantState state, CtBlock<?> blockGene) {
        CtMethod<?> traversal = SpoonQueries.getTraversalOfNode(state.getCtClass(), chosenPath.getTypeReference());
        assert traversal != null;

        List<CtParameter<?>> params = traversal.getParameters();

        CtVariableRead<?> pathRead;
        if (chosenPath.getTypeReference().equals(params.get(params.size() - 2).getType())) {
            pathRead = chosenPath.getVariableRead();
        } else if (chosenPath.getParentPath().getTypeReference().equals(params.get(params.size() - 2).getType())) {
            pathRead = chosenPath.getParentPath().getVariableRead();
        } else {
            return false;
        }

        CtVariable<?> setVar = handleVisitedSetVariable(blockGene, chosenPath);
        CtExpression<?>[] args = createArguments(traversal.getParameters(), setVar, pathRead);
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversal, args);

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(SpoonFactory.negateExpresion(traversalCall));
        if (SpoonQueries.checkAlreadyExistSimple(ifStatement.getCondition(), blockGene))
            return false;

        CtMethod<?> structureMethod = blockGene.getParent(CtMethod.class);
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethod.getBody());
        lastStatement.insertBefore(ifStatement);

        return true;
    }

    private CtExpression<?>[] createArguments(List<CtParameter<?>> params, CtVariable<?> visitedSetVar, CtVariableRead pathRead) {
        CtExpression<?>[] args = new CtExpression[params.size()];
        args[0] = SpoonFactory.createVariableRead(params.get(0));
        args[1] = pathRead;
        args[2] = SpoonFactory.createVariableRead(visitedSetVar);
        return args;
    }

    private CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody, Path initialField) {
        CtTypeReference<?> cyclicNode = initialField.getTypeReference();
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, cyclicNode);
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }


}
