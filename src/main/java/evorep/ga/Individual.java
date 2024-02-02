package evorep.ga;

import spoon.reflect.declaration.CtMethod;

public class Individual {

    /**
     * Individual's chromosome
     */
    private CtMethod chromosome;


    private double fitness = -1;

    /**
     * Initializes individual with an specific chromosome.
     * A chromosome is a list of statements.
     *
     * @param repOK The repOK method
     */
    public Individual(CtMethod repOK) {
        chromosome = repOK.clone();
    }

    public Individual() {
        this.chromosome = null;
    }

    /**
     * Gets individual's chromosome
     *
     * @return The individual's chromosome
     */
    public CtMethod getChromosome() {
        return this.chromosome;
    }

    /**
     * Gets individual's chromosome length
     *
     * @return The individual's chromosome length
     */
    public int getChromosomeLength() {
        return chromosome.getBody().getStatements().size();
    }


    /**
     * Store individual's fitness
     *
     * @param fitness The individuals fitness
     */
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    /**
     * Gets individual's fitness
     *
     * @return The individual's fitness
     */
    public double getFitness() {
        return this.fitness;
    }

    /**
     * Display the chromosome as a string.
     *
     * @return string representation of the chromosome
     */
    public String toString() {
        if (chromosome == null)
            return "Empty individual";
        return chromosome.toString();
    }

    public Individual clone() {
        return new Individual(chromosome);
    }

}
