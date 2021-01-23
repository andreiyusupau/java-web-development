package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;
import com.andreiyusupau.textparser.service.parser.exception.ParserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LexemeParserTest {

    private final String word = "First";
    private final String expression = "[2 2 +]";
    private final String badString = "bad\nstring";
    @Mock
    private Parser<Component, String> expressionParser;
    @InjectMocks
    private LexemeParser lexemeParser;

    @Test
    void parseShouldThrowException() {
        assertThrows(ParserException.class, () -> lexemeParser.parse(badString));
    }

    @Test
    void parseShouldReturnWord() {
        Component wordComponent = lexemeParser.parse(word);
        String value = ((Leaf) wordComponent).getValue();
        assertEquals("First", value);
    }

    @Test
    void parseShouldReturnExpression() {
        when(expressionParser.parse("[2 2 +]" ))
                .thenReturn(Leaf.newExpression("4" ));

        Component expressionComponent = lexemeParser.parse(expression);

        String value = ((Leaf) expressionComponent).getValue();
        assertEquals("4", value);

    }
}
