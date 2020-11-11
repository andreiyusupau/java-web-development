package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;

public class BackwardsParser implements Parser<String, Component>{
    @Override
    public String parse(Component source) {
        //TODO:
        return source.toString();
    }
}
