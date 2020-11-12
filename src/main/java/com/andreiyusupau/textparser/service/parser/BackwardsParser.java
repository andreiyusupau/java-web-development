package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;

import java.util.stream.Collectors;

public class BackwardsParser implements Parser<String, Component> {

    @Override
    public String parse(Component source) {
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
