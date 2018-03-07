package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.Collections;
import java.util.Set;

public class StringParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        return Collections.singleton(String.class);
    }

    @Override
    public String parseValue(String value, Class targetType) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to string");
        return value;
    }
}
