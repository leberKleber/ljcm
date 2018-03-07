package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.exception.UnparsableEntityException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class ByteParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Byte.class);
        responsibleClasses.add(byte.class);
        return responsibleClasses;
    }

    @Override
    public Byte parseValue(String value, Class targetType) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to byte");
        return Byte.parseByte(value);
    }
}
