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
            char charToReplace = readChar(bufferedReader);
            int charPosition = readNumber(bufferedReader);
            return new StringInputParameters(input, charToReplace, charPosition);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readString(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String stringInput = bufferedReader.readLine();
            if (!stringInput.equals("")) {
                return stringInput;
            } else {
                System.err.println("Please enter a string.");
            }
        }
    }

    public char readChar(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String charInput = bufferedReader.readLine();
            if (charInput.length() == 1) {
                return charInput.charAt(0);
            } else {
                System.err.println("Please enter a character.");
            }
        }
    }

    public int readNumber(BufferedReader bufferedReader) throws IOException {
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
