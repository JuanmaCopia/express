package evorep;

public class Example {

    final static String SOURCE_PATH = "./src/test/resources";
    final static String CLASS_NAME = "BinTree";

    private static void initialize() {
/*        SpoonManager.initialize(SOURCE_PATH, null, CLASS_NAME, 17);
        MutatorManager.initialize();*/
    }


    public static void main(String[] args) {
        initialize();
/*        CtClass<?> targetClass = SpoonManager.getTargetClass();
        TypeGraph graph = new TypeGraph(targetClass.getReference());
        System.out.println(graph);*/
    }
}
