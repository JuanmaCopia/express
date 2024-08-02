package evoexpress.classinvariant.fitness;

import evoexpress.classinvariant.state.ClassInvariantState;

import java.util.logging.Logger;

public abstract class ClassInvariantFitness {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;
    static final Logger logger = Logger.getLogger(ClassInvariantFitness.class.getName());

    public abstract double evaluate(ClassInvariantState state);
}
