package com.andreiyusupau.textparser.service;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {

    private final static String LEXEME_PATTERN="\\b\\w+?\\b";
    private final Pattern lexemePattern=Pattern.compile(LEXEME_PATTERN);
    private final Parser nextParser=new LexemeParser();

    @Override
    public Component parse(String string) {
        Component sentence=new Composite();
        Matcher matcher = lexemePattern.matcher(string);
        while (matcher.find()) {
            Component lexeme=nextParser.parse(matcher.group());
            sentence.addChild(lexeme);
        }
        return sentence;
    }

}
