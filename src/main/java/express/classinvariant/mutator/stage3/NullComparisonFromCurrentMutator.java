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
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class NullComparisonFromCurrentMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversalsOfReferenceObjects(state.getCtClass());
        if (traversals.isEmpty()) {
            return false;
        }

        traversal = Utils.getRandomElement(traversals);
        CtBlock<?> traversalBody = traversal.getBody();

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(traversalBody, LocalVarHelper.CURRENT_VAR_NAME);

        List<Path> candidates = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream()
                .filter(p -> TypeUtils.isReferenceType(p.getTypeReference()) && !p.isEmpty() && TypeUtils.hasOnlyOneCyclicField(p))
                .toList();

        if (candidates.isEmpty()) {
            return false;
        }

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));

        condition = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath);
        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_3_LABEL);
        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(traversal.getBody());
        endOfHandleCurrentComment.insertBefore(ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + traversalBody);
    }


}
