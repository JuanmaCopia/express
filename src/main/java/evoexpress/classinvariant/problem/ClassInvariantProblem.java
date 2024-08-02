package evoexpress.classinvariant.problem;

import evoexpress.classinvariant.mutator.ClassInvariantMutatorManager;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.fitness.ClassInvariantFitness;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.output.Compiler;
import evoexpress.search.simulatedannealing.problem.SimulatedAnnealingProblem;
import evoexpress.search.simulatedannealing.state.SimulatedAnnealingState;
import evoexpress.spoon.SpoonManager;

import java.text.DecimalFormat;
import java.util.Set;

public class ClassInvariantProblem implements SimulatedAnnealingProblem {

    ClassInvariantMutatorManager mutatorManager;
    ClassInvariantFitness fitnessFunction;
    ClassInvariantState initialState;
    Compiler compiler;

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
        return initialState == null ? new ClassInvariantState() : initialState;
    }

    @Override
    public SimulatedAnnealingState nextState(SimulatedAnnealingState state) {
        ClassInvariantState stateClone = ((ClassInvariantState) state).clone();
        compiler.addClassToPackage(stateClone.getCtClass());
        boolean wasMutated = mutatorManager.performRandomMutation(stateClone);
        ClassInvariantState nextState;
        if (wasMutated && compiles(stateClone)) {
            stateClone.setFitnessAsOutdated();
            nextState = stateClone;
        } else {
            nextState = (ClassInvariantState) state;
        }
        compiler.removeClassFromPackage(stateClone.getCtClass());
        return nextState;
    }

    private boolean compiles(ClassInvariantState nextState) {
        try {
            return compiler.compileModel();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Double evaluate(SimulatedAnnealingState state) {
        ClassInvariantState s = (ClassInvariantState) state;
        if (s.isFitnessUpdated())
            return s.getFitness();

        compiler.addClassToPackage(s.getCtClass());
        double fitness = fitnessFunction.evaluate(s);
        s.setFitness(fitness);
        compiler.removeClassFromPackage(s.getCtClass());
        return fitness;
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


}
