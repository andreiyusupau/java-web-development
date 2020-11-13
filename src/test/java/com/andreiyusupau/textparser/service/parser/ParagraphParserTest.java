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
class ParagraphParserTest {
    private final String paragraph = "First sentence. Second sentence!";
    @Mock
    private Parser<Component, String> sentenceParser;
    @InjectMocks
    private ParagraphParser paragraphParser;

    @Test
    void parseShouldReturnTwoSentences() {
        when(sentenceParser.parse(any(String.class)))
                .thenReturn(new Composite());

        Component textComponent = paragraphParser.parse(paragraph);

        assertEquals(2, textComponent.getChildren()
                .size());
    }
}
