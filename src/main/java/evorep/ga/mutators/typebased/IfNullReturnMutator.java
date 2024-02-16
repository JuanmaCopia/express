package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.typesgraph.TypesGraph;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class IfNullReturnMutator implements Mutator {

    public boolean isApplicable(Individual individual, CtCodeElement gene) {
        if (!(gene instanceof CtBlock<?> block) || !(block.getParent() instanceof CtMethod<?>))
            return false;
        TypesGraph typesGraph = SpoonManager.getTypesGraph();
        List<CtField<?>> fields = typesGraph.getOutgoingReferenceFields(typesGraph.getRoot());
        return !fields.isEmpty();
    }

    @Override
    public void mutate(Individual individual, CtCodeElement gene) {
        CtBlock<?> blockGene = (CtBlock<?>) gene;

        TypesGraph typesGraph = SpoonManager.getTypesGraph();
        CtField<?> chosenField = typesGraph.getOutgoingReferenceFields(typesGraph.getRoot()).stream().findAny().get();

        CtIf ifStatement = SpoonFactory.createIfThenStatement(
                (CtExpression<Boolean>) SpoonFactory.createBinaryExpression(chosenField, null, BinaryOperatorKind.EQ),
                SpoonFactory.createReturnStatement(SpoonFactory.createLiteral(RandomUtils.nextBoolean()))
        );

        blockGene.insertBegin(ifStatement);
    }


}
