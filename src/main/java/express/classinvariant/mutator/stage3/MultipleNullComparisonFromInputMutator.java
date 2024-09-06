package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class MultipleNullComparisonFromInputMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> traversalBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        CtMethod<?> traversal = RandomUtils.getRandomElement(traversals);
        traversalBody = traversal.getBody();

        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        List<Path> paths = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(traversedElement).stream()
                .filter(p -> TypeUtils.isReferenceType(p.getTypeReference()) && p.size() == 2)
                .toList();
        if (paths.size() < 2)
            return false;

        List<Path> chosenPaths = SpoonQueries.chooseNPaths(paths, 2);
        Path path1 = chosenPaths.get(0);
        Path path2 = chosenPaths.get(1);

        List<CtExpression<Boolean>> clauses1 = SpoonFactory.generateParentPathNullComparisonClauses(path1);
        clauses1.remove(0);
        clauses1.add(SpoonFactory.createNullComparisonClause(path1.getVariableRead()));

        List<CtExpression<Boolean>> clauses2 = SpoonFactory.generateParentPathNullComparisonClauses(path2);
        clauses2.remove(0);
        clauses2.add(SpoonFactory.createNullComparisonClause(path2.getVariableRead()));

        clauses1.addAll(clauses2);
        condition = SpoonFactory.conjunction(clauses1);

        return !SpoonQueries.checkAlreadyExist(condition, traversalBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_3_LABEL);
        CtStatement comment = SpoonQueries.getBeginOfTraversalComment(traversalBody);
        comment.insertBefore(ifStatement);

        //System.err.println("\nComposedNullCheckInTraversalMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + traversalBody);
    }


}
