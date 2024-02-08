package evorep.spoon.typesgraph;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypesGraphTest {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "SLL";
    static SpoonAPI launcher;

    static CtClass<?> targetClass;

    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        targetClass = SpoonQueries.getClass(CLASS_NAME);
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
        launcher = SpoonFactory.getLauncher();
    }

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
    }

    @Test
    void createTypeGraphTest() {
        CtTypeReference<?> rootType = targetClass.getReference();
        TypesGraph graph = TypesGraphFactory.createTypesGraph(rootType);

        List<TypesGraph.Edge> adjOfSLL = graph.getAdjacentNodes(rootType);
        assertEquals(2, adjOfSLL.size());

        TypesGraph.Edge headEdge = adjOfSLL.get(0);
        CtTypeReference<?> nodeType = headEdge.getDestination();
        CtField<?> headField = headEdge.getLabel();
        assertEquals("Node", nodeType.getSimpleName());
        assertEquals("head", headField.getSimpleName());

        TypesGraph.Edge sizeEdge = adjOfSLL.get(1);
        CtTypeReference<?> intType = sizeEdge.getDestination();
        CtField<?> sizeField = sizeEdge.getLabel();
        assertEquals("int", intType.getSimpleName());
        assertEquals("size", sizeField.getSimpleName());

        List<TypesGraph.Edge> adjOfNode = graph.getAdjacentNodes(nodeType);
        assertEquals(2, adjOfNode.size());

        TypesGraph.Edge dataEdge = adjOfNode.get(0);
        CtTypeReference<?> dataType = dataEdge.getDestination();
        CtField<?> dataField = dataEdge.getLabel();
        assertEquals("int", dataType.getSimpleName());
        assertEquals("data", dataField.getSimpleName());

        TypesGraph.Edge nextEdge = adjOfNode.get(1);
        CtTypeReference<?> nextType = nextEdge.getDestination();
        CtField<?> nextField = nextEdge.getLabel();
        assertEquals("Node", nextType.getSimpleName());
        assertEquals("next", nextField.getSimpleName());
    }
}
