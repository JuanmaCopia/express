package express;

import java.util.HashSet;
import java.util.Set;

import express.classinvariant.fitness.LengthFitness;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.stage1.ComposeNullCheckMutator;
import express.classinvariant.mutator.stage1.IfNullReturnMutator;
import express.classinvariant.mutator.stage1.RemoveIfInitialCheckMutator;
import express.classinvariant.mutator.stage4.AddSizeCheckMutator;
import express.classinvariant.mutator.stage4.CheckSizeEndOfTraversalMutator;
import express.classinvariant.mutator.stage4.RemoveIfPrimitiveCheckMutator;
import express.classinvariant.mutator.stage4.RemoveSizeCheckMutator;
import express.classinvariant.mutator.stage4.RemoveTraversalSizeCheckMutator;
import express.classinvariant.mutator.stage3.CheckVisitedFieldMutator;
import express.classinvariant.mutator.stage3.DeclareVisitedSetMutator;
import express.classinvariant.mutator.stage3.RemoveCheckMutator;
import express.classinvariant.mutator.stage3.AddNullCompToTraversalMutator;
import express.classinvariant.mutator.stage3.AddRandomComparisonToCurrent;
import express.classinvariant.mutator.stage3.CheckVisitedFieldEndOfTraversalMutator;
import express.classinvariant.mutator.stage3.ComposedNullCheckInTraversalMutator;
import express.classinvariant.mutator.stage3.IfNullReturnInTraversalMutator;
import express.classinvariant.mutator.stage2.RemoveTraversalInvocationMutator;
import express.classinvariant.mutator.stage2.RemoveTraversalMutator;
import express.classinvariant.mutator.stage3.CheckVisitedCurrentOnArrayTraversalMutator;
import express.classinvariant.mutator.stage2.DeclareArrayTraversalMutator;
import express.classinvariant.mutator.stage2.InvokeArrayTraversalMutator;
import express.classinvariant.mutator.stage2.InvokeFieldTraversalOnArrayTraversalMutator;
import express.classinvariant.mutator.stage2.ChangeLoopFieldsMutator;
import express.classinvariant.mutator.stage2.DeclareSimpleTraversalMutator;
import express.classinvariant.mutator.stage2.DeclareWorklistTraversalMutator;
import express.classinvariant.mutator.stage2.InvokeFieldTraversalMutator;
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

    long elapsedTime;

    public Express(Config config) {
        this.config = config;
        SpoonManager.initialize(config);
        printObjectGenerationStart();
        ObjectGenerator.generateObjects();
        printObjectsInformation();
    }

    private void printObjectGenerationStart() {
        System.out.println("Generating Objects...\n");
    }

    private void printObjectsInformation() {
        System.out.println("\n------------------ Objects Information ------------------\n");
        System.out.println("Positive Objects Collected: " + ObjectGenerator.positiveObjects.size());
        System.out.println("Negative Heap Objects Generated: " + ObjectGenerator.negativeHeapObjects.size());
        System.out.println("Negative Primitive Objects Generated: " + ObjectGenerator.negativePrimitiveObjects.size());
    }

    public void run() {
        printConfiguration();
        elapsedTime = System.currentTimeMillis();
        ClassInvariantState finalState = startSearch();
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        printResults(finalState);
        saveResults(finalState);
    }

    private ClassInvariantState startSearch() {
        ClassInvariantState currentState = initializationStageSearch();
        currentState = traversalStageSearch(currentState);
        currentState = startStructureCheckSearch(currentState);
        // currentState = startPrimitiveCheck(currentState);
        return currentState;
    }

    public ClassInvariantState initializationStageSearch() {
        printStartOfPhase("Initialization");
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        // Initial Check Mutators
        mutators.add(new ComposeNullCheckMutator());
        mutators.add(new IfNullReturnMutator());
        mutators.add(new RemoveIfInitialCheckMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, ObjectGenerator.negativeHeapObjects),
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState traversalStageSearch(ClassInvariantState currentState) {
        printStartOfPhase("Traversal", currentState);
        Set<ClassInvariantMutator> mutators = new HashSet<>();
        // Traversal Declaration Mutators
        mutators.add(new DeclareWorklistTraversalMutator());
        mutators.add(new DeclareSimpleTraversalMutator());
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
                currentState,
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState startStructureCheckSearch(ClassInvariantState currentState) {
        printStartOfPhase("Structural Property Check", currentState);
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
        mutators.add(new CheckVisitedCurrentOnArrayTraversalMutator());
        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, ObjectGenerator.negativeHeapObjects),
                currentState,
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
        System.out.println("Elapsed time: " + elapsedTime / 1000 + " s");
        System.out.println("Elapsed time during compilation: " + LengthFitness.compilationTime / 1000 + " s");
        System.out.println("Elapsed time during fitness function evaluation: " + LengthFitness.fitnessEvaluationTime / 1000 + " s");
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
        printStartOfPhase(phase, null);
    }

    public void printStartOfPhase(String phase, ClassInvariantState state) {
        if (state != null) {
            System.out.println("\n\n==============================  Current State  ==============================\n");
            System.out.println("Current best solution: " + state.getCtClass().toString());
            System.out.println("Fitness: " + state.getFitness());
        }
        System.out.println("\n\n==============================  " + phase + " Stage  ==============================\n");
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

    public void printConfiguration() {
        System.out.println("\n" + config.toString());
    }

    public static void main(String[] args) {
        Express express = new Express(new Config(CONFIG_FILE_PATH));
        express.run();
    }

}
