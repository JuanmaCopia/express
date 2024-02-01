package evorep.scope;

import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.visitor.chain.CtQuery;

import java.util.List;

public class Scope {

    CtQuery allVariables;
    CtQuery fields;
    CtQuery localVariables;

    public Scope(CtElement element) {
        this.allVariables = SpoonQueries.getAllReachableVariables(element);
        this.fields = allVariables.filterChildren(var -> var instanceof CtField<?>);
        this.localVariables = allVariables.filterChildren(var -> var instanceof CtLocalVariable<?>);
    }

    public List<CtVariable<?>> getAllVariables() {
        return allVariables.list();
    }

    public List<CtVariable<?>> getFields() {
        return fields.list();
    }

    public List<CtVariable<?>> getLocalVariables() {
        return localVariables.list();
    }
}
