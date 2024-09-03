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

public class ComposeNullCheckMutator implements ClassInvariantMutator {

    CtExpression<Boolean> condition;
    CtBlock<?> targetMethodBody;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(p -> p.size() == 2).toList();
        if (paths.size() < 2)
            return false;

        List<Path> chosenPaths = SpoonQueries.chooseNPaths(paths, 2);
        Path path1 = chosenPaths.get(0);
        Path path2 = chosenPaths.get(1);

        List<CtExpression<Boolean>> clauses1 = SpoonFactory.generateParentPathNullComparisonClauses(path1);
        clauses1.remove(0);
        clauses1.add(SpoonFactory.createNullComparisonClause(path1.getVariableRead()));

        List<CtExpression<Boolean>> clauses2 = SpoonFactory.generateParentPathNullComparisonClauses(path2);
        clauses2.remove(0);
        clauses2.add(SpoonFactory.createNullComparisonClause(path2.getVariableRead()));

        clauses1.addAll(clauses2);
        condition = SpoonFactory.conjunction(clauses1);
        targetMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        return !SpoonQueries.checkAlreadyExist(condition, targetMethodBody);
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtIf ifStatement = SpoonFactory.createIfReturnFalse(condition, LocalVarHelper.STAGE_1_LABEL);
        selectMutationOption(ifStatement);

        //System.err.println("\nComposeNullCheckMutator:\n" + ifStatement);
        //System.err.println("\nFinal Block:\n\n" + blockGene);
    }

    private void selectMutationOption(CtIf ifStatement) {
        List<CtIf> mutableIfs = MutatorHelper.getMutableIfs(targetMethodBody, LocalVarHelper.STAGE_1_LABEL);
        int option = 1;
        if (!mutableIfs.isEmpty()) {
            option = 2;
        }
        switch (Utils.nextInt(option)) {
            case 0:
                appendEndOfBlock(ifStatement);
                break;
            case 1:
                replaceIfStatement(mutableIfs, ifStatement);
                break;
        }
    }

    private void appendEndOfBlock(CtIf ifStatement) {
        CtStatement separatorLabel = SpoonQueries.getSeparatorLabelComment(targetMethodBody);
        separatorLabel.insertBefore(ifStatement);
        //System.err.println("\nComposeNullCheckMutator appended:\n" + ifStatement);
    }

    private void replaceIfStatement(List<CtIf> mutableIfs, CtIf ifStatement) {
        CtIf chosenIf = Utils.getRandomElement(mutableIfs);
        chosenIf.replace(ifStatement);
        //System.err.println("\nComposeNullCheckMutator replaced:\n" + chosenIf + "\nwith:\n" + ifStatement);
    }


}
