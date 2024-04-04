package evorep.ga;

import evorep.ga.mutators.Mutator;
import spoon.reflect.code.CtBlock;

import java.util.Set;

public class StructureCheckGA extends GeneticAlgorithm {
    public StructureCheckGA(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    CtBlock<?> selectPrecondition(Individual individual) {
        return individual.getStructureCheck();
    }
}
