package de.leberkleber.rscm;

import de.leberkleber.rscm.exception.NoResponsibleParserFound;
import de.leberkleber.rscm.parser.ConfigurationParser;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.Map;

public class ConfigurationProcessor {
    private Map<String, String> configurations;
    private Map<String, ConfigurationParser> configurationParser;


    ConfigurationProcessor(Map<String, String> configurations, Map<String, ConfigurationParser> configurationParser) {
        this.configurations = configurations;
        this.configurationParser = configurationParser;
    }


    public <C> C process(Class<C> configurationClass) throws Exception {
        C configurationInstance = configurationClass.newInstance();
        Field[] configurationProperties = configurationClass.getDeclaredFields();

        for (Field configurationProperty : configurationProperties) {
            Configuration configuration = configurationProperty.getAnnotation(Configuration.class);

            if(configuration != null) {
                String targetType = configurationProperty.getType().getName();
                String sourceConfiguration = configurations.get(configuration.value());
                Object parsedConfiguration = parseConfiguration(targetType, sourceConfiguration);

                if(parsedConfiguration != null) {
                    set(configurationInstance, configurationProperty.getName(), parsedConfiguration);
                } else {
                    if(!Configuration.DEFAULT_VALUE.equals(configuration.defaultValue())) {
                        set(configurationInstance, configurationProperty.getName(), configuration.defaultValue());
                    }
                }
            }
        }

        return configurationInstance;
    }


    private Object parseConfiguration(String targetType, String value) {
        ConfigurationParser responsibleParser = findResponsibleConfigurationParser(targetType);
        return responsibleParser.parseValue(value);
    }


    private ConfigurationParser findResponsibleConfigurationParser(String targetType) {
        ConfigurationParser responsibleParser = configurationParser.get(targetType);
        if(responsibleParser != null) {
            return responsibleParser;
        }

        String msg = MessageFormat.format("No responsible parser found for type {0}", targetType);
        throw new NoResponsibleParserFound(msg);
    }


    private boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }
}
