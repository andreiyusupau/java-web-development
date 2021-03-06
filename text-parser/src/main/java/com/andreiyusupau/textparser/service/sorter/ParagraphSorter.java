package com.andreiyusupau.textparser.service.sorter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;
import com.andreiyusupau.textparser.service.parser.ParagraphParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class ParagraphSorter implements Sorter<Component>{

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    @Override
    public Component sort(Component component) {
        LOGGER.info("Sorting paragraphs by sentences count.");
       Component sortedText=new Composite();
        List<Component> paragraphs =component.getChildren();
        paragraphs.sort(Comparator.comparingInt(comparedComponent -> comparedComponent.getChildren()
                .size()));
        paragraphs.forEach(sortedText::addChild);
        return sortedText;
    }
}
