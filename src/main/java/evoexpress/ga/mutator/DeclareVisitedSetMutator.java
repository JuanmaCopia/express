package evoexpress.ga.mutator;

import evoexpress.ga.individual.Individual;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class DeclareVisitedSetMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?> m) || !m.getSimpleName().startsWith("structureCheck"))
            return false;

        return true;
    }

    @Override
    public boolean mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;


        List<CtVariable<?>> refParams = SpoonManager.inputTypeData.getParameters().stream().filter(p -> TypeUtils.isReferenceType(p.getType())).toList();
        CtVariable<?> chosenParameter = refParams.get(RandomUtils.nextInt(refParams.size()));
        TypeGraph typeGraph = SpoonManager.inputTypeData.getTypeGraphOfParameter(chosenParameter);
        List<CtTypeReference<?>> nodesWithAliasing = typeGraph.getRefNodesWithAliasing();
        CtTypeReference<?> chosenNode = nodesWithAliasing.get(RandomUtils.nextInt(nodesWithAliasing.size()));

        if (SpoonQueries.searchVisitedSetInBlock(blockGene, chosenNode) != null)
            return false;


        CtVariable<?> setVar = SpoonFactory.createVisitedSetDeclaration(chosenNode, blockGene);
        blockGene.insertBegin((CtStatement) setVar);

        System.err.println("DeclareVisitedSetMutator:\n" + setVar);
        //System.err.println("Final Block:\n" + blockGene);
        return true;
    }


}
