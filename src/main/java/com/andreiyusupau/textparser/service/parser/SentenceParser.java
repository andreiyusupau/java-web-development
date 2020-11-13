package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser<Component,String> {

    private final static String LEXEME_PATTERN="\\b\\w+?\\b";
    private final Pattern lexemePattern=Pattern.compile(LEXEME_PATTERN);
    private final Parser<Component,String> nextParser;

    public SentenceParser(Parser<Component, String> nextParser) {
        this.nextParser = nextParser;
    }

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
