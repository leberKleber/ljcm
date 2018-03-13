package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.parser.ConfigurationParserException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;

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
    public Character parseValue(String value, Class targetType) {
        if(value == null) throw new ConfigurationParserException("Could not parse 'null' to char");
        if(value.length() != 1) throw new ConfigurationParserException("value must contain only one character");
        return value.charAt(0);
    }
}
