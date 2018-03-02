package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class CharParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Character.class);
        responsibleClasses.add(char.class);
        return responsibleClasses;
    }

    @Override
    public Character parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to char");
        if(value.length() != 1) throw new UnparsableEntityException("value must contain only one character");
        return value.charAt(0);
    }
}
