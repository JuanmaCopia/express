package evorep.typesgraph;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;

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
        TypesGraph graph = TypesGraphFactory.createTypesGraph(targetClass);
        List<CtType<?>> adj = graph.getAdjacentNodes(targetClass);
        assertEquals(1, adj.size());
        CtType<?> adjNode = adj.get(0);
        assertEquals("Node", adjNode.getSimpleName());

        List<CtType<?>> adjOfNode = graph.getAdjacentNodes(adjNode);
        assertEquals(1, adjOfNode.size());
        adjNode = adjOfNode.get(0);
        assertEquals("Node", adjNode.getSimpleName());
    }
}
