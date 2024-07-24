package evoexpress.classinvariant.problem;

import evoexpress.classinvariant.mutator.ClassInvariantMutatorManager;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.fitness.ClassInvariantFitness;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;

import java.util.Set;

public class ClassInvariantProblem implements SimulatedAnnealingProblem {

    ClassInvariantMutatorManager mutatorManager;
    ClassInvariantFitness fitnessFunction;
    ClassInvariantState initialState;

    public ClassInvariantProblem(Set<ClassInvariantMutator> mutators, ClassInvariantFitness fitnessFunction, ClassInvariantState initialState) {
        mutatorManager = new ClassInvariantMutatorManager(mutators);
        this.fitnessFunction = fitnessFunction;
        this.initialState = initialState;
    }

    public ClassInvariantProblem(Set<ClassInvariantMutator> mutators, ClassInvariantFitness fitnessFunction) {
        mutatorManager = new ClassInvariantMutatorManager(mutators);
        this.fitnessFunction = fitnessFunction;
    }

    @Override
    public ClassInvariantState initialState() {
        return initialState == null ? new ClassInvariantState() : initialState;
    }

    @Override
    public ClassInvariantState nextState(SimulatedAnnealingState state) {
        return mutatorManager.performRandomMutation((ClassInvariantState) state);
    }

    @Override
    public Double evaluate(SimulatedAnnealingState state) {
        ClassInvariantState s = (ClassInvariantState) state;
        if (!s.isFitnessUpdated())
            fitnessFunction.evaluate(s);
        return s.getFitness();
    }

    @Override
    public boolean isTerminationConditionMet(SimulatedAnnealingState state) {
        return false;
    }

    @Override
    public void printCurrentState(int round, Double temperature, SimulatedAnnealingState currentState) {
        ClassInvariantState s = (ClassInvariantState) currentState;
        System.out.println(round + " | Temperature: " + temperature + " | Fitness: " + s.getFitness());
    }


}
