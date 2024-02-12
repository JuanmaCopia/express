package evorep.ga.mutators;

import evorep.ga.Individual;
import spoon.reflect.code.CtCodeElement;

public interface Mutator {

    boolean isApplicable(CtCodeElement gene);

    void mutate(Individual individual, CtCodeElement gene);

}
