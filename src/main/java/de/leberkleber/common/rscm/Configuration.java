package de.leberkleber.common.rscm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {
    String DEFAULT_VALUE = "],({\"::^^!$=^(];:~[:*)/#_";
    String value();
    String defaultValue() default DEFAULT_VALUE;
}
