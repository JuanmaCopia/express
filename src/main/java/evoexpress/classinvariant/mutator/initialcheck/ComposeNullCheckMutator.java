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

        List<Path> chosenVarReads = SpoonQueries.chooseNPaths(paths, 2);
        CtVariableRead<?> var1 = chosenVarReads.get(0).getVariableRead();
        CtVariableRead<?> var2 = chosenVarReads.get(1).getVariableRead();

        CtExpression<Boolean> clause1 = SpoonFactory.createNullComparisonClause(var1);
        CtExpression<Boolean> clause2 = SpoonFactory.createNullComparisonClause(var2);

        CtExpression<Boolean> condition = SpoonFactory.createBooleanBinaryExpression(clause1, clause2, BinaryOperatorKind.AND);

        if (SpoonQueries.checkAlreadyExist(condition, blockGene))
            return false;

        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition);
        CtStatement comment = SpoonQueries.getReturnTrueComment(blockGene);
        comment.insertBefore(ifStatement);

        //System.err.println("\nAddComposedInitialNullCheckMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
        return true;
    }


}
