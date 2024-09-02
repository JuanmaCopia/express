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

public class IfNullReturnMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> targetMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(p -> p.size() > 1 && p.size() < 4).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = Utils.getRandomPath(paths);

        condition = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath);
        targetMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.INITIAL_METHOD_NAME).getBody();
        return !SpoonQueries.checkAlreadyExist(condition, targetMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement returnTrueComment = SpoonQueries.getReturnTrueComment(targetMethodBody);
        returnTrueComment.insertBefore(ifStatement);

        /*System.err.println("\nAddIfNullReturnMutator:\n" + ifStatement);
        System.err.println("\nFinal Block:\n\n" + methodBody);*/
    }


}
