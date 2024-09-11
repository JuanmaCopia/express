package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.MutatorHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class DeclareVisitedSetMutator implements ClassInvariantMutator {

    CtBlock<?> structureMethodBody;
    CtTypeReference<?> typeOfSet;
    CtLocalVariable<?> mapOfVisitedDeclaration;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(
                p -> p.size() > 1 && !p.getTypeReference().isArray()
        ).toList();
        if (paths.isEmpty())
            return false;

        mapOfVisitedDeclaration = TemplateHelper.getMapOfVisitedDeclaration(state.getCtClass());
        if (mapOfVisitedDeclaration == null) {
            return false;
        }

        Path chosenPath = RandomUtils.getRandomPath(paths);
        typeOfSet = chosenPath.getTypeReference();

        structureMethodBody = MutatorHelper.getMethodByName(state.getCtClass(), LocalVarHelper.STRUCTURE_METHOD_NAME).getBody();
        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(typeOfSet);
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getLocalVariablesMatchingPrefix(structureMethodBody, visitedSetVarName);
        return visitedSetVars.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtVariable<?> setDeclaration = TemplateHelper.createVisitedElementsSet(mapOfVisitedDeclaration, typeOfSet);
        mapOfVisitedDeclaration.insertAfter((CtStatement) setDeclaration);
        //System.err.println("DeclareVisitedSetMutator:\n" + setDeclaration);
    }

}
