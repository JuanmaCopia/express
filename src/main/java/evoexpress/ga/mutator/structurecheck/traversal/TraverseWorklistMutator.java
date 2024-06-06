package evoexpress.ga.mutator.structurecheck.traversal;

import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.MutatorHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.processors.traversals.TraverseWorklistProcessor;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;
import java.util.Set;

public class TraverseWorklistMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;
        return individual.hasNonTraversedPaths();
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        Set<Path> paths = individual.getNonTraversedPathsToCyclicNodes();
        Path chosenPath = paths.stream().toList().get(RandomUtils.nextInt(paths.size()));
        paths.remove(chosenPath);

        CtVariableRead<?> chosenInitialField = chosenPath.getVariableRead();

        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenPath.get(0));
        List<CtVariable<?>> loopFields = typeGraph.getCyclicFieldsOfNode(chosenInitialField.getType());

        loopFields = MutatorHelper.selectRandomVariablesFromList(loopFields);

        Processor<CtClass<?>> p = new TraverseWorklistProcessor(chosenInitialField, loopFields);
        p.process(individual.getCtClass());

        //System.err.println("\nTraverseWorklistMutator:\n" + individual.getCtClass().toString());

        return true;
    }


}
