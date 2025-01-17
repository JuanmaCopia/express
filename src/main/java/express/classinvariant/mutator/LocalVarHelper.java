package express.classinvariant.mutator;

import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.util.Set;
import java.util.stream.Collectors;

public class LocalVarHelper {

    public static final String IMMUTABLE_COMMENT = "Immutable Statement:";

    public static final String MUTABLE_METHOD_SUFFIX = "_M_";

    public static final String STRUCTURE_METHOD_NAME = "repOkStructure";
    public static final String PRIMITIVE_METHOD_NAME = "repOkPrimitive";

    public static final String SEPARATOR_LABEL = "SEPARATOR_LABEL";
    public static final String RETURN_TRUE_LABEL = "RETURN_TRUE_LABEL";

    public static final String STAGE_1_LABEL = "STAGE_1_LABEL";
    public static final String STAGE_2_LABEL = "STAGE_2_LABEL";
    public static final String STAGE_3_LABEL = "STAGE_3_LABEL";
    public static final String STAGE_4_LABEL = "STAGE_4_LABEL";

    public static final String SET_VAR_NAME = "visited";
    public static final String WORKLIST_VAR_NAME = "worklist_";
    public static final String CURRENT_VAR_NAME = "current_";
    public static final String TRAVERSAL_PREFIX = "traverse_";
    public static final String ARRAY_TRAVERSAL_PREFIX = "traverseArray_";
    public static final String INITIAL_SIZE_VAR_NAME = "initialSize_";
    public static final String TRAVERSAL_ROOT_VAR_NAME = "rootElement";
    public static final String TRAVERSED_ELEMENT_VAR_NAME = "subject";
    public static final String ARRAY_PARAM_NAME = "array_";
    public static final String THIS_PARAM_NAME = "_this";
    public static final String THIS_FIELD_NAME = "thisInstance";
    public static final String ARRAY_VAR_PREFIX = "arrayOf";
    public static final String MAP_OF_VISITED = "mapOfVisited";



    public static String getNextTraversalName(CtClass<?> ctClass, String traversalPrefix) {
        Set<String> traversalMethodNames = ctClass.getMethods().stream()
                .map(CtMethod::getSimpleName)
                .filter(name -> name.startsWith(traversalPrefix))
                .collect(Collectors.toSet());
        for (int i = 0; i < traversalMethodNames.size() + 1; i++) {
            String methodName = createTraversalName(traversalPrefix, i);
            if (!traversalMethodNames.contains(methodName)) {
                return methodName;
            }
        }
        throw new RuntimeException("No traversal name available");
    }

    public static String createTraversalName(String traversalPrefix, int id) {
        return traversalPrefix + id + MUTABLE_METHOD_SUFFIX;
    }

    public static String getStageLabel(int stageNumber) {
        return switch (stageNumber) {
            case 1 -> STAGE_1_LABEL;
            case 2 -> STAGE_2_LABEL;
            case 3 -> STAGE_3_LABEL;
            case 4 -> STAGE_4_LABEL;
            default -> throw new IllegalArgumentException("Invalid stage number");
        };
    }

    public static String getVisitedSetVarName(CtTypeReference<?> typeOfPath) {
        return SET_VAR_NAME + typeOfPath.getSimpleName();
    }
    
}
