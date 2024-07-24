package evoexpress.search.simulatedannealing;

import evoexpress.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import evoexpress.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;

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
        int i = 0;
        while (!problem.isTerminationConditionMet(currentState)) {
            double temperature = schedule.schedule(i);
            if (temperature <= 0.1) {
                return currentState;
            }
            problem.printCurrentState(i, temperature, currentState);
            i++;
            SimulatedAnnealingState nextState = problem.nextState(currentState);

            if (nextState == null)
                continue;

            double delta = problem.evaluate(currentState) - problem.evaluate(nextState);
            if (delta < 0) {
                currentState = nextState;
            } else {
                delta = delta + 1.0;
                double probability = Math.exp(-delta / temperature);
                System.out.println("Delta: " + delta + " Probability: " + probability);
                if (Math.random() < probability) {
                    currentState = nextState;
                }
            }

        }
        return currentState;
    }
}
