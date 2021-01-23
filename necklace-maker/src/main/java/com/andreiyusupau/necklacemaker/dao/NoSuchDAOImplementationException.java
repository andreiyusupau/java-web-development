package com.andreiyusupau.necklacemaker.dao;

class NoSuchDAOImplementationException extends RuntimeException {

    public NoSuchDAOImplementationException(String errorMessage) {
        super(errorMessage);
    }
}
