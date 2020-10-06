package com.andreiyusupau.stringprocessor.dao;

public class DataAccessException extends RuntimeException {

    public DataAccessException(String errorMessage) {
        super(errorMessage);
    }
    public DataAccessException(String errorMessage,Throwable cause) {
        super(errorMessage,cause);
    }
}