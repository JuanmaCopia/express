package evoexpress.ga.helper;

import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

public class LocalVarHelper {

    public static final String INITIAL_METHOD_NAME = "initialCheck";
    public static final String STRUCTURE_METHOD_NAME = "structureCheck";
    public static final String PRIMITIVE_METHOD_NAME = "primitiveCheck";

    public static final String LOCAL_VAR_PREFIX = "var_";
    public static final String SET_VAR_NAME = "visited_";
    public static final String WORKLIST_VAR_NAME = "worklist_";
    public static final String CURRENT_VAR_NAME = "current_";
    public static final String TRAVERSAL_PREFIX = "traverse_";
    public static final String TRAVERSAL_ARRAY_PREFIX = "traverseArray_";
    public static final String SIZE_VAR_NAME = "initialSize_";
    public static final String FIRST_ELEMENT_VAR_NAME = "firstElement_";
    public static final String PARENT_OF_ELEMENT_PARAM = "parentOfElement_";


    public static String getVarName(CtBlock<?> code) {
        return LOCAL_VAR_PREFIX + getNextId(code, LOCAL_VAR_PREFIX);
    }

    public static int getNextTraversalId(CtClass<?> ctClass) {
        List<String> traversalMethodNames = ctClass.getMethods().stream()
                .map(CtMethod::getSimpleName)
                .filter(name -> name.startsWith(TRAVERSAL_PREFIX))
                .toList();
        return traversalMethodNames.size();
    }

    public static int getNextId(CtBlock<?> code, String varPrefix) {
        List<CtLocalVariable<?>> vars = code.getElements(var -> var.getSimpleName().startsWith(varPrefix));
        return vars.size();
    }

    public static String getCurrentVarName(CtBlock<?> code) {
        return CURRENT_VAR_NAME + getNextId(code, CURRENT_VAR_NAME);
    }

    public static String getVisitedSetVarName(CtBlock<?> code) {
        return SET_VAR_NAME + getNextId(code, SET_VAR_NAME);
    }

    public static String getWorklistVarName(CtBlock<?> code) {
        return WORKLIST_VAR_NAME + getNextId(code, WORKLIST_VAR_NAME);
    }

    public static String getTraversalMethodName() {
        return TRAVERSAL_PREFIX;
    }

//    public static String getTraversalMethodName(CtClass<?> ctClass) {
//        return TRAVERSAL_ARRAY_PREFIX + getNextTraversalId(ctClass);
//    }
//
//
//    public static String getTraversalArrayMethodName(CtClass<?> ctClass) {
//        return TRAVERSAL_ARRAY_PREFIX + getNextTraversalId(ctClass);
//    }

    public static String getInitialSizeVarName() {
        return SIZE_VAR_NAME;
    }
}
