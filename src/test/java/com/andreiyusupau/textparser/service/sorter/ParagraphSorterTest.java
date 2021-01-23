package com.andreiyusupau.textparser.service.sorter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParagraphSorterTest {

    private final ParagraphSorter paragraphSorter = new ParagraphSorter();

    private Component text;

    private Component firstParagraph;

    private Component secondParagraph;

    private final Component sentence = new Composite();

    @BeforeEach
    void set() {
        text = new Composite();
        firstParagraph = new Composite();
        secondParagraph = new Composite();

        firstParagraph.addChild(sentence);
        firstParagraph.addChild(sentence);
        firstParagraph.addChild(sentence);


        secondParagraph.addChild(sentence);
        secondParagraph.addChild(sentence);

        text.addChild(firstParagraph);
        text.addChild(secondParagraph);
    }

    @Test
    void sortShouldReturnLexemesSortedByLength() {
        Component sortedText = paragraphSorter.sort(text);

        Component expectedText = new Composite();

        expectedText.addChild(secondParagraph);
        expectedText.addChild(firstParagraph);
        assertEquals(expectedText, sortedText);
    }
}