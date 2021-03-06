package com.andreiyusupau.textparser.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Composite implements Component {

    private final List<Component> children = new ArrayList<>();

    @Override
    public void addChild(Component component) {
        children.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Composite{\n"+
                children.stream()
                .map(Component::toString)
                        .collect(Collectors.joining(","))+
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}

        Composite composite = (Composite) o;

        return children.equals(composite.children);
    }

    @Override
    public int hashCode() {
        return children.hashCode();
    }
}
