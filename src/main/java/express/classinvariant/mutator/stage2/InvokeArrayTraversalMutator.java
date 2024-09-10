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
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class InvokeArrayTraversalMutator implements ClassInvariantMutator {

    CtBlock<?> targetMethodBody;
    CtExpression<Boolean> condition;
    CtVariable<?> setVar;
    boolean mustDeclareSet = false;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> arrayTraversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.ARRAY_TRAVERSAL_PREFIX);
        if (arrayTraversals.isEmpty()) {
            return false;
        }

        CtMethod<?> arrayTraversal = RandomUtils.getRandomElement(arrayTraversals);

        CtVariable<?> array = TemplateHelper.getTraversedElementParameter(arrayTraversal);

        List<Path> pathCandidates = TypeUtils.filterPathsByType(
                SpoonManager.getSubjectTypeData().getArrayPaths(),
                array.getType()
        ).stream().toList();

        if (pathCandidates.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(pathCandidates);

        targetMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        CtVariable<?> currentElementVar = TemplateHelper.getTraversalCurrentVariable(arrayTraversal);
        CtTypeReference<?> setSubType = TypeUtils.getActualTypeArgument(currentElementVar.getType(), 0);
        setVar = SpoonQueries.searchVisitedSetInBlock(targetMethodBody, setSubType);
        if (setVar == null) {
            mustDeclareSet = true;
            setVar = SpoonFactory.createVisitedIdentitySetDeclaration(setSubType);
        } else {
            mustDeclareSet = false;
        }
        CtExpression<?>[] args = MutatorHelper.createTraversalArguments(arrayTraversal.getParameters().get(0), setVar, chosenPath.getVariableRead());
        CtInvocation<Boolean> arrayTraversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(arrayTraversal, args);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateNullComparisonClauses(chosenPath);
        clauses.remove(0);
        clauses.add(SpoonFactory.negateExpresion(arrayTraversalCall));
        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExistSimple(condition, targetMethodBody);
    }


    @Override
    public void mutate(ClassInvariantState state) {
        if (mustDeclareSet) {
            CtStatement separatorLabel = SpoonQueries.getSeparatorLabelComment(targetMethodBody);
            separatorLabel.insertAfter((CtStatement) setVar);
        }

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_2_LABEL);
        CtStatement insertBeforeLabel = SpoonQueries.getReturnTrueLabel(targetMethodBody);
        MutatorHelper.selectMutationOption(ifStatement, targetMethodBody, insertBeforeLabel, LocalVarHelper.STAGE_2_LABEL);

        //System.err.println("InvokeArrayTraversalMutator: added check: \n" + ifStatement.toString());
        //System.err.println("\nInvokeArrayTraversalMutator: result:\n\n" + state.toString());
    }

}
