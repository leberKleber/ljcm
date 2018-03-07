package de.leberkleber.ljcm.loader;

import java.util.Properties;

/**
 * Implement {@link ConfigurationLoader} to load configurations from custom
 * source. Minimal set of implementations can be found at {@link de.leberkleber.ljcm.loader.impl}.
 * See: https://github.com/leberKleber/ljcm/wiki/Configurationloader

 */
public interface ConfigurationLoader {
    /**
     * should return loaded configuration. Return empty {@link Properties} instead
     * of {@code null}
     * @return {@link Properties}
     */
    Properties loadConfigurations();
}
