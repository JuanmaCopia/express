package evorep.ga;

import evorep.config.ToolConfig;
import evorep.execution.Executor;
import evorep.object.ObjectCollector;
import evorep.reflection.Reflection;
import evorep.spoon.SpoonManager;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class FitnessFunctions {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;
    private static final Logger logger = Logger.getLogger(FitnessFunctions.class.getName());
    private static final int MAX_LENGTH = 50000;

    public static void invalidInstancesFitness(Individual individual) {
        logger.info("FF: Evaluating fitness for:\n" + individual.toString());

        individual.setFitness(WORST_FITNESS_VALUE);
        if (individual.toString().length() > MAX_LENGTH || !SpoonManager.compileIndividual(individual)) {
            logger.info("FF: early return 1");
            return;
        }

        Method precondition = loadPreconditionMethod(individual);

        for (Object validInstance : ObjectCollector.positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            int result = Executor.runPrecondition(precondition, args);
            if (result != 1) {
                logger.info("FF: early return 2");
                return;
            }
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;
            int result = Executor.runPrecondition(precondition, args);
            if (result == -1) {
                logger.info("FF: early return 3");
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) individual.toString().length() / MAX_LENGTH;
        individual.setFitness(fitness);
        logger.info("FF: Given Fitness: " + fitness);
        logger.info("FF: final return");
    }

    public static Method loadPreconditionMethod(Individual individual) {
        Class<?> preconditionClass = Reflection.loadClass(SpoonManager.classLoader, individual.getChromosome().getQualifiedName());
        return Reflection.loadMethod(preconditionClass, ToolConfig.preconditionMethodName);
    }

}
