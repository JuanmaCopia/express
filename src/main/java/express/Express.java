package express;

import java.util.HashSet;
import java.util.Set;

import express.classinvariant.fitness.LengthFitness;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.initialcheck.ComposeNullCheckMutator;
import express.classinvariant.mutator.initialcheck.IfNullReturnMutator;
import express.classinvariant.mutator.initialcheck.RemoveIfInitialCheckMutator;
import express.classinvariant.mutator.primitivecheck.AddSizeCheckMutator;
import express.classinvariant.mutator.primitivecheck.CheckSizeEndOfTraversalMutator;
import express.classinvariant.mutator.primitivecheck.RemoveIfPrimitiveCheckMutator;
import express.classinvariant.mutator.primitivecheck.RemoveSizeCheckMutator;
import express.classinvariant.mutator.primitivecheck.RemoveTraversalSizeCheckMutator;
import express.classinvariant.mutator.structurecheck.CheckVisitedFieldMutator;
import express.classinvariant.mutator.structurecheck.DeclareVisitedSetMutator;
import express.classinvariant.mutator.structurecheck.RemoveCheckMutator;
import express.classinvariant.mutator.structurecheck.traversal.AddNullCompToTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.AddRandomComparisonToCurrent;
import express.classinvariant.mutator.structurecheck.traversal.CheckVisitedFieldEndOfTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.ComposedNullCheckInTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.IfNullReturnInTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.RemoveTraversalInvocationMutator;
import express.classinvariant.mutator.structurecheck.traversal.RemoveTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.array.CheckVisitedCurrentMutator;
import express.classinvariant.mutator.structurecheck.traversal.array.DeclareArrayTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.array.InvokeArrayTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.array.InvokeFieldTraversalOnArrayTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.init.ChangeLoopFieldsMutator;
import express.classinvariant.mutator.structurecheck.traversal.init.DeclareWorklistTraversalMutator;
import express.classinvariant.mutator.structurecheck.traversal.init.InvokeFieldTraversalMutator;
import express.classinvariant.problem.ClassInvariantProblem;
import express.classinvariant.search.ClassInvariantSearch;
import express.classinvariant.state.ClassInvariantState;
import express.config.Config;
import express.execution.Executor;
import express.object.ObjectGenerator;
import express.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import express.spoon.SpoonManager;

public class Express {

    private static final String CONFIG_FILE_PATH = "config.properties";
    Config config;

    public Express(Config config) {
        this.config = config;
        SpoonManager.initialize(config);
        printObjectGenerationStart();
        ObjectGenerator.generateObjects();
        printObjectsInformation();
    }

    private void printObjectGenerationStart() {
        System.out.println("\nGenerating Objects...\n");
    }

    private void printObjectsInformation() {
        System.out.println("\n------------------ Objects Information ------------------\n");
        System.out.println("Positive Objects Collected: " + ObjectGenerator.positiveObjects.size());
        System.out.println("Negative Heap Objects Generated: " + ObjectGenerator.negativeHeapObjects.size());
        System.out.println("Negative Primitive Objects Generated: " + ObjectGenerator.negativePrimitiveObjects.size());
    }

    public void run() {
        printStart();
        ClassInvariantState finalState = startSearch();
        printResults(finalState);
        saveResults(finalState);
    }

    private ClassInvariantState startSearch() {
        ClassInvariantState currentState = startInitialSearch();
        printCurrentState(currentState);
        currentState = startStructureCheckSearch(currentState);
        // currentState = startPrimitiveCheck(currentState);
        return currentState;
    }

    public ClassInvariantState startInitialSearch() {
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        // Initial Check Mutators
        mutators.add(new ComposeNullCheckMutator());
        mutators.add(new IfNullReturnMutator());
        mutators.add(new RemoveIfInitialCheckMutator());
        // Traversal Declaration Mutators
        mutators.add(new DeclareWorklistTraversalMutator());
        mutators.add(new DeclareArrayTraversalMutator());
        mutators.add(new RemoveTraversalMutator());
        // Traversal Modification Mutators
        mutators.add(new ChangeLoopFieldsMutator());
        // Traversal Invocation Mutators
        mutators.add(new InvokeArrayTraversalMutator());
        mutators.add(new InvokeFieldTraversalMutator());
        mutators.add(new InvokeFieldTraversalOnArrayTraversalMutator());
        mutators.add(new RemoveTraversalInvocationMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, ObjectGenerator.negativeHeapObjects),
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState startStructureCheckSearch(ClassInvariantState initialState) {
        printStartOfPhase("Structure Search");
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        mutators.add(new RemoveCheckMutator());
        // Structure Check Mutators
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
        mutators.add(new AddNullCompToTraversalMutator());
        mutators.add(new AddRandomComparisonToCurrent());
        mutators.add(new DeclareVisitedSetMutator());
        mutators.add(new CheckVisitedFieldMutator());
        mutators.add(new IfNullReturnInTraversalMutator());
        mutators.add(new ComposedNullCheckInTraversalMutator());
        mutators.add(new CheckVisitedCurrentMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, ObjectGenerator.negativeHeapObjects),
                initialState,
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState startPrimitiveCheck(ClassInvariantState initialState) {
        printStartOfPhase("Primitive Search");
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        mutators.add(new CheckSizeEndOfTraversalMutator());
        mutators.add(new AddSizeCheckMutator());
        mutators.add(new RemoveIfPrimitiveCheckMutator());
        mutators.add(new RemoveSizeCheckMutator());
        mutators.add(new RemoveTraversalSizeCheckMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, ObjectGenerator.negativePrimitiveObjects),
                initialState,
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public void printResults(ClassInvariantState finalState) {
        System.out.println("\n\n==============================  Search Finished  ==============================\n");
        System.out.println("Best solution: " + finalState.getCtClass().toString());
        System.out.println("Fitness: " + finalState.getFitness());
        printNotKilledMutants(finalState);
        System.out.println("\n=================================================================================\n");
    }

    public void printCurrentState(ClassInvariantState state) {
        System.out.println("\n\n==============================  Current State  ==============================\n");
        System.out.println("Current best solution: " + state.getCtClass().toString());
        System.out.println("Fitness: " + state.getFitness());
        System.out.println("\n=================================================================================\n");
    }

    public void printStartOfPhase(String phase) {
        System.out.println("\n\n==============================  " + phase + "  ==============================\n");
    }

    public void saveResults(ClassInvariantState finalState) {
        SpoonManager.getOutputManager().generatePredicateSourceFiles(finalState.getCtClass());
        System.out.println("\nSource code saved in: " + config.outputSrcPath);
    }

    public void printNotKilledMutants(ClassInvariantState finalState) {
        System.out.println("\n\n==============================  Unkilled Mutants  ==============================\n");
        Executor.printSurvivors(finalState.getCtClass());
        System.out.println("\n=================================================================================\n");
    }

    public void printStart() {
        System.out.println("\n" + config.toString());
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

    public static void main(String[] args) {
        Express express = new Express(new Config(CONFIG_FILE_PATH));
        express.run();
    }

}
