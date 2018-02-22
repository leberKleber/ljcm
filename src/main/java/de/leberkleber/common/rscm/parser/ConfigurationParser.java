package de.leberkleber.common.rscm.parser;

import java.util.Set;

public interface ConfigurationParser {
    Set<String> getResponsibleClasses();
    Object parseValue(String value);
}
