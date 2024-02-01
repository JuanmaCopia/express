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

    private static CtElement selectElementToMutate(Individual individual) {
        List<CtElement> mutableCodeElements = filterMutableCodeElements(individual.getChromosome());
        return mutableCodeElements.get(RandomUtils.nextInt(mutableCodeElements.size()));
    }

    private static List<CtElement> filterMutableCodeElements(CtElement element) {
        return element.getElements(e -> e instanceof CtCodeElement && isMutableCodeElement(e));
    }

    private static boolean isMutableCodeElement(CtElement element) {
        for (Mutator mutator : mutators)
            if (mutator.isApplicable(element))
                return true;
        return false;
    }

    private static Mutator selectMutator(CtElement element) {
        List<Mutator> possibleMutators = mutators.stream().filter(mutator -> mutator.isApplicable(element)).toList();
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

    public static Individual mutate(Individual individual) {
        Individual mutant = individual.clone();
        CtElement elemToMutate = selectElementToMutate(mutant);

        Mutator mutator = selectMutator(elemToMutate);
        mutator.mutate(elemToMutate, new Scope(elemToMutate));

        return mutant;
    }

}
