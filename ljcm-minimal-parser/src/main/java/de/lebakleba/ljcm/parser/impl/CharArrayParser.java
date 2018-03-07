package de.lebakleba.ljcm.parser.impl;

import de.lebakleba.ljcm.exception.UnparsableEntityException;
import de.lebakleba.ljcm.parser.ConfigurationParser;

import java.util.HashSet;
import java.util.Set;

public class CharArrayParser implements ConfigurationParser {
    @Override
    public Set<Class> getResponsibleClasses() {
        Set<Class> responsibleClasses = new HashSet<>();

        responsibleClasses.add(Character[].class);
        responsibleClasses.add(char[].class);
        return responsibleClasses;
    }

    @Override
    public char[] parseValue(String value, Class targetType) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to char[]");
        return value.toCharArray();
        }
        }
