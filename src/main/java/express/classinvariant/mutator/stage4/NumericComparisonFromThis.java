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
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;

import java.util.List;
import java.util.stream.Collectors;

public class NumericComparisonFromThis implements ClassInvariantMutator {

    CtBlock<?> targetMethodBody;
    CtExpression<Boolean> condition;

    @Override
    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getSimplePaths().stream().filter(
                p -> TypeUtils.isNumericType(p.getTypeReference()) && p.size() < 3
        ).collect(Collectors.toList());
        if (paths.size() < 2)
            return false;

        Path path1 = RandomUtils.getRandomElement(paths);
        paths.remove(path1);
        Path path2 = RandomUtils.getRandomElement(paths);

        condition = ComparisonTemplate.instantiateComparableTemplate(path1, path2);

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
