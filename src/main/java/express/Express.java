package express;

import java.util.ArrayList;
import java.util.List;

import express.classinvariant.fitness.LengthFitness;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.anystage.RemoveIfMutator;
import express.classinvariant.mutator.anystage.RemoveUnusedLocalVarMutator;
import express.classinvariant.mutator.stage1.MultipleNullComparisonMutator;
import express.classinvariant.mutator.stage1.SingleNullComparisonMutator;
import express.classinvariant.mutator.stage2.ChangeLoopFieldsMutator;
import express.classinvariant.mutator.stage2.ChangeTraversalRootElement;
import express.classinvariant.mutator.stage2.DeclareArrayTraversalMutator;
import express.classinvariant.mutator.stage2.DeclareSimpleTraversalMutator;
import express.classinvariant.mutator.stage2.DeclareWorklistTraversalMutator;
import express.classinvariant.mutator.stage2.InvokeArrayTraversalMutator;
import express.classinvariant.mutator.stage2.InvokeFieldTraversalMutator;
import express.classinvariant.mutator.stage2.InvokeFieldTraversalOnArrayTraversalMutator;
import express.classinvariant.mutator.stage2.RemoveUnusedTraversalsMutator;
import express.classinvariant.mutator.stage2.UnifyTraversalInvocationsMutator;
import express.classinvariant.mutator.stage3.AddRandomComparisonToCurrent;
import express.classinvariant.mutator.stage3.CheckVisitedCurrentOnArrayTraversalMutator;
import express.classinvariant.mutator.stage3.CheckVisitedFieldEndOfTraversalMutator;
import express.classinvariant.mutator.stage3.CheckVisitedFieldMutator;
import express.classinvariant.mutator.stage3.DeclareVisitedSetMutator;
import express.classinvariant.mutator.stage3.MultipleNullComparisonFromInputMutator;
import express.classinvariant.mutator.stage3.NullComparisonFromCurrentMutator;
import express.classinvariant.mutator.stage3.NullComparisonFromInputMutator;
import express.classinvariant.mutator.stage4.AddSizeCheckMutator;
import express.classinvariant.mutator.stage4.BooleanComparisonFromThis;
import express.classinvariant.mutator.stage4.BooleanComparisonToCurrentMutator;
import express.classinvariant.mutator.stage4.CheckSizeEndOfTraversalMutator;
import express.classinvariant.mutator.stage4.CheckVisitedPrimitiveFromCurrentMutator;
import express.classinvariant.mutator.stage4.NumericComparisonFromThis;
import express.classinvariant.mutator.stage4.NumericComparisonToCurrentMutator;
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
        System.out.println("Negative Initialization Objects Generated: " + ObjectGenerator.negativeInitializationObjects.size());
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
        currentState = startPrimitiveCheck(currentState);
        return currentState;
    }

    public ClassInvariantState initializationStageSearch() {
        printStartOfPhase("Initialization");
        List<ClassInvariantMutator> mutators = new ArrayList<>();
        // Initial Check Mutators
        mutators.add(new MultipleNullComparisonMutator());
        mutators.add(new SingleNullComparisonMutator());
        // Removals
        mutators.add(new RemoveIfMutator(1));
        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, ObjectGenerator.negativeInitializationObjects),
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState traversalStageSearch(ClassInvariantState currentState) {
        printStartOfPhase("Traversal", currentState);

        List<Object> survivors = Executor.obtainSurvivors(currentState.getCtClass(), ObjectGenerator.negativeHeapObjects);
        //System.err.println("Survivors: " + survivors.size() + " from " + ObjectGenerator.negativeHeapObjects.size());
        currentState.setFitnessAsOutdated();

        List<ClassInvariantMutator> mutators = new ArrayList<>();
        // Traversal Declaration Mutators
        mutators.add(new DeclareWorklistTraversalMutator());
        mutators.add(new DeclareSimpleTraversalMutator());
        mutators.add(new DeclareArrayTraversalMutator());
        // Traversal Modification Mutators
        mutators.add(new ChangeLoopFieldsMutator());
        mutators.add(new ChangeTraversalRootElement());
        // Traversal Invocation Mutators
        mutators.add(new InvokeArrayTraversalMutator());
        mutators.add(new InvokeFieldTraversalMutator());
        mutators.add(new InvokeFieldTraversalOnArrayTraversalMutator());
        // Removals
        mutators.add(new RemoveIfMutator(2));
        mutators.add(new RemoveUnusedTraversalsMutator());
        mutators.add(new UnifyTraversalInvocationsMutator());

        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, survivors),
                currentState,
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState startStructureCheckSearch(ClassInvariantState currentState) {
        printStartOfPhase("Structural Property Check", currentState);

        List<Object> survivors = Executor.obtainSurvivors(currentState.getCtClass(), ObjectGenerator.negativeHeapObjects);
        //System.err.println("Survivors: " + survivors.size() + " from " + ObjectGenerator.negativeHeapObjects.size());
        currentState.setFitnessAsOutdated();

        List<ClassInvariantMutator> mutators = new ArrayList<>();
        // Structure Check Mutators
        mutators.add(new CheckVisitedFieldEndOfTraversalMutator());
        mutators.add(new NullComparisonFromCurrentMutator());
        mutators.add(new AddRandomComparisonToCurrent());
        mutators.add(new DeclareVisitedSetMutator());
        mutators.add(new CheckVisitedFieldMutator());
        mutators.add(new NullComparisonFromInputMutator());
        mutators.add(new MultipleNullComparisonFromInputMutator());
        mutators.add(new CheckVisitedCurrentOnArrayTraversalMutator());
        // Removals
        mutators.add(new RemoveUnusedLocalVarMutator());
        mutators.add(new RemoveIfMutator(3));

        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, survivors),
                currentState,
                config.restartRounds);
        SimulatedAnnealingSchedule schedule = new SimulatedAnnealingSchedule(config.initialTemperature,
                config.coolingRate);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, schedule);
        return (ClassInvariantState) simulatedAnnealing.startSearch();
    }

    public ClassInvariantState startPrimitiveCheck(ClassInvariantState currentState) {
        printStartOfPhase("Primitive Properties Search", currentState);

        List<Object> survivors = Executor.obtainSurvivors(currentState.getCtClass(), ObjectGenerator.negativePrimitiveObjects);
        currentState.setFitnessAsOutdated();

        List<ClassInvariantMutator> mutators = new ArrayList<>();
        // For Primitive main method
        mutators.add(new BooleanComparisonFromThis());
        mutators.add(new NumericComparisonFromThis());
        //
        mutators.add(new CheckSizeEndOfTraversalMutator());
        mutators.add(new AddSizeCheckMutator());
        mutators.add(new NumericComparisonToCurrentMutator());
        mutators.add(new BooleanComparisonToCurrentMutator());
        mutators.add(new CheckVisitedPrimitiveFromCurrentMutator());
        mutators.add(new DeclareVisitedSetMutator());
        // Removals
        mutators.add(new RemoveIfMutator(4));
        mutators.add(new RemoveUnusedLocalVarMutator());

        ClassInvariantProblem problem = new ClassInvariantProblem(
                mutators,
                new LengthFitness(ObjectGenerator.positiveObjects, survivors),
                currentState,
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
        //printNotKilledMutants(finalState);
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
        String configFilePath = CONFIG_FILE_PATH;
        if (args.length == 1) {
            configFilePath = args[0];
        }

        Express express = new Express(new Config(configFilePath));
        express.run();
    }

}
