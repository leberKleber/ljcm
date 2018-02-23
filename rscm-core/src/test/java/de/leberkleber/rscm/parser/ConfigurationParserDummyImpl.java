package de.leberkleber.rscm.parser;

import java.util.*;

public class ConfigurationParserDummyImpl implements ConfigurationParser {
    private List<String> classes;

    public ConfigurationParserDummyImpl(String... classes) {
        this.classes = Arrays.asList(classes);
    }

    @Override
    public Set<String> getResponsibleClasses() {
        return new HashSet<>(classes);
    }

    @Override
    public Object parseValue(String value) {
        return value;
    }
}
