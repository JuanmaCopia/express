import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonManager;
import evorep.spoon.SpoonQueries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpoonQueriesTests {

    SpoonAPI launcher;
    CtClass<?> nodeClass;

    @BeforeEach
    void setUp() {
        SpoonManager.initialize("./src/test/resources", "./target/class-test", "Node");
        launcher = SpoonFactory.getLauncher();
        nodeClass = SpoonQueries.getClass("Node");
    }

    @Test
    void getFieldsTest() {
        List<CtVariable<?>> fields = SpoonQueries.getFields(nodeClass);
        assertEquals(2, fields.size());
    }

    @Test
    void getVariablesOfReferenceTypeTest() {
        List<CtVariable<?>> refFields = SpoonQueries.getVariablesOfReferenceType(SpoonQueries.getFields(nodeClass));
        assertEquals(1, refFields.size());
    }
}
