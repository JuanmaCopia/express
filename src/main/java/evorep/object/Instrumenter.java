package evorep.object;

import evorep.spoon.SpoonFactory;
import evorep.spoon.SpoonQueries;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.factory.CodeFactory;

import java.util.List;

/**
 * This class allows to perform the instrumentation of the tests in the test suite
 * @author Facundo Molina <facundo.molina@imdea.org>
 */
public class Instrumenter {

  /**
   * Instrument the given test method by adding a call to the ObjectCollector.collectObject method at the end of the method
   * @param method the test method to instrument
   */
  public static void instrumentMethod(CtMethod<?> method) {
    System.out.println("Instrumenting method: " + method.getSimpleName());
    CodeFactory codeFactory = SpoonFactory.getCodeFactory();
    List<CtVariable<?>> localVariableList = SpoonQueries.getLocalVariablesFromElement(method);
    for (CtVariable<?> variable : localVariableList) {
      if (variable.getType().getSimpleName().equals("SortedList")) {
        CtCodeSnippetStatement statement = codeFactory.createCodeSnippetStatement("evorep.object.ObjectCollector.saveObject(" + variable.getSimpleName() + ")");
        method.getBody().addStatement(statement);
      }
    }
    System.out.println("Method now is:");
    System.out.println(method);
  }

}
