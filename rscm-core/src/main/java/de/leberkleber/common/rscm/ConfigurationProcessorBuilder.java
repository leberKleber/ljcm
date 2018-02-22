package de.leberkleber.common.rscm;

import de.leberkleber.common.rscm.loader.ConfigurationLoader;
import de.leberkleber.common.rscm.parser.ConfigurationParser;

import java.util.*;

public final class ConfigurationProcessorBuilder {
    private ConfigurationLoader configurationLoader;
    private List<ConfigurationParser> configurationParsers;


    public ConfigurationProcessorBuilder() {
        this.configurationParsers = new ArrayList<>();
    }


    public ConfigurationProcessorBuilder addConfigurationParser(ConfigurationParser configurationParser) {
        this.configurationParsers.add(configurationParser);
        return this;
    }

    public ConfigurationProcessorBuilder setConfigurationLoader(ConfigurationLoader configurationLoader) {
        this.configurationLoader = configurationLoader;
        return this;
    }


    public ConfigurationProcessor build() {
        Map<String, String> configurations = configurationLoader.loadConfigurations();
        Map<String, ConfigurationParser> mappedConfigurationParsers = new HashMap<>();

        for (ConfigurationParser configurationParser : configurationParsers) {
            Set<String> responsibleClassNames = configurationParser.getResponsibleClasses();

            for (String className : responsibleClassNames) {
                mappedConfigurationParsers.put(className, configurationParser);
            }
        }

        return new ConfigurationProcessor(configurations, mappedConfigurationParsers);
    }
}
