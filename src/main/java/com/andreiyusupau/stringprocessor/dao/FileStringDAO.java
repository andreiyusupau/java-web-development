package com.andreiyusupau.stringprocessor.dao;

import com.andreiyusupau.stringprocessor.model.StringInputParameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileStringDAO implements DAO<StringInputParameters> {

    private static final String POSITIVE_INTEGER_REGEX = "^\\d{1,9}?";
    public static final String FILEPATH = "input.data";

    @Override
    public StringInputParameters get() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILEPATH)))) {
            String input = bufferedReader.readLine();
            String charToReplaceInput = bufferedReader.readLine();
            if (charToReplaceInput.length() != 1) {
                throw new DataAccessException("Wrong char to replace input. Check the input file.");
            }
            String charPositionInput = bufferedReader.readLine();
            if (!charPositionInput.matches(POSITIVE_INTEGER_REGEX)) {
                throw new DataAccessException("Wrong char to replace position input. Check the input file.");
            }
            return new StringInputParameters(input, charToReplaceInput.charAt(0), Integer.parseInt(charPositionInput));
        } catch (IOException e) {
            throw new DataAccessException("Error reading the file", e);
        }
    }
}
