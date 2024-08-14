package express.classinvariant.search;

import express.search.simulatedannealing.SimulatedAnnealing;
import express.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import express.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;

public class ClassInvariantSearch extends SimulatedAnnealing {
    public ClassInvariantSearch(SimulatedAnnealingProblem problem, SimulatedAnnealingSchedule schedule) {
        super(problem, schedule);
    }
}
