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
    Set<CtTypeReference<?>> nonTraversedNodesWithCycles;
    Set<CtTypeReference<?>> nonTraversedArrays;

    public ClassInvariantState() {
        cls = SpoonFactory.createPreconditionClass(id++);
        nonTraversedNodesWithCycles = new HashSet<>(SpoonManager.getTypeData().getCyclicTypes());
        nonTraversedArrays = new HashSet<>(SpoonManager.getTypeData().getArrayTypes());
        fitness = null;
    }

    public ClassInvariantState(ClassInvariantState other) {
        cls = other.getCtClass().clone();
        cls.setSimpleName(SpoonFactory.createPreconditionClassName(id++));
        nonTraversedNodesWithCycles = new HashSet<>(other.nonTraversedNodesWithCycles);
        nonTraversedArrays = new HashSet<>(other.nonTraversedArrays);
        fitness = other.fitness;
    }

    public void setTypeAsTraversed(CtTypeReference<?> typeReference) {
        if (typeReference instanceof CtArrayTypeReference)
            nonTraversedArrays.remove(typeReference);
        else
            nonTraversedNodesWithCycles.remove(typeReference);
    }

    public void setTypeAsNonTraversed(CtTypeReference<?> typeReference) {
        if (typeReference instanceof CtArrayTypeReference)
            nonTraversedArrays.add(typeReference);
        else
            nonTraversedNodesWithCycles.add(typeReference);
    }

    public Set<CtTypeReference<?>> getNonTraversedNodesWithCycles() {
        return nonTraversedNodesWithCycles;
    }

    public Set<CtTypeReference<?>> getNonTraversedArrays() {
        return nonTraversedArrays;
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
