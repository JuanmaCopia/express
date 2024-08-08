package evoexpress.search.simulatedannealing.problem;

import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;

public interface SimulatedAnnealingProblem {

    SimulatedAnnealingState initialState();

    SimulatedAnnealingState nextState(SimulatedAnnealingState state);

    Double evaluate(SimulatedAnnealingState state);

    boolean isTerminationConditionMet(SimulatedAnnealingState state);

    void printCurrentState(int round, Double temperature, SimulatedAnnealingState currentState);

    boolean shouldRestart(SimulatedAnnealingState currentState, SimulatedAnnealingState fittest);
}
