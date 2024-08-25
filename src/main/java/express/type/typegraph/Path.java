package express.type.typegraph;

import express.spoon.SpoonFactory;
import express.type.TypeUtils;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Path {

    LinkedList<CtVariable<?>> fields;

    public Path() {
        this.fields = new LinkedList<>();
    }

    public Path(CtVariable<?> firstVariable) {
        this.fields = new LinkedList<>();
        this.fields.add(firstVariable);
    }

    public Path(List<CtVariable<?>> fields) {
        this.fields = new LinkedList<>(fields);
    }

    public Path(CtVariable<?> root, Path path) {
        this.fields = new LinkedList<>(path.fields);
        this.fields.addFirst(root);
    }

    public Path(CtVariable<?> root, List<CtVariable<?>> fields) {
        this.fields = new LinkedList<>(fields);
        this.fields.addFirst(root);
    }

    public LinkedList<CtVariable<?>> getFieldChain() {
        return new LinkedList<>(fields);
    }

    public CtTypeReference<?> getTypeReference() {
        return getLast().getType();
    }

    public boolean isPrimitiveOrBoxedPrimitive() {
        return TypeUtils.isPrimitiveOrBoxedPrimitiveType(getTypeReference());
    }

    public boolean isSimple() {
        Set<CtVariable<?>> visited = new HashSet<>();
        for (CtVariable<?> field : fields) {
            if (!visited.add(field)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return fields.isEmpty();
    }

    public int size() {
        return fields.size();
    }

    public Pair<Path, Path> split(int index) {
        if (index < 0 || index >= fields.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return Pair.of(new Path(new LinkedList<>(fields.subList(0, index))),
                new Path(new LinkedList<>(fields.subList(index, fields.size()))));
    }

    public Pair<Path, Path> splitByType(CtTypeReference<?> type) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getType().getQualifiedName().equals(type.getQualifiedName())) {
                return split(i + 1);
            }
        }
        throw new IllegalArgumentException("Type not found in path");
    }

    public Path subPath(int start, int end) {
        if (start < 0 || start >= fields.size() || end < 0 || end >= fields.size() || start > end) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return new Path(fields.subList(start, end));
    }

    public Path subPath(int end) {
        return subPath(0, end);
    }

    public void add(CtVariable<?> newFirst) {
        fields.add(newFirst);
    }

    public CtVariable<?> removeLast() {
        return fields.removeLast();
    }

    public boolean contains(CtVariable<?> field) {
        return fields.contains(field);
    }

    public CtVariable<?> getLast() {
        return fields.get(fields.size() - 1);
    }

    public void setLast(CtVariable<?> newLast) {
        fields.set(fields.size() - 1, newLast);
    }

    public CtVariable<?> get(int i) {
        if (i < 0 || i >= fields.size())
            throw new IllegalArgumentException("Index out of bounds");
        return fields.get(i);
    }

    public void set(int i, CtVariable<?> newField) {
        if (i < 0 || i >= fields.size())
            throw new IllegalArgumentException("Index out of bounds");
        fields.set(i, newField);
    }

    public CtVariableRead<?> getVariableRead() {
        return SpoonFactory.createFieldRead(fields);
    }

    public CtVariableRead<?> getVariableReadOwner() {
        if (fields.size() <= 1)
            throw new IllegalArgumentException("Path has no owner");
        return SpoonFactory.createFieldRead(new LinkedList(fields.subList(0, fields.size() - 1)));
    }

    public Path getParentPath() {
        if (fields.size() <= 1)
            throw new IllegalArgumentException("Path has no parent");
        return new Path(new LinkedList<>(fields.subList(0, fields.size() - 1)));
    }

    public Path clone() {
        return new Path(fields);
    }

    public String toString() {
        if (fields.isEmpty()) {
            return "<EMPTY PATH>";
        }
        StringBuilder sb = new StringBuilder();
        for (CtVariable<?> field : fields) {
            sb.append(field.getSimpleName()).append(".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public int indexOf(CtVariable<?> field) {
        return fields.indexOf(field);
    }
}
