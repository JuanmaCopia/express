package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class ChangeTraversalRootElement implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtLocalVariable rootElement;
    Path chosenPath;

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty()) {
            return false;
        }

        traversal = Utils.getRandomElement(traversals);
        rootElement = SpoonQueries.getLocalVarMatchingPrefix(traversal.getBody(), LocalVarHelper.TRAVERSAL_ROOT_VAR_NAME);

        CtExpression rootElementAssignment = rootElement.getDefaultExpression();
        CtTypeReference<?> rootElementType = rootElementAssignment.getType();

        CtVariable<?> subjectVar = SpoonQueries.getTraversedElementParameter(traversal);
        List<Path> candidates = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(subjectVar).stream()
                .filter(p ->
                        !p.toString().equals(rootElementAssignment.toString()) &&
                                p.getTypeReference().isSubtypeOf(rootElementType) &&
                                p.size() > 1 &&
                                TypeUtils.hasOnlyOneCyclicField(p)
                ).toList();
        if (candidates.isEmpty()) {
            return false;
        }

        chosenPath = Utils.getRandomPath(candidates);

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtExpression<Boolean> nullCheckCondition = SpoonFactory.generateOrConcatenationOfNullComparisons(chosenPath);
        CtIf newNullCheck = SpoonFactory.createIfReturnTrue(nullCheckCondition);

        CtIf oldNullCheck = MutatorHelper.getFirstIf(traversal.getBody());

        /*System.err.println("\nChangeTraversalRootElement: BEFORE\n");
        System.err.println(oldNullCheck);
        System.err.println(rootElement);*/

        oldNullCheck.replace(newNullCheck);
        rootElement.setDefaultExpression(chosenPath.getVariableRead());

        /*System.err.println("\nChangeTraversalRootElement: AFTER\n");
        System.err.println(newNullCheck);
        System.err.println(rootElement);*/
    }

}
