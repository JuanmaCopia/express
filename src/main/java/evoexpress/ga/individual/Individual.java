package evoexpress.ga.individual;

import evoexpress.config.ToolConfig;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.type.typegraph.Path;
import spoon.reflect.declaration.CtClass;

import java.util.HashSet;
import java.util.Set;

public class Individual implements Comparable<Individual> {

    private static long id = 0;

    private final CtClass<?> cls;
    public boolean marked;
    Set<Path> nonTraversedPathsToCyclicNodes;
    Set<Path> nonTraversedPathsToArrayNodes;
    private double fitness;
    private boolean isFitnessUpdated;

    public Individual() {
        cls = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName + id++);
        nonTraversedPathsToCyclicNodes = SpoonManager.inputTypeData.getPathsToCyclicNodes();
        nonTraversedPathsToArrayNodes = SpoonManager.inputTypeData.getPathsToArrayNodes();
    }

    public Individual(Individual other) {
        cls = other.getCtClass().clone();
        cls.setSimpleName(ToolConfig.preconditionClassName + id++);
        nonTraversedPathsToCyclicNodes = new HashSet<>(other.nonTraversedPathsToCyclicNodes);
        nonTraversedPathsToArrayNodes = new HashSet<>(other.nonTraversedPathsToArrayNodes);
    }

    // Tracking traversed paths
    public boolean hasNonTraversedPathsToCyclicNodes() {
        return !nonTraversedPathsToCyclicNodes.isEmpty();
    }

    public boolean hasNonTraversedPathsToArrayNodes() {
        return !nonTraversedPathsToArrayNodes.isEmpty();
    }

    public Set<Path> getNonTraversedPathsToCyclicNodes() {
        return nonTraversedPathsToCyclicNodes;
    }

    public Set<Path> getNonTraversedPathsToArrayNodes() {
        return nonTraversedPathsToArrayNodes;
    }


    public CtClass<?> getCtClass() {
        return cls;
    }


    public String getQualifiedClassName() {
        return cls.getQualifiedName();
    }

    public String getSimpleClassName() {
        return cls.getSimpleName();
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
        return cls.toString();
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
