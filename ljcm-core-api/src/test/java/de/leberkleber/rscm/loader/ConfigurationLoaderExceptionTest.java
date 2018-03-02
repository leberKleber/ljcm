package de.leberkleber.rscm.loader;


import org.junit.Test;

/**
 * Useless Test!!! only for line coverage
 */
public class ConfigurationLoaderExceptionTest {
    @Test(expected = ConfigurationLoaderException.class)
    public void constructor1() {
        throw new ConfigurationLoaderException();
    }


    @Test(expected = ConfigurationLoaderException.class)
    public void constructor2() {
        throw new ConfigurationLoaderException("");
    }


    @Test(expected = ConfigurationLoaderException.class)
    public void constructor3() {
        throw new ConfigurationLoaderException("", null);
    }


    @Test(expected = ConfigurationLoaderException.class)
    public void constructor4() {
        throw new ConfigurationLoaderException(new Throwable());
    }


    @Test(expected = ConfigurationLoaderException.class)
    public void constructor5() {
        throw new ConfigurationLoaderException("", new Throwable(), true, false);
    }
}