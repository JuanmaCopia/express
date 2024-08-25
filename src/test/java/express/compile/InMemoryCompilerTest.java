package express.compile;

import express.config.Config;
import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtTypeReference;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryCompilerTest {

    private static Config config;
    private static InMemoryCompiler inMemoryCompiler;

    @BeforeAll
    public static void setUp() {
        config = new Config("./src/main/resources/examples/schedule/schedule.properties");
        SpoonManager.initialize(config);
        inMemoryCompiler = SpoonManager.getInMemoryCompiler();
    }

    @Test
    public void testIMC() {
        String scheduleClassName = config.subjectClassName;
        Class<?> scheduleClass;

        Object returnedValue = null;
        try {
            scheduleClass = inMemoryCompiler.loadClass(scheduleClassName);
            Object instance = scheduleClass.getDeclaredConstructor().newInstance();
            Method testMethod = scheduleClass.getDeclaredMethod("test");
            returnedValue = testMethod.invoke(instance);
        } catch (Exception e) {
            fail("Error invoking method from dynamically compiled class");
        }

        assertNotNull(returnedValue);
        assertEquals("hi", returnedValue.toString());

        List<CtType<?>> types = SpoonManager.getLauncher().getModel().getAllTypes().stream()
                .filter(t -> t.getQualifiedName().equals(scheduleClassName)).toList();

        CtType<?> scheduleOrig = types.get(0);
        CtType<?> scheduleType2 = scheduleOrig.clone();
        scheduleType2.setSimpleName("Schedule2");
        scheduleOrig.getPackage().addType(scheduleType2);

        CtStatement stringStatement = scheduleType2.getMethod("test").getBody().getStatements().get(0);

        Factory factory = SpoonManager.getLauncher().getFactory();
        CtTypeReference<String> stringType = factory.Type().stringType();
        CtLiteral<String> literal = factory.createLiteral();
        literal.setValue("bye");
        CtLocalVariable<?> localVar = SpoonFactory.createLocalVariable("s", stringType, literal);
        stringStatement.replace(localVar);

        boolean modifiedCompiles = inMemoryCompiler.compileSingleClass(scheduleType2.getQualifiedName(),
                SpoonManager.getPrettyPrintedSourceCode(scheduleType2));
        assertTrue(modifiedCompiles);

        returnedValue = null;
        try {
            Class<?> recompiledSchedule = inMemoryCompiler.loadClass(scheduleType2.getQualifiedName());
            Object instance = recompiledSchedule.getDeclaredConstructor().newInstance();
            Method testMethod = recompiledSchedule.getDeclaredMethod("test");
            returnedValue = testMethod.invoke(instance);
        } catch (Exception e) {
            fail("Error invoking method from dynamically modified and compiled class");
        }

        assertNotNull(returnedValue);
        assertEquals("bye", returnedValue.toString());
    }
}