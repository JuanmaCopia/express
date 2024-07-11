package evoexpress.ga.fitness;

import evoexpress.ga.individual.Individual;

import java.util.logging.Logger;

public abstract class FitnessFunction {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;
    static final Logger logger = Logger.getLogger(FitnessFunction.class.getName());

    public abstract void eval(Individual individual);
}
