package de.leberkleber.ljcm.exception;

public class NoResponsibleParserFoundException extends RuntimeException {
    public NoResponsibleParserFoundException() {
    }

    public NoResponsibleParserFoundException(String s) {
        super(s);
    }

    public NoResponsibleParserFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoResponsibleParserFoundException(Throwable throwable) {
        super(throwable);
    }

    public NoResponsibleParserFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
