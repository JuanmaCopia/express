package express.spoon;

import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;

import java.util.List;
import java.util.Objects;

public class SpoonHelper {

    public static void replace(CtElement e, CtElement op) {
        if (e instanceof CtStatement && op instanceof CtStatement) {
            e.replace(op);
            return;
        }
        if (e instanceof CtExpression && op instanceof CtExpression) {
            e.replace(op);
            return;
        }
        throw new IllegalArgumentException(e.getClass() + " " + op.getClass());
    }

    public static void removeComments(CtClass<?> cls) {
        List<CtComment> comments = cls.getElements(Objects::nonNull);
        for (CtComment comment : comments)
            comment.delete();
    }

}
