package de.lebakleba.ljcm.parser.impl;

import de.lebakleba.ljcm.parser.ConfigurationParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParsersTest {

    @Test
    public void getDefaultParsers() {
        List<ConfigurationParser> configurationParsers = Parsers.getDefaultParsers();

        assertTrue(containsClassOfType(configurationParsers, BooleanParser.class));
        assertTrue(containsClassOfType(configurationParsers, ByteParser.class));
        assertTrue(containsClassOfType(configurationParsers, CharArrayParser.class));
        assertTrue(containsClassOfType(configurationParsers, CharParser.class));
        assertTrue(containsClassOfType(configurationParsers, DoubleParser.class));
        assertTrue(containsClassOfType(configurationParsers, FloatParser.class));
        assertTrue(containsClassOfType(configurationParsers, IntParser.class));
        assertTrue(containsClassOfType(configurationParsers, LongParser.class));
        assertTrue(containsClassOfType(configurationParsers, ShortParser.class));
        assertTrue(containsClassOfType(configurationParsers, StringParser.class));
    }

    private boolean containsClassOfType(List<ConfigurationParser> parsers, Class clazz) {
        for (ConfigurationParser parser : parsers) {
            if(clazz.isInstance(parser)) {
                return true;
            }
        }

        return false;
    }
}