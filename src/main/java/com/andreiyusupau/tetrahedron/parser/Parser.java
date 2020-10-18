package com.andreiyusupau.tetrahedron.parser;

public interface Parser<T> {

    T parse(String input);
}
