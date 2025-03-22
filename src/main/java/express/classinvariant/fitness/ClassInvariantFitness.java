package express.classinvariant.fitness;

import express.classinvariant.state.ClassInvariantState;
import express.compile.InMemoryCompiler;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

import java.util.logging.Logger;

public abstract class ClassInvariantFitness {

    public static final double WORST_FITNESS_VALUE = Short.MAX_VALUE;
    static final Logger logger = Logger.getLogger(ClassInvariantFitness.class.getName());

    public static long compilationTime = 0;
    public static long fitnessEvaluationTime = 0;

    InMemoryCompiler compiler;

    public ClassInvariantFitness(InMemoryCompiler compiler) {
        this.compiler = compiler;
    }

    public void evaluate(ClassInvariantState state) {
        if (!state.isFitnessUpdated()) {
            long startTimestamp = System.currentTimeMillis();

            CtClass<?> ctClass = state.getCtClass();
            SpoonManager.addClassToMainPackage(ctClass);
            String classQualifiedName = ctClass.getQualifiedName();
            String classSourceCode = SpoonManager.getPrettyPrintedSourceCode(ctClass);
            SpoonManager.removeClassFromMainPackage(ctClass);

            boolean compiles = compiler.compileSingleClass(classQualifiedName, classSourceCode);
            compilationTime += System.currentTimeMillis() - startTimestamp;

            if (!compiles) {
                logger.warning("\nClass does not compile:\n" + classSourceCode);
                throw new RuntimeException("Class does not compile");
            }

            startTimestamp = System.currentTimeMillis();

            double fitness = calculateFitness(ctClass);
            fitnessEvaluationTime += System.currentTimeMillis() - startTimestamp;

            state.setFitness(fitness);
        }
    }

    abstract double calculateFitness(CtClass<?> ctClass);
}
