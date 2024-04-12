package evorep.instrumentation;

import evorep.config.ToolConfig;
import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.*;
import spoon.reflect.factory.CodeFactory;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.List;
import java.util.Set;

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
     * Instrument the given test method by adding a call to the ObjectCollector.collectObject method at the end of the method
     *
     * @param method the test method to instrument
     */
    public static void instrumentMethod(CtMethod<?> method) {
        CodeFactory codeFactory = SpoonFactory.getCodeFactory();
        List<CtVariable<?>> localVariableList = SpoonQueries.getLocalVariablesFromElement(method);
        for (CtVariable<?> variable : localVariableList) {
            if (variable.getType().getQualifiedName().equals(ToolConfig.subjectClassName)) {
                CtCodeSnippetStatement statement = codeFactory.createCodeSnippetStatement("evorep.object.ObjectCollector.saveObject(" + variable.getSimpleName() + ")");
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
        List<CtClass<?>> classes = model.getRootPackage().getElements(new TypeFilter<>(CtClass.class));
        for (CtClass<?> clazz : classes) {
            addEmptyConstructor(clazz);
        }
    }

    private static void addEmptyConstructor(CtClass clazz) {
        CtConstructor constructor = getEmptyConstructor(clazz);
        CtBlock<?> body = null;
        if (constructor != null) {
            body = constructor.getBody();
            clazz.removeConstructor(constructor);
        }
        if (body == null) {
            body = SpoonFactory.getCoreFactory().createBlock();
        }
        constructor = SpoonFactory.getCoreFactory().createConstructor();
        constructor.setBody(body);
        constructor.setModifiers(Set.of(ModifierKind.PUBLIC));
        clazz.addConstructor(constructor);
    }

    private static CtConstructor<?> getEmptyConstructor(CtClass<?> clazz) {
        return clazz.getConstructors().stream().filter(c -> c.getParameters().isEmpty()).findFirst().orElse(null);
    }


}
