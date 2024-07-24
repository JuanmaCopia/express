package evoexpress.ga.mutator.primitivecheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddSizeCheckMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;

        List<Path> integerFields = SpoonManager.inputTypeData.getIntegerFieldsOfParameters();
        return !integerFields.isEmpty() && !SpoonQueries.getVisitedSetLocalVars(block).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(blockGene);
        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));

        List<Path> integerFields = SpoonManager.inputTypeData.getIntegerFieldsOfParameters();
        Path chosenIntegerField = integerFields.get(RandomUtils.nextInt(integerFields.size()));
        CtVariableRead<?> intFieldRead = chosenIntegerField.getVariableRead();

        int maxMinus = 2;
        CtIf ifStatement = SpoonFactory.createVisitedSizeCheck(setVar, intFieldRead, RandomUtils.nextInt(maxMinus));
        if (SpoonQueries.checkAlreadyExistSimple(ifStatement.getCondition(), blockGene))
            return false;

        CtStatement lastStatement = SpoonQueries.getReturnTrueComment(blockGene);
        lastStatement.insertBefore(SpoonFactory.createComment("Size check:"));
        lastStatement.insertBefore(ifStatement);

        //System.err.println("\nAddSizeCheckMutator:\n" + ifStatement);

        return true;
    }


}
