package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;

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
    public Integer parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to int");
        return Integer.parseInt(value);
    }
}
