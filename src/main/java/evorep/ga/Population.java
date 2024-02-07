package evorep.ga;

import spoon.reflect.declaration.CtMethod;

import java.util.PriorityQueue;

public class Population {
    private PriorityQueue<Individual> population;

    /**
     * Initializes blank population of individuals
     */
    public Population() {
        population = new PriorityQueue<>();
    }

    public Population(Population initialPopulation) {
        population = new PriorityQueue<>(initialPopulation.getIndividuals());
    }

    public Population(int populationSize, CtMethod repOK) {
        population = new PriorityQueue<>();

        for (int i = 0; i < populationSize; i++)
            population.add(new Individual(repOK));
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
        return population.poll();
    }

    public void addIndividual(Individual individual) {
        population.add(individual);
    }

    /**
     * Get population's size
     *
     * @return size The population's size
     */
    public int size() {
        return population.size();
    }


}