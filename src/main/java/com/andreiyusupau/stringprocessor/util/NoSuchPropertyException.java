package com.andreiyusupau.stringprocessor.util;

public class NoSuchPropertyException extends RuntimeException {
    public NoSuchPropertyException(String errorMessage) {
        super(errorMessage);
    }
}
