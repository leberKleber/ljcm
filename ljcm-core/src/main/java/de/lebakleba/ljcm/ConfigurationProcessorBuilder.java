package de.lebakleba.ljcm;

import de.lebakleba.ljcm.loader.ConfigurationLoader;
import de.lebakleba.ljcm.parser.ConfigurationParser;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;


public final class ConfigurationProcessorBuilder {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationProcessorBuilder.class.getName());
    private ConfigurationLoader configurationLoader;
    private List<ConfigurationParser> configurationParsers;


    public ConfigurationProcessorBuilder() {
        this.configurationParsers = new ArrayList<>();
    }


    public ConfigurationProcessorBuilder addConfigurationParser(ConfigurationParser configurationParser) {
        if (configurationParser == null) {
            throw new NullPointerException("configurationParser must not be null");
        }
        this.configurationParsers.add(configurationParser);
        return this;
    }


    public ConfigurationProcessorBuilder addConfigurationParsers(List<ConfigurationParser> configurationParsers) {
        if(configurationParsers == null) {
            throw new NullPointerException("configurationParsers must not be null");
        }
        for (ConfigurationParser configurationParser : configurationParsers) {
            addConfigurationParser(configurationParser);
        }
        return this;
    }


    public ConfigurationProcessorBuilder setConfigurationLoader(ConfigurationLoader configurationLoader) {
        if (configurationLoader == null) {
            throw new NullPointerException("configurationLoader must not be null");
        }
        this.configurationLoader = configurationLoader;
        return this;
    }


    public ConfigurationProcessor build() {
        Properties configurations = configurationLoader.loadConfigurations();
        Map<Class, ConfigurationParser> mappedConfigurationParsers = new HashMap<>();

        for (ConfigurationParser configurationParser : configurationParsers) {
            Set<Class> responsibleClasses = configurationParser.getResponsibleClasses();

            for (Class clazz : responsibleClasses) {
                mappedConfigurationParsers.put(clazz, configurationParser);

                LOGGER.fine(MessageFormat.format("''{0}'' mapped on ''{1}''",
                        clazz.getTypeName(),
                        configurationParser.getClass().getTypeName()));
            }
        }

        LOGGER.finest(MessageFormat.format("Available configurations: {0}",
                configurations.toString()));

        return new ConfigurationProcessor(configurations, mappedConfigurationParsers);
    }
}
