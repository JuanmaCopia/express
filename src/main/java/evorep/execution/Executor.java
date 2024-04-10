package evorep.execution;

import evorep.ga.Individual;
import evorep.reflection.Reflection;

import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.List;
import java.util.concurrent.*;

public class Executor {

    public static int runPrecondition(Individual individual, Method precondition, Object[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Boolean> task = () -> {
            return (boolean) precondition.invoke(null, args);
        };

        boolean result = false;
        try {
            // Submit the task to the executor and get a Future object
            Future<Boolean> future = executor.submit(task);
            // Set a timeout for the task
            result = future.get(300, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            // Handle timeout exception
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            if (individual.marked) {
                System.err.println("\nError running precondition:\n");
                e.printStackTrace();
            }
            // Handle other exceptions
            //System.err.println("\nError running precondition:\n\n" + individual.toString());
            //e.printStackTrace();
            //System.err.println("\nThe individual was:\n\n" + individual.toString());
            return -1;
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
        if (result)
            return 1;
        return 0;
    }

    public static void runTestSuite(String testSuiteFullyQualifiedName, URLClassLoader classLoader) {
        try {
            Class<?> testClass = classLoader.loadClass(testSuiteFullyQualifiedName);
            List<Method> testMethods = Reflection.getRunnableTests(testClass);
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            int testsExecuted = 0;
            int errors = 0;
            for (Method testMethod : testMethods) {
                // Run the test method and let the instrumentation collect the created objects
                try {
                    Object result = testMethod.invoke(testObject);
                    testsExecuted++;
                } catch (Exception e) {
                    System.err.println("error running test " + testMethod.getName() + ": " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
