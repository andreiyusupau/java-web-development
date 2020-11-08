package com.andreiyusupau.textparser.service;

import com.andreiyusupau.textparser.model.Component;

public interface Parser {

    Component parse(String string);
}
