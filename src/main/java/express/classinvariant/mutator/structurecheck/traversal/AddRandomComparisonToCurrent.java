package express.classinvariant.mutator.structurecheck.traversal;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import express.type.typegraph.TypeGraph;
import express.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddRandomComparisonToCurrent implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> traversalBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        CtMethod<?> traversal  =Utils.getRandomElement(traversals);
        traversalBody = traversal.getBody();
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

        Path chosenPath = Utils.getRandomPath(candidates);
        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(chosenPath);

        CtVariableRead<?> currentRead = SpoonFactory.createVariableRead(currentDeclaration);
        clauses.add(SpoonFactory.createBooleanBinaryExpression(
                chosenPath.getVariableRead(), currentRead, BinaryOperatorKind.NE));

        condition = SpoonFactory.conjunction(clauses);
        return !SpoonQueries.checkAlreadyExist(condition, traversalBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        endOfHandleCurrentComment.insertBefore(ifStatement);

        //System.err.println("\n\nAddRandomComparisonToCurrent:\n\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + traversalBody);
    }

}