package express.classinvariant.mutator.stage3;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.LocalVarHelper;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.RandomUtils;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.typegraph.Path;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class DeclareVisitedSetMutator implements ClassInvariantMutator {

    CtTypeReference<?> typeOfSet;

    public boolean isApplicable(ClassInvariantState state) {
        List<Path> paths = SpoonManager.getSubjectTypeData().getReferencePaths().stream().filter(
                p -> p.size() > 1 && !p.getTypeReference().isArray()
        ).toList();
        if (paths.isEmpty())
            return false;

        Path chosenPath = RandomUtils.getRandomPath(paths);
        typeOfSet = chosenPath.getTypeReference();


        String visitedSetVarName = LocalVarHelper.getVisitedSetVarName(typeOfSet);
        List<CtLocalVariable<?>> visitedSetVars = SpoonQueries.getLocalVariablesMatchingPrefix(TemplateHelper.getStructureMethod(state).getBody(), visitedSetVarName);
        return visitedSetVars.isEmpty();
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtMethod<?> structureMethod = TemplateHelper.getStructureMethod(state);
        CtVariable<?> mapOfVisited = TemplateHelper.getMapOfVisitedParameter(structureMethod);

        CtVariable<?> setDeclaration = TemplateHelper.createVisitedElementsSet(mapOfVisited, typeOfSet);
        CtStatement separatorLabel = SpoonQueries.getSeparatorLabelComment(structureMethod.getBody());
        separatorLabel.insertAfter((CtStatement) setDeclaration);
        //System.err.println("DeclareVisitedSetMutator:\n" + setDeclaration);
    }

}
