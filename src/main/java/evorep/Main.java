package evorep;

import evorep.config.ToolConfig;
import evorep.ga.GeneticAlgorithm;
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
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 1.0, 1.0);
        Population population = ga.initPopulation(getRepOKMethod());

        ga.evalPopulation(population);

        int generation = 1;
        int MAX_GENERATIONS = 300;

        while (!ga.isTerminationConditionMet(population) && generation <= MAX_GENERATIONS) {
            printGeneration(generation, population);
            //population = ga.crossoverPopulation(population);
            population = ga.mutatePopulation(population);
            ga.evalPopulation(population);
            population = ga.selectFittest(population);
            generation++;
        }
        printResults(population, generation);
    }

    public static void printGeneration(int generation, Population population) {
        System.out.println("\n\n------------------   Generation " + generation + "   ------------------\n");
        System.out.println("Fittest: " + population.getFittest().getFitness());
        System.out.println("\n" + population.getFittest().toString());
    }

    public static void printResults(Population population, int generation) {
        System.out.println("\n\n==============================  Search Finished  ==============================\n");
        System.out.println("Number of generations: " + generation);
        System.out.println("Best solution: " + population.getFittest().toString());
        System.out.println("Fitness: " + population.getFittest().getFitness());
        System.out.println("\n=================================================================================\n");
    }
}
