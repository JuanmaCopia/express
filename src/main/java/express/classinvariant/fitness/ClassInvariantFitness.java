package express.classinvariant.fitness;

import express.classinvariant.state.ClassInvariantState;
import express.compile.InMemoryCompiler;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

import java.util.logging.Logger;

public abstract class ClassInvariantFitness {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;
    static final Logger logger = Logger.getLogger(ClassInvariantFitness.class.getName());

    InMemoryCompiler compiler;

    public ClassInvariantFitness(InMemoryCompiler compiler) {
        this.compiler = compiler;
    }

    public void evaluate(ClassInvariantState state) {
        if (!state.isFitnessUpdated()) {
            CtClass<?> ctClass = state.getCtClass();
            boolean compiles = compiler.compileSingleClass(ctClass.getQualifiedName(), SpoonManager.getPrettyPrintedSourceCode(ctClass));
            if (!compiles) {
                logger.warning("\nClass does not compile:\n" +  SpoonManager.getPrettyPrintedSourceCode(ctClass));
                throw new RuntimeException("Class does not compile");
            }
            double fitness = calculateFitness(ctClass);
            state.setFitness(fitness);
        }
    }

    abstract double calculateFitness(CtClass<?> ctClass);
}
