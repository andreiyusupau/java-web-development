package com.andreiyusupau.intarray.service.search;

public class NoSuchArraySearcherImplementationException extends RuntimeException {

    public NoSuchArraySearcherImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
