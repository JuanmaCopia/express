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
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class InvokeFieldTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtBlock<?> targetMethodBody;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        return isApplicable(state, RandomUtils.getRandomElement(traversals));
    }

    boolean isApplicable(ClassInvariantState state, CtMethod<?> trav) {
        CtLocalVariable<?> mapOfVisitedDeclaration = TemplateHelper.getMapOfVisitedDeclaration(state.getCtClass());
        if (mapOfVisitedDeclaration == null) {
            return false;
        }

        traversal = trav;
        CtVariable<?> initialElement = TemplateHelper.getTraversedElementParameter(traversal);

        List<Path> pathCandidates = TypeUtils.filterPathsByType(
                SpoonManager.getSubjectTypeData().getSimplePaths(),
                initialElement.getType()
        ).stream().filter(TypeUtils::hasOnlyOneCyclicField).toList();
        if (pathCandidates.isEmpty()) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomPath(pathCandidates);
        
        CtInvocation<Boolean> traversalCall = TemplateHelper.createTraversalInvocation(chosenPath, traversal, mapOfVisitedDeclaration);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateNullComparisonClauses(chosenPath);
        clauses.remove(0);
        clauses.add(SpoonFactory.negateExpresion(traversalCall));
        condition = SpoonFactory.conjunction(clauses);

        targetMethodBody = TemplateHelper.getStructureMethodBody(state);
        return !SpoonQueries.checkAlreadyExistSimple(condition, targetMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_2_LABEL);

        List<CtIf> invocations = null;
        List<CtMethod<?>> otherTraversals = MutatorHelper.findTraversalsWithDifferentParameters(state.getCtClass(), traversal);
        if (!otherTraversals.isEmpty()) {
            CtMethod<?> chosenTraversal = RandomUtils.getRandomElement(otherTraversals);
            invocations = MutatorHelper.getIfsCallingMethod(state.getCtClass(), LocalVarHelper.STAGE_2_LABEL, chosenTraversal.getSimpleName());
        }

        CtStatement insertBeforeLabel = SpoonQueries.getReturnTrueLabel(targetMethodBody);
        MutatorHelper.insertOrReplaceCheck(invocations, ifStatement, insertBeforeLabel);

        //System.err.println("\nInvokeFieldTraversalMutator Invocation: \n" + ifStatement.toString());
        //System.err.println("\n\InvokeFieldTraversalMutator: traversal:\n" + traversal.toString());
        //System.err.println("\InvokeFieldTraversalMutator: AFTER\n" + state.toString());
    }

}
