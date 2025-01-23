package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.ComparisonTemplate;
import express.classinvariant.mutator.template.TemplateHelper;
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

import java.util.List;
import java.util.stream.Collectors;

public class NumericComparisonFromThisStatic implements ClassInvariantMutator {

    CtBlock<?> targetMethodBody;
    CtExpression<Boolean> condition;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getSimplePaths().stream().filter(
                p -> TypeUtils.isNumericType(p.getTypeReference()) && p.size() < 3
        ).collect(Collectors.toList());
        if (paths.isEmpty())
            return false;

        Path path1 = RandomUtils.getRandomElement(paths);

        // Get static fields from the class
        CtClass<?> subjectClass = SpoonManager.getSubjectTypeData().getThisCtClass();
        List<CtField<?>> staticFields = subjectClass.getFields().stream().filter(
                f -> f.isStatic() && TypeUtils.isNumericType(f.getType())
        ).collect(Collectors.toList());
        if (staticFields.isEmpty())
            return false;

        CtField<?> staticField = RandomUtils.getRandomElement(staticFields);

        // Obtain the variableRead of the static field
        CtVariableRead<?> staticFieldRead = SpoonFactory.createStaticFieldRead(subjectClass, staticField);

        condition = ComparisonTemplate.instantiateComparableTemplate(path1, staticFieldRead, RandomUtils.nextBoolean());

        targetMethodBody = TemplateHelper.getPrimitiveMethod(state).getBody();
        return !SpoonQueries.checkAlreadyExistSimple(condition, targetMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_4_LABEL);
        CtStatement insertBeforeLabel = SpoonQueries.getSeparatorLabelComment(targetMethodBody);
        MutatorHelper.selectMutationOption(ifStatement, targetMethodBody, insertBeforeLabel, LocalVarHelper.STAGE_4_LABEL);

        //System.err.println("\nPrimitiveComparisonToCurrentMutator:\n" + ifStatement);
    }


}
