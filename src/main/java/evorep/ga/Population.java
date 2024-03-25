package evorep.ga;

import spoon.reflect.declaration.CtClass;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Population {
    private PriorityQueue<Individual> population;
    private HashSet<String> presentIndividuals = new HashSet<>();

    /**
     * Initializes blank population of individuals
     */
    public Population() {
        population = new PriorityQueue<>();
        presentIndividuals = new HashSet<>();
    }

    public Population(Population initialPopulation) {
        population = new PriorityQueue<>(initialPopulation.population);
        presentIndividuals = new HashSet<>(initialPopulation.presentIndividuals);
    }

    public Population(int populationSize, CtClass<?> preconditionClass) {
        population = new PriorityQueue<>();

        for (int i = 0; i < populationSize; i++) {
            Individual individual = new Individual();
            addIndividual(individual);
        }
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


}