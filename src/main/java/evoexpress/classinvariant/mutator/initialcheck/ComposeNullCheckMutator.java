package evoexpress.classinvariant.mutator.initialcheck;

import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;

import java.util.List;

public class ComposeNullCheckMutator implements ClassInvariantMutator {


    public boolean isApplicable(ClassInvariantState state) {
        return SpoonManager.getTypeData().getReferencePaths().stream().filter(p -> p.size() == 2).count() >= 2;
    }

    @Override
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> blockGene = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.INITIAL_METHOD_NAME).getBody();
        List<Path> paths = SpoonManager.getTypeData().getReferencePaths().stream().filter(p -> p.size() == 2).toList();

        List<Path> chosenPaths = SpoonQueries.chooseNPaths(paths, 2);
        Path path1 = chosenPaths.get(0);
        Path path2 = chosenPaths.get(1);

        List<CtExpression<Boolean>> clauses = SpoonFactory.generateParentPathNullComparisonClauses(path1);
        clauses.add(SpoonFactory.createNullComparisonClause(path1.getVariableRead()));
        clauses.addAll(SpoonFactory.generateParentPathNullComparisonClauses(path2));
        clauses.add(SpoonFactory.createNullComparisonClause(path2.getVariableRead()));

        CtExpression<Boolean> condition = SpoonFactory.conjunction(clauses);
        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getReturnTrueComment(blockGene);
        comment.insertBefore(ifStatement);

        //System.err.println("\nComposeNullCheckMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
