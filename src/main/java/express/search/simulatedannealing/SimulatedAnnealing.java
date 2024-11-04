package express.search.simulatedannealing;

import express.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import express.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import express.search.simulatedannealing.state.SimulatedAnnealingState;

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
        SimulatedAnnealingState fittest = currentState.clone();
        int i = 0;
        while (!problem.isTerminationConditionMet(currentState)) {

            double temperature = schedule.schedule(i);
            if (temperature <= 0.1) {
                return fittest;
            }
            problem.printCurrentState(i, temperature, currentState);
            i++;
            SimulatedAnnealingState nextState = problem.nextState(currentState);
            if (nextState == null)
                continue;

            double delta = currentState.getFitness() - problem.evaluate(nextState);
            if (delta < 0) {
                currentState = nextState;
            } else {
                delta = delta + 1.0;
                double probability = Math.exp(-delta / temperature);
                if (Math.random() < probability) {
                    currentState = nextState;
                }
            }

            if (problem.shouldRestart(currentState, fittest)) {
                currentState = fittest.clone();
            } else if (currentState.getFitness() > fittest.getFitness()) {
                fittest = currentState.clone();
            }

        }
        return fittest;
    }
}
