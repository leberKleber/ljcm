package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class LongParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Long.class);
        responsibleClasses.add(long.class);
        return responsibleClasses;
    }

    @Override
    public Long parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to long");
        return Long.parseLong(value);
    }
}
