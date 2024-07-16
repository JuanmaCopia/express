package evoexpress;

import evoexpress.config.ToolConfig;
import evoexpress.ga.fitness.LengthFitness;
import evoexpress.ga.fitness.NoLengthFitness;
import evoexpress.ga.helper.GAHelper;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.initialcheck.ComposeNullCheckMutator;
import evoexpress.ga.mutator.initialcheck.IfNullReturnMutator;
import evoexpress.ga.mutator.primitivecheck.AddSizeCheckMutator;
import evoexpress.ga.mutator.primitivecheck.CheckSizeEndOfTraversalMutator;
import evoexpress.ga.mutator.structurecheck.CheckVisitedFieldMutator;
import evoexpress.ga.mutator.structurecheck.DeclareVisitedSetMutator;
import evoexpress.ga.mutator.structurecheck.traversal.AddNullCompToTraversalMutator;
import evoexpress.ga.mutator.structurecheck.traversal.AddRandomComparisonToCurrent;
import evoexpress.ga.mutator.structurecheck.traversal.CheckVisitedFieldEndOfTraversalMutator;
import evoexpress.ga.mutator.structurecheck.traversal.init.*;
import evoexpress.ga.population.Population;
import evoexpress.ga.search.*;
import evoexpress.object.ObjectGeneratorManager;
import evoexpress.spoon.SpoonManager;

import java.util.HashSet;
import java.util.Set;

public class EvoExpress {

    public static void main(String[] args) {
        initialize();
        printStart();
        Population population = startInitialSearch();
        population = startTraversalSearch(population);
        population = startStructureCheckSearch(population);
        population = startPrimitiveCheck(population);
        printResults(population);
        saveResults(population);
    }

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
        SpoonManager.initialize();
        ObjectGeneratorManager.generateObjects();
    }


    public static void printStart() {
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

    public static Population startInitialSearch() {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new ComposeNullCheckMutator());
        mutators.add(new IfNullReturnMutator());
        GeneticAlgorithm ga = new InitialSearch(mutators, new LengthFitness(), ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(ga.initPopulation());
    }

    public static Population startTraversalSearch(Population population) {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new TraverseWorklistMutator());
        mutators.add(new IfNullReturnInTraversalMutator());
        mutators.add(new ComposedNullCheckInTraversalMutator());
        mutators.add(new ChangeLoopFieldsMutator());
        mutators.add(new ChangeFirstElementMutator());
        GeneticAlgorithm ga = new TraversalSearch(mutators, new NoLengthFitness(), ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(population);
    }

    public static Population startStructureCheckSearch(Population population) {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
        mutators.add(new AddNullCompToTraversalMutator());
        mutators.add(new AddRandomComparisonToCurrent());
        mutators.add(new DeclareVisitedSetMutator());
        mutators.add(new CheckVisitedFieldMutator());
        GeneticAlgorithm ga = new StructureCheckGA(mutators, new LengthFitness(), ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(population);
    }

    public static Population startPrimitiveCheck(Population population) {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new CheckSizeEndOfTraversalMutator());
        mutators.add(new AddSizeCheckMutator());
        GeneticAlgorithm ga = new PrimitiveCheckGA(mutators, new NoLengthFitness(), ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(population);
    }

//    public static Population minimize(Population population) {
//        Set<Mutator> mutators = new HashSet<>();
//        mutators.add(new RemoveCheckMutator());
//        GeneticAlgorithm ga = new MinimizationGA(mutators, new LengthFitness(), ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
//        return ga.startSearch(population);
//    }

    public static void printResults(Population population) {
        System.out.println("\n\n==============================  Search Finished  ==============================\n");
        System.out.println("Number of generations: " + population.getGenerationNumber());
        System.out.println("Best solution: " + population.getFittest().toString());
        System.out.println("Fitness: " + population.getFittest().getFitness());
        printNotKilledMutants(population);
        System.out.println("\n=================================================================================\n");
    }

    public static void saveResults(Population population) {
        SpoonManager.generateSourcePreconditionSourceFile(population.getFittest());
        System.out.println("\nSource code saved in: " + ToolConfig.outputSrcPath);
    }

    public static void printNotKilledMutants(Population population) {
        System.out.println("\n\n==============================  Unkilled Mutants  ==============================\n");
        Individual fittest = population.getFittest();
        GAHelper.printSurvivors(fittest);
        System.out.println("\n=================================================================================\n");
    }
}
