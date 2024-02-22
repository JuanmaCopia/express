package evorep.ga.mutators.typebased;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeEach;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

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

}
