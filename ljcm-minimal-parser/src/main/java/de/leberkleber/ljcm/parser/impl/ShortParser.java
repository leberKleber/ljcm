package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class ShortParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Short.class);
        responsibleClasses.add(short.class);
        return responsibleClasses;
    }

    @Override
    public Short parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to short");
        return Short.parseShort(value);
    }
}
