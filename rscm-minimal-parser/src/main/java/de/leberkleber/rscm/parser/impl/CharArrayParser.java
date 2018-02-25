package de.leberkleber.rscm.parser.impl;

import de.leberkleber.rscm.exception.UnparsableEntityException;
import de.leberkleber.rscm.parser.ConfigurationParser;

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
    public char[] parseValue(String value) {
        if(value == null) throw new UnparsableEntityException("Could not parse 'null' to char[]");
        return value.toCharArray();
        }
        }
