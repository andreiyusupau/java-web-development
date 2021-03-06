package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;
import com.andreiyusupau.textparser.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements Parser<Component,String> {

    private static final Logger LOGGER = LogManager.getLogger(LexemeParser.class);
    private final static String WORD_PATTERN = "\\b\\w+\\b";
    private final static String EXPRESSION_PATTERN = "\\[.+]";
    private final Parser<Component,String> nextParser;

    public LexemeParser(Parser<Component, String> nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Component parse(String string) {
        LOGGER.info("Parsing lexeme.");
        if (string.matches(WORD_PATTERN)) {
            return Leaf.newWord(string);
        } else if (string.matches(EXPRESSION_PATTERN)) {
            return nextParser.parse(string);
        } else {
            throw new ParserException("Lexeme doesn't match word or expression pattern.");
        }
    }
}
