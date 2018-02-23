package de.leberkleber.rscm;

import de.leberkleber.rscm.loader.ConfigurationLoader;
import de.leberkleber.rscm.loader.impl.ConfigurationLoaderDummyImpl;
import de.leberkleber.rscm.parser.ConfigurationParser;
import de.leberkleber.rscm.parser.ConfigurationParserDummy2Impl;
import de.leberkleber.rscm.parser.ConfigurationParserDummyImpl;
import org.junit.Test;
import util.RefelctionTestUtils;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.Assert.*;

public class ConfigurationProcessorBuilderTest {

    @Test
    public void addConfigurationParser() {
        new ConfigurationProcessorBuilder().addConfigurationParser(new ConfigurationParser() {
            @Override
            public Set<String> getResponsibleClasses() {
                return null;
            }

            @Override
            public Object parseValue(String value) {
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
        ConfigurationParser configurationParser1 = new ConfigurationParserDummyImpl("some.path.to.class1");
        ConfigurationParser configurationParser2 = new ConfigurationParserDummy2Impl("some.path.to.class2");
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
        assertEquals(configurationParsers.get("some.path.to.class1").getClass().getTypeName(),
                ConfigurationParserDummyImpl.class.getTypeName());
        assertEquals(configurationParsers.get("some.path.to.class2").getClass().getTypeName(),
                ConfigurationParserDummy2Impl.class.getTypeName());
    }
}