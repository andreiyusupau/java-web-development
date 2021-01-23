package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Leaf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SentenceParserTest {
    private final String sentence = "First sentence.";
    @Mock
    private Parser<Component, String> lexemeParser;
    @InjectMocks
    private SentenceParser sentenceParser;
    private final Leaf firstWord = Leaf.newWord("First" );
    private final Leaf secondWord = Leaf.newWord("sentence" );

    @Test
    void parseShouldReturnTwoSentences() {
        when(lexemeParser.parse(any(String.class)))
                .thenAnswer(x -> Leaf.newWord(x.getArgument(0).toString()));

        Component sentenceComponent = sentenceParser.parse(sentence);

        List<Component> expected = List.of(firstWord, secondWord);

        assertEquals(expected, sentenceComponent.getChildren());
    }
}