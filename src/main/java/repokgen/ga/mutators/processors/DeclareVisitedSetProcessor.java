package repokgen.ga.mutators.processors;

import java.util.HashSet;
import java.util.Set;

import repokgen.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.reference.CtTypeReference;

public class DeclareVisitedSetProcessor extends AbstractProcessor<CtBlock<?>> {

    CtTypeReference<?> setSubtype;

    CtLocalVariable<?> declaredVariable;

    public DeclareVisitedSetProcessor(CtTypeReference<?> setSubtype) {
        this.setSubtype = setSubtype;
    }

    @Override
    public void process(CtBlock<?> ctBlock) {
        CtTypeReference<?> setType = SpoonFactory.createTypeWithSubtypeReference(Set.class, setSubtype);
        CtTypeReference<?> hashSetType = SpoonFactory.createTypeWithSubtypeReference(HashSet.class, setSubtype);

        CtConstructorCall<?> hashSetConstructorCall = SpoonFactory.createConstructorCall(hashSetType);
        declaredVariable = SpoonFactory.createLocalVariable("visited", setType, hashSetConstructorCall);

        ctBlock.insertBegin(declaredVariable);
    }

    public CtLocalVariable<?> getDeclaredVariable() {
        return declaredVariable;
    }

}
