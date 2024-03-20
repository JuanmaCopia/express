package evorep.ga.mutators;

import evorep.ga.Individual;
import spoon.reflect.code.CtCodeElement;

public interface Mutator {

    boolean isApplicable(Individual individual, CtCodeElement gene);

    boolean mutate(Individual individual, CtCodeElement gene);

}
