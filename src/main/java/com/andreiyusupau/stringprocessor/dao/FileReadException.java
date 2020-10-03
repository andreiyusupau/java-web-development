package com.andreiyusupau.stringprocessor.dao;

public class FileReadException extends RuntimeException {

    public FileReadException(String errorMessage) {
        super(errorMessage);
    }
    public FileReadException(String errorMessage,Throwable cause) {
        super(errorMessage,cause);
    }
}