package de.leberkleber.rscm.exception;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Useless Test!!! only for line coverage
 */
public class NoResponsibleParserFoundExceptionTest {


    @Test(expected = NoResponsibleParserFoundException.class)
    public void testConstructor1() {
        throw new NoResponsibleParserFoundException();
    }


    @Test(expected = NoResponsibleParserFoundException.class)
    public void testConstructor2() {
        throw new NoResponsibleParserFoundException("");
    }


    @Test(expected = NoResponsibleParserFoundException.class)
    public void testConstructor3() {
        throw new NoResponsibleParserFoundException("", null);
    }


    @Test(expected = NoResponsibleParserFoundException.class)
    public void testConstructor4() {
        throw new NoResponsibleParserFoundException(new Throwable());
    }


    @Test(expected = NoResponsibleParserFoundException.class)
    public void testConstructor5() {
        throw new NoResponsibleParserFoundException("", new Throwable(), true, false);
    }
}