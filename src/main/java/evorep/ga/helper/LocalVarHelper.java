package evorep.ga.helper;

import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtLocalVariable;

import java.util.List;

public class LocalVarHelper {

    public static final String LOCAL_VAR_PREFIX = "var_";
    public static final String SET_VAR_NAME = "visited_";
    public static final String WORKLIST_VAR_NAME = "worklist_";
    public static final String CURRENT_VAR_NAME = "current_";


    public static String getVarName(CtBlock<?> code) {
        return LOCAL_VAR_PREFIX + getNextId(code, LOCAL_VAR_PREFIX);
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
}
