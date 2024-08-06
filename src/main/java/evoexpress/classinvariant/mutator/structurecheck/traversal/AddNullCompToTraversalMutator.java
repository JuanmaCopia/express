package evoexpress.classinvariant.mutator.structurecheck.traversal;

import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.template.ArrayTraversalTemplate;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.LinkedList;
import java.util.List;

public class AddNullCompToTraversalMutator implements ClassInvariantMutator {

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

        List<Path> candidates = SpoonManager.getTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream()
                .filter(p -> TypeUtils.isReferenceType(p.getTypeReference()) && p.size() > 1)
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
    public boolean mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtComment endOfHandleCurrentComment = SpoonQueries.getEndOfHandleCurrentComment(traversal.getBody());
        endOfHandleCurrentComment.insertBefore(ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n" + ifStatement);
        //System.err.println("\nAddNullCompToTraversalMutator:\n\n" + traversalBody);
        return true;
    }


}
