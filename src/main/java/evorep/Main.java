package evorep;

import evorep.config.ToolConfig;
import evorep.ga.GeneticAlgorithm;
import evorep.ga.Individual;
import evorep.ga.Population;
import evorep.ga.mutators.MutatorManager;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import spoon.reflect.declaration.CtMethod;

public class Main {

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
        SpoonManager.getTargetClass().addMethod(SpoonFactory.createRepOK("repOK"));
        MutatorManager.initialize();
    }

    private static CtMethod getRepOKMethod() {
        return SpoonManager.getTargetClass().getMethod("repOK");
    }

    public static void main(String[] args) {
        initialize();
        startSearch();
    }

    public static void startSearch() {
        GeneticAlgorithm ga = new GeneticAlgorithm(200, 1.0, 1.0);
        Population population = ga.initPopulation(getRepOKMethod());

        ga.evalPopulation(population);

        int generation = 1;
        int MAX_GENERATIONS = 300;

        while (!ga.isTerminationConditionMet(population) && generation <= MAX_GENERATIONS) {
            Individual fittest = population.getFittest();
            System.out.println("\nFitness value: " + fittest.getFitness());
            System.out.println("Individual:\n" + fittest.toString());

            //population = ga.crossoverPopulation(population);

            population = ga.mutatePopulation(population);

            ga.evalPopulation(population);

            population = ga.selectFittest(population);

            generation++;
        }

        System.out.println("Found solution in " + generation + " generations");
        System.out.println("Best solution: " + population.getFittest().toString());
        System.out.println("Fitness: " + population.getFittest().getFitness());
    }
}
