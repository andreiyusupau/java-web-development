package com.andreiyusupau.textparser.service.sorter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class LexemeSorter implements Sorter<Component> {

    private static final Logger LOGGER = LogManager.getLogger(LexemeSorter.class);

    @Override
    public Component sort(Component component) {
        LOGGER.info("Sorting lexemes by length.");
        Component sortedText=new Composite();
        List<Component> paragraphs=component.getChildren();
        for(Component paragraph:paragraphs){
            Component sortedParagraph=new Composite();
            List<Component> sentences=paragraph.getChildren();
            for(Component sentence:sentences){
                Component sortedSentence=new Composite();
                List<Component> lexemes=sentence.getChildren();
                lexemes.sort(Comparator.comparingInt(comparedLexeme -> comparedLexeme.toString()
                        .length()));
                lexemes.forEach(sortedSentence::addChild);
                sortedParagraph.addChild(sortedSentence);
            }
            sortedText.addChild(sortedParagraph);
        }
        return sortedText;
    }
}
