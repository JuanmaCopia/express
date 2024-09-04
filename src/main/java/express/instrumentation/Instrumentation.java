package express.instrumentation;

import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.type.TypeUtils;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.*;
import spoon.reflect.factory.CodeFactory;

import java.util.List;

public class Instrumentation {

    public static void instrumentTestSuite(CtClass<?> testSuiteClass) {
        testSuiteClass.getMethods().forEach(method -> {
            // Check if the method contains the test annotation
            if (isTestMethod(method)) {
                instrumentMethod(method);
            }
        });
    }

    /**
     * Instrument the given test method by adding a call to the
     * ObjectCollector.collectObject method at the end of the method
     *
     * @param method the test method to instrument
     */
    public static void instrumentMethod(CtMethod<?> method) {
        CodeFactory codeFactory = SpoonFactory.getCodeFactory();
        List<CtVariable<?>> localVariableList = method.getElements(e -> e instanceof CtLocalVariable<?>);
        for (CtVariable<?> variable : localVariableList) {
            if (variable.getType().isSubtypeOf(SpoonManager.getSubjectTypeData().getThisTypeReference())) {
                CtCodeSnippetStatement statement = codeFactory.createCodeSnippetStatement(
                        "collector.ObjectCollector.saveObject(" + variable.getSimpleName() + ")");
                method.getBody().addStatement(statement);
            }
        }
    }

    private static boolean isTestMethod(CtMethod<?> method) {
        for (CtAnnotation<?> annotation : method.getAnnotations()) {
            if (annotation.getName().equals("Test")) {
                return true;
            }
        }
        return false;
    }

    public static void instrumentClasses(CtModel model) {
        for (CtClass<?> clazz : TypeUtils.getAllUserDefinedClassesInModel(model)) {
            setPrivateFieldsAccessible(clazz);
        }
    }

    private static void setPrivateFieldsAccessible(CtClass<?> clazz) {
        clazz.getFields().forEach(f -> {
            ModifierKind visibility = f.getVisibility();
            if (visibility != null && visibility.equals(ModifierKind.PRIVATE)) {
                f.setVisibility(ModifierKind.PROTECTED);
            }
        });
    }

}
