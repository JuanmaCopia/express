package evoexpress.ga.helper;

import evoexpress.config.ToolConfig;
import evoexpress.execution.Executor;
import evoexpress.ga.individual.Individual;
import evoexpress.object.ObjectCollector;
import evoexpress.reflection.Reflection;
import evoexpress.spoon.SpoonManager;

import java.lang.reflect.Method;

public class GAHelper {

    public static void printSurvivors(Individual individual) {
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
