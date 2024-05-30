package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtMethod;

public class AddSizeCheckMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;

        if (SpoonQueries.getVisitedSetLocalVars(block).isEmpty()) {
            return false;
        }

        return false;
        // return !SpoonQueries.getIntegerFieldsOfRoot().isEmpty() && !SpoonQueries.containsSizeCheck(block);
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
//        CtBlock<?> blockGene = (CtBlock<?>) gene;
//
//        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getVisitedSetLocalVars(blockGene);
//        CtLocalVariable<?> setVar = visitedSetVars.get(RandomUtils.nextInt(visitedSetVars.size()));
//
//        List<CtVariable<?>> integerFields = SpoonQueries.getIntegerFieldsOfRoot();
//        CtVariable<?> chosenIntegerField = integerFields.get(RandomUtils.nextInt(integerFields.size()));
//        CtVariableRead<?> intFieldRead = SpoonFactory.createFieldReadOfRootObject(chosenIntegerField);
//
//        Processor<CtBlock<?>> p = new SizeCheckProcessor(setVar, intFieldRead);
//        p.process(blockGene);

        //System.err.println("\nAddSizeCheckMutator:\n\n" + blockGene);
        //individual.marked = true;

        return true;
    }


}
