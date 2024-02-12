package evorep.ga.mutators.typebased;

import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonManager;
import evorep.spoon.scope.Scope;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
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
        CtTypeReference<?> randomNode = nodesWithCycles.get(RandomUtils.nextInt(nodesWithCycles.size()));

        List<CtField<?>> cyclicFields = typesGraph.getSelfCyclicFieldsOfNode(randomNode);
/*        switch (getChoice(cyclicFields)) {
            case 0 ->
            case 1 -> ;
            default -> throw new RuntimeException("Invalid choice");
        }*/
        return block;
    }

    public static int getChoice(List<CtField<?>> cyclicFields) {
        List<Integer> filteredChoices = new ArrayList<>();
        if (cyclicFields.size() == 1) {
            filteredChoices.add(0);
        } else if (cyclicFields.size() > 1) {
            filteredChoices.add(1);
        }
        return filteredChoices.get(RandomUtils.nextInt(filteredChoices.size()));
    }

/*    public static void ApplySingleFieldTraversal() {
        Processor<CtBlock<?>> p = new ReferenceTraversalProcessor(headField, nextField);

        p.process(method.getBody());
    }*/


}
