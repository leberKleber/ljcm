package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.parser.ConfigurationParserException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.Collections;
import java.util.Set;

public class StringParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        return Collections.singleton(String.class);
    }

    @Override
    public String parseValue(String value, Class targetType) {
        if(value == null) throw new ConfigurationParserException("Could not parse 'null' to string");
        return value;
    }
}
