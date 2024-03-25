package evorep;

import evorep.config.ToolConfig;
import evorep.ga.GeneticAlgorithm;
import evorep.ga.Population;
import evorep.object.ObjectGeneratorManager;
import evorep.spoon.SpoonManager;

public class EvoRep {

    public static void main(String[] args) {
        initialize();
        printStart();
        startSearch();
    }

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
        SpoonManager.initialize();
        ObjectGeneratorManager.generateObjects();
    }


    public static void printStart() {
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

    public static void startSearch() {
        GeneticAlgorithm ga = new GeneticAlgorithm(ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);

        Population population = ga.initPopulation(SpoonManager.preconditionClass);
        ga.evalPopulation(population);
        population = ga.selectSurvivors(population);

        int generation = 1;
        while (!ga.isTerminationConditionMet(population) && generation <= ToolConfig.maxGenerations) {
            printGeneration(generation, population);
            //population = ga.crossoverPopulation(population);
            population = ga.mutatePopulation(population);
            ga.evalPopulation(population);
            population = ga.selectSurvivors(population);
            generation++;
        }
        printResults(population, generation - 1);
    }

    public static void printGeneration(int generation, Population population) {
        System.out.println("\n\n------------------   Generation " + generation + "   ------------------\n");
        System.out.println("Population size: " + population.size());
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
