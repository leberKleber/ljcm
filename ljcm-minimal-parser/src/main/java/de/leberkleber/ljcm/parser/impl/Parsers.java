package de.leberkleber.ljcm.parser.impl;

import de.leberkleber.ljcm.parser.ConfigurationParser;

import java.util.ArrayList;
import java.util.List;

public final class Parsers {
    private Parsers() {}

    public static List<ConfigurationParser> getDefaultParsers() {
        List<ConfigurationParser> defaultParser = new ArrayList<>();

        defaultParser.add(new BooleanParser());
        defaultParser.add(new ByteParser());
        defaultParser.add(new CharArrayParser());
        defaultParser.add(new CharParser());
        defaultParser.add(new DoubleParser());
        defaultParser.add(new FloatParser());
        defaultParser.add(new IntParser());
        defaultParser.add(new LongParser());
        defaultParser.add(new ShortParser());
        defaultParser.add(new StringParser());

        return defaultParser;
    }
}
