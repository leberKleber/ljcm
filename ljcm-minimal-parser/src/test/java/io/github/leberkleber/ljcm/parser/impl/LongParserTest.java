package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.parser.ConfigurationParserException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LongParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new LongParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Long.class));
        assertTrue(responsibleClasses.contains(long.class));
    }


    @Test
    public void parseValue() {
        assertEquals(1L, parser.parseValue("1", Long.class));
        assertEquals(-5564L, parser.parseValue("-5564", Long.class));
        assertEquals(35005L, parser.parseValue("35005", Long.class));
        assertEquals(-8L, parser.parseValue("-8", Long.class));
        assertEquals(0L, parser.parseValue("0", Long.class));
    }

    @Test(expected = ConfigurationParserException.class)
    public void parseNull() {
        parser.parseValue(null, Long.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble1() {
        parser.parseValue("asdf", Long.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble2() {
        parser.parseValue("5,555.5", Long.class);
        fail();
    }
}