package evoexpress.ga.mutator;

import evoexpress.ga.individual.Individual;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.TypeUtils;
import evoexpress.type.typegraph.Path;
import evoexpress.type.typegraph.TypeGraph;
import spoon.reflect.code.*;
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

        CtVariable<?> setVar = SpoonQueries.searchVisitedSetInBlock(blockGene, chosenNode);
        if (setVar == null) {
            setVar = SpoonFactory.createVisitedSetDeclaration(chosenNode, blockGene);
            blockGene.insertBegin((CtStatement) setVar);
        }

        CtTypeReference<?> setSubType = setVar.getType().getActualTypeArguments().get(0);

        List<Path> candidates = SpoonManager.inputTypeData.getAllReferencePathsOfType(setSubType, 1).stream().filter(p -> p.depth() >= 1).toList();
        if (candidates.isEmpty())
            return false;

        Path chosenPath = candidates.get(RandomUtils.nextInt(candidates.size()));
        CtVariableRead<?> chosenVarRead = chosenPath.getVariableRead();

        CtExpression<Boolean> nullComparisonClause = SpoonFactory.createNullComparisonClause(chosenVarRead, BinaryOperatorKind.NE);
        CtExpression<Boolean> addToSetInvocation = SpoonFactory.createAddToSetInvocation(setVar, chosenVarRead);
        if (RandomUtils.nextBoolean())
            addToSetInvocation = SpoonFactory.negateExpresion(addToSetInvocation);
        
        CtExpression<Boolean> conjunction = SpoonFactory.createBooleanBinaryExpression(
                nullComparisonClause,
                addToSetInvocation,
                BinaryOperatorKind.AND
        );

        if (SpoonQueries.checkAlreadyExist(conjunction, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(conjunction);

        CtStatement returnTrueComment = SpoonQueries.getReturnTrueComment(blockGene);
        returnTrueComment.insertBefore(ifStatement);

        //System.err.println("DeclareVisitedSetMutator:\n" + setVar);
        //System.err.println("Final Block:\n" + blockGene);
        return true;
    }


}
