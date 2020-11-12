package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;
import com.andreiyusupau.textparser.service.parser.interpreter.ExpressionParser;

public class LexemeParser implements Parser<Component,String> {

    private final static String WORD_PATTERN = "\\b\\w+\\b";
    private final static String EXPRESSION_PATTERN = "[.+]";
    private final Parser<Component,String> nextParser = new ExpressionParser();

    @Override
    public Component parse(String string) {
        if (string.matches(WORD_PATTERN)) {
            return Leaf.newWord(string);
        } else if (string.matches(EXPRESSION_PATTERN)) {
            return nextParser.parse(string);
        } else {
            //TODO:
            throw new RuntimeException();
        }
    }
}
