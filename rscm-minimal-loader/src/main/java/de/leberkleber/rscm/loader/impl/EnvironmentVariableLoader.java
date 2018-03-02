package de.leberkleber.rscm.loader.impl;

import de.leberkleber.rscm.loader.ConfigurationLoader;

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
