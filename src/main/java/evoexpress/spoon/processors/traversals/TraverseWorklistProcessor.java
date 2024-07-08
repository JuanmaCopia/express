package evoexpress.spoon.processors.traversals;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.spoon.template.WorklistTraversal;
import evoexpress.type.typegraph.Path;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class TraverseWorklistProcessor extends AbstractProcessor<CtClass<?>> {

    List<CtVariable<?>> loopFields;
    Path initialField;
    boolean useBreakInsteadOfReturn;

    public TraverseWorklistProcessor(Path initialField, List<CtVariable<?>> loopFields, boolean useBreakInsteadOfReturn) {
        super();
        this.loopFields = loopFields;
        this.initialField = initialField;
        this.useBreakInsteadOfReturn = useBreakInsteadOfReturn;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethod.getBody());

        CtVariable<?> setVar = handleVisitedSetVariable(structureMethodBody, lastStatement);

        List<CtParameter<?>> parameters = SpoonManager.inputTypeData.getInputs();
        parameters.add(SpoonFactory.createParameter(initialField.getParentPath().getTypeReference(), "parentOfTraversable"));
        parameters.add(SpoonFactory.createParameter(setVar.getType(), setVar.getSimpleName()));

        CtMethod<?> traversalMethod = WorklistTraversal.obtainTraversalMethod(ctClass, initialField, parameters, loopFields, useBreakInsteadOfReturn);

        CtExpression<?>[] args = createArguments(parameters, setVar);
        CtInvocation<Boolean> traversalCall = (CtInvocation<Boolean>) SpoonFactory.createStaticInvocation(traversalMethod, args);

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(SpoonFactory.negateExpresion(traversalCall));
        lastStatement.insertBefore(ifStatement);
    }

    private CtExpression<?>[] createArguments(List<CtParameter<?>> params, CtVariable<?> visitedSetVar) {

        CtExpression<?>[] args = new CtExpression[params.size()];
        args[0] = SpoonFactory.createVariableRead(params.get(0));
        args[1] = initialField.getParentPath().getVariableRead();
        args[2] = SpoonFactory.createVariableRead(visitedSetVar);
        return args;
    }

    private CtVariable<?> handleVisitedSetVariable(CtBlock<?> methodBody, CtStatement lastStatement) {
        CtTypeReference<?> cyclicNode = initialField.getTypeReference();
        List<CtLocalVariable<?>> setVars = SpoonQueries.getVisitedSetLocalVarsOfType(methodBody, cyclicNode);
        CtVariable<?> setVar = null;
        if (setVars.isEmpty()) {
            setVar = SpoonFactory.createVisitedSetDeclaration(cyclicNode, methodBody);
            lastStatement.insertBefore((CtStatement) setVar);
            return setVar;
        }
        return setVars.get(RandomUtils.nextInt(setVars.size()));
    }

}