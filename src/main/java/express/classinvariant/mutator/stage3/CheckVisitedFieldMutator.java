package express.classinvariant.mutator.stage3;

import java.util.List;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.reference.CtTypeReference;

public class CheckVisitedFieldMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> structureMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(
                p -> p.size() > 1 && p.size() < 3
        ).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(paths);
        CtTypeReference<?> typeOfPath = chosenPath.getTypeReference();

        structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(typeOfPath);
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getLocalVariablesMatchingPrefix(structureMethodBody, visitedSetVarName);
        if (visitedSetVars.isEmpty()) {
            return false;
        }

        CtLocalVariable<?> setVar = RandomUtils.getRandomElement(visitedSetVars);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateNullComparisonClauses(chosenPath);
        clauses.remove(0);

        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(setVar, chosenPath.getVariableRead());
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);
        clauses.add(addToSetInvocation);

        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExist(condition, structureMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_3_LABEL);
        CtStatement lastStatement = SpoonQueries.getReturnTrueLabel(structureMethodBody);
        lastStatement.insertBefore(ifStatement);

        //System.err.println("CheckVisitedFieldMutator:\n" + ifStatement);
        //System.err.println("Final Block:\n" + structureMethodBody);
    }


}
