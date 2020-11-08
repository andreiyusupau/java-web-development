package com.andreiyusupau.textparser.model;

import java.util.Collection;

public interface Component {

    void operation();

    default void addChild(Component component) {
        throw new UnsupportedOperationException();
    }

    default Collection<Component> getChildren() {
        throw new UnsupportedOperationException();
    }

    default void removeChild(Component component) {
        throw new UnsupportedOperationException();
    }
}
