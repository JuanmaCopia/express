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
import express.util.Utils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class NullComparisonFromInputMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> traversalBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));
        traversalBody = traversal.getBody();

        CtVariable<?> traversedElement = SpoonQueries.getTraversedElement(traversal);
        List<Path> paths = SpoonManager.getSubjectTypeData().getThisTypeGraph().computeSimplePathsForAlternativeVar(traversedElement).stream().filter(
                p -> p.size() > 1).toList();
        paths = TypeUtils.filterPaths(paths, TypeUtils::isReferenceType).stream().toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomElement(paths);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(chosenPath);
        clauses.remove(0);
        clauses.add(SpoonFactory.createNullComparisonClause(chosenPath.getVariableRead()));
        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExist(condition, traversalBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_3_LABEL);
        CtStatement comment = SpoonQueries.getBeginOfTraversalComment(traversalBody);
        comment.insertBefore(ifStatement);

        //System.err.println("\nIfNullReturnInTraversalMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + traversalBody);
    }

}
