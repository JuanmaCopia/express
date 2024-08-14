package express.classinvariant.mutator.structurecheck.traversal;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class ComposedNullCheckInTraversalMutator implements ClassInvariantMutator {


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
        List<Path> paths = SpoonManager.getTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(traversedElement).stream()
                .filter(p -> TypeUtils.isReferenceType(p.getTypeReference()) && p.size() == 2)
                .toList();
        if (paths.size() < 2)
            return false;

        List<Path> chosenPaths = SpoonQueries.chooseNPaths(paths, 2);
        Path path1 = chosenPaths.get(0);
        Path path2 = chosenPaths.get(1);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(path1);
        clauses.add(SpoonFactory.createNullComparisonClause(path1.getVariableRead()));
        clauses.addAll(SpoonFactory.generateParentPathNullComparisonClauses(path2));
        clauses.add(SpoonFactory.createNullComparisonClause(path2.getVariableRead()));

        CtExpression<Boolean> condition = SpoonFactory.conjunction(clauses);
        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getBeginOfTraversalComment(traversalBody);
        comment.insertBefore(ifStatement);

        //System.err.println("\nComposedNullCheckInTraversalMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + traversalBody);
        return true;
    }


}
