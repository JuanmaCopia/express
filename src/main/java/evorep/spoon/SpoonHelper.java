package evorep.spoon;

import evorep.ga.Individual;
import evorep.scope.Scope;

public class SpoonHelper {

    public static void putIndividualIntoTheEnvironment(Individual individual) {
        SpoonManager.getTargetClass().removeMethod(individual.getChromosome());
        SpoonManager.getTargetClass().addMethod(individual.getChromosome());
    }

    public static Scope getScope(Individual individual) {
        putIndividualIntoTheEnvironment(individual);
        return new Scope(individual.getChromosome().getBody().getLastStatement());
    }
}
