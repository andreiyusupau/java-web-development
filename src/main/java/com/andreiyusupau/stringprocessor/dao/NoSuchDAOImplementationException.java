package com.andreiyusupau.stringprocessor.dao;

class NoSuchDAOImplementationException extends RuntimeException {

    public NoSuchDAOImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
