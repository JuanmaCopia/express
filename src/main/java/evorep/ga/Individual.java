package evorep.ga;

import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtBlock;

public class Individual implements Comparable<Individual> {

    private final CtBlock<?> initialCheck;
    private final CtBlock<?> structureCheck;
    private final CtBlock<?> primitiveCheck;
    public int id;

    public String className;
    private double fitness;
    private boolean isFitnessUpdated;

    public Individual() {
        initialCheck = SpoonFactory.createReturnTrueBlock();
        structureCheck = SpoonFactory.createReturnTrueBlock();
        primitiveCheck = SpoonFactory.createReturnTrueBlock();
    }

    public Individual(Individual individual) {
        initialCheck = individual.initialCheck.clone();
        structureCheck = individual.structureCheck.clone();
        primitiveCheck = individual.primitiveCheck.clone();
        fitness = individual.fitness;
        isFitnessUpdated = individual.isFitnessUpdated;
    }

    public CtBlock<?> getInitialCheck() {
        return initialCheck;
    }

    public CtBlock<?> getStructureCheck() {
        return structureCheck;
    }

    public CtBlock<?> getPrimitiveCheck() {
        return primitiveCheck;
    }


    /**
     * Check if the individual needs to have its fitness recalculated
     *
     * @return True if the individual needs its fitness recalculated, otherwise, false
     */
    public boolean isFitnessUpdated() {
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
     * Display the chromosome as a string.
     *
     * @return string representation of the chromosome
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Initial Check: ").append(initialCheck.toString()).append("\n");
        sb.append("Structure Check: ").append(structureCheck.toString()).append("\n");
        sb.append("Primitive Check: ").append(primitiveCheck.toString()).append("\n");
        return sb.toString();
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
