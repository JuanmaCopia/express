package express.search.simulatedannealing;

import express.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import express.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import express.search.simulatedannealing.state.SimulatedAnnealingState;
import express.spoon.RandomUtils;

public abstract class SimulatedAnnealing {

    SimulatedAnnealingProblem problem;
    SimulatedAnnealingSchedule schedule;

    public SimulatedAnnealing(SimulatedAnnealingProblem problem, SimulatedAnnealingSchedule schedule) {
        this.problem = problem;
        this.schedule = schedule;
    }

    public SimulatedAnnealingState startSearch() {
        SimulatedAnnealingState currentState = problem.initialState();
        problem.evaluate(currentState);
        SimulatedAnnealingState bestState = currentState.clone();
        int i = 0;
        while (!problem.isTerminationConditionMet(currentState)) {

            double temperature = schedule.schedule(i);
            if (temperature <= 0.01) {
                return bestState;
            }
            problem.printCurrentState(i, temperature, currentState);
            i++;
            SimulatedAnnealingState nextState = problem.nextState(currentState);
            if (nextState == null)
                continue;

            double currentEnergy = currentState.getFitness();
            double nextEnergy = problem.evaluate(nextState);

            // Decide whether to accept the new solution
            if (acceptanceProbability(currentEnergy, nextEnergy, temperature) > RandomUtils.nextDouble()) {
                currentState = nextState;
            }

            if (problem.shouldRestart(currentState, bestState)) {
                currentState = bestState.clone();
            } else if (currentState.getFitness() < bestState.getFitness()) {
                bestState = currentState.clone();
            }

        }
        return bestState;
    }

    private double acceptanceProbability(double currentEnergy, double nextEnergy, double temperature) {
        if (nextEnergy < currentEnergy) {
            return 1.0; // Always accept better solutions
        }
        return Math.exp((currentEnergy - nextEnergy) / temperature); // Accept worse solutions with a probability
    }
}
