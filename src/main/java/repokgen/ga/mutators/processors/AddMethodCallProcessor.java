package repokgen.ga.mutators.processors;

import java.util.Collections;
import java.util.List;

import repokgen.spoon.SpoonFactory;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

public class AddMethodCallProcessor extends AbstractProcessor<CtStatement> {

    CtVariable<?> setVariable;
    String methodName;
    List<CtExpression<?>> args;
    List<CtTypeReference<?>> argsTypes;

    public AddMethodCallProcessor(CtVariable<?> setVariable, String methodName, CtExpression<?> arg,
            CtTypeReference<?> argType) {
        this(setVariable, methodName, Collections.singletonList(arg), Collections.singletonList(argType));
    }

    public AddMethodCallProcessor(CtVariable<?> setVariable, String methodName, List<CtExpression<?>> args,
            List<CtTypeReference<?>> argsTypes) {
        this.setVariable = setVariable;
        this.methodName = methodName;
        this.args = args;
        this.argsTypes = argsTypes;
    }

    @Override
    public void process(CtStatement ctStatement) {
        CtInvocation<?> addInvocation = SpoonFactory.createInvocation(setVariable, methodName,
                argsTypes, args);

        ctStatement.insertBefore(addInvocation);
    }

}
