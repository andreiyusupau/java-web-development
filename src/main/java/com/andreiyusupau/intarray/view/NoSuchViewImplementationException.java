package com.andreiyusupau.intarray.view;

public class NoSuchViewImplementationException extends RuntimeException {

    public NoSuchViewImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
