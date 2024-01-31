package evorep.ga;

import evorep.spoon.Utils;
import spoon.reflect.code.CtStatement;
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
     * Inserts a new gene to the chromosome at offset
     *
     * @param gene
     */
    public void addGene(int offset, CtStatement gene) {
        int chromosomeSize = chromosome.getBody().getStatements().size();
        if (offset == chromosomeSize)
            chromosome.getBody().addStatement(gene);
        else if (offset < chromosomeSize)
            chromosome.getBody().addStatement(offset, gene);
        else
            throw new IndexOutOfBoundsException("Offset is out of bounds");
    }

    /**
     * Set gene at offset
     *
     * @param gene
     * @param offset
     * @return gene
     */
    public void setGene(int offset, CtStatement gene) {
        Utils.replace(chromosome.getBody().getStatement(offset), gene);
    }

    /**
     * Get gene at offset
     *
     * @param offset
     * @return gene
     */
    public CtStatement getGene(int offset) {
        return chromosome.getBody().getStatement(offset);
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

}
