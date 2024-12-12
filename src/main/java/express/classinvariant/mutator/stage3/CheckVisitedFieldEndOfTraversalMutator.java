package express.classinvariant.mutator.stage3;

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
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedFieldEndOfTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }
        traversal = RandomUtils.getRandomElement(traversals);

        CtVariable<?> traversedElement = TemplateHelper.getTraversedElementParameter(traversal);
        CtVariable<?> visitedSetVar = TemplateHelper.getTraversalVisitedElementsVariable(traversal);
        CtVariable<?> currentVar = TemplateHelper.getTraversalCurrentVariable(traversal);
        CtTypeReference<?> traversedElementsType = currentVar.getType();

        List<Path> candidates = SpoonManager.getSubjectTypeData().getThisTypeGraph().computeSimplePathsForAlternativeVar(traversedElement).stream().filter(p -> p.size() == 2).toList();
        candidates = TypeUtils.filterPathsByType(candidates, traversedElementsType).stream().toList();
        if (candidates.isEmpty()) {
            System.err.println("No candidates found for traversed element: " + traversedElement);
            System.err.println("Traversed element type: " + traversedElement.getType());
            System.err.println("Set subtype: " + traversedElementsType);
            System.err.println("Traversal: " + traversal);
        }

        Path chosenPath = RandomUtils.getRandomPath(candidates);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateNullComparisonClauses(chosenPath);
        clauses.remove(0);

        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(visitedSetVar, chosenPath.getVariableRead());
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);
        clauses.add(addToSetInvocation);
        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExist(condition, traversal.getBody());
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_3_LABEL);
        CtStatement endOfTraversalComment = SpoonQueries.getEndOfTraversalComment(traversal.getBody());
        endOfTraversalComment.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldEndOfTraversalMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + traversalBody);
    }


}
