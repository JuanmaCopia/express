package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.scope.Scope;
import evorep.spoon.RandomUtils;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MutatorManager {

    private static Set<Mutator> mutators = new HashSet<>();

    public static void initializeMutators() {
        mutators = new HashSet<>();
        /*mutators.add(new BlockMutator());
        mutators.add(new IfMutator());
        mutators.add(new AssignmentMutator());
        mutators.add(new InvocationMutator());
        mutators.add(new UnaryOperatorMutator());
        mutators.add(new BinaryOperatorMutator());*/
    }

    private static CtCodeElement selectGene(Individual individual) {
        List<CtCodeElement> mutableCodeElements = filterMutableCodeElements(individual.getChromosome());
        return mutableCodeElements.get(RandomUtils.nextInt(mutableCodeElements.size()));
    }

    private static List<CtCodeElement> filterMutableCodeElements(CtElement element) {
        return element.getElements(e -> isMutableCodeElement(e));
    }

    private static boolean isMutableCodeElement(CtCodeElement element) {
        for (Mutator mutator : mutators)
            if (mutator.isApplicable(element))
                return true;
        return false;
    }

    private static Mutator selectMutator(CtCodeElement element) {
        List<Mutator> possibleMutators = mutators.stream().filter(mutator -> mutator.isApplicable(element)).toList();
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

    public static Individual mutate(Individual individual) {
        Individual mutant = individual.clone();
        CtCodeElement gene = selectGene(mutant);
        CtCodeElement mutatedGene = selectMutator(gene).mutate(gene, new Scope(gene));
        gene.replace(mutatedGene);
        return mutant;
    }

}
