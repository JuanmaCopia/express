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
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class InvokeFieldTraversalOnArrayTraversalMutator implements ClassInvariantMutator {


    CtMethod<?> arrayTraversal;
    CtMethod<?> cyclicFieldTraversal;
    CtExpression<Boolean> condition;
    CtVariable<?> setVar;
    boolean mustDeclareSet = false;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        if (arrayTraversals.isEmpty())
            return false;

        List<CtMethod<?>> cyclicFieldsTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (cyclicFieldsTraversals.isEmpty())
            return false;

        arrayTraversal = Utils.getRandomElement(arrayTraversals);
        cyclicFieldTraversal = Utils.getRandomElement(cyclicFieldsTraversals);
        CtTypeReference<?> traversedElementType = SpoonQueries.getTraversedElement(cyclicFieldTraversal).getType();


        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(
                arrayTraversal.getBody(), LocalVarHelper.CURRENT_VAR_NAME
        );

        List<Path> candidates = SpoonManager.getTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream().filter(
                        p -> p.getTypeReference().isSubtypeOf(traversedElementType)
                ).toList();
        if (candidates.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomPath(candidates);

        CtVariable<?> formalParameter = SpoonQueries.getTraversalSetParameter(cyclicFieldTraversal);
        CtTypeReference<?> setSubType = TypeUtils.getSubType(formalParameter.getType(), 0);
        setVar = SpoonQueries.searchVisitedSetInBlock(arrayTraversal.getBody(), setSubType);
        if (setVar == null) {
            mustDeclareSet = true;
            setVar = SpoonFactory.createVisitedSetDeclaration(setSubType);
        } else {
            mustDeclareSet = false;
        }

        CtVariable<?> thisVar = arrayTraversal.getParameters().get(0);
        CtExpression<?>[] args = createArguments(thisVar, setVar, chosenPath.getVariableRead());

        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(cyclicFieldTraversal, args);

        CtExpression<Boolean> clause1 = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = SpoonFactory.negateExpresion(traversalCall);
        condition = (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        return !SpoonQueries.checkAlreadyExistSimple(condition, arrayTraversal.getBody());
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> arrayTraversalBody = arrayTraversal.getBody();
        //System.err.println("InvokeFieldTraversalOnArrayTraversalMutator: BEFORE:\n" + state);
        if (mustDeclareSet) {
            arrayTraversalBody.insertBegin((CtStatement) setVar);
        }

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(arrayTraversalBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("InvokeFieldTraversalOnArrayTraversalMutator: added check\n" + ifStatement);
        //System.err.println("InvokeFieldTraversalOnArrayTraversalMutator: result:\n" + state);
        return true;
    }

    private CtExpression<?>[] createArguments(CtVariable<?> thisVar, CtVariable<?> visitedSetVar, CtVariableRead<?> pathRead) {
        CtExpression<?>[] args = new CtExpression[3];
        args[0] = SpoonFactory.createVariableRead(thisVar);
        args[1] = pathRead;
        args[2] = SpoonFactory.createVariableRead(visitedSetVar);
        return args;
    }


}
