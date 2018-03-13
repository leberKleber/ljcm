package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.parser.ConfigurationParserException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ShortParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new ShortParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Short.class));
        assertTrue(responsibleClasses.contains(short.class));
    }


    @Test
    public void parseValue() {
        assertEquals((short)1, parser.parseValue("1", Short.class));
        assertEquals((short)-5564, parser.parseValue("-5564", Short.class));
        assertEquals((short)3505, parser.parseValue("3505", Short.class));
        assertEquals((short)-8, parser.parseValue("-8", Short.class));
        assertEquals((short)0, parser.parseValue("0", Short.class));
    }

    @Test(expected = ConfigurationParserException.class)
    public void parseNull() {
        parser.parseValue(null, Short.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble1() {
        parser.parseValue("asdf", Short.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble2() {
        parser.parseValue("5.5", Short.class);
        fail();
    }
}