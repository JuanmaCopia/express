package evorep.spoon.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ExampleClassProcessor extends AbstractProcessor<CtClass<?>> {
    @Override
    public void process(CtClass<?> ctClass) {
        // Creates field.
        final CtTypeReference<Date> dateRef = ctClass.getFactory().Code().createCtTypeReference(Date.class);
        final CtTypeReference<List<Date>> listRef = ctClass.getFactory().Code().createCtTypeReference(List.class);
        listRef.addActualTypeArgument(dateRef);
        final CtField<List<Date>> listOfDates = ctClass.getFactory().Core().<List<Date>>createField();
        listOfDates.<CtField<?>>setType(listRef);
        listOfDates.<CtField<?>>addModifier(ModifierKind.PRIVATE);
        listOfDates.setSimpleName("dates");

        // Creates constructor.
        final CtCodeSnippetStatement statementInConstructor = ctClass.getFactory().Code()
                .createCodeSnippetStatement("this.dates = dates");
        final CtBlock<?> ctBlockOfConstructor = ctClass.getFactory().Code().createCtBlock(statementInConstructor);
        final CtParameter<List<Date>> parameter = ctClass.getFactory().Core().<List<Date>>createParameter();
        parameter.<CtParameter<?>>setType(listRef);
        parameter.setSimpleName("dates");
        final CtConstructor constructor = ctClass.getFactory().Core().createConstructor();
        constructor.setBody(ctBlockOfConstructor);
        constructor.setParameters(Collections.<CtParameter<?>>singletonList(parameter));
        constructor.addModifier(ModifierKind.PUBLIC);

        // Apply transformation.
        ctClass.addField(listOfDates);
        ctClass.addConstructor(constructor);
    }
}