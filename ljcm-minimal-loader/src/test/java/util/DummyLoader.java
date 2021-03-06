package util;

import io.github.leberkleber.ljcm.loader.ConfigurationLoader;

import java.util.Map;
import java.util.Properties;

public class DummyLoader implements ConfigurationLoader {
    private Map<String, String> data;

    public DummyLoader(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public Properties loadConfigurations() {
        Properties properties = new Properties();
        properties.putAll(data);

        return properties;
    }
}
