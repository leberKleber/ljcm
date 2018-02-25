package de.leberkleber.rscm.parser.impl;

import de.leberkleber.rscm.exception.UnparsableEntityException;
import de.leberkleber.rscm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class IntParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new IntParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Integer.class));
        assertTrue(responsibleClasses.contains(int.class));
    }


    @Test
    public void parseValue() {
        assertEquals(1, parser.parseValue("1"));
        assertEquals(-5564, parser.parseValue("-5564"));
        assertEquals(35005, parser.parseValue("35005"));
        assertEquals(-8, parser.parseValue("-8"));
        assertEquals(0, parser.parseValue("0"));
    }

    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble1() {
        parser.parseValue("asdf");
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidDouble2() {
        parser.parseValue("5555.5");
        fail();
    }
}