package io.github.leberkleber.ljcm.loader.impl;

import io.github.leberkleber.ljcm.loader.ConfigurationLoader;

import java.util.Map;
import java.util.Properties;

public class EnvironmentVariableLoader implements ConfigurationLoader {
    @Override
    public Properties loadConfigurations() {
        Properties properties = new Properties();
        Map<String, String> envVars = System.getenv();

        envVars.forEach(properties::put);

        return properties;
    }
}
