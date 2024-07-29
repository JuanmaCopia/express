package evoexpress.classinvariant.fitness;

import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.config.ToolConfig;
import evoexpress.execution.Executor;
import evoexpress.object.ObjectCollector;
import evoexpress.reflection.Reflection;
import evoexpress.spoon.SpoonManager;

import java.lang.reflect.Method;

public class LengthFitness extends ClassInvariantFitness {

    private static final int MAX_LENGTH = 20000;

    @Override
    public void evaluate(ClassInvariantState state) {
        SpoonManager.addClassToPackage(state.getCtClass());
        //logger.info("FF: Evaluating fitness for:\n" + state.toString());
        if (state.marked) {
            logger.info("FF: Evaluating fitness for:\n" + state);
        }

        state.setFitness(WORST_FITNESS_VALUE);

        Class<?> preconditionClass = Reflection.loadClass(SpoonManager.classLoader, state.getQualifiedClassName());
        Method precondition = Reflection.loadMethod(preconditionClass, ToolConfig.preconditionMethodName);

        for (Object validInstance : ObjectCollector.positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            if (state.marked)
                logger.info("FF: Running precondition for valid instance: " + validInstance.toString());
            int result = Executor.runPrecondition(precondition, args);
            if (result != 1) {
                if (state.marked) {
                    logger.info("FF: early return 2");
                    logger.info("FF: killed valid mutant: " + validInstance.toString());
                }
                SpoonManager.removeClassFromPackage(state.getCtClass());
                return;
            }
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            Object[] args = new Object[1];
            args[0] = invalidInstance;
            //logger.info("FF: Running precondition for invalid instance: " + invalidInstance.toString());
            int result = Executor.runPrecondition(precondition, args);
            if (result == -1) {
                if (state.marked)
                    logger.info("FF: early return 3");
                SpoonManager.removeClassFromPackage(state.getCtClass());
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) state.toString().length() / MAX_LENGTH;
        state.setFitness(fitness);
        if (state.marked)
            logger.info("FF: Given Fitness: " + fitness);

        SpoonManager.removeClassFromPackage(state.getCtClass());
    }

}
