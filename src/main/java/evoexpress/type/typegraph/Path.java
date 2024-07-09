package evoexpress.type.typegraph;

import evoexpress.spoon.SpoonFactory;
import evoexpress.type.TypeUtils;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.LinkedList;
import java.util.List;

public class Path {

    LinkedList<CtVariable<?>> fields;

    public Path(CtVariable<?> root, List<CtVariable<?>> fields) {
        this.fields = new LinkedList<>(fields);
        this.fields.addFirst(root);
    }

    public Path(List<CtVariable<?>> fields) {
        this.fields = new LinkedList<>(fields);
    }

    public LinkedList<CtVariable<?>> getFieldChain() {
        return new LinkedList<>(fields);
    }

    public CtTypeReference<?> getTypeReference() {
        return getLast().getType();
    }

    public int depth() {
        return fields.size() - 1;
    }

    public boolean isPrimitiveOrBoxedPrimitive() {
        return TypeUtils.isPrimitiveOrBoxedPrimitiveType(getTypeReference());
    }

    public CtVariable<?> getLast() {
        return fields.get(fields.size() - 1);
    }

    public void setLast(CtVariable<?> newLast) {
        fields.set(fields.size() - 1, newLast);
    }

    public CtVariable<?> get(int i) {
        return fields.get(i);
    }

    public CtVariableRead<?> getVariableRead() {
        return SpoonFactory.createFieldRead(fields);
    }

    public CtVariableRead<?> getVariableReadOwner() {
        assert fields.size() > 1;
        return SpoonFactory.createFieldRead(new LinkedList(fields.subList(0, fields.size() - 1)));
    }

    public Path getParentPath() {
        assert fields.size() > 1;
        return new Path(new LinkedList<>(fields.subList(0, fields.size() - 1)));
    }

    public Path clone() {
        return new Path(new LinkedList<>(fields));
    }

    public String toString() {
        return getVariableRead().toString();
    }
}
