package evoexpress.classinvariant.mutator.structurecheck.traversal.array;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
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

import java.util.List;

public class InvokeArrayTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    List<Path> pathCandidates;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        return isApplicable(Utils.getRandomElement(traversals));
    }

    boolean isApplicable(CtMethod<?> arrayTraversal) {
        traversal = arrayTraversal;
        CtVariable<?> array = SpoonQueries.getTraversedElementParameter(traversal);

        pathCandidates = TypeUtils.filterPathsByType(
                SpoonManager.getTypeData().getArrayPaths(),
                array.getType()
        ).stream().toList();

        return !pathCandidates.isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        Path chosenPath = Utils.getRandomPath(pathCandidates);
        if (!addTraversalInvocation(traversal, chosenPath, structureMethodBody)) {
            return false;
        }

        //System.err.println("AddTraverseInvocationMutator:\n" + structureMethodBody.toString());

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
