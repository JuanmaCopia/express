package express.classinvariant.mutator.primitivecheck;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonQueries;
import spoon.reflect.code.*;

import java.util.List;

public class RemoveSizeCheckMutator implements ClassInvariantMutator {

    public boolean isApplicable(ClassInvariantState state) {
        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        CtStatement sizeCheckComment = SpoonQueries.getSizeCheckComment(methodBody);
        if (sizeCheckComment == null)
            return false;

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
//        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
//
//        CtStatement sizeCheckComment = SpoonQueries.getSizeCheckComment(methodBody);
//        List<CtStatement> statements = methodBody.getStatements();
//
//        int index = statements.indexOf(sizeCheckComment);
//        if (index == -1 || index == statements.size() - 1) {
//            throw new RuntimeException("The current statement is not found");
//        }
//
//        CtStatement sizeCheckStatement = statements.get(index + 1);
//        sizeCheckStatement.delete();
//        sizeCheckComment.delete();

    }


}
