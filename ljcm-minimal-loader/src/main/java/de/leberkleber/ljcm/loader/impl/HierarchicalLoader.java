package de.leberkleber.ljcm.loader.impl;

import de.leberkleber.ljcm.loader.ConfigurationLoader;

import java.util.Properties;

public class HierarchicalLoader implements ConfigurationLoader {
    Properties properties;


    private HierarchicalLoader(Properties properties) {
        this.properties = properties;
    }


    @Override
    public Properties loadConfigurations() {
        return properties;
    }


    public static class Builder {
        private Properties properties;

        public Builder() {
            properties = new Properties();
        }

        public Builder addLoader(ConfigurationLoader configurationLoader) {
            if(configurationLoader == null) throw new NullPointerException("configurationLoader must not be null");
            Properties properties = configurationLoader.loadConfigurations();

            if(properties != null) {
                properties.forEach((key, value) -> this.properties.setProperty((String)key, (String)value));
            }

            return this;
        }

        public HierarchicalLoader build() {
            return new HierarchicalLoader(properties);
        }
    }
}
