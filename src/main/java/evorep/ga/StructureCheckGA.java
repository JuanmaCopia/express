package evorep.ga;

import evorep.config.ToolConfig;
import evorep.ga.mutators.Mutator;
import spoon.reflect.code.CtBlock;

import java.util.Set;

public class StructureCheckGA extends GeneticAlgorithm {

    private static final int MAX_GEN_WITH_NO_IMPROVEMENT = 200;
    int generationsWithNoImprovement = 0;
    double lastFittest = FitnessFunctions.WORST_FITNESS_VALUE;

    public StructureCheckGA(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    boolean isTerminationConditionMet(Population population) {
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

    @Override
    CtBlock<?> selectPrecondition(Individual individual) {
        return individual.getStructureCheck();
    }

    @Override
    void printGeneration(Population population) {
        System.out.println("\n\n------------------   StructureCheck: Generation " + population.getGenerationNumber() + "   ------------------\n");
        System.out.println("Population size: " + population.size());
        System.out.println("Fittest: " + population.getFittest().getFitness());
        System.out.println("\n" + population.getFittest().toString());
    }
}
