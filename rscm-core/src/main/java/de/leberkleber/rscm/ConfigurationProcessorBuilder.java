package de.leberkleber.rscm;

import de.leberkleber.rscm.loader.ConfigurationLoader;
import de.leberkleber.rscm.parser.ConfigurationParser;

import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Logger;

public final class ConfigurationProcessorBuilder {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationProcessorBuilder.class.getName());
    private ConfigurationLoader configurationLoader;
    private List<ConfigurationParser> configurationParsers;


    public ConfigurationProcessorBuilder() {
        this.configurationParsers = new ArrayList<>();
    }


    public ConfigurationProcessorBuilder addConfigurationParser(ConfigurationParser configurationParser) {
        if(configurationParser == null) {
            throw new NullPointerException("configurationParser must not be null");
        }
        this.configurationParsers.add(configurationParser);
        return this;
    }

    public ConfigurationProcessorBuilder setConfigurationLoader(ConfigurationLoader configurationLoader) {
        if(configurationLoader == null) {
            throw new NullPointerException("configurationLoader must not be null");
        }
        this.configurationLoader = configurationLoader;
        return this;
    }


    public ConfigurationProcessor build() {
        Properties configurations = configurationLoader.loadConfigurations();
        Map<String, ConfigurationParser> mappedConfigurationParsers = new HashMap<>();

        for (ConfigurationParser configurationParser : configurationParsers) {
            Set<String> responsibleClassNames = configurationParser.getResponsibleClasses();

            for (String className : responsibleClassNames) {
                mappedConfigurationParsers.put(className, configurationParser);

                LOGGER.fine(MessageFormat.format("'{0}' mapped on {1}",
                        className,
                        configurationParser.getClass().getTypeName()));
            }
        }

        LOGGER.finest(MessageFormat.format("Available configurations: {0}",
                configurations.toString()));

        return new ConfigurationProcessor(configurations, mappedConfigurationParsers);
    }
}
