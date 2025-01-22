package express.classinvariant.fitness;

import java.lang.reflect.Method;
import java.util.Collection;

import express.config.Config;
import express.execution.Executor;
import express.reflection.Reflection;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

public class LengthFitness extends ClassInvariantFitness {

    private static final int MAX_LENGTH = 5000;

    Config config;
    ClassLoader classLoader;

    Collection<Object> positiveObjects;
    Collection<Object> negativeObjects;

    public LengthFitness(Collection<Object> positiveObjects, Collection<Object> negativeObjects) {
        super(SpoonManager.getInMemoryCompiler());
        this.config = SpoonManager.getConfig();
        this.classLoader = compiler.getClassLoader();
        this.positiveObjects = positiveObjects;
        this.negativeObjects = negativeObjects;
    }

    @Override
    double calculateFitness(CtClass<?> ctClass) {
        Class<?> predicateClass;
        try {
            predicateClass = compiler.loadClass(ctClass.getQualifiedName());
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading class: " + ctClass.getQualifiedName());
            throw new RuntimeException(e);
        }
        //Class<?> predicateClass = Reflection.loadClass(classLoader, ctClass.getQualifiedName());
        Method predicate = Reflection.loadMethod(predicateClass, config.predicateMethodName);

        for (Object validInstance : positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            int result = Executor.runPredicate(predicate, args);
            if (result == -1) {
                System.err.println("Error running predicate");
                System.err.println("Class: " + ctClass.toString());
                return WORST_FITNESS_VALUE;
            }
            if (result != 1) {
                return WORST_FITNESS_VALUE;
            }
        }

        double fitness = negativeObjects.size() * -1;

        for (Object invalidInstance : negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;
            int result = Executor.runPredicate(predicate, args);
            if (result == -1) {
                System.err.println("Error running predicate");
                System.err.println("Class: " + ctClass.toString());
                return WORST_FITNESS_VALUE;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) ctClass.toString().length() / MAX_LENGTH;
        return fitness;
    }

}
