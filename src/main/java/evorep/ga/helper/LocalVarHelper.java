package evorep.ga.helper;

public class LocalVarHelper {

    public static final String LOCAL_VAR_PREFIX = "var_";
    public static final String SET_VAR_NAME = "visited";
    public static final String WORKLIST_VAR_NAME = "worklist";

    static int id = 0;

    public static String getVarName() {
        return LOCAL_VAR_PREFIX + id++;
    }
}
