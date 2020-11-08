package com.andreiyusupau.textparser.model;

import java.util.ArrayList;
import java.util.Collection;

public final class Composite implements Component{

    private final Collection<Component> sentences=new ArrayList<>();

    @Override
    public void operation() {

    }

    @Override
    public void addChild(Component component) {
sentences.add(component);
    }

    @Override
    public Collection<Component> getChildren() {
        return sentences;
    }

    @Override
    public void removeChild(Component component) {
sentences.remove(component);
    }
}
