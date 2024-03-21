package evorep.ga;

import evorep.object.ObjectCollector;
import evorep.object.ObjectGeneratorManager;
import evorep.spoon.SpoonManager;

import java.lang.reflect.Method;
import java.net.URLClassLoader;

public class FitnessFunctions {

    public static final double WORST_FITNESS_VALUE = -10000.0;

    private static final int MAX_LENGTH = 5000;

    public static void invalidInstancesFitness(Individual individual) {
/*        System.out.println("\n\n ========================== Fitness evaluated ======================== \n\n");
        System.out.println("Individual:\n" + individual.toString());
        System.out.println("");*/


        individual.setFitness(WORST_FITNESS_VALUE);
        if (individual.toString().length() > MAX_LENGTH || !SpoonManager.compileIndividual(individual)) {
/*            System.out.println("Individual is too long or could not compile!");
            System.out.println("\nFitness: " + individual.getFitness());
            System.out.println("\n\n ===================================================================== \n\n");*/
            return;
        }
        URLClassLoader classLoader = SpoonManager.createClassLoader();

        ObjectGeneratorManager.generateObjects(classLoader);

        Class aClass = SpoonManager.loadTargetClass(classLoader);
        Method repOKMethod = SpoonManager.loadMethod(aClass, individual.getChromosome().getSimpleName());

        if (ObjectCollector.positiveObjects.isEmpty() || ObjectCollector.negativeObjects.isEmpty()) {
            System.err.println("ObjectCollector is empty!");
            throw new IllegalStateException("ObjectCollector is empty!");
        }

        for (Object validInstance : ObjectCollector.positiveObjects) {
            int result = SpoonManager.runRepOK(individual, repOKMethod, validInstance);
            if (result != 1) {
/*                System.out.println("Returned false on positive object!");
                System.out.println("\nFitness: " + individual.getFitness());
                System.out.println("\n\n ===================================================================== \n\n");*/
                return;
            }
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            int result = SpoonManager.runRepOK(individual, repOKMethod, invalidInstance);
            if (result == -1) {
/*                System.out.println("Run repok exception on invalid object!");
                System.out.println("\nFitness: " + individual.getFitness());
                System.out.println("\n\n ===================================================================== \n\n");*/
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            } else {
                //System.err.println("Could not kill: " + invalidInstance.toString());
            }
        }

        fitness -= (double) individual.toString().length() / MAX_LENGTH;

        individual.setFitness(fitness);
/*        System.out.println("Fitness last point");
        System.out.println("\nFitness: " + individual.getFitness());
        System.out.println("\n\n ===================================================================== \n\n");*/

    }

    /*
     * public float calcFitness(Individual individual) {
     * String goal = SpoonHelper.getFalseFitnessString();
     * String individualString =
     * SpoonHelper.getStatementsString(individual.getChromosome());
     *
     * float fitness = new LevenshteinDistance().apply(goal, individualString) * -1;
     *
     * if (!SpoonManager.compileIndividual(individual)) {
     * return WORST_FITNESS_VALUE;
     * }
     *
     * individual.setFitness(fitness);
     * return fitness;
     * }
     */
}
