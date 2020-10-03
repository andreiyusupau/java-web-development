package com.andreiyusupau.stringprocessor.dao;

import com.andreiyusupau.stringprocessor.model.StringInputParameters;

import java.io.*;

public class FileStringDAO implements DAO<StringInputParameters> {

    private static final String POSITIVE_INTEGER_REGEX = "^\\d{1,9}?";
    public static final String FILEPATH = "input.data";

    @Override
    public StringInputParameters get() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILEPATH)))) {
            String input = bufferedReader.readLine();
            String charToReplaceInput = bufferedReader.readLine();
            if (charToReplaceInput.length() != 1) {
                throw new FileReadException("Wrong char to replace input. Check the input file.");
            }
            String charPositionInput = bufferedReader.readLine();
            if (!charPositionInput.matches(POSITIVE_INTEGER_REGEX)) {
                throw new FileReadException("Wrong char to replace position input. Check the input file.");
            }
            return new StringInputParameters(input, charToReplaceInput.charAt(0), Integer.parseInt(charPositionInput));
        } catch (IOException e) {
            throw new FileReadException("Error reading the file",e);
        }
    }
}
