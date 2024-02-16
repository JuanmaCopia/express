package evorep.ga.mutators.typebased;

import evorep.ga.Individual;
import evorep.ga.mutators.Mutator;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeclareWorklistMutatorTests {

    private static final String METHOD_NAME = "m";

    Launcher launcher;
    CtClass<?> sllClass;
    CtMethod<?> method;

    @BeforeEach
    void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "BinTree", 17);
        launcher = SpoonFactory.getLauncher();
        sllClass = SpoonQueries.getClass("BinTree");
        method = sllClass.getMethodsByName(METHOD_NAME).get(0);
    }

    @Test
    void worklistMutatorTest() {
        Mutator mutator = new DeclareWorklistMutator();

        Individual individual = new Individual(method);

        assertTrue(mutator.isApplicable(individual, method.getBody()));

        mutator.mutate(individual, method.getBody());

        assertTrue(SpoonQueries.hasWorklistDeclared(method.getBody()));
        assertFalse(mutator.isApplicable(individual, method.getBody()));
    }

}
