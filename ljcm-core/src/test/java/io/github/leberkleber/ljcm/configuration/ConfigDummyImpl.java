package io.github.leberkleber.ljcm.configuration;

import io.github.leberkleber.ljcm.Configuration;

public class ConfigDummyImpl {
    @Configuration("test.exists")
    private String testExists;

    @Configuration("test.doseNotExists")
    private String testDoseNotExists;

    @Configuration(value = "testo.testa", defaultValue = "defaultV")
    private String testWithDefault;

    private String testWithoutAnnotation = "default";

    public String getTestExists() {
        return testExists;
    }

    public String getTestDoseNotExists() {
        return testDoseNotExists;
    }

    public String getTestWithDefault() {
        return testWithDefault;
    }

    public String getTestWithoutAnnotation() {
        return testWithoutAnnotation;
    }
}
