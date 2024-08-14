package express.classinvariant.mutator.structurecheck.traversal.init;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.type.TypeUtils;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class ChangeFirstElementMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        return !traversals.isEmpty();
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        CtMethod<?> traversal = traversals.get(RandomUtils.nextInt(traversals.size()));

        List<CtStatement> firstElements = traversal.getElements(
                e -> e instanceof CtLocalVariable<?> var &&
                        var.getSimpleName().equals(LocalVarHelper.FIRST_ELEMENT_VAR_NAME)
        );
        if (firstElements.isEmpty()) {
            return false;
        }
        CtLocalVariable<?> firstElement = (CtLocalVariable<?>) firstElements.get(0);

        List<CtParameter<?>> params = traversal.getParameters();
        CtVariable<?> parentOfFirstElement = params.get(params.size() - 2);

        CtVariableRead<?> firstElemRead = (CtVariableRead<?>) firstElement.getAssignment();
        CtTypeReference<?> typeOfFirstElem = firstElemRead.getType();

        String[] fields = firstElemRead.toString().split("\\.");
        String fieldName = fields[fields.length - 1];

        List<CtVariable<?>> candidateFields = TypeUtils.getFields(parentOfFirstElement.getType()).stream().filter(
                field -> field.getType().equals(typeOfFirstElem) && !field.getSimpleName().equals(fieldName)
        ).toList();
        if (candidateFields.isEmpty()) {
            return false;
        }

        CtVariable<?> chosenField = candidateFields.get(RandomUtils.nextInt(candidateFields.size()));

        CtFieldRead newFirstElementRead = SpoonFactory.createFieldRead(parentOfFirstElement, chosenField);
        firstElement.setAssignment(newFirstElementRead);

        //System.err.println("ChangeTraverseInitialFieldMutator: " + chosenField.getSimpleName() + " instead of " + fieldName);
        //System.err.println("Result: \n" + chosenTraversal);

        return true;
    }


}
