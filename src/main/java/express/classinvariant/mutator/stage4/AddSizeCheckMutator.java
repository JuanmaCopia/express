package express.classinvariant.mutator.stage4;

import java.util.List;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class AddSizeCheckMutator implements ClassInvariantMutator {

    CtBlock<?> methodBody;
    CtExpression<Boolean> condition;

    CtLocalVariable<?> setDeclaration;
    boolean mustDeclareSet = false;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<Path> integerFields = SpoonManager.getSubjectTypeData().getIntegerPaths();
        if (integerFields.isEmpty())
            return false;

        List<CtMethod<?>> traversals = MutatorHelper.getMethodsByName(state.getCtClass(), LocalVarHelper.TRAVERSAL_PREFIX);
        if (traversals.isEmpty())
            return false;

        methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.PRIMITIVE_METHOD_NAME).getBody();

        CtMethod<?> traversal = RandomUtils.getRandomElement(traversals);

        // Get first parameter of traversal
        CtVariable<?> traversedElement = traversal.getParameters().get(0);

        // Get type of traversedElement
        CtTypeReference<?> traversedElementType = traversedElement.getType();

        // obtain set if declared
        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(traversedElementType);
        List<CtLocalVariable<?>> visitedSetList = SpoonQueries.getLocalVariablesMatchingPrefix(methodBody, visitedSetVarName);

        if (visitedSetList.isEmpty()) {
            // Declare visited set
            CtMethod<?> primitiveMethod = TemplateHelper.getPrimitiveMethod(state);
            CtVariable<?> mapOfVisited = TemplateHelper.getMapOfVisitedParameter(primitiveMethod);
            setDeclaration = TemplateHelper.createVisitedElementsSet(mapOfVisited, traversedElementType);
            mustDeclareSet = true;
        } else {
            setDeclaration = visitedSetList.get(0);
            mustDeclareSet = false;
        }

        Path choseIntegerPath = RandomUtils.getRandomPath(integerFields);
        CtVariableRead<?> pathRead = choseIntegerPath.getVariableRead();

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(choseIntegerPath);
        clauses.remove(0);
        clauses.add(createSizeCheckCondition(setDeclaration, pathRead));
        condition = SpoonFactory.conjunction(clauses);

        return !SpoonQueries.checkAlreadyExistSimple(condition, methodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        if (mustDeclareSet) {
            methodBody.insertBegin(setDeclaration);
        }

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        CtStatement lastStatement = SpoonQueries.getReturnTrueLabel(methodBody);
        lastStatement.insertBefore(ifStatement);

        // System.err.println("\nAddSizeCheckMutator:\n" + ifStatement);
        // System.err.println("body: \n" + methodBody);
    }

    public CtExpression<Boolean> createSizeCheckCondition(CtVariable<?> setVariable, CtExpression<?> integerField) {
        CtInvocation<?> sizeInvocation = SpoonFactory.createInvocation(setVariable, "size");
        CtExpression<?> sizeMinus = sizeInvocation;

        int minus = RandomUtils.nextInt(0, 3);
        if (minus > 0)
            sizeMinus = SpoonFactory.createBinaryExpression(sizeInvocation, minus, BinaryOperatorKind.MINUS);

        return SpoonFactory.createBinaryExpression(sizeMinus, integerField, BinaryOperatorKind.NE);
    }

}
