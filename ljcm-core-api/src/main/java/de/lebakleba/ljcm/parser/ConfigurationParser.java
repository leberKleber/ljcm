package de.lebakleba.ljcm.parser;

import java.util.Set;

/**
 * Implement {@link ConfigurationParser} to parse custom configuration class types.
 * Minimal set of implementations can be found at {@link de.lebakleba.ljcm.parser.impl}.
 * See: https://github.com/lebakleba/ljcm/wiki/Configurationparser
 */
public interface ConfigurationParser {
    /**
     * Should return set of classes for which {@link ConfigurationParser}
     * is responsible. Primitive Types can also applied to {@link Set<Class>}
     * e.g.: {@code int.class;}.
     *
     * @return {@link Set<Class>}
     */
    Set<Class> getResponsibleClasses();

    /**
     * Should parse {@param value} to {@param targetType}, which is one
     * of responsible the classes, given by
     * {@link ConfigurationParser#getResponsibleClasses()}
     *
     * @param value {@link String}
     * @param targetType {@link Class}
     * @return {@link Object instanceof Set<Class>}
     */
    Object parseValue(String value, Class targetType);
}
