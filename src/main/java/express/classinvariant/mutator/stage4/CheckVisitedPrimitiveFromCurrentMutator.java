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
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.stream.Collectors;

public class CheckVisitedPrimitiveFromCurrentMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtBlock<?> traversalBody;
    CtExpression<Boolean> condition;

    CtVariable<?> setVar;
    boolean mustDeclareSet;

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
                .filter(p -> TypeUtils.isNumericType(p.getTypeReference()) && p.size() < 3)
                .collect(Collectors.toList());
        if (candidates.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(candidates);
        CtTypeReference<?> pathType = chosenPath.getTypeReference();

        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(pathType);
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getLocalVariablesMatchingPrefix(traversalBody, visitedSetVarName);
        if (!visitedSetVars.isEmpty()) {
            setVar = visitedSetVars.get(0);
            mustDeclareSet = false;
        } else {
            mustDeclareSet = true;
            CtVariable<?> mapOfVisited = TemplateHelper.getMapOfVisitedParameter(traversal);
            setVar = TemplateHelper.createVisitedElementsSet(mapOfVisited, pathType);
        }

        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(setVar, chosenPath.getVariableRead());
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);


        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(chosenPath);
        clauses.add(addToSetInvocation);

        condition = SpoonFactory.conjunction(clauses);
        if (SpoonQueries.checkAlreadyExistSimple(condition, traversalBody))
            return false;

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        if (mustDeclareSet) {
            CtWhile whileStatement = SpoonQueries.getTraversalLoop(traversalBody);
            whileStatement.insertBefore((CtStatement) setVar);
        }

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        List<CtIf> checks = MutatorHelper.getMutableChecksOfTraversalLoop(traversal, LocalVarHelper.STAGE_4_LABEL);
        CtComment insertBeforeLabel = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        MutatorHelper.insertOrReplaceCheck(checks, ifStatement, insertBeforeLabel);

        //System.err.println("\nCheckVisitedPrimitiveFromCurrentMutator:\n" + ifStatement);
    }


}
