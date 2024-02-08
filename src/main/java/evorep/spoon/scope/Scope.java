package evorep.spoon.scope;

import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtVariable;

import java.util.LinkedList;
import java.util.List;

public class Scope {

    private List<CtVariable<?>> allVariables;
    private List<CtVariable<?>> fields;
    private List<CtVariable<?>> localVariables;

    public Scope(CtCodeElement element) {
        allVariables = SpoonQueries.getAllReachableVariables(element);
        fields = allVariables.stream().filter(var -> var instanceof CtField<?>).toList();
        localVariables = allVariables.stream().filter(var -> var instanceof CtLocalVariable<?>).toList();
    }

    public List<CtVariable<?>> getAllVariables() {
        return new LinkedList(allVariables);
    }

    public List<CtVariable<?>> getFields() {
        return new LinkedList(fields);
    }

    public List<CtVariable<?>> getLocalVariables() {
        return new LinkedList(localVariables);
    }

    public String toString() {
        return "Scope{" +
                "allVariables=" + allVariables +
                ", fields=" + fields +
                ", localVariables=" + localVariables +
                '}';
    }
}
