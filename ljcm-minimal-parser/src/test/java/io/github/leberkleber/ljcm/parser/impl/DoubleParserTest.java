package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.exception.UnparsableEntityException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DoubleParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new DoubleParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Double.class));
        assertTrue(responsibleClasses.contains(double.class));
    }


    @Test
    public void parseValue() {
        assertEquals(1.0d, parser.parseValue("1", Double.class));
        assertEquals(-5.564d, parser.parseValue("-5.564", Double.class));
        assertEquals(3500.5d, parser.parseValue("3500.5", Double.class));
        assertEquals(-8d, parser.parseValue("-8", Double.class));
        assertEquals(0d, parser.parseValue("0", Double.class));
    }

    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null, Double.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble1() {
        parser.parseValue("asdf", Double.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble2() {
        parser.parseValue("5,555.5", Double.class);
        fail();
    }
}