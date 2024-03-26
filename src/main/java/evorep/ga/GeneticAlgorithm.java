package evorep.ga;

import evorep.ga.mutators.MutatorManager;

public class GeneticAlgorithm {

    public static final int MIN_POPULATION_SIZE = 1;

    private final int maxPopulationSize;
    /**
     * Mutation rate is the fractional probability than an individual gene will
     * mutate randomly in a given generation. The range is 0.0-1.0, but is
     * generally small (on the order of 0.1 or less).
     */
    private final double mutationRate;
    /**
     * Crossover rate is the fractional probability that two individuals will
     * "mate" with each other, sharing genetic information, and creating
     * offspring with traits of each of the parents. Like mutation rate the
     * rance is 0.0-1.0 but small.
     */
    private final double crossoverRate;
    /**
     * Elitism is the concept that the strongest members of the population
     * should be preserved from generation to generation. If an individual is
     * one of the elite, it will not be mutated or crossover.
     */
    private final int elitismCount;

    public GeneticAlgorithm(int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.maxPopulationSize = maxPopulationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;

    }

    public Population initPopulation() {
        Population initialPopulation = new Population();
        Individual individual = new Individual(0);
        initialPopulation.addIndividual(individual);
        return initialPopulation;
    }


    /**
     * Evaluate the fitness of the population
     *
     * @param population The population to evaluate
     */
    public void evalPopulation(Population population) {
        population.getIndividuals().stream().filter(Individual::needsFitnessUpdate).forEach(FitnessFunctions::invalidInstancesFitness);
    }

    /**
     * Check if population has met termination condition
     *
     * @param population
     * @return boolean True if termination condition met, otherwise, false
     */
    public boolean isTerminationConditionMet(Population population) {
        return population.getFittest().getFitness() > -1.0;
    }

    /**
     * Apply mutation to population
     *
     * @param population The population to apply mutation to
     * @return The mutated population
     */
    public Population mutatePopulation(Population population) {
        Population newPopulation = new Population();

        int i = 0;
        for (Individual individual : population.getIndividuals()) {
            if (i < elitismCount) {
                Individual clone = new Individual(individual, newPopulation.getNextID());
                if (MutatorManager.mutate(clone))
                    newPopulation.addIndividual(clone);
            } else if (Math.random() < mutationRate && individual.getFitness() > FitnessFunctions.WORST_FITNESS_VALUE) {
                MutatorManager.mutate(individual);
            }
            newPopulation.addIndividual(individual);
            i++;
        }

        return newPopulation;
    }

    /**
     * Select the survivors of the population
     *
     * @param population The population to select survivors from
     * @return The new population of survivors
     */
    public Population selectSurvivors(Population population) {
        Population survivors = new Population();
        int i = 0;
        while (i < maxPopulationSize && population.size() > 0) {
            Individual fittest = population.removeFittest();
            if (survivors.size() < MIN_POPULATION_SIZE)
                survivors.addIndividual(fittest);
            else if (fittest.getFitness() > FitnessFunctions.WORST_FITNESS_VALUE)
                survivors.addIndividual(fittest);
            i++;
        }
        return survivors;
    }


}
