package evoexpress.classinvariant.mutator.primitivecheck;

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

import java.util.List;

public class AddSizeCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        List<Path> integerFields = SpoonManager.inputTypeData.getIntegerFieldsOfParameters();
        return !integerFields.isEmpty() && !SpoonQueries.getVisitedSetLocalVars(methodBody).isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(methodBody);
        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));

        List<Path> integerFields = SpoonManager.inputTypeData.getIntegerFieldsOfParameters();
        Path chosenIntegerField = integerFields.get(RandomUtils.nextInt(integerFields.size()));
        CtVariableRead<?> intFieldRead = chosenIntegerField.getVariableRead();

        int maxMinus = 2;
        CtIf ifStatement = SpoonFactory.createVisitedSizeCheck(setVar, intFieldRead, RandomUtils.nextInt(maxMinus));
        if (SpoonQueries.checkAlreadyExistSimple(ifStatement.getCondition(), methodBody))
            return false;

        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(methodBody);
        lastStatement.insertBefore(SpoonFactory.createComment("Size check:"));
        lastStatement.insertBefore(ifStatement);

        //System.err.println("\nAddSizeCheckMutator:\n" + ifStatement);

        return true;
    }


}
