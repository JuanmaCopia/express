package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.ga.mutators.typebased.TypeGraphCycleBasedMutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonHelper;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MutatorManager {

    private static Set<Mutator> mutators = new HashSet<>();

    private static Set<Mutator> initPopulationMutators = new HashSet<>();

    public static void initialize() {
        mutators = new HashSet<>();
        mutators.add(new BlockMutator());
        mutators.add(new VariableReadMutator());
        mutators.add(new VariableWriteMutator());
        mutators.add(new UnaryOperatorMutator());
        mutators.add(new BinaryOperatorMutator());
        mutators.add(new ExpressionMutator());
        mutators.add(new DeclareVarRootBlockMutator());

        initPopulationMutators.add(new TypeGraphCycleBasedMutator());
    }

    private static CtCodeElement selectGene(Individual individual) {
        List<CtCodeElement> mutableCodeElements = filterMutableCodeElements(individual.getChromosome());
        if (mutableCodeElements.isEmpty())
            throw new RuntimeException("No mutable code elements found in the chromosome");
        return mutableCodeElements.get(RandomUtils.nextInt(mutableCodeElements.size()));
    }

    private static List<CtCodeElement> filterMutableCodeElements(CtElement element) {
        return element.getElements(e -> isMutableCodeElement(e));
    }

    private static boolean isMutableCodeElement(CtCodeElement element) {
        for (Mutator mutator : mutators)
            if (mutator.isApplicable(element))
                return true;
        return false;
    }

    private static Mutator selectMutator(Set<Mutator> candidateMutators, CtCodeElement gene) {
        List<Mutator> possibleMutators = candidateMutators.stream().filter(mutator -> mutator.isApplicable(gene)).toList();
        if (possibleMutators.isEmpty())
            return null;
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

    public static Individual mutate(Individual individual) {
        Individual mutant = individual.clone();
        Scope scope = SpoonHelper.getScope(mutant);
        CtCodeElement gene = selectGene(mutant);
        Mutator mutator = selectMutator(mutators, gene);
        if (mutator != null) {
            CtCodeElement mutatedGene = mutator.mutate(gene, scope);
            gene.replace(mutatedGene);
        }
        return mutant;
    }

    public static Individual initialMutation(Individual individual) {
        Individual mutant = individual.clone();
        Scope scope = SpoonHelper.getScope(mutant);
        CtBlock<?> gene = mutant.getChromosome().getBody();
        Mutator mutator = selectMutator(initPopulationMutators, gene);
        if (mutator != null) {
            CtCodeElement mutatedGene = mutator.mutate(mutant.getChromosome().getBody(), scope);
            gene.replace(mutatedGene);
        }
        return mutant;
    }

}
