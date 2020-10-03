package com.andreiyusupau.stringprocessor.model;

public class StringInputParameters {

    private final String input;
    private final char charToReplace;
    private final int charPosition;

    public StringInputParameters(String input, char charToReplace, int charPosition) {
        this.input = input;
        this.charToReplace = charToReplace;
        this.charPosition = charPosition;
    }

    public String getInput() {
        return input;
    }

    public char getCharToReplace() {
        return charToReplace;
    }

    public int getCharPosition() {
        return charPosition;
    }
}
