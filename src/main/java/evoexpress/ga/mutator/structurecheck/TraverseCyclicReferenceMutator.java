package evoexpress.ga.mutator.structurecheck;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtMethod;

public class TraverseCyclicReferenceMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;

        return false;
        //return !SpoonQueries.getNonUsedInitialPathsToCyclicField(block).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
//        CtBlock<?> blockGene = (CtBlock<?>) gene;
//
//        List<List<CtVariable<?>>> paths = SpoonQueries.getNonUsedInitialPathsToCyclicField(blockGene);
//        List<CtVariable<?>> chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
//        CtVariableRead<?> chosenInitialField = SpoonFactory.createFieldReadOfRootObject(chosenPath);
//
//        CtTypeReference<?> cyclicNode = chosenInitialField.getVariable().getType();
//        List<CtVariable<?>> loopFields = TypeGraph.getInstance().getSelfCyclicFieldsOfNode(cyclicNode);
//        CtVariable<?> chosenLoopField = loopFields.get(RandomUtils.nextInt(loopFields.size()));
//
//        Processor<CtBlock<?>> p = new TraverseCyclicReferenceProcessor(chosenInitialField, chosenLoopField);
//        p.process(blockGene);

        return true;
    }


}
