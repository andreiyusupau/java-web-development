package com.andreiyusupau.stringprocessor.view;

class NoSuchViewImplementationException extends RuntimeException {

    public NoSuchViewImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
