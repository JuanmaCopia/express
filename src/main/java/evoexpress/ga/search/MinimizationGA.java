package evoexpress.ga.search;

import evoexpress.ga.fitness.FitnessFunction;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.population.Population;

import java.util.Set;

public class MinimizationGA extends GeneticAlgorithm {

    private static final int MAX_GEN_WITH_NO_IMPROVEMENT = 30;
    int generationsWithNoImprovement = 0;
    double lastFittest = FitnessFunction.WORST_FITNESS_VALUE;

    public MinimizationGA(Set<Mutator> mutators, FitnessFunction fitnessFunction, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, fitnessFunction, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    boolean isTerminationConditionMet(Population population) {
        if (lastFittest >= population.getFittest().getFitness())
            generationsWithNoImprovement++;
        else
            generationsWithNoImprovement = 0;
        lastFittest = population.getFittest().getFitness();
        return generationsWithNoImprovement >= MAX_GEN_WITH_NO_IMPROVEMENT;
    }

}
