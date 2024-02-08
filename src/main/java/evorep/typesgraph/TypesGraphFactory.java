package evorep.typesgraph;

import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TypesGraphFactory {

    public static TypesGraph createTypesGraph(CtType rootClass) {
        TypesGraph graph = new TypesGraph();

        Set<CtType> visited = new HashSet<>();
        visited.add(rootClass);
        LinkedList<CtType> workList = new LinkedList<>();
        workList.add(rootClass);

        while (!workList.isEmpty()) {
            CtType currentType = workList.removeFirst();
            graph.addNode(currentType);

            List<CtField<?>> fields = currentType.getFields();
            for (CtField<?> field : fields) {
                CtType fieldType = field.getType().getDeclaration();
                if (fieldType != null) {
                    graph.addEdge(currentType, fieldType);
                    if (visited.add(fieldType))
                        workList.add(fieldType);
                }
            }

        }
        return graph;
    }
}
