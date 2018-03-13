package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.parser.ConfigurationParserException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Boolean.class);
        responsibleClasses.add(boolean.class);
        return responsibleClasses;
    }

    @Override
    public Boolean parseValue(String value, Class targetType) {
        if(value == null) throw new ConfigurationParserException("Could not parse 'null' to boolean");
        Set<String> trueSet = new HashSet<>(Arrays.asList("1", "true", "yes"));
        value = value.toLowerCase();

        return trueSet.contains(value);

    }
}
