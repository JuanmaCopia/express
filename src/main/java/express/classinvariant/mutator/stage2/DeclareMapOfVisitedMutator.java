package express.classinvariant.mutator.stage2;

import express.classinvariant.mutator.ClassInvariantMutator;
import express.classinvariant.mutator.template.TemplateHelper;
import express.classinvariant.state.ClassInvariantState;
import express.spoon.SpoonQueries;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;

public class DeclareMapOfVisitedMutator implements ClassInvariantMutator {


    @Override
    public boolean isApplicable(ClassInvariantState state) {
        return TemplateHelper.getMapOfVisitedDeclaration(state.getCtClass()) == null;
    }

    @Override
    public void mutate(ClassInvariantState state) {
        CtLocalVariable<?> mapOfVisitedDeclaration = TemplateHelper.createMapOfVisitedDeclaration();

        CtBlock<?> structureMethodBody = TemplateHelper.getStructureMethodBody(state);
        CtStatement separatorLabel = SpoonQueries.getSeparatorLabelComment(structureMethodBody);
        separatorLabel.insertAfter(mapOfVisitedDeclaration);

        //System.err.println("DeclareMapOfVisitedMutator:" + mapOfVisitedDeclaration);
    }

}
