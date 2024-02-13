package evorep.ga;

import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;

public class Individual implements Comparable<Individual> {

    private CtMethod chromosome;
    private double fitness = -1;
    private boolean isFitnessUpdated = false;


    /**
     * Initializes individual with an specific chromosome.
     * A chromosome is a list of statements.
     *
     * @param repOK The repOK method
     */
    public Individual(CtMethod repOK) {
        chromosome = repOK.clone();
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
     * Store individual's fitness
     *
     * @param fitnessValue The individuals fitness
     */
    public void setFitness(double fitnessValue) {
        fitness = fitnessValue;
        isFitnessUpdated = true;
    }

    public boolean needsFitnessUpdate() {
        return !isFitnessUpdated;
    }

    public void setFitnessAsOutdated() {
        isFitnessUpdated = false;
    }

    public CtStatement getLastGene() {
        return this.chromosome.getBody().getLastStatement();
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
    @Override
    public String toString() {
        if (chromosome == null)
            return "Empty individual";
        return chromosome.toString();
    }

    public Individual clone() {
        Individual clone = new Individual(chromosome);
        clone.setFitness(fitness);
        return clone;
    }

    @Override
    public int compareTo(Individual other) {
        if (this.getFitness() < other.getFitness())
            return -1;
        else if (this.getFitness() > other.getFitness())
            return 1;
        return 0;
    }
}
