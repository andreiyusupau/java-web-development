package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

public class BackwardsParser implements Parser<String, Component> {

    private static final Logger LOGGER = LogManager.getLogger(BackwardsParser.class);
    @Override
    public String parse(Component source) {
        LOGGER.info("Parsing components back to text.");
        return source.getChildren()
                .stream()
                .map(paragraph -> paragraph.getChildren()
                        .stream()
                        .map(sentence -> sentence.getChildren()
                                .stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(" ")))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }
}
