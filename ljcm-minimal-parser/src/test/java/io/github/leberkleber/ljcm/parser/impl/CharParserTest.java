package io.github.leberkleber.ljcm.parser.impl;

import io.github.leberkleber.ljcm.exception.UnparsableEntityException;
import io.github.leberkleber.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CharParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new CharParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Character.class));
        assertTrue(responsibleClasses.contains(char.class));
    }


    @Test
    public void parseValue() {
        assertEquals('2', parser.parseValue("2", Character.class));
        assertEquals('ä', parser.parseValue("ä", Character.class));
        assertEquals('l', parser.parseValue("l", Character.class));
    }


    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null, Character.class);
        fail();
    }


    @Test(expected = UnparsableEntityException.class)
    public void parseToLongString() {
        parser.parseValue("tooManyChars", Character.class);
        fail();
    }
}