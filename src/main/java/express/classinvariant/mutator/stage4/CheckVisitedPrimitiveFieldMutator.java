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
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class CheckVisitedPrimitiveFieldMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> primitiveMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getNumericPaths().stream().filter(
                p -> p.size() <= 3
        ).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(paths);
        CtTypeReference<?> typeOfPath = chosenPath.getTypeReference();

        primitiveMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.PRIMITIVE_METHOD_NAME).getBody();
        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(typeOfPath);
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getLocalVariablesMatchingPrefix(primitiveMethodBody, visitedSetVarName);
        if (visitedSetVars.isEmpty()) {
            return false;
        }

        CtLocalVariable<?> setVar = RandomUtils.getRandomElement(visitedSetVars);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateNullComparisonClauses(chosenPath);
        clauses.remove(0);
        int lastIndex = clauses.size() - 1;
        clauses.remove(lastIndex);

        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(setVar, chosenPath.getVariableRead());
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);
        clauses.add(addToSetInvocation);

        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExist(condition, primitiveMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);
        CtStatement insertBeforeLabel = SpoonQueries.getSeparatorLabelComment(primitiveMethodBody);
        MutatorHelper.selectMutationOption(ifStatement, primitiveMethodBody, insertBeforeLabel, LocalVarHelper.STAGE_4_LABEL);

        //System.err.println("CheckVisitedPrimitiveFieldMutator:\n" + primitiveMethodBody);
        //System.err.println("Final Block:\n" + structureMethodBody);
    }


}
