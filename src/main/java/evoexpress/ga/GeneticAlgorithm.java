package evoexpress.ga;

import evoexpress.ga.fitness.FitnessFunctions;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.population.Population;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonManager;
import spoon.reflect.code.CtCodeElement;

import java.util.List;
import java.util.Set;

public abstract class GeneticAlgorithm {

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

    /**
     * Set of mutators to employ in the search
     */
    private Set<Mutator> mutators;

    public GeneticAlgorithm(Set<Mutator> mutators, int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.mutators = mutators;
        this.maxPopulationSize = maxPopulationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;

    }

    public Population initPopulation() {
        Population initialPopulation = new Population();
        Individual individual = new Individual();
        assert SpoonManager.compileIndividual(individual);
        initialPopulation.addIndividual(individual);
        return initialPopulation;
    }

    /**
     * Evaluate the fitness of the population
     *
     * @param population The population to evaluate
     */
    void evalPopulation(Population population) {
        population.getIndividuals().stream().filter(Individual::isFitnessUpdated).forEach(FitnessFunctions::invalidInstancesNoLengthFitness);
    }

    /**
     * Check if population has met termination condition
     *
     * @param population
     * @return boolean True if termination condition met, otherwise, false
     */
    abstract boolean isTerminationConditionMet(Population population);

    /**
     * Apply mutation to population
     *
     * @param population The population to apply mutation to
     * @return The mutated population
     */
    Population mutatePopulation(Population population) {
        Population newPopulation = new Population();
        newPopulation.setGenerationNumber(population.getGenerationNumber());

        int i = 0;
        for (Individual individual : population.getIndividuals()) {
            if (i < elitismCount) {
                newPopulation.addIndividual(individual);
            }
            handleMutation(individual, newPopulation);
            i++;
        }

        return newPopulation;
    }

    private void handleMutation(Individual individual, Population newPopulation) {
        if (shouldMutate(individual)) {
            Individual mutant = mutateIndividual(individual, mutators);
            if (mutant != null) {
                newPopulation.addIndividual(mutant);
            }
        }
    }

    private boolean shouldMutate(Individual individual) {
        return individual.getFitness() > FitnessFunctions.WORST_FITNESS_VALUE && Math.random() < mutationRate;
    }

    Individual mutateIndividual(Individual individual, Set<Mutator> mutators) {
        Individual mutant = cloneIndividual(individual);
        SpoonManager.addClassToPackage(mutant.getCtClass());
        CtCodeElement gene = selectGene(mutant, mutators);
        Mutator mutator = selectMutator(mutators, mutant, gene);
        if (mutator != null && mutator.mutate(mutant, gene) && SpoonManager.compileIndividual(mutant)) {
            return mutant;
        }
        SpoonManager.removeClassFromPackage(mutant.getCtClass());
        return null;
    }

    private Individual cloneIndividual(Individual individual) {
        return new Individual(individual);
    }

//    private Individual cloneIndividual(Individual individual) {
//        CtClass<?> cls = individual.getCtClass();
//
//
//        return new Individual(cls);
//    }

    CtCodeElement selectGene(Individual individual, Set<Mutator> mutators) {
        List<CtCodeElement> mutableCodeElements = filterMutableCodeElements(individual, mutators);
        if (mutableCodeElements.isEmpty())
            return null;
        return mutableCodeElements.get(RandomUtils.nextInt(mutableCodeElements.size()));
    }

    Mutator selectMutator(Set<Mutator> candidateMutators, Individual individual, CtCodeElement gene) {
        if (gene == null) {
            return null;
        }
        List<Mutator> possibleMutators = candidateMutators.stream()
                .filter(mutator -> mutator.isApplicable(individual, gene)).toList();
        if (possibleMutators.isEmpty())
            return null;
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

    boolean isMutableCodeElement(Individual individual, CtCodeElement element, Set<Mutator> mutators) {
        for (Mutator mutator : mutators)
            if (mutator.isApplicable(individual, element))
                return true;
        return false;
    }

    List<CtCodeElement> filterMutableCodeElements(Individual individual, Set<Mutator> mutators) {
        return individual.getCtClass().getElements(e -> isMutableCodeElement(individual, e, mutators));
    }

    /**
     * Select the survivors of the population
     *
     * @param population The population to select survivors from
     * @return The new population of survivors
     */
    Population selectSurvivors(Population population) {
        Population survivors = new Population();
        survivors.setGenerationNumber(population.getGenerationNumber() + 1);
        int i = 0;
        while (i < maxPopulationSize && population.size() > 0) {
            Individual fittest = population.removeFittest();
            if (fittest.getFitness() > FitnessFunctions.WORST_FITNESS_VALUE)
                survivors.addIndividual(fittest);
            else {
                SpoonManager.removeClassFromPackage(fittest.getCtClass());
            }
            i++;
        }

        return survivors;
    }


    public Population startSearch(Population population) {
        evalPopulation(population);
        population = selectSurvivors(population);

        while (!isTerminationConditionMet(population)) {
            printGeneration(population);
            //population = crossoverPopulation(population);
            population = mutatePopulation(population);
            evalPopulation(population);
            population = selectSurvivors(population);
        }
        //printResults(population, generation - 1);
        return population;
    }

    void printGeneration(Population population) {
        System.out.println("\n\n------------------   " + this.getClass().getSimpleName() + ": Generation " + population.getGenerationNumber() + "   ------------------\n");
        System.out.println("Population size: " + population.size());
        System.out.println("Fittest: " + population.getFittest().getFitness());
        //System.out.println("\n" + population.getFittest().toString());
    }

}
