package com.andreiyusupau.stringprocessor.util;

public class PropertyLoadException extends RuntimeException {

    public PropertyLoadException(String errorMessage) {
        super(errorMessage);
    }

    public PropertyLoadException(String errorMessage,Throwable cause) {
        super(errorMessage,cause);
    }
}
