package evoexpress.classinvariant.fitness;

import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.config.Config;
import evoexpress.execution.Executor;
import evoexpress.object.ObjectCollector;
import evoexpress.output.Compiler;
import evoexpress.reflection.Reflection;
import evoexpress.spoon.SpoonManager;
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
        Class<?> preconditionClass = Reflection.loadClass(classLoader, ctClass.getQualifiedName());
        Method precondition = Reflection.loadMethod(preconditionClass, config.preconditionMethodName);

        for (Object validInstance : ObjectCollector.positiveObjects) {
            Object[] args = new Object[1];
            args[0] = validInstance;
            int result = Executor.runPrecondition(precondition, args);
            if (result == -1) {
                System.err.println("Error running precondition");
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
            int result = Executor.runPrecondition(precondition, args);
            if (result == -1) {
                System.err.println("Error running precondition");
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
