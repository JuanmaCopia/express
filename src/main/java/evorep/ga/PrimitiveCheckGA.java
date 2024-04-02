package evorep.ga;

import evorep.ga.mutators.Mutator;
import spoon.reflect.declaration.CtMethod;

import java.util.Set;

public class PrimitiveCheckGA extends GeneticAlgorithm {
    public PrimitiveCheckGA(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        super(mutators, maxPopulationSize, mutationRate, crossoverRate, elitismCount);
    }

    @Override
    CtMethod<?> selectPrecondition(Individual individual) {
        return individual.getChromosome().getMethod("primitiveCheck");
    }
}
