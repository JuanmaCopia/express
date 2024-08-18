package express.classinvariant.mutator.primitivecheck;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.*;

import java.util.List;

public class AddSizeCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        List<Path> integerFields = SpoonManager.getTypeData().getIntegerPaths();
        return !integerFields.isEmpty() && !SpoonQueries.getVisitedSetLocalVars(methodBody).isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
//        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
//
//        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(methodBody);
//        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));
//
//        List<Path> integerFields = SpoonManager.getTypeData().getIntegerPaths();
//        Path chosenIntegerField = integerFields.get(RandomUtils.nextInt(integerFields.size()));
//        CtVariableRead<?> intFieldRead = chosenIntegerField.getVariableRead();
//
//        int maxMinus = 2;
//        CtIf ifStatement = SpoonFactory.createVisitedSizeCheck(setVar, intFieldRead, RandomUtils.nextInt(maxMinus));
//        if (SpoonQueries.checkAlreadyExistSimple(ifStatement.getCondition(), methodBody))
//            return false;
//
//        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(methodBody);
//        lastStatement.insertBefore(SpoonFactory.createComment("Size check:"));
//        lastStatement.insertBefore(ifStatement);

        //System.err.println("\nAddSizeCheckMutator:\n" + ifStatement);
    }


}