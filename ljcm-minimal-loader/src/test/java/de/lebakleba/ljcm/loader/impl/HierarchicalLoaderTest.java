package de.lebakleba.ljcm.loader.impl;


import de.lebakleba.ljcm.loader.ConfigurationLoader;
import org.junit.Test;
import util.DummyLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class HierarchicalLoaderTest {

    @Test
    public void builder() {
        //given
        String keyDuplicate = "test.test";
        String keyA = "testA";
        String keyB = "testB";
        Map<String, String> propertiesA = new HashMap<>();
        Map<String, String> propertiesB = new HashMap<>();
        propertiesA.put(keyDuplicate, "value.value");
        propertiesA.put(keyA, "valueA.value");
        propertiesB.put(keyDuplicate, "valueB.value");
        propertiesB.put(keyB, "valueB.value");

        DummyLoader dummyLoaderA = new DummyLoader(propertiesA);
        DummyLoader dummyLoaderB = new DummyLoader(propertiesB);


        //when
        ConfigurationLoader configurationLoader = new HierarchicalLoader.Builder()
                .addLoader(dummyLoaderA)
                .addLoader(dummyLoaderB).build();

        Properties properties = configurationLoader.loadConfigurations();


        //then
        assertNotNull(properties);
        assertEquals("valueB.value", properties.getProperty(keyDuplicate));
        assertEquals("valueA.value", properties.getProperty(keyA));
        assertEquals("valueB.value", properties.getProperty(keyB));
        assertNull(properties.getProperty("not found"));
    }

}