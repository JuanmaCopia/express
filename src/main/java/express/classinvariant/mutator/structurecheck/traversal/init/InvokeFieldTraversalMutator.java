package express.classinvariant.mutator.structurecheck.traversal.init;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class InvokeFieldTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtBlock<?> targetBody;
    CtExpression<Boolean> condition;
    CtVariable<?> setVar;
    boolean mustDeclareSet = false;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        traversal = Utils.getRandomElement(traversals);
        CtVariable<?> initialElement = SpoonQueries.getTraversedElementParameter(traversal);

        List<Path> pathCandidates = TypeUtils.filterPathsByType(
                SpoonManager.getSubjectTypeData().getSimplePaths(),
                initialElement.getType()
        ).stream().toList();

        if (pathCandidates.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomPath(pathCandidates);

        targetBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        CtVariable<?> formalParameter = SpoonQueries.getTraversalSetParameter(traversal);
        CtTypeReference<?> setSubType = formalParameter.getType().getActualTypeArguments().get(0);
        setVar = SpoonQueries.searchVisitedSetInBlock(targetBody, setSubType);
        if (setVar == null) {
            mustDeclareSet = true;
            setVar = SpoonFactory.createVisitedSetDeclaration(setSubType);
        } else {
            mustDeclareSet = false;
        }

        CtExpression<?>[] args = createArguments(traversal.getParameters(), setVar, chosenPath.getVariableRead());
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversal, args);

        CtExpression<Boolean> clause1 = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = SpoonFactory.negateExpresion(traversalCall);
        condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExistSimple(condition, targetBody))
            return false;

        return true;
    }


    @Override
    public void mutate(ClassInvariantState state) {
        if (mustDeclareSet) {
            targetBody.insertBegin((CtStatement) setVar);
        }

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement lastStatement = SpoonQueries.getMark1Comment(targetBody);
        lastStatement.insertBefore(ifStatement);

        //System.err.println("\nInvokeFieldTraversalMutator: invocation:\n" + ifStatement.toString());
        //System.err.println("\n\nInvokeFieldTraversalMutator: traversal:\n" + traversal.toString());
        //System.err.println("\nInvokeFieldTraversalMutator: AFTER\n" + state.toString());
    }


    private CtExpression<?>[] createArguments(List<CtParameter<?>> params, CtVariable<?> visitedSetVar, CtVariableRead<?> pathRead) {
        CtExpression<?>[] args = new CtExpression[params.size()];
        args[0] = SpoonFactory.createVariableRead(params.get(0));
        args[1] = pathRead;
        args[2] = SpoonFactory.createVariableRead(visitedSetVar);
        return args;
    }

}
