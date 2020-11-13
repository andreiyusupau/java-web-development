package com.andreiyusupau.textparser.service.sorter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import com.andreiyusupau.textparser.model.Leaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexemeSorterTest {

    private final LexemeSorter lexemeSorter = new LexemeSorter();

    private Component text;

    private Component paragraph;

    private Component sentence;

    private final Component firstWord = Leaf.newWord("first" );
    private final Component secondWord = Leaf.newWord("second" );
    private final Component thirdWord = Leaf.newWord("I" );

    @BeforeEach
    void set() {
        text = new Composite();
        paragraph = new Composite();
        sentence = new Composite();

        sentence.addChild(firstWord);
        sentence.addChild(secondWord);
        sentence.addChild(thirdWord);

        paragraph.addChild(sentence);

        text.addChild(paragraph);
    }

    @Test
    void sortShouldReturnLexemesSortedByLength() {
        Component sortedText = lexemeSorter.sort(text);

        Component expectedText = new Composite();
        Component expectedParagraph = new Composite();
        Component expectedSentence = new Composite();
        expectedSentence.addChild(thirdWord);
        expectedSentence.addChild(firstWord);
        expectedSentence.addChild(secondWord);
        expectedParagraph.addChild(expectedSentence);
        expectedText.addChild(expectedParagraph);
        assertEquals(expectedText, sortedText);
    }
}
