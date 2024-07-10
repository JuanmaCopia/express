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

import java.util.ArrayList;
import java.util.List;

public class TraverseWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        return true;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        List<Path> pathsToCyclicNodes = new ArrayList<>(SpoonManager.inputTypeData.getPathsToCyclicNodes());
        List<Path> paths = pathsToCyclicNodes.stream().filter(
                path -> individual.getNonTraversedNodesWithCycles().contains(path.getTypeReference())
        ).toList();

        Path chosenPath;
        if (!paths.isEmpty()) {
            chosenPath = paths.get(RandomUtils.nextInt(paths.size()));
            individual.setTypeAsTraversed(chosenPath.getTypeReference());
            instantiateTraversalMethod(chosenPath, individual);

        } else {
            chosenPath = pathsToCyclicNodes.get(RandomUtils.nextInt(pathsToCyclicNodes.size()));
        }

        if (!addTraversalInvocation(chosenPath, individual, (CtBlock<?>) gene))
            return false;

        //System.err.println("TraverseWorklistMutator:\n" + individual.getCtClass().toString());

        return true;
    }

    private void instantiateTraversalMethod(Path chosenPath, Individual individual) {
        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(chosenPath.getTypeReference());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        boolean useBreakInsteadOfReturn = RandomUtils.nextBoolean();
        Processor<CtClass<?>> p = new TraverseWorklistProcessor(chosenPath, loopFields, useBreakInsteadOfReturn);
        p.process(individual.getCtClass());
    }

    private boolean addTraversalInvocation(Path chosenPath, Individual individual, CtBlock<?> blockGene) {
        CtMethod<?> traversal = SpoonQueries.getTraversalOfNode(individual.getCtClass(), chosenPath.getTypeReference());
        assert traversal != null;

        List<CtParameter<?>> params = traversal.getParameters();
        if (!params.get(params.size() - 2).getType().equals(chosenPath.getParentPath().getTypeReference()))
            return false;

        InvokeWorklistProcessor p = new InvokeWorklistProcessor(chosenPath, traversal);
        p.process(individual.getCtClass());

//        if (SpoonQueries.checkAlreadyExistSimple(p.resultCheck.getCondition(), blockGene))
//            return false;

        return true;
    }

}
