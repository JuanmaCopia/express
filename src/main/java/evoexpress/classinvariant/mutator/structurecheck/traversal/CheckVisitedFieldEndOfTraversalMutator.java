package evoexpress.classinvariant.mutator.structurecheck.traversal;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.spoon.RandomUtils;
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

public class CheckVisitedFieldEndOfTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }
        traversal = Utils.getRandomElement(traversals);

        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        CtVariable<?> visitedSetVar = SpoonQueries.getVisitedSetParameter(traversal);
        CtTypeReference<?> setSubType = TypeUtils.getSubType(visitedSetVar.getType(), 0);

        List<Path> candidates = SpoonManager.getTypeData().getThisTypeGraph().computeSimplePathsForAlternativeVar(traversedElement).stream().filter(p -> p.size() > 1).toList();
        candidates = TypeUtils.filterPathsByType(candidates, setSubType).stream().toList();

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.createNullComparisonClause(chosenVarRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, chosenVarRead);
        condition = SpoonFactory.createBooleanBinaryExpression(
                nullComparisonClause,
                addToSetInvocation,
                BinaryOperatorKind.AND
        );

        return !SpoonQueries.checkAlreadyExist(condition, traversal.getBody());
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(traversal.getBody());
        endOfTraversalComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + traversalBody);
        return true;
    }


}
