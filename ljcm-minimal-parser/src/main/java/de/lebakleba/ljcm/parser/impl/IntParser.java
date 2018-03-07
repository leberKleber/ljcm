package de.lebakleba.ljcm.parser.impl;

import de.lebakleba.ljcm.exception.UnparsableEntityException;
import de.lebakleba.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class IntParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Integer.class);
        responsibleClasses.add(int.class);
        return responsibleClasses;
    }

    @Override
    public Integer parseValue(String value, Class targetType) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to int");
        return Integer.parseInt(value);
    }
}
