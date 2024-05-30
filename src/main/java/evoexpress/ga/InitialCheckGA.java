package evoexpress.ga;

import evoexpress.config.ToolConfig;
import evoexpress.ga.fitness.FitnessFunctions;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.population.Population;

import java.util.Set;

public class InitialCheckGA extends GeneticAlgorithm {

    private static final int MAX_GEN_WITH_NO_IMPROVEMENT = 60;
    int generationsWithNoImprovement = 0;
    double lastFittest = FitnessFunctions.WORST_FITNESS_VALUE;

    public InitialCheckGA(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    public boolean isTerminationConditionMet(Population population) {
        if (lastFittest >= population.getFittest().getFitness())
            generationsWithNoImprovement++;
        else
            generationsWithNoImprovement = 0;
        lastFittest = population.getFittest().getFitness();
        if (generationsWithNoImprovement >= MAX_GEN_WITH_NO_IMPROVEMENT)
            return true;
        if (population.getGenerationNumber() >= ToolConfig.maxGenerations)
            return true;
        return false;
    }

}
