package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
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

public class CheckSizeEndOfTraversalMutator implements ClassInvariantMutator {

    CtLocalVariable<?> initialSizeVar;
    CtExpression<Boolean> condition;
    CtBlock<?> traversalBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty())
            return false;

        CtMethod<?> traversal = RandomUtils.getRandomElement(traversals);
        traversalBody = traversal.getBody();

        List<CtLocalVariable<?>> localVars = SpoonQueries.getLocalVariablesMatchingPrefix(traversalBody, LocalVarHelper.INITIAL_SIZE_VAR_NAME);
        if (!localVars.isEmpty()) {
            // Size already checked
            return false;
        }

        CtVariable<?> traversedElement = TemplateHelper.getTraversedElementParameter(traversal);
        List<Path> candidatePaths = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(traversedElement).stream()
                .filter(p -> TypeUtils.isIntegerType(p.getTypeReference()) && p.size() < 3)
                .toList();
        if (candidatePaths.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(candidatePaths);

        CtVariable<?> visitedSetVar = TemplateHelper.getTraversalVisitedElemensVariable(traversal);
        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(visitedSetVar, "size");
        initialSizeVar = SpoonFactory.createLocalVariable(LocalVarHelper.INITIAL_SIZE_VAR_NAME, SpoonFactory.getTypeFactory().integerPrimitiveType(), sizeInvocation);

        CtExpression<?> leftExpr = SpoonFactory.createBinaryExpression(sizeInvocation, initialSizeVar, BinaryOperatorKind.MINUS);
        condition = SpoonFactory.createBinaryExpression(leftExpr, chosenPath.getVariableRead(), BinaryOperatorKind.NE);

        return !SpoonQueries.checkAlreadyExist(condition, traversalBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        CtStatement beginOfTraversalComment = SpoonQueries.getBeginOfTraversalComment(traversalBody);
        beginOfTraversalComment.insertAfter(initialSizeVar);
        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(traversalBody);
        endOfTraversalComment.insertAfter(ifStatement);

        //System.err.println("CheckSizeEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + traversalBody);
    }

}
