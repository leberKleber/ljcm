package de.leberkleber.ljcm;

import de.leberkleber.ljcm.exception.NoResponsibleParserFoundException;
import de.leberkleber.ljcm.exception.UnableToSetObjectValueException;
import de.leberkleber.ljcm.exception.UnparsableEntityException;
import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigurationProcessor {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationProcessor.class.getName());
    private Properties configurations;
    private Map<Class, ConfigurationParser> configurationParsers;


    ConfigurationProcessor(Properties configurations, Map<Class, ConfigurationParser> configurationParsers) {
        if (configurations == null) {
            throw new NullPointerException("configurations must not be null");
        }
        if (configurationParsers == null) {
            throw new NullPointerException("configurationParser must not be null");
        }
        this.configurations = configurations;
        this.configurationParsers = configurationParsers;
    }


    public <C> C process(Class<C> configurationClass) throws Exception {
        C configurationInstance = configurationClass.newInstance();
        Field[] configurationProperties = configurationClass.getDeclaredFields();

        for (Field configurationProperty : configurationProperties) {
            Configuration configuration = configurationProperty.getAnnotation(Configuration.class);

            if (configuration != null) {
                String sourceConfiguration = configurations.getProperty(configuration.value(), configuration.defaultValue());

                if (sourceConfiguration != null && !Configuration.DEFAULT_VALUE.equals(sourceConfiguration)) {
                    Class targetType = configurationProperty.getType();

                    Object parsedConfiguration = parseConfiguration(targetType, sourceConfiguration);
                    if (parsedConfiguration != null) {
                        setObjValue(configurationInstance, configurationProperty.getName(), parsedConfiguration);
                    }
                } else {
                    LOGGER.warning(MessageFormat.format("No configuration found for ''{0}''", configuration.value()));
                }
            }
        }

        return configurationInstance;
    }


    private Object parseConfiguration(Class targetType, String value) {
        ConfigurationParser responsibleParser = findResponsibleConfigurationParser(targetType);
        Object parsedValue;

        try {
            parsedValue = responsibleParser.parseValue(value);
        } catch (Exception e) {
            String msg = MessageFormat.format("Could not parse ''{0}'' to ''{1}''", value, targetType.getTypeName());
            throw new UnparsableEntityException(msg);
        }

        LOGGER.finest(MessageFormat.format("parsed ''{0}'' to ''{1}'' with ''{3}''",
                value,
                parsedValue,
                responsibleParser.getClass().getTypeName()));

        return parsedValue;
    }


    private ConfigurationParser findResponsibleConfigurationParser(Class targetType) {
        ConfigurationParser responsibleParser = null;

        for (Map.Entry<Class, ConfigurationParser> entry : configurationParsers.entrySet()) {
            if (entry.getKey().getName().equals(targetType.getName())) {
                responsibleParser = entry.getValue();
            }
        }

        if (responsibleParser != null) {
            return responsibleParser;
        }

        String msg = MessageFormat.format("No responsible parser found for type {0}", targetType);
        throw new NoResponsibleParserFoundException(msg);
    }


    private void setObjValue(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                LOGGER.finest(MessageFormat.format("Set ''{0}''>''{1}'' to ''{2}''",
                        object.getClass().getTypeName(),
                        fieldName,
                        fieldValue));
                return;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                String msg = MessageFormat.format("Unable to set field {0} at {1} cause: ",
                        fieldName,
                        object.getClass().getTypeName());
                throw new UnableToSetObjectValueException(msg, e);
            }
        }
    }
}
