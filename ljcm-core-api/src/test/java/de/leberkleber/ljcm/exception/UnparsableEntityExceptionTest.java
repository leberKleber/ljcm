package de.leberkleber.ljcm.exception;

import org.junit.Test;

/**
 * Useless Test!!! only for line coverage
 */
public class UnparsableEntityExceptionTest {


    @Test(expected = UnparsableEntityException.class)
    public void testConstructor1() {
        throw new UnparsableEntityException();
    }


    @Test(expected = UnparsableEntityException.class)
    public void testConstructor2() {
        throw new UnparsableEntityException("");
    }


    @Test(expected = UnparsableEntityException.class)
    public void testConstructor3() {
        throw new UnparsableEntityException("", null);
    }


    @Test(expected = UnparsableEntityException.class)
    public void testConstructor4() {
        throw new UnparsableEntityException(new Throwable());
    }


    @Test(expected = UnparsableEntityException.class)
    public void testConstructor5() {
        throw new UnparsableEntityException("", new Throwable(), true, false);
    }
}