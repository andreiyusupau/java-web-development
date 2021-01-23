package com.andreiyusupau.textparser.service.parser;

/**
 * @param <T> target class
 * @param <S> source class
 */
@FunctionalInterface
public interface Parser<T,S> {
    T parse(S source);
}
