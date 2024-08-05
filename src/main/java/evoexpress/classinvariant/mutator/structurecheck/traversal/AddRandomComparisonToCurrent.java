package evoexpress.classinvariant.mutator.structurecheck.traversal;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeData;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;
import java.util.Set;

public class AddRandomComparisonToCurrent implements ClassInvariantMutator {

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

        TypeGraph typeGraph = SpoonManager.getTypeData().getThisTypeGraph();
        int size = 2;
        List<Path> candidates = typeGraph
                .computeSimplePathsForAlternativeVar(currentDeclaration)
                .stream()
                .filter(p -> p.size() > size && currentDeclaration.getType().equals(p.getTypeReference()))
                .toList();
        if (candidates.isEmpty())
            return false;


        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        Path chosenPathOwner = chosenPath.getParentPath();
        Path currentPath = chosenPathOwner.getParentPath();
        CtVariableRead<?> chosenPathRead = chosenPath.getVariableRead();
        CtVariableRead<?> chosenPathReadOwner = chosenPathOwner.getVariableRead();
        CtVariableRead<?> currentRead = currentPath.getVariableRead();

        CtExpression<Boolean> clause1 = SpoonFactory.createNullComparisonClause(chosenPathReadOwner, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = SpoonFactory.createBooleanBinaryExpression(chosenPathRead, currentRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> condition = SpoonFactory.createBooleanBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);

        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("AddRandomComparisonToCurrent:\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + traversalBody);
        return true;
    }


}
