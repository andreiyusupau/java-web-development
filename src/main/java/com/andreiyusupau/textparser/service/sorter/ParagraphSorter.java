package com.andreiyusupau.textparser.service.sorter;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.model.Composite;

import java.util.Comparator;
import java.util.List;

public class ParagraphSorter implements Sorter<Component>{

    @Override
    public Component sort(Component component) {
       Component sortedText=new Composite();
        List<Component> paragraphs =component.getChildren();
        paragraphs.sort(Comparator.comparingInt(comparedComponent -> comparedComponent.getChildren()
                .size()));
        paragraphs.forEach(sortedText::addChild);
        return sortedText;
    }
}
