package express.classinvariant.mutator.initialcheck;

import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.classinvariant.mutator.ClassInvariantMutator;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import express.util.Utils;
import spoon.reflect.code.*;

import java.util.List;

public class IfNullReturnMutator implements ClassInvariantMutator {

    CtBlock<?> targetMethodBody;
    CtExpression<Boolean> condition;

    public boolean isApplicable(ClassInvariantState state) {
        targetMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.INITIAL_METHOD_NAME).getBody();

        List<Path> paths = SpoonManager.getTypeData().getReferencePaths().stream().filter(p -> p.size() > 1 && p.size() < 4).toList();
        Path chosenPath = Utils.getRandomPath(paths);

        condition = SpoonFactory.generateAndConcatenationOfNullComparisons(chosenPath);
        if (SpoonQueries.checkAlreadyExist(condition, targetMethodBody))
            return false;

        return true;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement returnTrueComment = SpoonQueries.getReturnTrueComment(targetMethodBody);
        returnTrueComment.insertBefore(ifStatement);

        /*System.err.println("\nAddIfNullReturnMutator:\n" + ifStatement);
        System.err.println("\nFinal Block:\n\n" + methodBody);*/
        return true;
    }


}
