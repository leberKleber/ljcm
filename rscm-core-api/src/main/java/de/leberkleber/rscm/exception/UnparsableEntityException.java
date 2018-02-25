package de.leberkleber.rscm.exception;

public class UnparsableEntityException extends RuntimeException {
    public UnparsableEntityException() {
    }

    public UnparsableEntityException(String s) {
        super(s);
    }

    public UnparsableEntityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UnparsableEntityException(Throwable throwable) {
        super(throwable);
    }

    public UnparsableEntityException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
