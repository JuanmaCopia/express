package evoexpress.classinvariant.state;

import evoexpress.config.ToolConfig;
import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.Set;

public class ClassInvariantState implements SimulatedAnnealingState {

    private static long id = 0;

    private final CtClass<?> cls;
    private Double fitness;
    public boolean marked;
    Set<CtTypeReference<?>> nonTraversedNodesWithCycles;

    public ClassInvariantState() {
        cls = SpoonFactory.createPreconditionClass(ToolConfig.preconditionClassName + id++);
        nonTraversedNodesWithCycles = SpoonManager.inputTypeData.getNodesWithCycles();
    }

    public ClassInvariantState(ClassInvariantState other) {
        cls = other.getCtClass().clone();
        cls.setSimpleName(ToolConfig.preconditionClassName + id++);
        nonTraversedNodesWithCycles = new HashSet<>(other.nonTraversedNodesWithCycles);
    }

    public void setTypeAsTraversed(CtTypeReference<?> typeReference) {
        nonTraversedNodesWithCycles.remove(typeReference);
    }

    public Set<CtTypeReference<?>> getNonTraversedNodesWithCycles() {
        return nonTraversedNodesWithCycles;
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
        return fitness != null;
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
