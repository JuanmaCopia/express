package evoexpress.ga.mutator.structurecheck.traversal.outer;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.processors.traversals.SizeCheckProcessor;
import evoexpress.type.typegraph.Path;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class AddSizeCheckMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;

        List<Path> integerFields = SpoonManager.inputTypeData.getIntegerFieldsOfParameters();
        return !integerFields.isEmpty() && !SpoonQueries.getVisitedSetLocalVars(block).isEmpty() && !SpoonQueries.containsSizeCheck(block);
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(blockGene);
        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));

        List<Path> integerFields = SpoonManager.inputTypeData.getIntegerFieldsOfParameters();
        Path chosenIntegerField = integerFields.get(RandomUtils.nextInt(integerFields.size()));
        CtVariableRead<?> intFieldRead = chosenIntegerField.getVariableRead();

        Processor<CtBlock<?>> p = new SizeCheckProcessor(setVar, intFieldRead);
        p.process(blockGene);

        //System.err.println("\nAddSizeCheckMutator:\n\n" + blockGene);
        //individual.marked = true;

        return true;
    }


}
