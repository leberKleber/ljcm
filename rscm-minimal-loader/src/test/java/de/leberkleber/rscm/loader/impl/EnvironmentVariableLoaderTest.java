package de.leberkleber.rscm.loader.impl;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EnvironmentVariableLoaderTest {

    @Test
    public void loadConfigurations() {
        //given
        EnvironmentVariableLoader loader = new EnvironmentVariableLoader();


        //when
        Properties properties = loader.loadConfigurations();


        //then
        Set<Map.Entry<String, String>> systemEnvEntrySet = System.getenv().entrySet();
        for (Map.Entry<String, String> systemEnvEntry : systemEnvEntrySet) {
            String key = systemEnvEntry.getKey();
            String value = systemEnvEntry.getValue();

            assertNotNull(properties.getProperty(key));
            assertEquals(value, properties.getProperty(key));
        }
    }
}