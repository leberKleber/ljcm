package de.leberkleber.rscm.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigurationParserDummy2Impl implements ConfigurationParser {
    private List<Class> classes;

    public ConfigurationParserDummy2Impl(Class... classes) {
        this.classes = Arrays.asList(classes);
    }

    @Override
    public Set<Class> getResponsibleClasses() {
        return new HashSet<>(classes);
    }

    @Override
    public Object parseValue(String value) {
        return value;
    }
}
