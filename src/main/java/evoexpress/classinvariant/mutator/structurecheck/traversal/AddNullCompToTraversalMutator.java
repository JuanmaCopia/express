package evoexpress.classinvariant.mutator.structurecheck.traversal;

import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddNullCompToTraversalMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        return !traversals.isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));
        CtBlock<?> traversalBody = traversal.getBody();

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(traversalBody, LocalVarHelper.CURRENT_VAR_NAME);

        List<Path> candidates = SpoonManager.getTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream()
                .filter(p -> TypeUtils.isReferenceType(p.getTypeReference()) && p.size() > 1)
                .toList();
        if (candidates.isEmpty())
            return false;

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> condition = SpoonFactory.createNullComparisonClause(chosenVarRead);
        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + traversalBody);
        return true;
    }


}
