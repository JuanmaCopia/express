package evoexpress;

import evoexpress.classinvariant.fitness.LengthFitness;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.all.RemoveCheckMutator;
import evoexpress.classinvariant.mutator.initialcheck.ComposeNullCheckMutator;
import evoexpress.classinvariant.mutator.initialcheck.IfNullReturnMutator;
import evoexpress.classinvariant.mutator.initialcheck.RemoveIfInitialCheckMutator;
import evoexpress.classinvariant.mutator.primitivecheck.*;
import evoexpress.classinvariant.mutator.structurecheck.CheckVisitedFieldMutator;
import evoexpress.classinvariant.mutator.structurecheck.DeclareVisitedSetMutator;
import evoexpress.classinvariant.mutator.structurecheck.RemoveIfStructureCheckMutator;
import evoexpress.classinvariant.mutator.structurecheck.traversal.*;
import evoexpress.classinvariant.mutator.structurecheck.traversal.init.*;
import evoexpress.classinvariant.mutator.structurecheck.traversal.array.*;
import evoexpress.classinvariant.problem.ClassInvariantProblem;
import evoexpress.classinvariant.search.ClassInvariantSearch;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.config.Config;
import evoexpress.object.ObjectGenerator;
import evoexpress.search.simulatedannealing.schedule.SimulatedAnnealingSchedule;
import evoexpress.spoon.SpoonManager;
import evoexpress.execution.Executor;

import java.util.HashSet;
import java.util.Set;

public class EvoExpress {

    private static final String CONFIG_FILE_PATH = "config.properties";
    Config config;

    public EvoExpress(Config config) {
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
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness());
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, new SimulatedAnnealingSchedule(7, 0.004));
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
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), initialState);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, new SimulatedAnnealingSchedule(7, 0.004));
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
        ClassInvariantProblem problem = new ClassInvariantProblem(mutators, new LengthFitness(), initialState);
        ClassInvariantSearch simulatedAnnealing = new ClassInvariantSearch(problem, new SimulatedAnnealingSchedule(5, 0.02));
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
        SpoonManager.getOutput().generateSourcePreconditionSourceFile(finalState.getCtClass());
        System.out.println("\nSource code saved in: " + config.outputSrcPath);
    }

    public void printNotKilledMutants(ClassInvariantState finalState) {
        System.out.println("\n\n==============================  Unkilled Mutants  ==============================\n");
        Executor.printSurvivors(finalState.getCtClass());
        System.out.println("\n=================================================================================\n");
    }

    public void printStart() {
        System.out.println("\n==============================  Search Started  ==============================\n");
    }

    public static void main(String[] args) {
        EvoExpress evoExpress = new EvoExpress(new Config(CONFIG_FILE_PATH));
        evoExpress.run();
    }

}
