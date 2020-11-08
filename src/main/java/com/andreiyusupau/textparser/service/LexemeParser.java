package com.andreiyusupau.textparser.service;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;

import java.util.regex.Pattern;

public class LexemeParser implements Parser {

    private final static String WORD_PATTERN = "CHANGE";
    private final static String EXPRESSION_PATTERN = "CHANGE";
    private final Pattern wordPattern = Pattern.compile(WORD_PATTERN);
    private final Parser nextParser = new LexemeParser();

    @Override
    public Component parse(String string) {
        if (string.matches(WORD_PATTERN)) {
            return Leaf.newWord(string);
        } else if (string.matches(EXPRESSION_PATTERN)) {
            return Leaf.newExpression(string);
        } else {
            throw new RuntimeException();
        }
    }
}
