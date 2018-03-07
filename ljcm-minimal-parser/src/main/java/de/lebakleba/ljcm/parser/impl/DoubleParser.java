package de.lebakleba.ljcm.parser.impl;

import de.lebakleba.ljcm.exception.UnparsableEntityException;
import de.lebakleba.ljcm.parser.ConfigurationParser;

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
    public Double parseValue(String value, Class targetType) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to double");
        return Double.parseDouble(value);
    }
}
