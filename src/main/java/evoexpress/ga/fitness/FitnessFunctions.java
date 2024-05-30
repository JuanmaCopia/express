package evoexpress.ga.fitness;

import evoexpress.config.ToolConfig;
import evoexpress.execution.Executor;
import evoexpress.ga.individual.Individual;
import evoexpress.object.ObjectCollector;
import evoexpress.reflection.Reflection;
import evoexpress.spoon.SpoonManager;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class FitnessFunctions {

    public static final double WORST_FITNESS_VALUE = Short.MIN_VALUE;
    private static final Logger logger = Logger.getLogger(FitnessFunctions.class.getName());
    private static final int MAX_LENGTH = 50000;

    public static void invalidInstancesFitness(Individual individual) {

        //logger.info("FF: Evaluating fitness for:\n" + individual.toString());
        if (individual.marked) {
            logger.info("FF: Evaluating fitness for:\n" + individual);
        }

        individual.setFitness(WORST_FITNESS_VALUE);
        if (individual.toString().length() > MAX_LENGTH) {
            if (individual.marked)
                logger.info("FF: early return 1");
            return;
        }

        Class<?> preconditionClass = Reflection.loadClass(SpoonManager.classLoader, individual.getQualifiedClassName());
        Method precondition = Reflection.loadMethod(preconditionClass, ToolConfig.preconditionMethodName);

        for (Object validInstance : ObjectCollector.positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            //logger.info("FF: Running precondition for valid instance: " + validInstance.toString());
            int result = Executor.runPrecondition(individual, precondition, args);
            if (result != 1) {
                if (individual.marked) {
                    logger.info("FF: early return 2");
                    logger.info("FF: killed valid mutant: " + validInstance.toString());
                }
                return;
            }
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;
            //logger.info("FF: Running precondition for invalid instance: " + invalidInstance.toString());
            int result = Executor.runPrecondition(individual, precondition, args);
            if (result == -1) {
                if (individual.marked)
                    logger.info("FF: early return 3");
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) individual.toString().length() / MAX_LENGTH;
        individual.setFitness(fitness);
        if (individual.marked)
            logger.info("FF: Given Fitness: " + fitness);

    }


    public static void printSurvivors(Individual individual) {
        assert SpoonManager.compileIndividual(individual);

        Class<?> preconditionClass = Reflection.loadClass(SpoonManager.classLoader, individual.getQualifiedClassName());
        Method precondition = Reflection.loadMethod(preconditionClass, ToolConfig.preconditionMethodName);

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;

            int result = Executor.runPrecondition(individual, precondition, args);
            if (result == 1) {
                System.out.println("\n\nCould not kill:\n" + invalidInstance.toString());
            } else if (result == -1) {
                System.out.println("Error with" + invalidInstance.toString());
                return;
            }
        }


    }


}
