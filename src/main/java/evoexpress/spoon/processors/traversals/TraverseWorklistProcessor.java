package evoexpress.spoon.processors.traversals;

import evoexpress.ga.helper.LocalVarHelper;
import evoexpress.ga.mutator.template.WorklistTraversalTemplate;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
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
    boolean useParent;

    public TraverseWorklistProcessor(Path initialField, List<CtVariable<?>> loopFields, boolean useBreakInsteadOfReturn, boolean useParent) {
        super();
        this.loopFields = loopFields;
        this.initialField = initialField;
        this.useBreakInsteadOfReturn = useBreakInsteadOfReturn;
        this.useParent = useParent;
    }

    @Override
    public void process(CtClass<?> ctClass) {
        CtMethod<?> structureMethod = ctClass.getMethodsByName(LocalVarHelper.STRUCTURE_METHOD_NAME).get(0);
        CtBlock<?> structureMethodBody = structureMethod.getBody();
        CtStatement lastStatement = SpoonQueries.getMark1Comment(structureMethod.getBody());

        CtVariable<?> setVar = handleVisitedSetVariable(structureMethodBody, lastStatement);

        List<CtParameter<?>> parameters = SpoonManager.inputTypeData.getInputs();
        if (useParent) {
            parameters.add(SpoonFactory.createParameter(initialField.getParentPath().getTypeReference(), LocalVarHelper.PARENT_OF_ELEMENT_PARAM));
        } else {
            parameters.add(SpoonFactory.createParameter(initialField.getTypeReference(), LocalVarHelper.FIRST_ELEMENT_VAR_NAME));
        }
        parameters.add(SpoonFactory.createParameter(setVar.getType(), setVar.getSimpleName()));

        CtMethod<?> traversalMethod = WorklistTraversalTemplate.createTraversalMethod(ctClass, initialField, parameters, loopFields, useBreakInsteadOfReturn, useParent);
        ctClass.addMethod(traversalMethod);
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