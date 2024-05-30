package evoexpress.ga.population;

import evoexpress.ga.individual.Individual;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Population {

    private final PriorityQueue<Individual> population;
    private final HashSet<String> presentIndividuals;
    private int generationNumber = 1;

    /**
     * Initializes blank population of individuals
     */
    public Population() {
        population = new PriorityQueue<>();
        presentIndividuals = new HashSet<>();
    }

    /**
     * Get individuals from the population
     *
     * @return individuals in population
     */
    public PriorityQueue<Individual> getIndividuals() {
        return population;
    }

    /**
     * Get the fittest individual in the population
     *
     * @return The fittest individual in the population
     */
    public Individual getFittest() {
        return population.peek();
    }

    /**
     * Remove the fittest individual from the population
     *
     * @return The fittest individual in the population
     */
    public Individual removeFittest() {
        assert !population.isEmpty();
        Individual fittest = population.poll();
        presentIndividuals.remove(fittest.toString());
        return fittest;
    }

    /**
     * Add individual to the population
     *
     * @param individual The individual to add
     */
    public void addIndividual(Individual individual) {
        if (presentIndividuals.add(individual.toString())) {
            population.add(individual);
        }
    }

    /**
     * Get population's size
     *
     * @return size The population's size
     */
    public int size() {
        return population.size();
    }


    /**
     * Get the generation number of the population
     *
     * @return The generation number of the population
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Set the generation number of the population
     *
     * @param generationNumber The generation number of the population
     */
    public void setGenerationNumber(int generationNumber) {
        this.generationNumber = generationNumber;
    }

}