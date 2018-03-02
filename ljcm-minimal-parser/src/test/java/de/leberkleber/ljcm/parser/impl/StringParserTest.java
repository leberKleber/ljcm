package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StringParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new StringParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(String.class));
    }


    @Test
    public void parseValue() {
        assertEquals("asdfadga11d54sfg#drfg$%&/(", parser.parseValue("asdfadga11d54sfg#drfg$%&/("));
    }

    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null);
        fail();
    }
}