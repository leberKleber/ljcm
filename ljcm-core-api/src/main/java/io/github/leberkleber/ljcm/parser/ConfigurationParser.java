package io.github.leberkleber.ljcm.parser;

import java.util.Set;

/**
 * Implement {@link ConfigurationParser} to parse custom configuration class types.
 * Minimal set of implementations can be found at io.github.leberkleber.ljcm.parser.impl.
 * See: https://github.com/leberKleber/ljcm/wiki/Configurationparser
 */
public interface ConfigurationParser {
    /**
     * Should return set of classes for which {@link ConfigurationParser}
     * is responsible. Primitive Types can also applied to {@link Set}
     * e.g.: {@code int.class;}.
     *
     * @since 1.0
     * @return {@link Set}
     */
    Set<Class> getResponsibleClasses();

    /**
     * Should parse {@link String value} to {@link Class targetType}, which is one
     * of responsible the classes, given by
     * {@link ConfigurationParser#getResponsibleClasses()}
     *
     * @since 1.0
     * @param value {@link String}
     * @param targetType {@link Class}
     * @return {@link Object} instanceof Set<Class>
     */
    Object parseValue(String value, Class targetType);
}
