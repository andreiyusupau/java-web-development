package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextParserTest {
    private final String text = "First sentence. Second sentence.\n" + "Third sentence? Fourth sentence!";
    @Mock
    private Parser<Component, String> paragraphParser;
    @InjectMocks
    private TextParser textParser;

    @Test
    void parseShouldReturnTwoParagraphs() {
        when(paragraphParser.parse(any(String.class)))
                .thenReturn(new Composite());

        Component textComponent = textParser.parse(text);

        assertEquals(2, textComponent.getChildren().size());
    }
}
