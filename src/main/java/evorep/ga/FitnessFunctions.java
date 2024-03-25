package evorep.ga;

public class FitnessFunctions {

    public static final double WORST_FITNESS_VALUE = -10000.0;

    private static final int MAX_LENGTH = 50000;

    public static void invalidInstancesFitness(Individual individual) {
        /*individual.setFitness(WORST_FITNESS_VALUE);
        if (individual.toString().length() > MAX_LENGTH || !SpoonManager.compileIndividual(individual)) {
            return;
        }

        for (Object validInstance : ObjectCollector.positiveObjects) {
            int result = Executor.runPrecondition(validInstance);
            if (result != 1) {
                return;
            }
        }

        double fitness = ObjectCollector.negativeObjects.size() * -1;

        for (Object invalidInstance : ObjectCollector.negativeObjects) {
            int result = Executor.runPrecondition(invalidInstance);
            if (result == -1) {
                return;
            } else if (result == 0) {
                fitness = fitness + 1;
            }
        }

        fitness -= (double) individual.toString().length() / MAX_LENGTH;

        individual.setFitness(fitness);*/

    }

}
