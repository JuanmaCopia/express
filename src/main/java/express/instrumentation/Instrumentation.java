package express.instrumentation;

import java.util.List;
import java.util.Set;

import express.spoon.SpoonFactory;
import express.spoon.SpoonManager;
import express.spoon.SpoonQueries;
import express.type.TypeUtils;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.factory.CodeFactory;
import spoon.reflect.visitor.filter.TypeFilter;

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
        List<CtVariable<?>> localVariableList = SpoonQueries.getLocalVariablesFromElement(method);
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
        List<CtClass<?>> classes = model.getRootPackage().getElements(new TypeFilter<>(CtClass.class));
        for (CtClass<?> clazz : classes) {
            addEmptyConstructor(clazz);
            setPrivateFieldsAccessible(clazz);
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

    private static void setPrivateFieldsAccessible(CtClass<?> clazz) {
        clazz.getFields().forEach(f -> f.setVisibility(ModifierKind.PUBLIC));
    }

    private static CtConstructor<?> getEmptyConstructor(CtClass<?> clazz) {
        return clazz.getConstructors().stream().filter(c -> c.getParameters().isEmpty()).findFirst().orElse(null);
    }

}
