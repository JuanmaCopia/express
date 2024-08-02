package evoexpress.classinvariant.mutator.structurecheck.traversal;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class IfNullReturnInTraversalMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        return !traversals.isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));
        CtBlock<?> traversalBody = traversal.getBody();

        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        List<Path> paths = SpoonManager.getTypeData().getThisTypeGraph().computeSimplePathsForAlternativeVar(traversedElement).stream().filter(p -> p.size() > 1).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> condition = null;
        if (chosenPath.size() == 2) {
            condition = SpoonFactory.createNullComparisonClause(chosenVarRead);
        } else if (chosenPath.size() == 3) {
            CtVariableRead<?> owner = chosenPath.getVariableReadOwner();
            condition = SpoonFactory.createBooleanBinaryExpression(
                    SpoonFactory.createNullComparisonClause(owner, BinaryOperatorKind.NE),
                    SpoonFactory.createNullComparisonClause(chosenVarRead),
                    BinaryOperatorKind.AND
            );
        }

        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getBeginOfTraversalComment(traversalBody);
        comment.insertBefore(ifStatement);

        //System.err.println("\nIfNullReturnInTraversalMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + traversalBody);
        return true;
    }


}
