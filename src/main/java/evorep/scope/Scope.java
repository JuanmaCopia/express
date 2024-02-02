package evorep.scope;

import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

public class Scope {

    List<CtVariable<?>> allVariables;
    List<CtVariable<?>> fields;
    List<CtVariable<?>> localVariables;

    public Scope(CtCodeElement element) {
        allVariables = SpoonQueries.getAllReachableVariables(element);
        fields = allVariables.stream().filter(var -> var instanceof CtField<?>).toList();
        localVariables = allVariables.stream().filter(var -> var instanceof CtLocalVariable<?>).toList();
    }

    public List<CtVariable<?>> getAllVariables() {
        return allVariables;
    }

    public List<CtVariable<?>> getFields() {
        return fields;
    }

    public List<CtVariable<?>> getLocalVariables() {
        return localVariables;
    }
}
