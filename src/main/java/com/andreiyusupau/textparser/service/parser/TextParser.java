package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser<Component,String> {

    private final static String PARAGRAPH_PATTERN="(.+?)(\\z|\\n|\\r|\\f|\\u0085|\\u2029|$)";
    private final Pattern paragraphPattern=Pattern.compile(PARAGRAPH_PATTERN);
    private final Parser<Component,String> nextParser=new ParagraphParser();

    @Override
    public Component parse(String string) {
       Component text=new Composite();
        Matcher matcher = paragraphPattern.matcher(string);
        while (matcher.find()) {
            Component paragraph=nextParser.parse(matcher.group(1));
            text.addChild(paragraph);
        }
        return text;
    }
}
