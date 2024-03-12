package evorep.ga;

import evorep.object.ObjectCollector;
import evorep.object.ObjectGeneratorManager;
import evorep.spoon.SpoonManager;

import java.lang.reflect.Method;
import java.net.URLClassLoader;

public class FitnessFunctions {

    private static final float WORST_FITNESS_VALUE = -1000;

    private static final int MAX_LENGTH = 5000;

    public static void invalidInstancesFitness(Individual individual) {
        individual.setFitness(WORST_FITNESS_VALUE);
        if (individual.toString().length() > MAX_LENGTH || !SpoonManager.compileIndividual(individual)) {
            return;
        }
        URLClassLoader classLoader = SpoonManager.createClassLoader();

        ObjectGeneratorManager.generateObjects(classLoader);

        Class aClass = SpoonManager.loadClass(classLoader);
        Method repOKMethod = SpoonManager.loadMethod(aClass, individual.getChromosome().getSimpleName());

        for (Object validInstance : ObjectCollector.positiveObjects) {
            int result = SpoonManager.runRepOK(individual, repOKMethod, validInstance);
            if (result < 1)
                return;
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            int result = SpoonManager.runRepOK(individual, repOKMethod, invalidInstance);
            if (result < 0)
                return;
            else if (result == 0) {
                //System.out.println("RepOK failed!");
                fitness = fitness + 1;
            }
        }

        fitness -= (float) individual.toString().length() / MAX_LENGTH;

        //System.out.println("For Invalid instances fitness is: " + fitness);

        individual.setFitness(fitness);


        //System.out.println("Individual:\n" + individual);


        //System.out.println("\n ------------------------------------------ \n");
    }

    /*    public float calcFitness(Individual individual) {
        String goal = SpoonHelper.getFalseFitnessString();
        String individualString = SpoonHelper.getStatementsString(individual.getChromosome());

        float fitness = new LevenshteinDistance().apply(goal, individualString) * -1;

        if (!SpoonManager.compileIndividual(individual)) {
            return WORST_FITNESS_VALUE;
        }

        individual.setFitness(fitness);
        return fitness;
    }*/
}
