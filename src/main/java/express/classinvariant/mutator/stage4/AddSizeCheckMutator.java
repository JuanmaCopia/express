package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class AddSizeCheckMutator implements ClassInvariantMutator {

    CtBlock<?> methodBody;
    CtExpression<Boolean> condition;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        List<Path> integerFields = SpoonManager.getSubjectTypeData().getIntegerPaths();
        if (integerFields.isEmpty())
            return false;

        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVars(methodBody);
        if (setVars.isEmpty())
            return false;

        CtLocalVariable<?> chosenSet = RandomUtils.getRandomElement(setVars);
        Path choseIntegerPath = RandomUtils.getRandomPath(integerFields);
        CtVariableRead<?> pathRead = choseIntegerPath.getVariableRead();

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(choseIntegerPath);
        clauses.remove(0);
        clauses.add(createSizeCheckCondition(chosenSet, pathRead));
        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExistSimple(condition, methodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        CtStatement lastStatement = SpoonQueries.getReturnTrueLabel(methodBody);
        lastStatement.insertBefore(ifStatement);

        //System.err.println("\nAddSizeCheckMutator:\n" + ifStatement);
    }

    public CtExpression<Boolean> createSizeCheckCondition(CtVariable<?> setVariable, CtExpression<?> integerField) {
        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(setVariable, "size");
        CtExpression<?> sizeMinus = sizeInvocation;

        int minus = RandomUtils.nextInt(0, 3);
        if (minus > 0)
            sizeMinus = SpoonFactory.createBinaryExpression(sizeInvocation, minus, BinaryOperatorKind.MINUS);

        return SpoonFactory.createBinaryExpression(sizeMinus, integerField, BinaryOperatorKind.NE);
    }

}
