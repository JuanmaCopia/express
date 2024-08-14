package express.classinvariant.mutator;

import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;

import java.util.List;
import java.util.Set;

public class ClassInvariantMutatorManager {

    private final Set<ClassInvariantMutator> mutators;

    public ClassInvariantMutatorManager(Set<ClassInvariantMutator> mutators) {
        this.mutators = mutators;
    }

    public boolean performRandomMutation(ClassInvariantState state) {
        ClassInvariantMutator mutator = selectMutator(state);
        if (mutator != null) {
            mutator.mutate(state);
            //System.err.println("Mutator applied: " + mutator.getClass().getSimpleName());
            state.setFitnessAsOutdated();
            return true;
        }
        return false;
    }

    ClassInvariantMutator selectMutator(ClassInvariantState state) {
        List<ClassInvariantMutator> possibleMutators = mutators.stream()
                .filter(mutator -> mutator.isApplicable(state)).toList();
        if (possibleMutators.isEmpty())
            return null;
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

}
