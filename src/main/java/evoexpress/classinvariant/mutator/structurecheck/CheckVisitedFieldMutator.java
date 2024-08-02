package evoexpress.classinvariant.mutator.structurecheck;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedFieldMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        return !SpoonQueries.getVisitedSetLocalVars(structureMethodBody).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(structureMethodBody);
        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));
        CtTypeReference<?> setSubType = setVar.getType().getActualTypeArguments().get(0);

        List<Path> candidates = SpoonManager.getTypeData().getSimplePathsOfType(setSubType);
        if (candidates.isEmpty())
            return false;

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.createNullComparisonClause(chosenVarRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(setVar, chosenVarRead);
        CtExpression<Boolean> conjunction = SpoonFactory.createBooleanBinaryExpression(
                nullComparisonClause,
                addToSetInvocation,
                BinaryOperatorKind.AND
        );

        if (SpoonQueries.checkAlreadyExist(conjunction, structureMethodBody))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(conjunction);

        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(structureMethodBody);
        lastStatement.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + structureMethodBody);
        return true;
    }


}
