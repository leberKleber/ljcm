package de.leberkleber.rscm.parser.impl;

import de.leberkleber.rscm.exception.UnparsableEntityException;
import de.leberkleber.rscm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class DoubleParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Double.class);
        responsibleClasses.add(double.class);
        return responsibleClasses;
    }

    @Override
    public Double parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to double");
        return Double.parseDouble(value);
    }
}
