package evorep.ga.mutators.typebased;

import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.processors.ReferenceTraversalProcessor;
import evorep.spoon.scope.Scope;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class TypeGraphCycleBasedMutator implements Mutator {

    public boolean isApplicable(CtCodeElement gene) {
        return gene instanceof CtBlock && !SpoonManager.getTypesGraph().getNodesWithSelfCycles().isEmpty();
    }

    @Override
    public CtCodeElement mutate(CtCodeElement gene, Scope scope) {
        CtBlock<?> block = (CtBlock<?>) gene.clone();

        TypesGraph typesGraph = SpoonManager.getTypesGraph();

        List<CtTypeReference<?>> nodesWithCycles = typesGraph.getNodesWithSelfCycles();
        CtTypeReference<?> chosenNode = nodesWithCycles.get(RandomUtils.nextInt(nodesWithCycles.size()));

        List<List<CtField<?>>> simplePaths = typesGraph.getSimplePaths(typesGraph.getRoot(), chosenNode);
        List<CtField<?>> cyclicFields = typesGraph.getSelfCyclicFieldsOfNode(chosenNode);
        switch (getChoice(cyclicFields)) {
            case 0 -> applySingleFieldTraversal(block, simplePaths, cyclicFields);
            case 1 -> {

            }
            default -> throw new RuntimeException("Invalid choice");
        }
        return block;
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
