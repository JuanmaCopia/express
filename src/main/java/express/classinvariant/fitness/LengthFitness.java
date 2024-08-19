package express.classinvariant.fitness;

import express.config.Config;
import express.execution.Executor;
import collector.ObjectCollector;
import express.reflection.Reflection;
import express.spoon.SpoonManager;
import spoon.reflect.declaration.CtClass;

import java.lang.reflect.Method;
import java.net.URLClassLoader;

public class LengthFitness extends ClassInvariantFitness {

    private static final int MAX_LENGTH = 12000;

    Config config;
    URLClassLoader classLoader;

    public LengthFitness() {
        super(SpoonManager.getOutput().getCompiler());
        this.config = SpoonManager.getConfig();
        this.classLoader = SpoonManager.getOutput().getClassLoader();
    }

    @Override
    double calculateFitness(CtClass<?> ctClass) {
        Class<?> predicateClass = Reflection.loadClass(classLoader, ctClass.getQualifiedName());
        Method predicate = Reflection.loadMethod(predicateClass, config.predicateMethodName);

        for (Object validInstance : ObjectCollector.positiveObjects) {
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

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
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
