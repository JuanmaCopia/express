package evoexpress;

import evoexpress.classinvariant.mutator.initialcheck.RemoveIfInitialCheckMutator;
import evoexpress.classinvariant.mutator.primitivecheck.*;
import evoexpress.classinvariant.mutator.structurecheck.RemoveIfStructureCheckMutator;
import evoexpress.classinvariant.mutator.structurecheck.traversal.*;
import evoexpress.classinvariant.mutator.structurecheck.traversal.init.*;
import evoexpress.classinvariant.problem.ClassInvariantProblem;
import evoexpress.classinvariant.search.ClassInvariantSearch;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.config.ToolConfig;
import evoexpress.classinvariant.fitness.LengthFitness;
import evoexpress.execution.Executor;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.initialcheck.ComposeNullCheckMutator;
import evoexpress.classinvariant.mutator.initialcheck.IfNullReturnMutator;
import evoexpress.classinvariant.mutator.structurecheck.CheckVisitedFieldMutator;
import evoexpress.classinvariant.mutator.structurecheck.DeclareVisitedSetMutator;
import evoexpress.object.ObjectGeneratorManager;
import evoexpress.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import evoexpress.spoon.SpoonManager;

import java.util.HashSet;
import java.util.Set;

public class EvoExpress {

    public static void main(String[] args) {
        initialize();
        printStart();
        ClassInvariantState finalState = startSearch();
        printResults(finalState);
        saveResults(finalState);
    }

    private static ClassInvariantState startSearch() {
        ClassInvariantState currentState = startInitialSearch();
        currentState = startStructureCheckSearch(currentState);
        currentState = startPrimitiveCheck(currentState);
        return currentState;
    }

    public static ClassInvariantState startInitialSearch() {
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        mutators.add(new ComposeNullCheckMutator());
        mutators.add(new IfNullReturnMutator());
        mutators.add(new RemoveIfInitialCheckMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness());
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, new SimulatedAnnealingSchedule(10, 0.05));
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public static ClassInvariantState startStructureCheckSearch(ClassInvariantState initialState) {
        printStartOfPhase("Structure Search");
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
        mutators.add(new AddNullCompToTraversalMutator());
        mutators.add(new AddRandomComparisonToCurrent());
        mutators.add(new DeclareVisitedSetMutator());
        mutators.add(new CheckVisitedFieldMutator());
        mutators.add(new RemoveIfStructureCheckMutator());
        mutators.add(new TraverseWorklistMutator());
        mutators.add(new IfNullReturnInTraversalMutator());
        mutators.add(new ComposedNullCheckInTraversalMutator());
        mutators.add(new ChangeLoopFieldsMutator());
        mutators.add(new ChangeFirstElementMutator());
        mutators.add(new RemoveIfTraversalMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), initialState);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, new SimulatedAnnealingSchedule(20, 0.01));
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public static ClassInvariantState startPrimitiveCheck(ClassInvariantState initialState) {
        printStartOfPhase("Primitive Search");
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        mutators.add(new CheckSizeEndOfTraversalMutator());
        mutators.add(new AddSizeCheckMutator());
        mutators.add(new RemoveIfPrimitiveCheckMutator());
        mutators.add(new RemoveSizeCheckMutator());
        mutators.add(new RemoveTraversalSizeCheckMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), initialState);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, new SimulatedAnnealingSchedule(5, 0.02));
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public static void printResults(ClassInvariantState finalState) {
        System.out.println("\n\n==============================  Search Finished  ==============================\n");
        System.out.println("Best solution: " + finalState.getCtClass().toString());
        System.out.println("Fitness: " + finalState.getFitness());
        printNotKilledMutants(finalState);
        System.out.println("\n=================================================================================\n");
    }

    public static void printStartOfPhase(String phase) {
        System.out.println("\n\n==============================  " + phase + "  ==============================\n");
    }

    public static void saveResults(ClassInvariantState finalState) {
        SpoonManager.generateSourcePreconditionSourceFile(finalState.getCtClass());
        System.out.println("\nSource code saved in: " + ToolConfig.outputSrcPath);
    }

    public static void printNotKilledMutants(ClassInvariantState finalState) {
        System.out.println("\n\n==============================  Unkilled Mutants  ==============================\n");
        Executor.printSurvivors(finalState.getCtClass());
        System.out.println("\n=================================================================================\n");
    }

    private static void initialize() {
        ToolConfig.parseConfigurationFile();
        SpoonManager.initialize();
        ObjectGeneratorManager.generateObjects();
    }

    public static void printStart() {
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

}
