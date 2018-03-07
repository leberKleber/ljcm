package io.github.leberkleber.ljcm.loader.impl;

import io.github.leberkleber.ljcm.loader.ConfigurationLoader;
import io.github.leberkleber.ljcm.loader.ConfigurationLoaderException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesFileLoader implements ConfigurationLoader {
    private String propertiesFilePath;


    public PropertiesFileLoader(String propertiesFilePath) {
        if (propertiesFilePath == null) throw new NullPointerException("propertiesFilePath must not be null");
        this.propertiesFilePath = propertiesFilePath;
    }


    @Override
    public Properties loadConfigurations() {
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            if (propertiesFilePath.startsWith("classpath:")) {
                String realPropertiesFilePath = propertiesFilePath.split("classpath:")[1];
                inputStream = PropertiesFileLoader.class.getResourceAsStream(realPropertiesFilePath);
                if(inputStream == null) {
                    throw new FileNotFoundException(realPropertiesFilePath + " (No such file or directory)");
                }
            } else {
                File file = Paths.get(propertiesFilePath).toFile();
                inputStream = new FileInputStream(file);
            }

            properties.load(inputStream);
        } catch (IOException e) {
            throw new ConfigurationLoaderException("Error while loading properties cause: ", e);
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new ConfigurationLoaderException("Error while closing inputStream cause: ", e);
                }
            }
        }

        return properties;
    }
}
