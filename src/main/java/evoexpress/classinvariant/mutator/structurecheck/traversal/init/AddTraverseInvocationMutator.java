package evoexpress.classinvariant.mutator.structurecheck.traversal.init;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.template.WorklistTraversalTemplate;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class AddTraverseInvocationMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        return !MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));
        CtVariable<?> initialElement = SpoonQueries.getTraversalInitialElementParameter(traversal);

        TypeGraph typeGraph = SpoonManager.getTypeData().getThisTypeGraph();
        List<Path> pathCandidates = typeGraph.computeSimplePathsForAlternativeVar(initialElement).stream().toList();
        Path chosenPath = pathCandidates.get(RandomUtils.nextInt(pathCandidates.size()));

        if (!addTraversalInvocation(traversal, chosenPath, structureMethodBody)) {
            //System.err.println("TraverseWorklistMutator: Could not add traversal invocation");
            return false;
        }

        //System.err.println("AddTraverseInvocationMutator:\n" + state.getCtClass().toString());

        return true;
    }


    private boolean addTraversalInvocation(CtMethod<?> traversal, Path chosenPath, CtBlock<?> structureMethodBody) {
        CtVariable<?> setVar = handleVisitedSetVariable(traversal, structureMethodBody, chosenPath);
        CtExpression<?>[] args = createArguments(traversal.getParameters(), setVar, chosenPath.getVariableRead());
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversal, args);

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(SpoonFactory.negateExpresion(traversalCall));
        if (SpoonQueries.checkAlreadyExistSimple(ifStatement.getCondition(), structureMethodBody))
            return false;

        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethodBody);
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

    private CtVariable<?> handleVisitedSetVariable(CtMethod<?> traversal, CtBlock<?> structureMethodBody, Path chosenPath) {
        CtVariable<?> formalParameter = SpoonQueries.getTraversalSetParameter(traversal);
        CtTypeReference<?> setSubType = formalParameter.getType().getActualTypeArguments().get(0);
        CtVariable<?> setVar = SpoonQueries.searchVisitedSetInBlock(structureMethodBody, setSubType);
        if (setVar == null) {
            setVar = SpoonFactory.createVisitedSetDeclaration(setSubType, structureMethodBody);
            structureMethodBody.insertBegin((CtStatement) setVar);
        }
        return setVar;
    }


}
