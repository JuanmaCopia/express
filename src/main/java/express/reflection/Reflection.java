package express.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Reflection {


    /**
     * Load the class with the given qualified name
     *
     * @param classLoader        the class loader
     * @param qualifiedClassName the qualified name of the class
     * @return the class
     */
    public static Class<?> loadClass(URLClassLoader classLoader, String qualifiedClassName) {
        Class<?> aClass = null;
        try {
            aClass = classLoader.loadClass(qualifiedClassName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return aClass;
    }

    /**
     * Load the method with the given name from the given class
     *
     * @param clazz      the class
     * @param methodName the name of the method
     * @return the method
     */
    public static Method loadMethod(Class<?> clazz, String methodName) {
        try {
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                if (m.getName().equals(methodName))
                    return m;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Get the list of runnable tests in the given test class
     * A test method is runnable if it is annotated with @Test.
     *
     * @param testClass the test class
     * @return the list of methods corresponding to runnable tests
     */
    public static List<Method> getRunnableTests(Class<?> testClass) {
        // Use reflection to find all the JUnit tests in the class
        ArrayList<Method> testMethods = new ArrayList<>();
        for (Method method : testClass.getDeclaredMethods()) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation.annotationType().getSimpleName().equals("Test")) {
                    testMethods.add(method);
                }
            }
        }
        testMethods.sort(Comparator.comparing(Method::getName));
        return testMethods;
    }

}
