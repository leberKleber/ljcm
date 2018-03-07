[![Build Status](https://travis-ci.org/lebakleba/ljcm.svg?branch=master)](https://travis-ci.org/lebakleba/ljcm)
[![codecov.io](https://codecov.io/github/lebakleba/ljcm/coverage.svg?branch=master)](https://codecov.io/github/lebakleba)
# ljcm 
**Lightweight Java Configuration Management**

Small, simple and lightweight java framework to manage configurations

## How to use
### 1) Include via Maven
```xml
<dependency>
    <groupId>de.lebakleba.ljcm</groupId>
    <artifactId>ljcm-minimal</artifactId>
    <version>0.1-SNAPSHOT</version>
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
                new PropertiesFileLoader("classpath:/app.properties")
        ).build();
          
    cp.process(Configuration.class);
}
```
## Parsers
### Default parsers
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

## Logging

ljcm uses jul. You can easy use a jul-bridge e.g.:
SLF4J:
```java
import java.util.logging.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;

SLF4JBridgeHandler.removeHandlersForRootLogger();
SLF4JBridgeHandler.install();
```
