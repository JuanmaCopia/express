package evoexpress.classinvariant.mutator.primitivecheck;

import evoexpress.classinvariant.mutator.ClassInvariantMutator;
import evoexpress.classinvariant.mutator.LocalVarHelper;
import evoexpress.classinvariant.mutator.MutatorHelper;
import evoexpress.classinvariant.state.ClassInvariantState;
import evoexpress.spoon.RandomUtils;
import evoexpress.spoon.SpoonFactory;
import evoexpress.spoon.SpoonManager;
import evoexpress.spoon.SpoonQueries;
import evoexpress.type.typegraph.Path;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

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
    public boolean mutate(ClassInvariantState state) {
        CtBlock<?> methodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();

        CtStatement sizeCheckComment = SpoonQueries.getSizeCheckComment(methodBody);
        List<CtStatement> statements = methodBody.getStatements();

        int index = statements.indexOf(sizeCheckComment);
        if (index == -1 || index == statements.size() - 1) {
            throw new RuntimeException("The current statement is not found");
        }

        CtStatement sizeCheckStatement = statements.get(index + 1);
        sizeCheckStatement.delete();
        sizeCheckComment.delete();

        return true;
    }


}
