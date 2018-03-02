package de.leberkleber.ljcm.parser;

import java.util.Set;

public interface ConfigurationParser {
    Set<Class> getResponsibleClasses();
    Object parseValue(String value);
}
