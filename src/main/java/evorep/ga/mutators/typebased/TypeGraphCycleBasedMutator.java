package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.processors.ReferenceTraversalProcessor;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TypeGraphCycleBasedMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        return gene instanceof CtBlock && !SpoonManager.getTypesGraph().getNodesWithSelfCycles().isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> mutatedGene = (CtBlock<?>) gene.clone();

        TypesGraph typesGraph = SpoonManager.getTypesGraph();

        Set<CtTypeReference<?>> nodesWithCycles = typesGraph.getNodesWithSelfCycles();
        CtTypeReference<?> chosenNode = nodesWithCycles.stream().findAny().get();

        List<List<CtField<?>>> simplePaths = typesGraph.getSimplePaths(typesGraph.getRoot(), chosenNode);
        List<CtField<?>> cyclicFields = typesGraph.getSelfCyclicFieldsOfNode(chosenNode);
        switch (getChoice(cyclicFields)) {
            case 0 -> applySingleFieldTraversal(mutatedGene, simplePaths, cyclicFields);
            case 1 -> {

            }
            default -> throw new RuntimeException("Invalid choice");
        }
        gene.replace(mutatedGene);
    }

    public static int getChoice(List<CtField<?>> cyclicFields) {
        List<Integer> filteredChoices = new ArrayList<>();
        if (cyclicFields.size() == 1) {
            filteredChoices.add(0);
        } else if (cyclicFields.size() > 1) {
            //filteredChoices.add(1);
        }
        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }

    public static void applySingleFieldTraversal(CtBlock<?> block, List<List<CtField<?>>> simplePaths, List<CtField<?>> cyclicFields) {
        List<CtField<?>> chosenPath = simplePaths.get(RandomUtils.nextInt(simplePaths.size()));
        CtVariableRead<?> initialField = SpoonFactory.createFieldRead(chosenPath);

        CtField<?> loopField = cyclicFields.get(RandomUtils.nextInt(cyclicFields.size()));

        Processor<CtBlock<?>> p = new ReferenceTraversalProcessor(initialField, loopField);
        p.process(block);
    }


}
