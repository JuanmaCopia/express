package express.type.typegraph;

import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.Objects;

public class GraphNode {
    CtVariable<?> field;
    CtTypeReference<?> type;

    public GraphNode(CtVariable<?> field, CtTypeReference<?> type) {
        this.field = field;
        this.type = type;
    }

    public CtVariable<?> getField() {
        return field;
    }

    public CtTypeReference<?> getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GraphNode node = (GraphNode) o;
        return field.equals(node.field) && type.getQualifiedName().equals(node.type.getQualifiedName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, type);
    }

    @Override
    public String toString() {
        return "(" + field.getSimpleName() + "} " + type.getSimpleName();
    }

}
