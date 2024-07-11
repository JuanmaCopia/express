package evoexpress.ga;

import evoexpress.ga.fitness.FitnessFunction;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.population.Population;

import java.util.Set;

public class PrimitiveCheckGA extends GeneticAlgorithm {
    public PrimitiveCheckGA(Set<Mutator> mutators, FitnessFunction fitnessFunction, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, fitnessFunction, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    boolean isTerminationConditionMet(Population population) {
        return false;
    }

}
