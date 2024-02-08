package evorep.spoon.generators;

import evorep.spoon.scope.Scope;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalVarGeneratorTests {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "Node";
    final static String METHOD_NAME = "m";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static Scope scope;

    static Set<String> possibleVarDeclarations;

    static Set<String> possibleColVarDecl;

    private static void initializeVarDeclarations() {
        if (possibleVarDeclarations == null) {
            possibleVarDeclarations = new HashSet<>();
            possibleVarDeclarations.add("Node myVar = next");
            possibleVarDeclarations.add("Node myVar = next.next");
        }
        if (possibleColVarDecl == null) {
            possibleColVarDecl = new HashSet<>();
            possibleColVarDecl.add("HashSet<Node> visited = new HashSet<Node>()");
            possibleColVarDecl.add("LinkedList<Node> worklist = new LinkedList<Node>()");
        }
    }


    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass(CLASS_NAME);
        method = nodeClass.getMethodsByName(METHOD_NAME).get(0);
        scope = new Scope(method.getBody().getLastStatement());
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
        launcher = SpoonFactory.getLauncher();
    }

    @BeforeAll
    static void setUp() {
        initializeSpoon();
        initializeASTElements();
        initializeVarDeclarations();
    }

    @Test
    void varDeclarationGeneratorTest() {
        Set<String> varDeclarations = new HashSet<>();
        while (varDeclarations.size() < 2) {
            CtStatement varDecl = LocalVarDeclarationGenerator.generateUserDefinedLocalVarDeclaration(scope.getFields(), "myVar");
            varDeclarations.add(varDecl.toString());
        }
        assertTrue(varDeclarations.containsAll(possibleVarDeclarations));
    }

    @Test
    void collectionVarDeclarationGeneratorTest() {
        Set<String> varDeclarations = new HashSet<>();
        while (varDeclarations.size() < 2) {
            CtStatement varDecl = LocalVarDeclarationGenerator.generateCollectionLocalVarDeclaration(scope.getFields());
            varDeclarations.add(varDecl.toString());
        }
        assertTrue(varDeclarations.containsAll(possibleColVarDecl));
    }

}
