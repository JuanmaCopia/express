package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import evorep.spoon.processors.TraverseCyclicReferenceProcessor;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseCyclicReferenceMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;

        return !SpoonQueries.getNonTraversedCyclicFieldReads(block).isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        List<CtVariableRead<?>> varReads = SpoonQueries.getNonTraversedCyclicFieldReads(blockGene);
        CtVariableRead<?> chosenInitialField = varReads.get(RandomUtils.nextInt(varReads.size()));

        CtTypeReference<?> cyclicNode = chosenInitialField.getVariable().getType();
        List<CtField<?>> loopFields = SpoonManager.getTypeGraph().getSelfCyclicFieldsOfNode(cyclicNode);
        CtField<?> chosenLoopField = loopFields.get(RandomUtils.nextInt(loopFields.size()));

        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(blockGene, cyclicNode);
        CtLocalVariable<?> chosenSetVar = null;
        if (setVars.isEmpty()) {
            chosenSetVar = SpoonFactory.createVisitedSetDeclaration(cyclicNode, blockGene);
        } else {
            chosenSetVar = setVars.get(RandomUtils.nextInt(setVars.size()));
        }

        Processor<CtBlock<?>> p = new TraverseCyclicReferenceProcessor(chosenInitialField, chosenLoopField, chosenSetVar);
        p.process(blockGene);
    }


}
