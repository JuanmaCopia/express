package evoexpress.ga;

import evoexpress.ga.mutator.Mutator;

import java.util.Set;

public class PrimitiveCheckGA extends GeneticAlgorithm {
    public PrimitiveCheckGA(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    boolean isTerminationConditionMet(Population population) {
        return false;
    }
    
}
