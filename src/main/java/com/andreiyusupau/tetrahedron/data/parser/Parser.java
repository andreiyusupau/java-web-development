package com.andreiyusupau.tetrahedron.data.parser;

public interface Parser<T> {

    T parse(String input);
}
