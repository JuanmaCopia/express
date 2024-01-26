import evorep.ga.mutators.codegenerators.LocalVarDeclarationGenerator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalVarGeneratorTests {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "Node";
    final static String METHOD_NAME = "m";

    static SpoonAPI launcher;

    static CtClass<?> nodeClass;
    static CtMethod<?> method;
    static List<CtVariable<?>> fields;
    static List<CtVariable<?>> localVars;
    static List<CtVariable<?>> allVars;

    static Set<String> possibleVarDeclarations;

    private static void initializeVarDeclarations() {
        if (possibleVarDeclarations == null) {
            possibleVarDeclarations = new HashSet<>();
            possibleVarDeclarations.add("Node myVar = next");
            possibleVarDeclarations.add("Node myVar = next.next");
        }
    }


    private static void initializeASTElements() {
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass(CLASS_NAME);
        method = nodeClass.getMethodsByName(METHOD_NAME).get(0);
        fields = SpoonQueries.getFields(nodeClass);
        localVars = SpoonQueries.getLocalVariables(method);
        allVars = new ArrayList<>();
        allVars.addAll(fields);
        allVars.addAll(localVars);
    }

    private static void initializeSpoon() {
        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME);
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
            CtStatement varDecl = LocalVarDeclarationGenerator.generateUserDefinedLocalVarDeclaration(fields, "myVar");
            varDeclarations.add(varDecl.toString());
        }
        assertTrue(varDeclarations.containsAll(possibleVarDeclarations));
    }

}
