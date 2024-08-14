package express;

import express.classinvariant.fitness.LengthFitness;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.all.RemoveCheckMutator;
import express.classinvariant.mutator.initialcheck.ComposeNullCheckMutator;
import express.classinvariant.mutator.initialcheck.IfNullReturnMutator;
import express.classinvariant.mutator.initialcheck.RemoveIfInitialCheckMutator;
import express.classinvariant.mutator.primitivecheck.*;
import express.classinvariant.mutator.structurecheck.CheckVisitedFieldMutator;
import express.classinvariant.mutator.structurecheck.DeclareVisitedSetMutator;
import express.classinvariant.mutator.structurecheck.traversal.*;
import express.classinvariant.mutator.structurecheck.traversal.init.*;
import express.classinvariant.mutator.structurecheck.traversal.array.*;
import express.classinvariant.problem.ClassInvariantProblem;
import express.classinvariant.search.ClassInvariantSearch;
import express.classinvariant.state.ClassInvariantState;
import express.config.Config;
import express.object.ObjectGenerator;
import express.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import express.spoon.SpoonManager;
import express.execution.Executor;

import java.util.HashSet;
import java.util.Set;

public class Express {

    private static final String CONFIG_FILE_PATH = "config.properties";
    Config config;

    public Express(Config config) {
        this.config = config;
        SpoonManager.initialize(config);
        ObjectGenerator.generateObjects();
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
        //currentState = startPrimitiveCheck(currentState);
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
        mutators.add(new ChangeFirstElementMutator());
        // Traversal Invocation Mutators
        mutators.add(new InvokeArrayTraversalMutator());
        mutators.add(new InvokeFieldTraversalMutator());
        mutators.add(new InvokeFieldTraversalOnArrayTraversalMutator());
        mutators.add(new RemoveTraversalInvocationMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature, config.coolingRate);
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
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), initialState, config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature, config.coolingRate);
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
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), initialState, config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature, config.coolingRate);
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
        System.out.println("\n\n==============================  Search Finished  ==============================\n");
        System.out.println("Current best solution: " + state.getCtClass().toString());
        System.out.println("Fitness: " + state.getFitness());
        System.out.println("\n=================================================================================\n");
    }

    public void printStartOfPhase(String phase) {
        System.out.println("\n\n==============================  " + phase + "  ==============================\n");
    }

    public void saveResults(ClassInvariantState finalState) {
        SpoonManager.getOutput().generatePredicateSourceFiles(finalState.getCtClass());
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
