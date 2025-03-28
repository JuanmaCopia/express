package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.ComparisonTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.object.mutate.values.ValueProvider;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;
import java.util.stream.Collectors;

public class NumericComparisonFromCurrentConstantMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtBlock<?> traversalBody;
    CtExpression<Boolean> condition;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversalsOfReferenceObjects(state.getCtClass());
        if (traversals.isEmpty())
            return false;

        traversal = RandomUtils.getRandomElement(traversals);
        traversalBody = traversal.getBody();

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(traversalBody, LocalVarHelper.CURRENT_VAR_NAME);

        List<Path> candidates = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream()
                .filter(p -> TypeUtils.isIntegerType(p.getTypeReference()) && !p.isEmpty() && p.size() < 3)
                .collect(Collectors.toList());
        if (candidates.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomElement(candidates);

        int value = ValueProvider.getRandomIntegerConstant();
        // Convert value to CtExpression
        CtExpression<?> valueExpr = SpoonFactory.createLiteral(value);

        condition = ComparisonTemplate.instantiateComparableTemplate(chosenPath, valueExpr);

        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        List<CtIf> checks = MutatorHelper.getMutableChecksOfTraversalLoop(traversal, LocalVarHelper.STAGE_4_LABEL);
        CtComment insertBeforeLabel = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        MutatorHelper.insertOrReplaceCheck(checks, ifStatement, insertBeforeLabel);

        //System.err.println("\nNumericComparisonFromCurrentConstantMutator:\n" + ifStatement);
    }


}
