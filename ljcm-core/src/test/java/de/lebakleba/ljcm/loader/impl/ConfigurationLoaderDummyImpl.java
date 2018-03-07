package de.lebakleba.ljcm.loader.impl;

import de.lebakleba.ljcm.loader.ConfigurationLoader;

import java.util.Properties;

public class ConfigurationLoaderDummyImpl implements ConfigurationLoader {
    private Properties properties;

    public ConfigurationLoaderDummyImpl(String key, String value) {
        properties = new Properties();
        properties.put(key, value);
    }

    @Override
    public Properties loadConfigurations() {
        return properties;
    }
}
