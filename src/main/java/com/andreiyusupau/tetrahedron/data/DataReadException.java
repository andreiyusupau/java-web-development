package com.andreiyusupau.tetrahedron.data;

public class DataReadException extends RuntimeException {

    public DataReadException(String message) {
        super(message);
    }

    public DataReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
