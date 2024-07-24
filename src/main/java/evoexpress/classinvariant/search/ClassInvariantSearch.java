package evoexpress.classinvariant.search;

import evoexpress.search.simulatedannealing.SimulatedAnnealing;
import evoexpress.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import evoexpress.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;

public class ClassInvariantSearch extends SimulatedAnnealing {
    public ClassInvariantSearch(SimulatedAnnealingProblem problem, SimulatedAnnealingSchedule schedule) {
        super(problem, schedule);
    }
}
