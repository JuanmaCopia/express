package evoexpress.classinvariant.mutator;

import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;

import java.util.List;
import java.util.Set;

public class ClassInvariantMutatorManager {

    private final Set<ClassInvariantMutator> mutators;

    public ClassInvariantMutatorManager(Set<ClassInvariantMutator> mutators) {
        this.mutators = mutators;
    }

    public ClassInvariantState performRandomMutation(ClassInvariantState state) {
        ClassInvariantState mutant = state.clone();
        ClassInvariantMutator mutator = selectMutator(mutant);
        SpoonManager.addClassToPackage(mutant.getCtClass());

        if (mutator != null && mutator.mutate(mutant)) {
            boolean compiles = false;
            try {
                compiles = SpoonManager.compileCtClass(mutant.getCtClass());
            } catch (Exception e) {
                SpoonManager.removeClassFromPackage(mutant.getCtClass());
                System.err.println("Error while compiling state");
                System.err.println("Individual: \n" + mutant);
            }
            SpoonManager.removeClassFromPackage(mutant.getCtClass());
            if (!compiles) {
                return null;
            }
            return mutant;
        }
        SpoonManager.removeClassFromPackage(mutant.getCtClass());
        return null;
    }

    ClassInvariantMutator selectMutator(ClassInvariantState state) {
        List<ClassInvariantMutator> possibleMutators = mutators.stream()
                .filter(mutator -> mutator.isApplicable(state)).toList();
        if (possibleMutators.isEmpty())
            return null;
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

}
