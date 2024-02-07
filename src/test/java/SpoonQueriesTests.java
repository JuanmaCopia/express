import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpoonQueriesTests {

    String METHOD_NAME = "m";

    SpoonAPI launcher;
    CtClass<?> sllClass;
    CtMethod<?> method;

    @BeforeEach
    void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "SLL", 17);
        launcher = SpoonFactory.getLauncher();
        sllClass = SpoonQueries.getClass("SLL");
        method = sllClass.getMethodsByName(METHOD_NAME).get(0);
    }

    @Test
    void getFieldsTest() {
        List<CtVariable<?>> fields = SpoonQueries.getFields(sllClass);
        assertEquals(2, fields.size());
    }

    @Test
    void getVariablesOfReferenceTypeTest() {
        List<CtVariable<?>> refFields = SpoonQueries.getVariablesOfReferenceType(SpoonQueries.getFields(sllClass));
        assertEquals(1, refFields.size());
    }

    @Test
    void getAllVariablesTest() {
        List<CtVariable<?>> vars = SpoonQueries.getAllReachableVariablesFromMethod(method);
        assertEquals(3, vars.size());
    }
}
