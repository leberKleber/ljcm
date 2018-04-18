[![Build Status](https://travis-ci.org/leberKleber/ljcm.svg?branch=master)](https://travis-ci.org/leberKleber/ljcm)
[![codecov.io](https://codecov.io/github/leberKleber/ljcm/coverage.svg?branch=master)](https://codecov.io/github/leberKleber)
[![license](https://img.shields.io/github/license/leberkleber/ljcm.svg)]()
# ljcm 
**Lightweight Java Configuration Management**

Small, simple and lightweight java framework to manage configurations

## How to use
### 1) Include via Maven
```xml
<dependency>
    <groupId>io.github.leberkleber.ljcm</groupId>
    <artifactId>ljcm-minimal</artifactId>
    <version>1.0.1</version>
</dependency>
```
### 2) Annotate Configuration-File
```java
public class Configuration {
    @Configuration("my.config.key")
    private String myConfig;
    
    public String getMyConfig() {
        return myConfig;
    }
}
```
### 3) Configure ljcm
```java
public static void main(String[] args){
    ConfigurationProcessor cp = new ConfigurationProcessorBuilder()
        .addConfigurationParsers(Parser.getDefaultParser())
        .setConfigurationLoader(
            new HierarchicalLoader.Builder()
                .addLoader(new EnvironmentVariableLoader())
                .addLoader(new PropertiesFileLoader("classpath:/app.properties"))
                .addLoader(new PropertiesFileLoader("/etc/myapp/app.properties"))
                .build();
        ).build();
          
    cp.process(Configuration.class);
}
```
## Configuration parser
### Default parser
The "ljcm-minimal-parser" contains a minial set of parsers:
- Boolean / boolean @BooleanParser
- Byte / byte @ByteParser
- Character[] / char[] @CharArrayParser
- Character / char @CharParser
- Double / double @DoubleParser
- Float / float @FloatParser
- Integer / int @IntParser
- Long / long @LongParser
- Short / short @ShortParser
- String @ StringParser

All "minimal-parser" can be loaded via:
```java
Parser.getDefaultParser()
```
### Custom parser
A custom parser must implement the "ConfigurationParser" interface.

## Configuration loader
### Default loader
The "ljcm-minimal-loader" contains a minial set of loaders:
- HierarchicalLoader
- EnvironmentVariableLoader
- PropertiesFileLoader

## Logging

ljcm uses jul. You can easy use a jul-bridge e.g.:
SLF4J:
```java
import java.util.logging.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;

SLF4JBridgeHandler.removeHandlersForRootLogger();
SLF4JBridgeHandler.install();
```
