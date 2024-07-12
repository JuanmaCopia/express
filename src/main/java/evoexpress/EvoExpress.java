package evoexpress;

import evoexpress.config.ToolConfig;
import evoexpress.ga.GeneticAlgorithm;
import evoexpress.ga.PrimitiveCheckGA;
import evoexpress.ga.StructureCheckGA;
import evoexpress.ga.TraversalSearch;
import evoexpress.ga.fitness.LengthFitness;
import evoexpress.ga.fitness.NoLengthFitness;
import evoexpress.ga.helper.GAHelper;
import evoexpress.ga.individual.Individual;
import evoexpress.ga.mutator.Mutator;
import evoexpress.ga.mutator.structurecheck.AddComposedInitialNullCheckMutator;
import evoexpress.ga.mutator.structurecheck.AddIfNullReturnMutator;
import evoexpress.ga.mutator.structurecheck.DeclareVisitedSetMutator;
import evoexpress.ga.mutator.structurecheck.traversal.TraverseWorklistMutator;
import evoexpress.ga.mutator.structurecheck.traversal.inner.AddNullCompToTraversalMutator;
import evoexpress.ga.mutator.structurecheck.traversal.inner.AddRandomComparisonToCurrent;
import evoexpress.ga.mutator.structurecheck.traversal.inner.CheckSizeEndOfTraversalMutator;
import evoexpress.ga.mutator.structurecheck.traversal.inner.CheckVisitedFieldEndOfTraversalMutator;
import evoexpress.ga.mutator.structurecheck.traversal.outer.AddSizeCheckMutator;
import evoexpress.ga.mutator.structurecheck.traversal.outer.CheckVisitedFieldMutator;
import evoexpress.ga.mutator.structurecheck.traversal.trav.ChangeFirstElementMutator;
import evoexpress.ga.mutator.structurecheck.traversal.trav.ChangeLoopFieldsMutator;
import evoexpress.ga.population.Population;
import evoexpress.object.ObjectGeneratorManager;
import evoexpress.spoon.SpoonManager;

import java.util.HashSet;
import java.util.Set;

public class EvoExpress {

    public static void main(String[] args) {
        initialize();
        printStart();
        Population population = startTraversalSearch();
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

    public static Population startTraversalSearch() {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new TraverseWorklistMutator());
        mutators.add(new AddIfNullReturnMutator());
        mutators.add(new AddComposedInitialNullCheckMutator());
        mutators.add(new ChangeLoopFieldsMutator());
        mutators.add(new ChangeFirstElementMutator());
        mutators.add(new DeclareVisitedSetMutator());
        mutators.add(new CheckVisitedFieldMutator());
        GeneticAlgorithm ga = new TraversalSearch(mutators, new NoLengthFitness(), ToolConfig.maxPopulation, ToolConfig.mutationRate, ToolConfig.crossoverRate, ToolConfig.elitismCount);
        return ga.startSearch(ga.initPopulation());
    }

    public static Population startStructureCheckSearch(Population population) {
        Set<Mutator> mutators = new HashSet<>();
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
        mutators.add(new AddNullCompToTraversalMutator());
        mutators.add(new AddRandomComparisonToCurrent());
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
