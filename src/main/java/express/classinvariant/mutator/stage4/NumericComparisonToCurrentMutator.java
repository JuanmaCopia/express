package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.ComparisonTemplate;
import express.classinvariant.state.ClassInvariantState;
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

public class NumericComparisonToCurrentMutator implements ClassInvariantMutator {

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
                .filter(p -> TypeUtils.isNumericType(p.getTypeReference()) && !p.isEmpty() && p.size() < 4)
                .collect(Collectors.toList());
        if (candidates.size() < 2)
            return false;

        List<Path> path1candidates = candidates.stream().filter(p -> p.size() == 2).toList();
        if (path1candidates.isEmpty())
            return false;

        Path path1 = RandomUtils.getRandomElement(path1candidates);
        candidates.remove(path1);
        Path path2 = RandomUtils.getRandomElement(candidates);

        condition = ComparisonTemplate.instantiateComparableTemplate(path1, path2);
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

        //System.err.println("\nPrimitiveComparisonToCurrentMutator:\n" + ifStatement);
    }


}
