package evorep.instrumentation;

import evorep.object.Instrumenter;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

public class Instrumentation {

    public static void instrumentTestSuite(CtClass<?> testSuiteClass) {
        testSuiteClass.getMethods().forEach(method -> {
            // Check if the method contains the test annotation
            if (isTestMethod(method)) {
                Instrumenter.instrumentMethod(method);
            }
        });
    }

    private static boolean isTestMethod(CtMethod<?> method) {
        for (CtAnnotation<?> annotation : method.getAnnotations()) {
            if (annotation.getName().equals("Test")) {
                return true;
            }
        }
        return false;
    }

}
