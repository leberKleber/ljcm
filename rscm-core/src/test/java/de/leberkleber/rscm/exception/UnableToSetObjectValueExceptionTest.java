package de.leberkleber.rscm.exception;

import org.junit.Test;

/**
 * Useless Test!!! only for line coverage
 */
public class UnableToSetObjectValueExceptionTest {


    @Test(expected = UnableToSetObjectValueException.class)
    public void testConstructor1() {
        throw new UnableToSetObjectValueException();
    }


    @Test(expected = UnableToSetObjectValueException.class)
    public void testConstructor2() {
        throw new UnableToSetObjectValueException("");
    }


    @Test(expected = UnableToSetObjectValueException.class)
    public void testConstructor3() {
        throw new UnableToSetObjectValueException("", null);
    }


    @Test(expected = UnableToSetObjectValueException.class)
    public void testConstructor4() {
        throw new UnableToSetObjectValueException(new Throwable());
    }


    @Test(expected = UnableToSetObjectValueException.class)
    public void testConstructor5() {
        throw new UnableToSetObjectValueException("", new Throwable(), true, false);
    }
}