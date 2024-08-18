package express.classinvariant.problem;

import express.classinvariant.mutator.ClassInvariantMutatorManager;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.fitness.ClassInvariantFitness;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import express.search.simulatedannealing.state.SimulatedAnnealingState;

import java.text.DecimalFormat;
import java.util.Set;

public class ClassInvariantProblem implements SimulatedAnnealingProblem {

    ClassInvariantMutatorManager mutatorManager;
    ClassInvariantFitness fitnessFunction;
    ClassInvariantState initialState;

    int restartRounds;
    int roundsWithoutImprovement = 0;

    public ClassInvariantProblem(Set<ClassInvariantMutator> mutators, ClassInvariantFitness fitnessFunction, ClassInvariantState initialState, int restartRounds) {
        mutatorManager = new ClassInvariantMutatorManager(mutators);
        this.fitnessFunction = fitnessFunction;
        this.initialState = initialState;
        this.restartRounds = restartRounds;
    }

    public ClassInvariantProblem(Set<ClassInvariantMutator> mutators, ClassInvariantFitness fitnessFunction,  int restartRounds) {
        mutatorManager = new ClassInvariantMutatorManager(mutators);
        this.fitnessFunction = fitnessFunction;
        this.restartRounds = restartRounds;
    }

    @Override
    public ClassInvariantState initialState() {
        if (initialState != null)
            return initialState;
        return new ClassInvariantState();
    }

    @Override
    public SimulatedAnnealingState nextState(SimulatedAnnealingState state) {
        ClassInvariantState stateClone = ((ClassInvariantState) state).clone();
        ClassInvariantState nextState = (ClassInvariantState) state;
        if (mutatorManager.performRandomMutation(stateClone)) {
            nextState = stateClone;
        }
        return nextState;
    }

    @Override
    public Double evaluate(SimulatedAnnealingState state) {
        ClassInvariantState s = (ClassInvariantState) state;
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
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(round + " | Temperature: " + df.format(temperature) + " | Fitness: " + df.format(s.getFitness()));
    }

    @Override
    public boolean shouldRestart(SimulatedAnnealingState currentState, SimulatedAnnealingState fittest) {
        if (fittest.getFitness() >= currentState.getFitness()) {
            roundsWithoutImprovement++;
        } else {
            roundsWithoutImprovement = 0;
        }
        if (roundsWithoutImprovement >= restartRounds) {
            roundsWithoutImprovement = 0;
            return true;
        }
        return false;
    }


}