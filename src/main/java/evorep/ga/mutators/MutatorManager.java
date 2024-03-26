package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.ga.mutators.typebased.*;
import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtCodeElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MutatorManager {

    private static final Set<Mutator> initPopulationMutators = new HashSet<>();
    private static Set<Mutator> mutators = new HashSet<>();

    public static void initialize() {
        mutators = new HashSet<>();
        mutators.add(new AddIfNullReturnMutator());
        mutators.add(new TraverseCyclicReferenceMutator());
        mutators.add(new TraverseWorklistMutator());
        mutators.add(new AddSizeCheckMutator());
        mutators.add(new AddComposedInitialNullCheckMutator());
        mutators.add(new AddComposedIfToTraversalMutator());
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
    }

    public static boolean mutate(Individual individual) {
        CtCodeElement gene = selectGene(individual);
        if (gene != null) {
            Mutator mutator = selectMutator(mutators, individual, gene);
            if (mutator != null && mutator.mutate(individual, gene)) {
                individual.setFitnessAsOutdated();
                return true;
            }
        }
        return false;
    }

    private static CtCodeElement selectGene(Individual individual) {
        List<CtCodeElement> mutableCodeElements = filterMutableCodeElements(individual);
        if (mutableCodeElements.isEmpty())
            return null;
        return mutableCodeElements.get(RandomUtils.nextInt(mutableCodeElements.size()));
    }

    private static Mutator selectMutator(Set<Mutator> candidateMutators, Individual individual, CtCodeElement gene) {
        List<Mutator> possibleMutators = candidateMutators.stream()
                .filter(mutator -> mutator.isApplicable(individual, gene)).toList();
        if (possibleMutators.isEmpty())
            return null;
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

    private static List<CtCodeElement> filterMutableCodeElements(Individual individual) {
        return individual.getChromosome().getElements(e -> isMutableCodeElement(individual, e));
    }

    private static boolean isMutableCodeElement(Individual individual, CtCodeElement element) {
        for (Mutator mutator : mutators)
            if (mutator.isApplicable(individual, element))
                return true;
        return false;
    }

    /*
     * public static void initialMutation(Individual individual) {
     * CtBlock<?> gene = individual.getChromosome().getBody();
     * Mutator mutator = selectMutator(initPopulationMutators, gene);
     * if (mutator != null)
     * mutator.mutate(individual, gene);
     * }
     */

}
