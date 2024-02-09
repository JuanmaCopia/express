package evorep.ga.mutators;

import evorep.ga.Individual;
import evorep.spoon.scope.Scope;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonHelper;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MutatorManager {

    private static Set<Mutator> mutators = new HashSet<>();

    public static void initialize() {
        mutators = new HashSet<>();
        mutators.add(new BlockMutator());
        mutators.add(new VariableReadMutator());
        mutators.add(new VariableWriteMutator());
        mutators.add(new UnaryOperatorMutator());
        mutators.add(new BinaryOperatorMutator());
        mutators.add(new ExpressionMutator());
        mutators.add(new DeclareVarRootBlockMutator());
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

    private static Mutator selectMutator(CtCodeElement element) {
        List<Mutator> possibleMutators = mutators.stream().filter(mutator -> mutator.isApplicable(element)).toList();
        return possibleMutators.get(RandomUtils.nextInt(possibleMutators.size()));
    }

    public static Individual mutate(Individual individual) {
        Individual mutant = individual.clone();

        Scope scope = SpoonHelper.getScope(mutant);
        //System.err.println("Scope: " + scope.toString());

        CtCodeElement gene = selectGene(mutant);
        Mutator mutator = selectMutator(gene);

/*        System.out.println("\nOriginal: \n" + individual.getChromosome().toString());
        System.out.println("\nSelected gene: \n" + gene.toString());
        System.out.println("\nRole of gene: \n" + gene.getRoleInParent().toString());
        System.out.println("\nMutator applied: " + mutator.getClass().getSimpleName() + "\n");*/

        CtCodeElement mutatedGene = mutator.mutate(gene, scope);
        //System.out.println("\nMutated gene: \n" + mutatedGene.toString());

        gene.replace(mutatedGene);


        //System.out.println("\nMutant: \n" + mutant.getChromosome().toString());

        return mutant;
    }

}
