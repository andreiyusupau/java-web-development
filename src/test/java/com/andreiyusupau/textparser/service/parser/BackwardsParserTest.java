package com.andreiyusupau.textparser.service.parser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import com.andreiyusupau.textparser.model.Leaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackwardsParserTest {

    private final BackwardsParser backwardsParser = new BackwardsParser();
    private final String text = "First, sentence. Second sentence.\n" + "Third sentence? Fourth sentence!";

    private Component textComponent;
    private Component firstParagraph;
    private Component secondParagraph;

    private Component firstSentence;
    private Component secondSentence;
    private Component thirdSentence;
    private Component fourthSentence;

    @BeforeEach
    void set() {
        textComponent = new Composite();

        firstParagraph = new Composite();
        secondParagraph = new Composite();

        firstSentence = new Composite();
        secondSentence = new Composite();
        thirdSentence = new Composite();
        fourthSentence = new Composite();


        firstSentence.addChild(Leaf.newWord("First," ));
        firstSentence.addChild(Leaf.newWord("sentence." ));
        secondSentence.addChild(Leaf.newWord("Second" ));
        secondSentence.addChild(Leaf.newWord("sentence." ));
        thirdSentence.addChild(Leaf.newWord("Third" ));
        thirdSentence.addChild(Leaf.newWord("sentence?" ));
        fourthSentence.addChild(Leaf.newWord("Fourth" ));
        fourthSentence.addChild(Leaf.newWord("sentence!" ));

        firstParagraph.addChild(firstSentence);
        firstParagraph.addChild(secondSentence);
        secondParagraph.addChild(thirdSentence);
        secondParagraph.addChild(fourthSentence);

        textComponent.addChild(firstParagraph);
        textComponent.addChild(secondParagraph);
    }

    @Test
    void parseShouldReturnTwoParagraphs() {
        String restoredText = backwardsParser.parse(textComponent);

        assertEquals(text, restoredText);
    }
}
