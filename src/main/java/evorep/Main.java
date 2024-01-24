package evorep;

import evorep.config.ToolConfig;
import evorep.ga.GeneticAlgorithm;
import evorep.ga.Population;
import evorep.spoon.ProcessorsUseExamples;

public class Main {

    public static void main(String[] args) {
        ToolConfig.parseConfigurationFile();
        // startSearch();
        ProcessorsUseExamples.alreadyVisitedCheckProcessorExample();

    }

    public static void startSearch() {
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.001, 0.95, 2);
        Population population = ga.initPopulation();

        // Evaluate population
        ga.evalPopulation(population);

        // Keep track of current generation
        int generation = 1;
        int MAX_GENERATIONS = 100;

        /**
         * Start the evolution loop
         *
         * Every genetic algorithm problem has different criteria for finishing.
         * In this case, we know what a perfect solution looks like (we don't
         * always!), so our isTerminationConditionMet method is very
         * straightforward: if there's a member of the population whose
         * chromosome is all ones, we're done!
         */
        while (!ga.isTerminationConditionMet(population) && generation <= MAX_GENERATIONS) {
            // Print fittest individual from population
            System.out.println("Best solution: " + population.getFittest(0).toString());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population);

            // Evaluate population
            ga.evalPopulation(population);

            // Increment the current generation
            generation++;
        }

        /**
         * We're out of the loop now, which means we have a perfect solution on
         * our hands. Let's print it out to confirm that it is actually all
         * ones, as promised.
         */
        System.out.println("Found solution in " + generation + " generations");
        System.out.println("Best solution: " + population.getFittest(0).toString());
        System.out.println("Fitness: " + population.getFittest(0).getFitness());
    }
}
