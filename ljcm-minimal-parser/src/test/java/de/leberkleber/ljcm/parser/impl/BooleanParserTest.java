package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BooleanParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new BooleanParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Boolean.class));
        assertTrue(responsibleClasses.contains(boolean.class));
    }


    @Test
    public void parseValue() {
        assertEquals(Boolean.TRUE, parser.parseValue("1"));
        assertEquals(Boolean.TRUE, parser.parseValue("yes"));
        assertEquals(Boolean.TRUE, parser.parseValue("true"));
        assertEquals(Boolean.FALSE, parser.parseValue("asfdsdgf"));
        assertEquals(Boolean.FALSE, parser.parseValue(""));
    }

    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null);
        fail();
    }
}