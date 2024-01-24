package evorep.ga;

import java.util.ArrayList;
import java.util.List;

import evorep.spoon.SpoonFactory;
import spoon.reflect.code.CtStatement;

public class Individual {

	private List<CtStatement> chromosome;
	private double fitness = -1;

	/**
	 * Initializes individual with an specific chromosome.
	 * A chromosome is a list of statements.
	 *
	 * @param chromosome
	 *                   The chromosome of the individual
	 */
	public Individual(List<CtStatement> chromosome) {
		this.chromosome = chromosome;
	}

	/**
	 * Initializes an individual with a return true statement
	 */
	public Individual() {
		chromosome = new ArrayList<>();
		chromosome.add(SpoonFactory.createReturnTrueStatement());
	}

	/**
	 * Gets individual's chromosome
	 *
	 * @return The individual's chromosome
	 */
	public List<CtStatement> getChromosome() {
		return this.chromosome;
	}

	/**
	 * Gets individual's chromosome length
	 *
	 * @return The individual's chromosome length
	 */
	public int getChromosomeLength() {
		return chromosome.size();
	}

	/**
	 * Inserts a new gene to the chromosome at offset
	 *
	 * @param gene
	 */
	public void addGene(int offset, CtStatement gene) {
		if (offset == chromosome.size())
			chromosome.add(gene);
		else if (offset < chromosome.size())
			chromosome.add(offset, gene);
		else
			throw new IndexOutOfBoundsException("Offset is out of bounds");
	}

	/**
	 * Set gene at offset
	 *
	 * @param gene
	 * @param offset
	 * @return gene
	 */
	public void setGene(int offset, CtStatement gene) {
		chromosome.set(offset, gene);
	}

	/**
	 * Get gene at offset
	 *
	 * @param offset
	 * @return gene
	 */
	public CtStatement getGene(int offset) {
		return chromosome.get(offset);
	}

	/**
	 * Store individual's fitness
	 *
	 * @param fitness
	 *                The individuals fitness
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	/**
	 * Gets individual's fitness
	 *
	 * @return The individual's fitness
	 */
	public double getFitness() {
		return this.fitness;
	}

	/**
	 * Display the chromosome as a string.
	 *
	 * @return string representation of the chromosome
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (CtStatement statement : chromosome) {
			stringBuilder.append(statement.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	// public List<CtLocalVariable<?>> getLocalVariables() {

	// }
}
