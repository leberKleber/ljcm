package de.lebakleba.ljcm;

import de.lebakleba.ljcm.loader.ConfigurationLoader;
import de.lebakleba.ljcm.loader.impl.ConfigurationLoaderDummyImpl;
import de.lebakleba.ljcm.parser.ConfigurationParser;
import de.lebakleba.ljcm.parser.ConfigurationParserDummy2Impl;
import de.lebakleba.ljcm.parser.ConfigurationParserDummyImpl;
import org.junit.Test;
import util.RefelctionTestUtils;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ConfigurationProcessorBuilderTest {

    @Test
    public void addConfigurationParser() {
        new ConfigurationProcessorBuilder().addConfigurationParser(new ConfigurationParser() {
            @Override
            public Set<Class> getResponsibleClasses() {
                return null;
            }

            @Override
            public Object parseValue(String value, Class targetClass) {
                return null;
            }
        });
    }


    @Test(expected = NullPointerException.class)
    public void addConfigurationParserNull() {
        new ConfigurationProcessorBuilder().addConfigurationParser(null);
        fail();
    }


    @Test
    public void setConfigurationLoader() {
        new ConfigurationProcessorBuilder().setConfigurationLoader(() -> null);
    }


    @Test(expected = NullPointerException.class)
    public void setConfigurationLoaderNull() {
        new ConfigurationProcessorBuilder().setConfigurationLoader(null);
        fail();
    }


    @Test
    public void build() throws NoSuchFieldException, IllegalAccessException {
        ConfigurationLoader configurationLoader = new ConfigurationLoaderDummyImpl("test.test", "Value");
        ConfigurationParser configurationParser1 = new ConfigurationParserDummyImpl(String.class);
        ConfigurationParser configurationParser2 = new ConfigurationParserDummy2Impl(Long.class);
        ConfigurationProcessor configurationProcessor = new ConfigurationProcessorBuilder()
                .setConfigurationLoader(configurationLoader)
                .addConfigurationParser(configurationParser1)
                .addConfigurationParser(configurationParser2)
                .build();


        Properties properties =
                (Properties)RefelctionTestUtils.getFieldValue(configurationProcessor, "configurations");
        Map<String, ConfigurationParser> configurationParsers =
                (Map<String, ConfigurationParser>)RefelctionTestUtils.getFieldValue(configurationProcessor, "configurationParsers");


        assertNotNull(properties);
        assertEquals(properties.get("test.test"), "Value");

        assertNotNull(configurationParsers);
        assertEquals(configurationParsers.size(), 2);
        assertEquals(configurationParsers.get(String.class).getClass().getTypeName(),
                ConfigurationParserDummyImpl.class.getTypeName());
        assertEquals(configurationParsers.get(Long.class).getClass().getTypeName(),
                ConfigurationParserDummy2Impl.class.getTypeName());
    }
}