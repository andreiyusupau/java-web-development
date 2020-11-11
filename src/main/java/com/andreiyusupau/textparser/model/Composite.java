package com.andreiyusupau.textparser.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public final class Composite implements Component {

    private final Collection<Component> children = new ArrayList<>();

    @Override
    public void operation() {

    }

    @Override
    public void addChild(Component component) {
        children.add(component);
    }

    @Override
    public Collection<Component> getChildren() {
        return children;
    }

    @Override
    public void removeChild(Component component) {
        children.remove(component);
    }

    @Override
    public String toString() {

        return "Composite{\n"+
                children.stream()
                .map(Component::toString).collect(Collectors.joining(","))+
                "\n}";
    }
}
