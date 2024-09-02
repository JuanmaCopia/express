package express.classinvariant.mutator.stage1;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;

import java.util.List;

public class ComposeNullCheckMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> initialCheckBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(p -> p.size() == 2).toList();
        if (paths.size() < 2)
            return false;

        List<Path> chosenPaths = SpoonQueries.chooseNPaths(paths, 2);
        Path path1 = chosenPaths.get(0);
        Path path2 = chosenPaths.get(1);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(path1);
        clauses.add(SpoonFactory.createNullComparisonClause(path1.getVariableRead()));
        clauses.addAll(SpoonFactory.generateParentPathNullComparisonClauses(path2));
        clauses.add(SpoonFactory.createNullComparisonClause(path2.getVariableRead()));

        condition = SpoonFactory.conjunction(clauses);
        initialCheckBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.INITIAL_METHOD_NAME).getBody();
        return !SpoonQueries.checkAlreadyExist(condition, initialCheckBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getReturnTrueComment(initialCheckBody);
        comment.insertBefore(ifStatement);

        //System.err.println("\nComposeNullCheckMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }


}
