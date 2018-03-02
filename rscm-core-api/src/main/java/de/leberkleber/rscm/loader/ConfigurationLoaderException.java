package de.leberkleber.rscm.loader;

public class ConfigurationLoaderException extends RuntimeException {
    public ConfigurationLoaderException() {
    }

    public ConfigurationLoaderException(String s) {
        super(s);
    }

    public ConfigurationLoaderException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ConfigurationLoaderException(Throwable throwable) {
        super(throwable);
    }

    public ConfigurationLoaderException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
