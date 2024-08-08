package evoexpress.classinvariant.state;

import evoexpress.config.Config;
import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.type.typegraph.TypeData;
import spoon.refactoring.Refactoring;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.Set;

public class ClassInvariantState implements SimulatedAnnealingState {

    private static long id = 0;

    private final CtClass<?> cls;
    private Double fitness;
    public boolean marked;

    public ClassInvariantState() {
        cls = SpoonFactory.createPreconditionClass(id++);
        fitness = null;
    }

    public ClassInvariantState(ClassInvariantState other) {
        cls = other.getCtClass().clone();
        cls.setSimpleName(SpoonFactory.createPreconditionClassName(id++));
        fitness = other.fitness;
    }


    public CtClass<?> getCtClass() {
        return cls;
    }

    /**
     * Check if the individual needs to have its fitness recalculated
     *
     * @return True if the individual needs its fitness recalculated, otherwise, false
     */
    public boolean isFitnessUpdated() {
        return fitness != null;
    }

    /**
     * Set the individual's fitness as outdated
     */
    public void setFitnessAsOutdated() {
        fitness = null;
    }


    /**
     * Gets individual's fitness
     *
     * @return The individual's fitness
     */
    @Override
    public double getFitness() {
        return this.fitness;
    }

    /**
     * Store individual's fitness
     *
     * @param fitnessValue The individuals fitness
     */
    @Override
    public void setFitness(double fitnessValue) {
        fitness = fitnessValue;
    }

    /*
     * Clone this state.
     */
    @Override
    public ClassInvariantState clone() {
        return new ClassInvariantState(this);
    }

    /**
     * Display the chromosome as a string.
     *
     * @return string representation of the chromosome
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        return sb.toString();
    }

}
