package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser<Component,String> {

    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private final static String PARAGRAPH_PATTERN="(.+?)(\\z|\\n|\\r|\\f|\\u0085|\\u2029|$)";
    private final Pattern paragraphPattern=Pattern.compile(PARAGRAPH_PATTERN);
    private final Parser<Component,String> nextParser;

    public TextParser(Parser<Component, String> nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Component parse(String string) {
        LOGGER.info("Parsing text.");
       Component text=new Composite();
        Matcher matcher = paragraphPattern.matcher(string);
        while (matcher.find()) {
            Component paragraph=nextParser.parse(matcher.group(1));
            text.addChild(paragraph);
        }
        return text;
    }
}
