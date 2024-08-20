package express.classinvariant.fitness;

import express.classinvariant.state.ClassInvariantState;
import express.compile.InMemoryCompiler;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;

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
            SpoonManager.addClassToMainPackage(ctClass);
            String classQualifiedName = ctClass.getQualifiedName();
            String classSourceCode = SpoonManager.getPrettyPrintedSourceCode(ctClass);
            SpoonManager.removeClassFromMainPackage(ctClass);

            boolean compiles = compiler.compileSingleClass(classQualifiedName, classSourceCode);
            if (!compiles) {
                logger.warning("\nClass does not compile:\n" +  classSourceCode);
                throw new RuntimeException("Class does not compile");
            }
            double fitness = calculateFitness(ctClass);
            state.setFitness(fitness);
        }
    }

    abstract double calculateFitness(CtClass<?> ctClass);
}
