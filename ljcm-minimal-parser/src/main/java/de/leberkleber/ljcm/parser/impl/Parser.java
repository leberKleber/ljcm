package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.ArrayList;
import java.util.List;

public final class Parser {
    private Parser() {}

    public static List<ConfigurationParser> getDefaultParser() {
        List<ConfigurationParser> defaultParser = new ArrayList<>();

        defaultParser.add(new BooleanParser());
        defaultParser.add(new ByteParser());
        defaultParser.add(new CharArrayParser());
        defaultParser.add(new CharParser());
        defaultParser.add(new DoubleParser());
        defaultParser.add(new FloatParser());
        defaultParser.add(new IntParser());
        defaultParser.add(new ShortParser());
        defaultParser.add(new StringParser());

        return defaultParser;
    }
}
