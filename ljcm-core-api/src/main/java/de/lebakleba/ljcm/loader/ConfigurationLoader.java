package de.lebakleba.ljcm.loader;

import java.util.Properties;

/**
 * Implement {@link ConfigurationLoader} to load configurations from custom
 * source. Minimal set of implementations can be found at {@link de.lebakleba.ljcm.loader.impl}.
 * See: https://github.com/lebakleba/ljcm/wiki/Configurationloader

 */
public interface ConfigurationLoader {
    /**
     * should return loaded configuration. Return empty {@link Properties} instead
     * of {@code null}
     * @return {@link Properties}
     */
    Properties loadConfigurations();
}
