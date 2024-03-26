package evorep.ga;

import evorep.config.ToolConfig;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Population {
    private PriorityQueue<Individual> population;
    private HashSet<String> presentIndividuals = new HashSet<>();

    private boolean[] presentIDs = new boolean[ToolConfig.maxPopulation + ToolConfig.elitismCount];

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
        presentIDs[fittest.getId()] = false;
        return fittest;
    }

    public void addIndividual(Individual individual) {
        if (presentIndividuals.add(individual.toString())) {
            population.add(individual);
            presentIDs[individual.getId()] = true;
        }
    }

    public int getNextID() {
        for (int i = 0; i < presentIDs.length; i++) {
            if (!presentIDs[i]) {
                return i;
            }
        }
        throw new RuntimeException("No more IDs available");
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