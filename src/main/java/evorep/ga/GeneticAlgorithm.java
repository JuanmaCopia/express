package evorep.ga;

import evorep.ga.mutators.MutatorManager;
import evorep.spoon.SpoonCompiler;
import evorep.spoon.SpoonQueries;
import org.apache.commons.text.similarity.LevenshteinDistance;
import spoon.reflect.declaration.CtMethod;

/**
 * The GeneticAlgorithm class is our main abstraction for managing the
 * operations of the genetic algorithm. This class is meant to be
 * problem-specific, meaning that (for instance) the "calcFitness" method may
 * need to change from problem to problem.
 * <p>
 * This class concerns itself mostly with population-level operations, but also
 * problem-specific operations such as calculating fitness, testing for
 * termination criteria, and managing mutation and crossover operations (which
 * generally need to be problem-specific as well).
 * <p>
 * Generally, GeneticAlgorithm might be better suited as an abstract class or an
 * interface, rather than a concrete class as below. A GeneticAlgorithm
 * interface would require implementation of methods such as
 * "isTerminationConditionMet", "calcFitness", "mutatePopulation", etc, and a
 * concrete class would be defined to solve a particular problem domain. For
 * instance, the concrete class "TravelingSalesmanGeneticAlgorithm" would
 * implement the "GeneticAlgorithm" interface. This is not the approach we've
 * chosen, however, so that we can keep each chapter's examples as simple and
 * concrete as possible.
 *
 * @author bkanber
 */
public class GeneticAlgorithm {

    private static final double NOT_COMPILE_PENALIZATION = 1000;
    private int maxPopulationSize;

    /**
     * Mutation rate is the fractional probability than an individual gene will
     * mutate randomly in a given generation. The range is 0.0-1.0, but is
     * generally small (on the order of 0.1 or less).
     */
    private double mutationRate;

    /**
     * Crossover rate is the fractional probability that two individuals will
     * "mate" with each other, sharing genetic information, and creating
     * offspring with traits of each of the parents. Like mutation rate the
     * rance is 0.0-1.0 but small.
     */
    private double crossoverRate;

    public GeneticAlgorithm(int maxPopulationSize, double mutationRate, double crossoverRate) {
        this.maxPopulationSize = maxPopulationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
    }

    /**
     * Initialize population
     *
     * @param repOK The repOK method
     * @return population The initial population generated
     */
    public Population initPopulation(CtMethod repOK) {
        return new Population(this.maxPopulationSize, repOK);
    }

    /**
     * Calculate fitness for an individual.
     *
     * @param individual the individual to evaluate
     * @return double The fitness value for individual
     */
    public double calcFitness(Individual individual) {
        String goal = SpoonQueries.getFalseFitnessString();
        String individualString = individual.toString();

        double fitness = new LevenshteinDistance().apply(goal, individualString);

        if (!SpoonCompiler.compileIndividual(individual)) {
            fitness += NOT_COMPILE_PENALIZATION;
        }

        individual.setFitness(fitness);
        return fitness;
    }


    public void evalPopulation(Population population) {
        population.getIndividuals().stream().filter(Individual::needsFitnessUpdate).forEach(this::calcFitness);
    }

    /**
     * Check if population has met termination condition
     *
     * @param population
     * @return boolean True if termination condition met, otherwise, false
     */
    public boolean isTerminationConditionMet(Population population) {
        return false;
    }

    /**
     * Apply mutation to population
     *
     * @param population The population to apply mutation to
     * @return The mutated population
     */
    public Population mutatePopulation(Population population) {
        Population newPopulation = new Population(population);

        for (Individual individual : population.getIndividuals()) {
            individual = mutateIndividual(individual);
            newPopulation.addIndividual(individual);
        }

        return newPopulation;
    }

    private Individual mutateIndividual(Individual individual) {
        Individual mutant = MutatorManager.mutate(individual);
        mutant.setFitnessAsOutdated();
        return mutant;
    }


    public Population selectFittest(Population population) {
        Population newPopulation = new Population();
        System.out.println("Population size: " + population.size());
        int i = 0;
        while (i < maxPopulationSize && population.size() > 0) {
            newPopulation.addIndividual(population.removeFittest());
            i++;
        }
        return newPopulation;
    }


}
