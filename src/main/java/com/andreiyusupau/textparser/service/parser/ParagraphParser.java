package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser<Component,String>{

    private final static String SENTENCE_PATTERN=".+?(\\?!|!\\?|\\.|!|\\?|\\.\\.\\.)";
    private final Pattern sentencePattern=Pattern.compile(SENTENCE_PATTERN);
    private final Parser<Component,String> nextParser=new SentenceParser();

    @Override
    public Component parse(String string) {
        Component paragraph=new Composite();
        Matcher matcher = sentencePattern.matcher(string);
        while (matcher.find()) {
            Component sentence=nextParser.parse(matcher.group());
            paragraph.addChild(sentence);
        }
        return paragraph;
    }
}
