package de.leberkleber.rscm.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigurationParserDummy2Impl implements ConfigurationParser {
    private List<String> classes;

    public ConfigurationParserDummy2Impl(String... classes) {
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
