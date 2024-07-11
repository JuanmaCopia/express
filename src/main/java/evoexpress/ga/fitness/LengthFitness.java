package evoexpress.ga.fitness;

import evoexpress.config.ToolConfig;
import evoexpress.execution.Executor;
import evoexpress.ga.individual.Individual;
import evoexpress.object.ObjectCollector;
import evoexpress.reflection.Reflection;
import evoexpress.spoon.SpoonManager;

import java.lang.reflect.Method;

public class LengthFitness extends FitnessFunction {

    private static final int MAX_LENGTH = 1000000;

    @Override
    public void eval(Individual individual) {
        SpoonManager.addClassToPackage(individual.getCtClass());
        //logger.info("FF: Evaluating fitness for:\n" + individual.toString());
        if (individual.marked) {
            logger.info("FF: Evaluating fitness for:\n" + individual);
        }

        individual.setFitness(WORST_FITNESS_VALUE);

        Class<?> preconditionClass = Reflection.loadClass(SpoonManager.classLoader, individual.getQualifiedClassName());
        Method precondition = Reflection.loadMethod(preconditionClass, ToolConfig.preconditionMethodName);

        for (Object validInstance : ObjectCollector.positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            if (individual.marked)
                logger.info("FF: Running precondition for valid instance: " + validInstance.toString());
            int result = Executor.runPrecondition(individual, precondition, args);
            if (result != 1) {
                if (individual.marked) {
                    logger.info("FF: early return 2");
                    logger.info("FF: killed valid mutant: " + validInstance.toString());
                }
                SpoonManager.removeClassFromPackage(individual.getCtClass());
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
                SpoonManager.removeClassFromPackage(individual.getCtClass());
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) individual.toString().length() / MAX_LENGTH;
        individual.setFitness(fitness);
        if (individual.marked)
            logger.info("FF: Given Fitness: " + fitness);

        SpoonManager.removeClassFromPackage(individual.getCtClass());
    }

}
