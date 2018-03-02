package de.leberkleber.rscm.loader.impl;

import de.leberkleber.rscm.loader.ConfigurationLoaderException;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class PropertiesFileLoaderTest {

    @Test
    public void loadConfigurationsFromFS() throws IOException {
        Path path = null;
        try {
            //given
            path = Files.createTempFile("file-load", "unit-test");
            InputStream propertiesInputStream = PropertiesFileLoaderTest.class.getResourceAsStream("/test.properties");
            Files.copy(propertiesInputStream, path, StandardCopyOption.REPLACE_EXISTING);
            PropertiesFileLoader propertiesFileLoader = new PropertiesFileLoader(path.toAbsolutePath().toString());


            //when
            Properties properties = propertiesFileLoader.loadConfigurations();


            //then
            assertNotNull(properties);
            assertEquals(properties.getProperty("thisIsATestProperty"), "someTest");

        } finally {
            if (path != null) {
                Files.delete(path);
            }
        }
    }


    @Test
    public void loadConfigurationsFromClasspath() throws IOException {
        //given
        PropertiesFileLoader propertiesFileLoader = new PropertiesFileLoader("classpath:/test.properties");


        //when
        Properties properties = propertiesFileLoader.loadConfigurations();


        //then
        assertNotNull(properties);
        assertEquals(properties.getProperty("thisIsATestProperty"), "someTest");
    }


    @Test(expected = ConfigurationLoaderException.class)
    public void loadConfigurationsFromFSNotFound()  {
        //given
        PropertiesFileLoader propertiesFileLoader = new PropertiesFileLoader("/this/file/do/not/exists/######");


        //when
        propertiesFileLoader.loadConfigurations();


        //then
        fail();
    }


    @Test(expected = ConfigurationLoaderException.class)
    public void loadConfigurationsFromClasspathNotFound()  {
        //given
        PropertiesFileLoader propertiesFileLoader = new PropertiesFileLoader("classpath:/this/file/do/not/exists/######");


        //when
        propertiesFileLoader.loadConfigurations();


        //then
        fail();
    }
}
