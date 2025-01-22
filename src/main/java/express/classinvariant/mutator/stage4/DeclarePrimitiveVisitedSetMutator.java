package express.classinvariant.mutator.stage4;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class DeclarePrimitiveVisitedSetMutator implements ClassInvariantMutator {

    CtTypeReference<?> typeOfSet;
    CtMethod<?> primitiveMethod;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> numericPaths = SpoonManager.getSubjectTypeData().getNumericPaths().stream().filter(p -> p.size() <= 4).toList();
        if (numericPaths.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(numericPaths);
        typeOfSet = chosenPath.getTypeReference();

        primitiveMethod = TemplateHelper.getPrimitiveMethod(state);
        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(typeOfSet);
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getLocalVariablesMatchingPrefix(primitiveMethod.getBody(), visitedSetVarName);
        if (!visitedSetVars.isEmpty())
            return false;

        return true;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtVariable<?> mapOfVisited = TemplateHelper.getMapOfVisitedParameter(primitiveMethod);

        CtLocalVariable<?> setDeclaration = TemplateHelper.createVisitedElementsSet(mapOfVisited, typeOfSet);
        primitiveMethod.getBody().insertBegin(setDeclaration);

        //System.err.println("DeclareVisitedSetMutator:\n" + setDeclaration);
    }

}
