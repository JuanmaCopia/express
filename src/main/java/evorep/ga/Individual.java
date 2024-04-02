package evorep.ga;

import evorep.config.ToolConfig;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import spoon.reflect.code.CtBlock;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

public class Individual implements Comparable<Individual> {

    private final CtClass<?> chromosome;
    private double fitness;
    private boolean isFitnessUpdated;
    private int id;

    public Individual(int id) {
        this.chromosome = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName + id);
        SpoonFactory.createSubPreconditions(chromosome, SpoonManager.preconditionParameters);
        this.isFitnessUpdated = false;
        this.id = id;
    }

    public Individual(Individual individual, int newId) {
        CtClass<?> newChromosome = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName + newId);
        SpoonFactory.createSubPreconditions(newChromosome, SpoonManager.preconditionParameters);
        for (CtMethod<?> method : individual.getChromosome().getMethods()) {
            if (!method.getSimpleName().equals(ToolConfig.preconditionMethodName)) {
                CtBlock<?> body = method.getBody().clone();
                CtMethod<?> subPrecond = SpoonFactory.getMethodByName(newChromosome, method.getSimpleName());
                if (subPrecond == null) {
                    System.err.println("\n\nChromosome is: " + newChromosome.toString() + "\n\n");
                    System.err.println("Method: " + method.getSimpleName() + " Not Found!");
                }
                subPrecond.setBody(body);
            }
        }
        this.chromosome = newChromosome;
        this.fitness = individual.getFitness();
        this.isFitnessUpdated = individual.needsFitnessUpdate();
        this.id = newId;
    }

    public int getId() {
        return id;
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
