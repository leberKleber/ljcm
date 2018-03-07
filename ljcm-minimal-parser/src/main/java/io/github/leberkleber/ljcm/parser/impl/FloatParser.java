package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.exception.UnparsableEntityException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class FloatParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Float.class);
        responsibleClasses.add(float.class);
        return responsibleClasses;
    }

    @Override
    public Float parseValue(String value, Class targetType) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to float");
        return Float.parseFloat(value);
    }
}
