package evoexpress.ga.mutator.structurecheck.traversal;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.processors.traversals.InvokeWorklistProcessor;
import evoexpress.spoon.processors.traversals.TraverseWorklistProcessor;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;
import java.util.Set;

public class TraverseWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        return individual.hasNonTraversedPathsToCyclicNodes();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;
        Set<Path> paths = individual.getNonTraversedPathsToCyclicNodes();
        Path chosenPath = paths.stream().toList().get(RandomUtils.nextInt(paths.size()));
        paths.remove(chosenPath);
        individual.getTraversedPathsToCyclicNodes().add(chosenPath);

        CtTypeReference<?> nodeToTraverse = chosenPath.getTypeReference();
        Set<CtTypeReference<?>> nonTraversedNodesWithCycles = individual.getNonTraversedNodesWithCycles();

        if (nonTraversedNodesWithCycles.contains(nodeToTraverse)) {
            nonTraversedNodesWithCycles.remove(nodeToTraverse);
            instantiateTraversalMethod(chosenPath, individual);
        }

        return addTraversalInvocation(chosenPath, individual);
    }

//    private void replaceTraversalMethod(Path chosenPath, Individual individual, CtBlock<?> block) {
//        CtMethod<?> traversal = getTraversalOfNode(individual.getCtClass(), chosenPath.getTypeReference());
//        String traversalName = traversal.getSimpleName();
//        removeInvocation(traversalName, block);
//        individual.getCtClass().removeMethod(traversal);
//        instantiateTraversalMethod(chosenPath, individual);
//    }

//    private void removeInvocation(String traversalName, CtBlock<?> block) {
//        List<CtElement> ifContainingInvocations = SpoonQueries.getIfsInvokingMethod(block, traversalName);
//        for (CtElement statement : ifContainingInvocations) {
//            block.removeStatement((CtStatement) statement);
//        }
//    }

    private void instantiateTraversalMethod(Path chosenPath, Individual individual) {
        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        boolean useBreakInsteadOfReturn = RandomUtils.nextBoolean();
        Processor<CtClass<?>> p = new TraverseWorklistProcessor(chosenPath, loopFields, useBreakInsteadOfReturn);
        p.process(individual.getCtClass());
    }

    private boolean addTraversalInvocation(Path chosenPath, Individual individual) {
        CtMethod<?> traversal = SpoonQueries.getTraversalOfNode(individual.getCtClass(), chosenPath.getTypeReference());
        assert traversal != null;

        List<CtParameter<?>> params = traversal.getParameters();
        if (!params.get(params.size() - 2).getType().equals(chosenPath.getParentPath().getTypeReference()))
            return false;

        Processor<CtClass<?>> p = new InvokeWorklistProcessor(chosenPath, traversal);
        p.process(individual.getCtClass());
        return true;
    }

}
