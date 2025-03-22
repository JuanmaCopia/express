package express.classinvariant.mutator;

import java.util.List;

import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;

public class ClassInvariantMutatorManager {

    private final List<ClassInvariantMutator> mutators;

    public ClassInvariantMutatorManager(List<ClassInvariantMutator> mutators) {
        this.mutators = mutators;
    }

    public boolean performRandomMutation(ClassInvariantState state) {
        ClassInvariantMutator mutator = selectMutator(state);
        if (mutator != null) {
            mutator.mutate(state);
            // System.err.println("Mutator applied: " + mutator.getClass().getSimpleName());
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

//    private List<ClassInvariantMutator> getApplicableMutators(ClassInvariantState state) {
//        List<ClassInvariantMutator> applicableMutators = new ArrayList<>();
//        for (ClassInvariantMutator mutator : mutators) {
//            String stateStr = state.toString();
//            if (mutator.isApplicable(state)) {
//                applicableMutators.add(mutator);
//            }
//            if (!stateStr.equals(state.toString()))
//                throw new IllegalStateException("The following mutator has changed the state: " + mutator.getClass().getSimpleName());
//        }
//        return applicableMutators;
//    }

}
