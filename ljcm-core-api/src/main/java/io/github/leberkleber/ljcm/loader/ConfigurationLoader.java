package io.github.leberkleber.ljcm.loader;

import java.util.Properties;

/**
 * Implement {@link ConfigurationLoader} to load configurations from custom
 * source. Minimal set of implementations can be found at {@link io.github.leberkleber.ljcm.loader.impl}.
 * See: https://github.com/leberKleber/ljcm/wiki/Configurationloader
 */
public interface ConfigurationLoader {
    /**
     * should return loaded configuration. Return empty {@link Properties} instead
     * of {@code null}
     *
     * @since 1.0
     * @return {@link Properties}
     */
    Properties loadConfigurations();
}
