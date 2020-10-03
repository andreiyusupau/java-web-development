package com.andreiyusupau.intarray.service.sort;

public class NoSuchArraySorterImplementationException extends RuntimeException {

    public NoSuchArraySorterImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
