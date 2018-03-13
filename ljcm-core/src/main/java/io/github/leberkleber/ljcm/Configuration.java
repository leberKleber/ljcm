package io.github.leberkleber.ljcm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marks the field, which should be replaces by loaded Configuration.
 * Acceptable types must be registered via {@link ConfigurationProcessorBuilder}.
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {
    String DEFAULT_VALUE = "],({\"::^^!$=^(];:~[:*)/#_";

    /**
     * Configuration key
     * @return configuration key
     */
    String value();
    String defaultValue() default DEFAULT_VALUE;
}
