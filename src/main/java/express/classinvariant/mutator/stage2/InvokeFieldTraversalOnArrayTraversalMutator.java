package express.classinvariant.mutator.stage2;

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
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class InvokeFieldTraversalOnArrayTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> arrayTraversal;
    CtBlock<?> arrayTraversalBody;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        CtLocalVariable<?> mapOfVisitedDeclaration = TemplateHelper.getMapOfVisitedDeclaration(state.getCtClass());
        if (mapOfVisitedDeclaration == null)
            return false;

        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        if (arrayTraversals.isEmpty())
            return false;

        List<CtMethod<?>> fieldTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (fieldTraversals.isEmpty())
            return false;

        arrayTraversal = RandomUtils.getRandomElement(arrayTraversals);

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(
                arrayTraversal.getBody(), LocalVarHelper.CURRENT_VAR_NAME
        );
        CtMethod<?> fieldTraversal = RandomUtils.getRandomElement(fieldTraversals);
        CtTypeReference<?> traversedElementType = TemplateHelper.getTraversedElementParameter(fieldTraversal).getType();
        List<Path> candidates = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream().filter(
                        p -> p.getTypeReference().isSubtypeOf(traversedElementType) &&
                                TypeUtils.hasOnlyOneCyclicField(p)
                ).toList();
        if (candidates.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(candidates);

        CtInvocation<Boolean> traversalCall = TemplateHelper.createTraversalInvocation(chosenPath, fieldTraversal, mapOfVisitedDeclaration);

        CtExpression<Boolean> clause1 = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath, BinaryOperatorKind.NE);
        CtExpression<Boolean> clause2 = SpoonFactory.negateExpresion(traversalCall);
        condition = SpoonFactory.createBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);
        arrayTraversalBody = arrayTraversal.getBody();

        return !SpoonQueries.checkAlreadyExistSimple(condition, arrayTraversal.getBody());
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_2_LABEL);
        CtComment insertBeforeLabel = SpoonQueries.getEndOfHandleCurrentComment(arrayTraversalBody);
        MutatorHelper.selectMutationOption(ifStatement, arrayTraversalBody, insertBeforeLabel, LocalVarHelper.STAGE_2_LABEL);

        //System.err.println("InvokeFieldTraversalOnArrayTraversalMutator: added check\n" + ifStatement);
        //System.err.println("InvokeFieldTraversalOnArrayTraversalMutator: result:\n" + state);
    }

}
