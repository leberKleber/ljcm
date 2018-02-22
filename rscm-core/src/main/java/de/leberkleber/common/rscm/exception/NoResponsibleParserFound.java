package de.leberkleber.common.rscm.exception;

public class NoResponsibleParserFound extends RuntimeException {
    public NoResponsibleParserFound() {
    }

    public NoResponsibleParserFound(String s) {
        super(s);
    }

    public NoResponsibleParserFound(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoResponsibleParserFound(Throwable throwable) {
        super(throwable);
    }

    public NoResponsibleParserFound(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
