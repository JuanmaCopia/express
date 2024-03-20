package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.SizeCheckProcessor;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddSizeCheckMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        if (SpoonQueries.getVisitedSetLocalVars(block).isEmpty()) {
            return false;
        }

        return !SpoonQueries.getIntegerFieldsOfRoot().isEmpty() && !SpoonQueries.containsSizeCheck(block);
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(blockGene);
        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));

        List<CtField<?>> integerFields = SpoonQueries.getIntegerFieldsOfRoot();
        CtField<?> chosenIntegerField = integerFields.get(RandomUtils.nextInt(integerFields.size()));
        CtVariableRead<?> intFieldRead = SpoonFactory.createVariableRead(chosenIntegerField);

        Processor<CtBlock<?>> p = new SizeCheckProcessor(setVar, intFieldRead);
        p.process(blockGene);

        return true;
    }


}
