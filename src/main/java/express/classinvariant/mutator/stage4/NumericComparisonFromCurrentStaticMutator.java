package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.ComparisonTemplate;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.List;
import java.util.stream.Collectors;

public class NumericComparisonFromCurrentStaticMutator implements ClassInvariantMutator {

    CtMethod<?> traversal;
    CtBlock<?> traversalBody;
    CtExpression<Boolean> condition;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<CtMethod<?>> traversals = MutatorHelper.getAllTraversalsOfReferenceObjects(state.getCtClass());
        if (traversals.isEmpty())
            return false;

        traversal = RandomUtils.getRandomElement(traversals);
        traversalBody = traversal.getBody();

        CtLocalVariable<?> currentDeclaration = SpoonQueries.getLocalVarMatchingPrefix(traversalBody, LocalVarHelper.CURRENT_VAR_NAME);

        List<Path> candidates = SpoonManager.getSubjectTypeData().getThisTypeGraph()
                .computeSimplePathsForAlternativeVar(currentDeclaration).stream()
                .filter(p -> TypeUtils.isNumericType(p.getTypeReference()) && !p.isEmpty() && p.size() < 3)
                .collect(Collectors.toList());
        if (candidates.isEmpty())
            return false;

        // Get static fields from the class
        CtClass<?> subjectClass = SpoonManager.getSubjectTypeData().getThisCtClass();
        List<CtField<?>> staticFields = subjectClass.getFields().stream().filter(
                f -> f.isStatic() && TypeUtils.isNumericType(f.getType())
        ).collect(Collectors.toList());
        if (staticFields.isEmpty()) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomElement(candidates);
        CtField<?> staticField = RandomUtils.getRandomElement(staticFields);
        CtVariableRead<?> staticFieldRead = SpoonFactory.createStaticFieldRead(subjectClass, staticField);

        condition = ComparisonTemplate.instantiateComparableTemplate(chosenPath, staticFieldRead);

        if (SpoonQueries.checkAlreadyExist(condition, traversalBody))
            return false;
        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);

        List<CtIf> checks = MutatorHelper.getMutableChecksOfTraversalLoop(traversal, LocalVarHelper.STAGE_4_LABEL);
        CtComment insertBeforeLabel = SpoonQueries.getEndOfHandleCurrentComment(traversalBody);
        MutatorHelper.insertOrReplaceCheck(checks, ifStatement, insertBeforeLabel);

        //System.err.println("\nNumericComparisonFromCurrentStaticMutator:\n" + ifStatement);
    }


}
