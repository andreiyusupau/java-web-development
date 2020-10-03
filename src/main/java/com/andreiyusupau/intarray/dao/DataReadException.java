package com.andreiyusupau.intarray.dao;

public class DataReadException extends RuntimeException {

    public DataReadException(String errorMessage) {
        super(errorMessage);
    }

    public DataReadException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}