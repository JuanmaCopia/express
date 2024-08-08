package evoexpress.classinvariant.problem;

import evoexpress.classinvariant.mutator.ClassInvariantMutatorManager;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.fitness.ClassInvariantFitness;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.output.Compiler;
import evoexpress.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;
import evoexpress.spoon.SpoonManager;
import org.apache.commons.math3.genetics.Fitness;
import spoon.reflect.declaration.CtClass;

import java.text.DecimalFormat;
import java.util.Set;

public class ClassInvariantProblem implements SimulatedAnnealingProblem {

    static final int MAX_ROUNDS_WITHOUT_IMPROVEMENT = 100;

    ClassInvariantMutatorManager mutatorManager;
    ClassInvariantFitness fitnessFunction;
    ClassInvariantState initialState;
    Compiler compiler;

    int roundsWithoutImprovement = 0;

    public ClassInvariantProblem(Set<ClassInvariantMutator> mutators, ClassInvariantFitness fitnessFunction, ClassInvariantState initialState) {
        mutatorManager = new ClassInvariantMutatorManager(mutators);
        this.fitnessFunction = fitnessFunction;
        this.initialState = initialState;
        this.compiler = SpoonManager.getOutput().getCompiler();
    }

    public ClassInvariantProblem(Set<ClassInvariantMutator> mutators, ClassInvariantFitness fitnessFunction) {
        mutatorManager = new ClassInvariantMutatorManager(mutators);
        this.fitnessFunction = fitnessFunction;
        this.compiler = SpoonManager.getOutput().getCompiler();
    }

    @Override
    public ClassInvariantState initialState() {
        if (initialState != null)
            return initialState;
        return new ClassInvariantState();
    }

    @Override
    public SimulatedAnnealingState nextState(SimulatedAnnealingState state) {
        ClassInvariantState stateClone = ((ClassInvariantState) state).clone();
        ClassInvariantState nextState = (ClassInvariantState) state;
        if (mutatorManager.performRandomMutation(stateClone)) {
            nextState = stateClone;
        }
        return nextState;
    }

    @Override
    public Double evaluate(SimulatedAnnealingState state) {
        ClassInvariantState s = (ClassInvariantState) state;
        fitnessFunction.evaluate(s);
        return s.getFitness();
    }

    @Override
    public boolean isTerminationConditionMet(SimulatedAnnealingState state) {
        return false;
    }

    @Override
    public void printCurrentState(int round, Double temperature, SimulatedAnnealingState currentState) {
        ClassInvariantState s = (ClassInvariantState) currentState;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(round + " | Temperature: " + df.format(temperature) + " | Fitness: " + df.format(s.getFitness()));
    }

    @Override
    public boolean shouldRestart(SimulatedAnnealingState currentState, SimulatedAnnealingState fittest) {
        if (fittest.getFitness() > currentState.getFitness()) {
            roundsWithoutImprovement++;
        } else {
            roundsWithoutImprovement = 0;
        }
        return roundsWithoutImprovement >= MAX_ROUNDS_WITHOUT_IMPROVEMENT;
    }


}
