package com.andreiyusupau.intarray.view;

public class UserInputReadException extends RuntimeException {

    public UserInputReadException(String errorMessage) {
        super(errorMessage);
    }

    public UserInputReadException(String errorMessage,Throwable cause) {
        super(errorMessage,cause);
    }
}
