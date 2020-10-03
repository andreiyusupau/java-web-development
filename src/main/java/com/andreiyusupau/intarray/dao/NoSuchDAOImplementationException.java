package com.andreiyusupau.intarray.dao;

public class NoSuchDAOImplementationException extends RuntimeException {

    public NoSuchDAOImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
