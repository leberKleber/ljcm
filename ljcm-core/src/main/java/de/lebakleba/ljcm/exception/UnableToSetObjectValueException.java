package de.lebakleba.ljcm.exception;

public class UnableToSetObjectValueException extends RuntimeException {
    public UnableToSetObjectValueException() {
    }

    public UnableToSetObjectValueException(String s) {
        super(s);
    }

    public UnableToSetObjectValueException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UnableToSetObjectValueException(Throwable throwable) {
        super(throwable);
    }

    public UnableToSetObjectValueException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
