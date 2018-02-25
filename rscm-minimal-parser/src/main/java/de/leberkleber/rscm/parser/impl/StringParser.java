package de.leberkleber.rscm.parser.impl;

import de.leberkleber.rscm.exception.UnparsableEntityException;
import de.leberkleber.rscm.parser.ConfigurationParser;

import java.util.Collections;
import java.util.Set;

public class StringParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        return Collections.singleton(String.class);
    }

    @Override
    public String parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to string");
        return value;
    }
}
