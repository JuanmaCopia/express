package evorep.ga.mutators.structurecheck;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.TraverseCyclicReferenceProcessor;
import evorep.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseCyclicReferenceMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getNonTraversedCyclicFieldReads(block).isEmpty();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> varReads = SpoonQueries.getNonTraversedCyclicFieldReads(blockGene);
        CtVariableRead<?> chosenInitialField = varReads.get(RandomUtils.nextInt(varReads.size()));

        CtTypeReference<?> cyclicNode = chosenInitialField.getVariable().getType();
        List<CtVariable<?>> loopFields = TypeGraph.getInstance().getSelfCyclicFieldsOfNode(cyclicNode);
        CtVariable<?> chosenLoopField = loopFields.get(RandomUtils.nextInt(loopFields.size()));

        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(blockGene, cyclicNode);
        CtLocalVariable<?> chosenSetVar = null;
        if (setVars.isEmpty()) {
            chosenSetVar = SpoonFactory.createVisitedSetDeclaration(cyclicNode, blockGene);
        } else {
            chosenSetVar = setVars.get(RandomUtils.nextInt(setVars.size()));
        }

        Processor<CtBlock<?>> p = new TraverseCyclicReferenceProcessor(chosenInitialField, chosenLoopField, chosenSetVar);
        p.process(blockGene);

        return true;
    }


}
