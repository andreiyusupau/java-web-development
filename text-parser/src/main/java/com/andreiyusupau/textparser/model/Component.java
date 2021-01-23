package com.andreiyusupau.textparser.model;

import java.util.List;

public interface Component {

    default void addChild(Component component) {
        throw new UnsupportedOperationException();
    }

    default List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }
}
