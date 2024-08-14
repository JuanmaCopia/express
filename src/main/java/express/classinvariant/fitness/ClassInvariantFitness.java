package express.classinvariant.fitness;

import express.classinvariant.state.ClassInvariantState;
import express.compile.Compiler;
import spoon.reflect.declaration.CtClass;

import java.util.logging.Logger;

public abstract class ClassInvariantFitness {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;
    static final Logger logger = Logger.getLogger(ClassInvariantFitness.class.getName());

    Compiler compiler;

    public ClassInvariantFitness(Compiler compiler) {
        this.compiler = compiler;
    }

    public void evaluate(ClassInvariantState state) {
        if (!state.isFitnessUpdated()) {
            CtClass<?> ctClass = state.getCtClass();
            compiler.compileModel(ctClass);
            double fitness = calculateFitness(ctClass);
            state.setFitness(fitness);
        }
    }

    abstract double calculateFitness(CtClass<?> ctClass);
}
