package evoexpress;

import evoexpress.config.ToolConfig;
import evoexpress.ga.*;
import evoexpress.ga.fitness.FitnessFunctions;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.initialcheck.AddComposedInitialNullCheckMutator;
import evoexpress.ga.mutator.initialcheck.AddIfNullReturnMutator;
import evoexpress.ga.mutator.structurecheck.*;
import evoexpress.object.ObjectGeneratorManager;
import evoexpress.spoon.SpoonManager;

import java.util.HashSet;
import java.util.Set;

public class EvoExpress {

    public static void main(String[] args) {
        initialize();
        printStart();
        Population population = startInitialCheckSearch();
        population = startStructureCheckSearch(population);
        printResults(population);
        saveResults(population);
        //printNotKilledMutants(population);
    }

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
        SpoonManager.initialize();
        ObjectGeneratorManager.generateObjects();
    }


    public static void printStart() {
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

    public static Population startInitialCheckSearch() {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new AddIfNullReturnMutator());
        mutators.add(new AddComposedInitialNullCheckMutator());
        GeneticAlgorithm ga = new InitialCheckGA(mutators, ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(ga.initPopulation());
    }

    public static Population startStructureCheckSearch(Population population) {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new TraverseWorklistMutator());
        mutators.add(new TraverseCyclicReferenceMutator());
        mutators.add(new AddComposedIfToTraversalMutator());
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
        mutators.add(new AddSizeCheckMutator());
        mutators.add(new AddNullCompToTraversalMutator());
        mutators.add(new TraverseCircularReferenceMutator());
        GeneticAlgorithm ga = new StructureCheckGA(mutators, ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(population);
    }


    public static void printResults(Population population) {
        System.out.println("\n\n==============================  Search Finished  ==============================\n");
        System.out.println("Number of generations: " + population.getGenerationNumber());
        System.out.println("Best solution: " + population.getFittest().toString());
        System.out.println("Fitness: " + population.getFittest().getFitness());
        System.out.println("\n=================================================================================\n");
    }

    public static void saveResults(Population population) {
        SpoonManager.generateSourcePreconditionSourceFile(population.getFittest());
        System.out.println("\nSource code saved in: " + ToolConfig.outputSrcPath);
    }

    public static void printNotKilledMutants(Population population) {
        System.out.println("\n\n==============================  Unkilled Mutants  ==============================\n");
        Individual fittest = population.getFittest();
        FitnessFunctions.printSurvivors(fittest);
        System.out.println("\n=================================================================================\n");
    }
}
