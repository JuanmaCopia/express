package evorep.spoon.generators;

import evorep.spoon.RandomUtils;
import evorep.spoon.SpoonFactory;
import evorep.spoon.scope.Scope;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collection;
import java.util.List;

public class MethodCallGenerator {

    public static CtInvocation generateAddToCollectionMethodCall(Scope scope) {
        CtVariable<?> collection = RandomUtils.getRandomElementOfType(scope.getLocalVariables(), Collection.class);
        return generateCollectionMethodCallExpression(collection, "add", scope.getAllVariables());
    }

    public static CtInvocation generateCollectionMethodCallExpression(
            CtVariable<?> collection,
            String methodName,
            List<CtVariable<?>> scopeVariables
    ) {
        // The type of the argument of the method call is the type of the elements of the collection
        CtTypeReference<?> argType = collection.getReference().getType().getActualTypeArguments().get(0);

        CtExpression<?> argument = (CtExpression<?>) ReferenceExpressionGenerator.generateRandomVarReadOfType(
                scopeVariables, argType);
        return SpoonFactory.createInvocation(collection, methodName, argType, argument);

    }

    public static CtExpression<Boolean> generateRandomCollectionMethodCallExpression(Scope scope) {
        CtVariable<?> collection = RandomUtils.getRandomElementOfType(scope.getLocalVariables(), Collection.class);
        return generateCollectionMethodCallExpression(collection, "add", scope.getAllVariables());
    }
}
