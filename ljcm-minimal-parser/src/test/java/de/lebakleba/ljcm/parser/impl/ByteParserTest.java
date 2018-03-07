package de.lebakleba.ljcm.parser.impl;

import de.lebakleba.ljcm.exception.UnparsableEntityException;
import de.lebakleba.ljcm.parser.ConfigurationParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ByteParserTest {
    private ConfigurationParser parser;


    @Before
    public void setUp() {
        parser = new ByteParser();
    }


    @Test
    public void getResponsibleClasses() {
        Set<Class> responsibleClasses = parser.getResponsibleClasses();

        assertTrue(responsibleClasses.contains(Byte.class));
        assertTrue(responsibleClasses.contains(byte.class));
    }


    @Test
    public void parseValue() {
        assertEquals((byte)1, parser.parseValue("1", Byte.class));
        assertEquals((byte)53, parser.parseValue("53", Byte.class));
        assertEquals((byte)-69, parser.parseValue("-69", Byte.class));
    }


    @Test(expected = UnparsableEntityException.class)
    public void parseNull() {
        parser.parseValue(null, Byte.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidNum() {
        parser.parseValue("-454282", Byte.class);
        fail();
    }


    @Test(expected = NumberFormatException.class)
    public void parseInvalidString() {
        parser.parseValue("s", Byte.class);
        fail();
    }
}