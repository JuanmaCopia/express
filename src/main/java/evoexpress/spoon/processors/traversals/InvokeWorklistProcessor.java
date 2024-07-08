package evoexpress.spoon.processors.traversals;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class InvokeWorklistProcessor extends AbstractProcessor<CtClass<?>> {

    Path initialField;
    CtMethod<?> traversal;

    public InvokeWorklistProcessor(Path initialField, CtMethod<?> traversal) {
        super();
        this.initialField = initialField;
        this.traversal = traversal;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();

        CtVariable<?> setVar = handleVisitedSetVariable(structureMethodBody);

//        List<CtParameter<?>> parameters = SpoonManager.inputTypeData.getInputs();
//        parameters.add(SpoonFactory.createParameter(initialField.getParentPath().getTypeReference(), "parentOfTraversable"));
//        parameters.add(SpoonFactory.createParameter(setVar.getType(), setVar.getSimpleName()));
//
//        CtMethod<?> traversalMethod = WorklistTraversal.obtainTraversalMethod(ctClass, initialField, parameters, loopFields, useBreakInsteadOfReturn);

        CtExpression<?>[] args = createArguments(traversal.getParameters(), setVar);
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversal, args);
        
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(SpoonFactory.negateExpresion(traversalCall));
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethod.getBody());
        lastStatement.insertBefore(ifStatement);
    }

    private CtExpression<?>[] createArguments(List<CtParameter<?>> params, CtVariable<?> visitedSetVar) {

        CtExpression<?>[] args = new CtExpression[params.size()];
        args[0] = SpoonFactory.createVariableRead(params.get(0));
        args[1] = initialField.getParentPath().getVariableRead();
        args[2] = SpoonFactory.createVariableRead(visitedSetVar);
        return args;
    }

    private CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody) {
        CtTypeReference<?> cyclicNode = initialField.getTypeReference();
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, cyclicNode);
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }

}