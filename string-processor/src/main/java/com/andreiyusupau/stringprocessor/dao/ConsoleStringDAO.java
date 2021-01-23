package com.andreiyusupau.stringprocessor.dao;

import com.andreiyusupau.stringprocessor.model.StringInputParameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStringDAO implements DAO<StringInputParameters> {

    private static final String POSITIVE_INTEGER_REGEX = "^\\d{1,9}?";

    @Override
    public StringInputParameters get() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please, input a new String:");
            String input = readString(bufferedReader);
            System.out.println("Enter a character with which a symbol in every word will be replaced:");
            char charToReplace = readChar(bufferedReader);
            System.out.println("Enter a position of the symbol to replace in every word::");
            int charPosition = readNumber(bufferedReader);
            return new StringInputParameters(input, charToReplace, charPosition);
        } catch (IOException e) {
           throw new DataAccessException("Error reading input from console",e);
        }
    }

    private String readString(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String stringInput = bufferedReader.readLine();
            if (!stringInput.equals("")) {
                return stringInput;
            } else {
                System.err.println("Please enter a string.");
            }
        }
    }

    private char readChar(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String charInput = bufferedReader.readLine();
            if (charInput.length() == 1) {
                return charInput.charAt(0);
            } else {
                System.err.println("Please enter a character.");
            }
        }
    }

    private int readNumber(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String number = bufferedReader.readLine();
            if (number.matches(POSITIVE_INTEGER_REGEX)) {
                return Integer.parseInt(number);
            } else {
                System.err.println("Enter a positive integer number!");
            }
        }
    }
}
