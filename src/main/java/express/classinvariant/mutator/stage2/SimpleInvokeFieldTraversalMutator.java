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

public class SimpleInvokeFieldTraversalMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtBlock<?> targetMethodBody;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        traversal = RandomUtils.getRandomElement(traversals);

        CtVariable<?> initialElement = TemplateHelper.getTraversedElementParameter(traversal);
        List<Path> pathCandidates = TypeUtils.filterPathsByType(
                SpoonManager.getSubjectTypeData().getSimplePaths(),
                initialElement.getType()
        ).stream().filter(TypeUtils::hasOnlyOneCyclicField).toList();
        if (pathCandidates.isEmpty()) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomPath(pathCandidates);

        CtMethod<?> structureMethod = TemplateHelper.getStructureMethod(state);
        CtVariable<?> mapOfVisitedDeclaration = TemplateHelper.getMapOfVisitedParameter(structureMethod);
        CtInvocation<Boolean> traversalCall = TemplateHelper.createTraversalInvocation(chosenPath, traversal, mapOfVisitedDeclaration);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateNullComparisonClauses(chosenPath);
        clauses.remove(0);
        clauses.add(SpoonFactory.negateExpresion(traversalCall));
        condition = SpoonFactory.conjunction(clauses);

        targetMethodBody = structureMethod.getBody();
        return !SpoonQueries.checkAlreadyExistSimple(condition, targetMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_2_LABEL);

        CtStatement insertBeforeLabel = SpoonQueries.getReturnTrueLabel(targetMethodBody);
        insertBeforeLabel.insertBefore(ifStatement);

        //System.out.println("\nInvokeFieldTraversalMutator Invocation: \n" + ifStatement.toString());
        //System.out.println("\nInvokeFieldTraversalMutator AFTER: \n" + targetMethodBody.toString());
        //System.err.println("\n\InvokeFieldTraversalMutator: traversal:\n" + traversal.toString());
        //System.err.println("\InvokeFieldTraversalMutator: AFTER\n" + state.toString());
    }

}
