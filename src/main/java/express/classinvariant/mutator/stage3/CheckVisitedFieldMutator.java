package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.code.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedFieldMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> structureMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(
                p -> p.size() > 1 && TypeUtils.hasOnlyOneCyclicField(p)
        ).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomPath(paths);
        CtTypeReference<?> typeOfPath = chosenPath.getTypeReference();

        structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(structureMethodBody).stream().filter(
                v -> typeOfPath.isSubtypeOf(v.getType().getActualTypeArguments().get(0))).toList();
        if (visitedSetVars.isEmpty()) {
            return false;
        }

        CtLocalVariable<?> setVar = Utils.getRandomElement(visitedSetVars);

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
