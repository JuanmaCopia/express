package express.classinvariant.mutator.stage1;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;

import java.util.List;

public class SingleNullComparisonMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> targetMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(p -> p.size() > 1 && p.size() < 4).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomPath(paths);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(chosenPath);
        clauses.remove(0);
        clauses.add(SpoonFactory.createNullComparisonClause(chosenPath.getVariableRead()));
        condition = SpoonFactory.conjunction(clauses);

        targetMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        return !SpoonQueries.checkAlreadyExist(condition, targetMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_1_LABEL);
        CtStatement insertBeforeLabel = SpoonQueries.getSeparatorLabelComment(targetMethodBody);
        MutatorHelper.selectMutationOption(ifStatement, targetMethodBody, insertBeforeLabel, LocalVarHelper.STAGE_1_LABEL);

        //System.err.println("\nFinal Block:\n\n" + targetMethodBody);
    }

}
