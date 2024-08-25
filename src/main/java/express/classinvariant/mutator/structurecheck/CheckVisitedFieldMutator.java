package express.classinvariant.mutator.structurecheck;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedFieldMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> structureMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(structureMethodBody);
        if (visitedSetVars.isEmpty())
            return false;

        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));
        CtTypeReference<?> setSubType = setVar.getType().getActualTypeArguments().get(0);

        List<Path> candidates = SpoonManager.getSubjectTypeData().getSimplePathsOfType(setSubType);
        if (candidates.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomPath(candidates);
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(setVar, chosenVarRead);
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);

        condition = SpoonFactory.createBooleanBinaryExpression(
                nullComparisonClause,
                addToSetInvocation,
                BinaryOperatorKind.AND
        );

        return !SpoonQueries.checkAlreadyExist(condition, structureMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(structureMethodBody);
        lastStatement.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + structureMethodBody);
    }


}
