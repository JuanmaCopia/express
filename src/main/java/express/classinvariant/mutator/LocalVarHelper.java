package express.classinvariant.mutator;

import spoon.reflect.code.CtBlock;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalVarHelper {

    public static final String IMMUTABLE_COMMENT = "Immutable Statement:";

    public static final String MUTABLE_METHOD_SUFFIX = "_M_";
    public static final String IMMUTABLE_METHOD_SUFFIX = "_I_";

    public static final String STRUCTURE_METHOD_NAME = "repOkStructure";
    public static final String PRIMITIVE_METHOD_NAME = "repOkPrimitive";

    public static final String SEPARATOR_LABEL = "SEPARATOR_LABEL";
    public static final String RETURN_TRUE_LABEL = "RETURN_TRUE_LABEL";

    public static final String STAGE_1_LABEL = "STAGE_1_LABEL";
    public static final String STAGE_2_LABEL = "STAGE_2_LABEL";
    public static final String STAGE_3_LABEL = "STAGE_3_LABEL";
    public static final String STAGE_4_LABEL = "STAGE_4_LABEL";

    public static final String LOCAL_VAR_PREFIX = "var_";
    public static final String SET_VAR_NAME = "visited_";
    public static final String WORKLIST_VAR_NAME = "worklist_";
    public static final String CURRENT_VAR_NAME = "current_";
    public static final String TRAVERSAL_PREFIX = "traverse_";
    public static final String ARRAY_TRAVERSAL_PREFIX = "traverseArray_";
    public static final String SIZE_VAR_NAME = "initialSize_";
    public static final String FIRST_ELEMENT_VAR_NAME = "firstElement_";
    public static final String TRAVERSED_ELEMENT_VAR_NAME = "subject";
    public static final String ARRAY_PARAM_NAME = "array_";
    public static final String THIS_PARAM_NAME = "_this";
    public static final String ARRAY_VAR_PREFIX = "arrayOf";

    public static final Map<String, Integer> idMap = new HashMap<>();


    public static String getVarName(CtBlock<?> code) {
        return LOCAL_VAR_PREFIX + getNextId(code, LOCAL_VAR_PREFIX);
    }

    public static int getNextTraversalId(CtClass<?> ctClass, String prefix) {
        List<String> traversalMethodNames = ctClass.getMethods().stream()
                .map(CtMethod::getSimpleName)
                .filter(name -> name.startsWith(prefix))
                .toList();
        return traversalMethodNames.size();
    }

    public static int getNextId(CtBlock<?> code, String varPrefix) {
        if (idMap.containsKey(varPrefix)) {
            idMap.put(varPrefix, idMap.get(varPrefix) + 1);
        } else {
            idMap.put(varPrefix, 0);
        }
        return idMap.get(varPrefix);
    }

    public static String getCurrentVarName(CtBlock<?> code) {
        return CURRENT_VAR_NAME;
    }

//    public static String getVisitedSetVarName(CtBlock<?> code) {
//        return SET_VAR_NAME + getNextId(code, SET_VAR_NAME);
//    }

    public static String getWorklistVarName(CtBlock<?> code) {
        return WORKLIST_VAR_NAME;
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
