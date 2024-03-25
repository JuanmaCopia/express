package evorep.ga;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

public class Individual implements Comparable<Individual> {

    private static int individualId = 0;

    private final CtClass<?> chromosome;
    private double fitness = -1;
    private boolean isFitnessUpdated = false;

    public Individual() {
        this.chromosome = SpoonFactory.createPreconditionClass("Precondition" + individualId++, SpoonManager.targetMethod.getParameters());
    }

    public Individual(CtClass<?> chromosome, double fitness) {
        this.chromosome = chromosome;
        this.fitness = fitness;
        this.isFitnessUpdated = true;
    }


    /**
     * Gets individual's chromosome
     *
     * @return The individual's chromosome
     */
    public CtClass<?> getChromosome() {
        return this.chromosome;
    }

    /**
     * Check if the individual needs to have its fitness recalculated
     *
     * @return True if the individual needs its fitness recalculated, otherwise, false
     */
    public boolean needsFitnessUpdate() {
        return !isFitnessUpdated;
    }

    /**
     * Set individual's fitness as outdated
     */
    public void setFitnessAsOutdated() {
        isFitnessUpdated = false;
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
     * Store individual's fitness
     *
     * @param fitnessValue The individuals fitness
     */
    public void setFitness(double fitnessValue) {
        fitness = fitnessValue;
        isFitnessUpdated = true;
    }

    /**
     * Clone the individual
     *
     * @return The cloned individual
     */
    public Individual clone() {
        return new Individual(chromosome, fitness);
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

    /**
     * Compare individuals by fitness
     *
     * @param other The individual to compare to
     * @return -1 if this individual is fitter, 1 if the other individual is fitter, 0 if they are equally fit
     */
    @Override
    public int compareTo(Individual other) {
        if (this.getFitness() > other.getFitness())
            return -1;
        else if (this.getFitness() < other.getFitness())
            return 1;
        return 0;
    }
}
