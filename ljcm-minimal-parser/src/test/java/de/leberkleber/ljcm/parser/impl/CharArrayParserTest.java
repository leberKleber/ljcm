package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class CharArrayParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new CharArrayParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Character[].class));
        assertTrue(responsibleClasses.contains(char[].class));
    }


    @Test
    public void parseValue() {
        assertTrue(Arrays.equals("sss1".toCharArray(), (char[])parser.parseValue("sss1", Character[].class)));
        assertTrue(Arrays.equals("äd aqsd".toCharArray(), (char[])parser.parseValue("äd aqsd", Character[].class)));
        assertTrue(Arrays.equals("-9".toCharArray(), (char[])parser.parseValue("-9", Character[].class)));
    }


    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null, Character[].class);
        fail();
    }
}