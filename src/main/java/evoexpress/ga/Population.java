package evoexpress.ga;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Population {
    private PriorityQueue<Individual> population;
    private HashSet<String> presentIndividuals = new HashSet<>();
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

    public Individual getFittest() {
        return population.peek();
    }

    public Individual removeFittest() {
        Individual fittest = population.poll();
        presentIndividuals.remove(fittest.toString());
        return fittest;
    }

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


    public void increaseGeneration() {
        generationNumber++;
    }

    public int getGenerationNumber() {
        return generationNumber;
    }

    public void setGenerationNumber(int generationNumber) {
        this.generationNumber = generationNumber;
    }

}