package express.classinvariant.mutator.template;

import express.classinvariant.mutator.LocalVarHelper;
import express.spoon.SpoonFactory;
import express.type.TypeUtils;
import express.type.typegraph.Path;
import org.apache.commons.lang3.tuple.Pair;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class SimpleTraversalTemplate {

    public static CtMethod<?> instantiate(CtClass<?> ctClass, Path initialField, CtVariable<?> loopField) {
        int splitIndex = 2;
        Pair<Path, Path> splitPaths = initialField.split(splitIndex);
        Path leftPath = splitPaths.getLeft();
        Path rightPath = splitPaths.getRight();

        CtMethod<?> traversal = TemplateHelper.createTraversalMethod(ctClass, leftPath, LocalVarHelper.SIMPLE_TRAVERSAL_PREFIX);

        TemplateHelper.createSimpleTraversalBody(rightPath, traversal, loopField, false);
        return traversal;
    }
}