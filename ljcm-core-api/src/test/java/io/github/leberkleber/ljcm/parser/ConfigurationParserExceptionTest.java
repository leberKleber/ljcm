package io.github.leberkleber.ljcm.parser;

import io.github.leberkleber.ljcm.parser.ConfigurationParserException;
import org.junit.Test;

/**
 * Useless Test!!! only for line coverage
 */
public class ConfigurationParserExceptionTest {


    @Test(expected = ConfigurationParserException.class)
    public void testConstructor1() {
        throw new ConfigurationParserException();
    }


    @Test(expected = ConfigurationParserException.class)
    public void testConstructor2() {
        throw new ConfigurationParserException("");
    }


    @Test(expected = ConfigurationParserException.class)
    public void testConstructor3() {
        throw new ConfigurationParserException("", null);
    }


    @Test(expected = ConfigurationParserException.class)
    public void testConstructor4() {
        throw new ConfigurationParserException(new Throwable());
    }


    @Test(expected = ConfigurationParserException.class)
    public void testConstructor5() {
        throw new ConfigurationParserException("", new Throwable(), true, false);
    }
}