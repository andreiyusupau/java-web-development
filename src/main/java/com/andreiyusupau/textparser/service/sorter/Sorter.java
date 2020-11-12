package com.andreiyusupau.textparser.service.sorter;

@FunctionalInterface
public interface Sorter<T> {
    T sort(T t);
}
