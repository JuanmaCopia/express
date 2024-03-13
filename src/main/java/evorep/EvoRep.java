package evorep;

import evorep.config.ToolConfig;
import evorep.ga.GeneticAlgorithm;
import evorep.ga.Population;
import evorep.spoon.SpoonManager;
import spoon.reflect.declaration.CtMethod;

public class EvoRep {

    public static void main(String[] args) {
        initialize();
        printStart();
        startSearch();
    }

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
    }


    public static void printStart() {
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

    public static void startSearch() {
        GeneticAlgorithm ga = new GeneticAlgorithm(ToolConfig.maxPopulation, 1.0, 1.0);
        //Population population = ga.initPopulationBasedOnTypeGraph(getRepOKMethod());
        Population population = ga.initPopulation(getRepOKMethod());
        ga.evalPopulation(population);
        population = ga.selectFittest(population);

        int generation = 1;
        while (!ga.isTerminationConditionMet(population) && generation <= ToolConfig.maxGenerations) {
            printGeneration(generation, population);
            //population = ga.crossoverPopulation(population);
            population = ga.mutatePopulation(population);
            ga.evalPopulation(population);
            population = ga.selectFittest(population);
            generation++;
        }
        printResults(population, generation - 1);
    }

    private static CtMethod getRepOKMethod() {
        return SpoonManager.getTargetClass().getMethod("repOK");
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

/*        Individual fittest = population.getFittest();
        FitnessFunctions.invalidInstancesFitness(fittest);*/
    }
}
