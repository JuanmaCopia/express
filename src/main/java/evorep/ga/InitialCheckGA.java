package evorep.ga;

import evorep.ga.mutators.Mutator;
import spoon.reflect.code.CtBlock;

import java.util.Set;

public class InitialCheckGA extends GeneticAlgorithm {

    private static int MAX_GEN_WITH_NO_IMPROVEMENT = 300;

    int generationsWithNoImprovement = 0;

    public InitialCheckGA(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    public boolean isTerminationConditionMet(Population population) {
        if (lastFittest >= population.getFittest().getFitness())
            generationsWithNoImprovement++;
        return generationsWithNoImprovement >= MAX_GEN_WITH_NO_IMPROVEMENT;
    }

    @Override
    CtBlock<?> selectPrecondition(Individual individual) {
        return individual.getInitialCheck();
    }


}
