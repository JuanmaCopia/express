package evorep.ga;

import evorep.ga.mutators.MutatorManager;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.processors.MultipleReferenceTraversalProcessor;
import evorep.spoon.typesgraph.TypeGraph;
import evorep.util.Utils;
import spoon.processing.Processor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The GeneticAlgorithm class is our main abstraction for managing the
 * operations of the genetic algorithm. This class is meant to be
 * problem-specific, meaning that (for instance) the "calcFitness" method may
 * need to change from problem to problem.
 * <p>
 * This class concerns itself mostly with population-level operations, but also
 * problem-specific operations such as calculating fitness, testing for
 * termination criteria, and managing mutation and crossover operations (which
 * generally need to be problem-specific as well).
 * <p>
 * Generally, GeneticAlgorithm might be better suited as an abstract class or an
 * interface, rather than a concrete class as below. A GeneticAlgorithm
 * interface would require implementation of methods such as
 * "isTerminationConditionMet", "calcFitness", "mutatePopulation", etc, and a
 * concrete class would be defined to solve a particular problem domain. For
 * instance, the concrete class "TravelingSalesmanGeneticAlgorithm" would
 * implement the "GeneticAlgorithm" interface. This is not the approach we've
 * chosen, however, so that we can keep each chapter's examples as simple and
 * concrete as possible.
 *
 * @author bkanber
 */
public class GeneticAlgorithm {

    public static final int MIN_POPULATION_SIZE = 1;

    private final int maxPopulationSize;
    /**
     * Mutation rate is the fractional probability than an individual gene will
     * mutate randomly in a given generation. The range is 0.0-1.0, but is
     * generally small (on the order of 0.1 or less).
     */
    private final double mutationRate;
    /**
     * Crossover rate is the fractional probability that two individuals will
     * "mate" with each other, sharing genetic information, and creating
     * offspring with traits of each of the parents. Like mutation rate the
     * rance is 0.0-1.0 but small.
     */
    private final double crossoverRate;
    /**
     * Elitism is the concept that the strongest members of the population
     * should be preserved from generation to generation. If an individual is
     * one of the elite, it will not be mutated or crossover.
     */
    private final int elitismCount;

    public GeneticAlgorithm(int maxPopulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.maxPopulationSize = maxPopulationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;

    }

    /**
     * Initialize population
     *
     * @param repOK The repOK method
     * @return population The initial population generated
     */
    public Population initPopulation(CtMethod repOK) {
        return new Population(this.maxPopulationSize, repOK);
    }

    public Population initPopulationBasedOnTypeGraph(CtMethod repOK) {
        Population population = new Population();

        TypeGraph typesGraph = SpoonManager.getTypeGraph();
        Set<CtTypeReference<?>> nodesWithCycles = typesGraph.getNodesWithSelfCycles();
        for (CtTypeReference<?> node : nodesWithCycles) {
            List<CtField<?>> cyclicFields = typesGraph.getSelfCyclicFieldsOfNode(node);
            List<List<CtField<?>>> simplePaths = typesGraph.getSimplePaths(typesGraph.getRoot(), node);
            for (List<CtField<?>> path : simplePaths) {
                CtVariableRead<?> initialField = SpoonFactory.createFieldRead(path);
                List<List<CtField<?>>> allCominations = new LinkedList<>();
                for (int i = 1; i <= cyclicFields.size(); i++) {
                    allCominations.addAll(Utils.generateCombinations(cyclicFields, i));
                }
                for (List<CtField<?>> combination : allCominations) {
                    Individual individual = new Individual(repOK);
                    CtBlock<?> repOKBody = individual.getChromosome().getBody();
                    Processor<CtBlock<?>> p = new MultipleReferenceTraversalProcessor(initialField, combination);
                    p.process(repOKBody);
                    population.addIndividual(individual);
                }
            }
        }

        if (population.size() < maxPopulationSize) {
            int remaining = maxPopulationSize - population.size();
            for (int i = 0; i < remaining; i++) {
                Individual individual = new Individual(repOK);
                population.addIndividual(individual);
            }
        }

        return population;
    }

    public void evalPopulation(Population population) {
        population.getIndividuals().stream().filter(Individual::needsFitnessUpdate).forEach(FitnessFunctions::invalidInstancesFitness);
    }

    /**
     * Check if population has met termination condition
     *
     * @param population
     * @return boolean True if termination condition met, otherwise, false
     */
    public boolean isTerminationConditionMet(Population population) {
        return population.getFittest().getFitness() == 0.0;
    }

    /**
     * Apply mutation to population
     *
     * @param population The population to apply mutation to
     * @return The mutated population
     */
    public Population mutatePopulation(Population population) {
        Population newPopulation = new Population();

        int i = 0;
        for (Individual individual : population.getIndividuals()) {
            if (i < elitismCount) {
                Individual mutant = mutateIndividual(individual);
                newPopulation.addIndividual(individual);
                newPopulation.addIndividual(mutant);
            } else if (Math.random() < mutationRate && individual.getFitness() > FitnessFunctions.WORST_FITNESS_VALUE) {
                Individual mutant = mutateIndividual(individual);
                newPopulation.addIndividual(mutant);
            } else {
                newPopulation.addIndividual(individual);
            }
            i++;
        }

        return newPopulation;
    }

    private Individual mutateIndividual(Individual individual) {
        Individual mutant = MutatorManager.mutate(individual);
        mutant.setFitnessAsOutdated();
        return mutant;
    }


    public Population selectFittest(Population population) {
        Population survivors = new Population();
        int i = 0;
        while (i < maxPopulationSize && population.size() > 0) {
            Individual fittest = population.removeFittest();
            if (survivors.size() < MIN_POPULATION_SIZE)
                survivors.addIndividual(fittest);
            else if (fittest.getFitness() > FitnessFunctions.WORST_FITNESS_VALUE)
                survivors.addIndividual(fittest);
            i++;
        }
        return survivors;
    }


}
