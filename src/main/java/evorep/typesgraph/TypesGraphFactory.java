package evorep.typesgraph;

import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TypesGraphFactory {

    public static TypesGraph createTypesGraph(CtTypeReference rootType) {
        TypesGraph graph = new TypesGraph();

        Set<CtTypeReference> visited = new HashSet<>();
        visited.add(rootType);
        LinkedList<CtTypeReference> workList = new LinkedList<>();
        workList.add(rootType);

        while (!workList.isEmpty()) {
            CtTypeReference currentType = workList.removeFirst();
            graph.addNode(currentType);

            CtType<?> declaration = currentType.getDeclaration();
            if (declaration == null)
                continue; // Type is not declared in the current project
            
            List<CtField<?>> fields = declaration.getFields();
            for (CtField<?> field : fields) {
                CtTypeReference fieldType = field.getType();
                if (fieldType != null) {
                    graph.addEdge(currentType, fieldType, field);
                    if (visited.add(fieldType))
                        workList.add(fieldType);
                }
            }

        }
        return graph;
    }
}
