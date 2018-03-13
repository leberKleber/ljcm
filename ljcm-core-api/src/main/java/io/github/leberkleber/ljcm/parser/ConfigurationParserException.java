package io.github.leberkleber.ljcm.parser;

public class ConfigurationParserException extends RuntimeException {
    public ConfigurationParserException() {
    }

    public ConfigurationParserException(String s) {
        super(s);
    }

    public ConfigurationParserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ConfigurationParserException(Throwable throwable) {
        super(throwable);
    }

    public ConfigurationParserException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
