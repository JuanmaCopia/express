package evorep.ga;

import evorep.execution.Executor;
import evorep.object.ObjectCollector;
import evorep.reflection.Reflection;
import evorep.spoon.SpoonManager;

import java.lang.reflect.Method;

public class FitnessFunctions {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;

    private static final int MAX_LENGTH = 50000;

    public static void invalidInstancesFitness(Individual individual) {
        individual.setFitness(WORST_FITNESS_VALUE);
        if (individual.toString().length() > MAX_LENGTH || !SpoonManager.compileIndividual(individual)) {
            return;
        }

        Method precondition = loadPreconditionMethod(individual);

        for (Object validInstance : ObjectCollector.positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            int result = Executor.runPrecondition(precondition, args);
            if (result != 1) {
                return;
            }
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;
            int result = Executor.runPrecondition(precondition, args);
            if (result == -1) {
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) individual.toString().length() / MAX_LENGTH;
        individual.setFitness(fitness);
    }

    public static Method loadPreconditionMethod(Individual individual) {
        Class<?> preconditionClass = Reflection.loadClass(SpoonManager.classLoader, individual.getChromosome().getQualifiedName());
        return Reflection.loadMethod(preconditionClass, "precondition");
    }

}
